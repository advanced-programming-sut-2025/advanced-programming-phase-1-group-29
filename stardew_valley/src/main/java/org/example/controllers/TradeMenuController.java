package org.example.controllers;

import org.example.models.App;
import org.example.models.Player;
import org.example.models.Result;
import org.example.models.TradeMenu;

import java.util.ArrayList;


public class TradeMenuController extends Controller {
    public Result startTrade() {
        StringBuilder result = new StringBuilder();
        result.append("Trade Menu\n");

        Player currentPlayer = App.getCurrentGame().getCurrentPlayer();
        TradeMenu menu = App.getCurrentGame().getTradeMenu();

        result.append("Online Players:\n");
        for (Player player : App.getCurrentGame().getPlayers()) {
            result.append("- ").append(player.getUser().getUsername()).append("\n");
        }

        result.append("\nNew Trade Requests for You:\n");
        boolean hasNew = false;

        for (int i = 0; i < menu.getUsernames().size(); i++) {
            String receiverUsername = menu.getTargetUsernames().get(i);
            if (receiverUsername.equals(currentPlayer.getUser().getUsername()) &&
                    !currentPlayer.hasSeenTradeRequest(i)) {

                String senderUsername = menu.getUsernames().get(i);
                String type = menu.getTypes().get(i);
                String item = menu.getItems().get(i);
                int amount = menu.getAmounts().get(i);
                int price = menu.getPrices().get(i);
                String targetItem = menu.getTargetItems().get(i);
                int targetAmount = menu.getTargetAmounts().get(i);

                result.append("From ").append(senderUsername)
                        .append(" → ").append(type).append(" ")
                        .append(amount).append(" x ").append(item);

                if (price > 0) {
                    result.append(" for ").append(price).append(" coins");
                } else if (!targetItem.isEmpty()) {
                    result.append(" for ").append(targetAmount).append(" x ").append(targetItem);
                }

                result.append(" (ID: ").append(i + 1).append(")\n");

                currentPlayer.markTradeRequestSeen(i);
                hasNew = true;
            }
        }

        if (!hasNew) {
            result.append("No new trade requests.\n");
        }

        return new Result(true, result.toString());
    }



    public Result trade(String username, String type, String item, String amountString,
                        String priceString, String targetItem, String targetAmountString) {
        if (priceString == null || priceString.isEmpty()){
            if (targetItem == null || targetItem.isEmpty() || targetAmountString == null || targetAmountString.isEmpty()) {
                return new Result(false, "invalid parameters");
            }
        }
        Player sender = App.getCurrentGame().getCurrentPlayer();
        Player receiver = null;

        for (Player p : App.getCurrentGame().getPlayers()) {
            if (p.getUser().getUsername().equals(username)) {
                receiver = p;
                break;
            }
        }

        if (receiver == null) return new Result(false, "invalid username");

        if (!type.equalsIgnoreCase("offer") && !type.equalsIgnoreCase("request")) {
            return new Result(false, "invalid type");
        }

        if (!amountString.matches("\\d+")) {
            return new Result(false, "invalid amount");
        }
        int amount = Integer.parseInt(amountString);

        if ((priceString != null && !priceString.isEmpty()) &&
                (targetItem != null && !targetItem.isEmpty())) {
            return new Result(false, "choose only one payment method");
        }

        Integer price = null;
        if (priceString != null && !priceString.isEmpty()) {
            if (!priceString.matches("\\d+")) return new Result(false, "invalid price");
            price = Integer.parseInt(priceString);
            if (type.equalsIgnoreCase("request")) {
                if (sender.getCoins() < price) {
                    return new Result(false, "you don't have enough money.");
                }
            }
        }

        Integer targetAmount = null;
        if (targetAmountString != null && !targetAmountString.isEmpty()) {
            if (!targetAmountString.matches("\\d+")) return new Result(false, "invalid target amount");
            targetAmount = Integer.parseInt(targetAmountString);
            if (type.equalsIgnoreCase("request")) {
                if (sender.getInventory().getNumberOfInventoryItem(targetItem) < targetAmount) {
                    return new Result(false, "you don't have enough " + targetItem);
                }
            }
        }

        if (type.equalsIgnoreCase("offer")) {
            if (sender.getInventory().getNumberOfInventoryItem(item) < amount) {
                return new Result(false, "you don't have enough " + item);
            }
        }

        App.getCurrentGame().getTradeMenu().addUsername(sender.getUser().getUsername());
        App.getCurrentGame().getTradeMenu().addTargetUsername(receiver.getUser().getUsername());
        App.getCurrentGame().getTradeMenu().addType(type.toLowerCase());
        App.getCurrentGame().getTradeMenu().addItem(item);
        App.getCurrentGame().getTradeMenu().addAmount(amount);
        App.getCurrentGame().getTradeMenu().addPrice(price == null ? 0 : price); // اگر پول نبود، صفر
        App.getCurrentGame().getTradeMenu().addTargetItem(targetItem == null ? "" : targetItem);
        App.getCurrentGame().getTradeMenu().addTargetAmount(targetAmount == null ? 0 : targetAmount);
        String pendingTrade = "Requested trade to " + receiver.getUser().getUsername() +
                " | Type: " + type + " | " + amount + " x " + item +
                (price != null && price > 0 ? " for " + price + " coins" :
                        (targetItem != null && !targetItem.isEmpty() ? " for " + targetAmount + " x " + targetItem : ""));

        sender.addToTradeHistory(pendingTrade);
        return new Result(true, "Trade registered successfully.");
    }

    public Result tradeList() {
        TradeMenu menu = App.getCurrentGame().getTradeMenu();
        StringBuilder result = new StringBuilder();
        result.append("Trade Requests:\n");

        for (int i = 0; i < menu.getUsernames().size(); i++) {
            if (!menu.getTargetUsernames().get(i).equals(App.getCurrentGame().getCurrentPlayer().getUser().getUsername()))
                continue;
            String username = menu.getUsernames().get(i);
            String type = menu.getTypes().get(i);
            String item = menu.getItems().get(i);
            int amount = menu.getAmounts().get(i);
            int price = menu.getPrices().get(i);
            String targetItem = menu.getTargetItems().get(i);
            int targetAmount = menu.getTargetAmounts().get(i);

            result.append("ID: ").append(i + 1).append(" | ")
                    .append(username).append(" wants to ")
                    .append(type).append(" ")
                    .append(amount).append(" x ").append(item);

            if (price > 0) {
                result.append(" for ").append(price).append(" coins");
            } else if (!targetItem.isEmpty()) {
                result.append(" for ").append(targetAmount).append(" x ").append(targetItem);
            }

            result.append("\n");
        }

        return new Result(true, result.toString());
    }

    public Result respondToTrade(String action, String idString) {
        if (!idString.matches("\\d+")) return new Result(false, "Invalid ID format.");
        int id = Integer.parseInt(idString) - 1;

        TradeMenu menu = App.getCurrentGame().getTradeMenu();
        if (id < 0 || id >= menu.getUsernames().size())
            return new Result(false, "Trade request not found.");

        String targetUsername = menu.getTargetUsernames().get(id);
        String currentUsername = App.getCurrentGame().getCurrentPlayer().getUser().getUsername();
        if (!targetUsername.equals(currentUsername)) {
            return new Result(false, "You are not the recipient of this trade request.");
        }

        Player receiver = App.getCurrentGame().getCurrentPlayer();
        String senderUsername = menu.getUsernames().get(id);
        Player sender = null;
        for (Player p : App.getCurrentGame().getPlayers()) {
            if (p.getUser().getUsername().equals(senderUsername)) {
                sender = p;
                break;
            }
        }
        if (sender == null) return new Result(false, "Sender not found.");

        String type = menu.getTypes().get(id);
        String item = menu.getItems().get(id);
        int amount = menu.getAmounts().get(id);
        int price = menu.getPrices().get(id);
        String targetItem = menu.getTargetItems().get(id);
        int targetAmount = menu.getTargetAmounts().get(id);

        if (action.equals("-reject")) {
            removeTrade(menu, id);
            decreseFriendship(receiver, sender);
            return new Result(true, "Trade request rejected.");
        } else if (action.equals("-accept")) {
            if (type.equalsIgnoreCase("offer")) {
                if (price > 0) {
                    if (receiver.getCoins() < price)
                        return new Result(false, "You don't have enough coins.");
                    receiver.setCoins(receiver.getCoins() - price);
                    sender.setCoins(sender.getCoins() + price);
                }
                else {
                    if (receiver.getInventory().getCapacity() < amount){
                        return new Result(false, "You don't have enough inventory.");
                    }
                    if (sender.getInventory().getCapacity() < targetAmount){
                        return new Result(false, "sender doesn't have enough inventory space.");
                    }
                    if (receiver.getInventory().getNumberOfInventoryItem(targetItem) < targetAmount)
                        return new Result(false, "You don't have enough " + targetItem);
                    receiver.getInventory().removeInventoryItem(targetItem, targetAmount);
                    sender.getInventory().addInventoryItem(targetItem, targetAmount, 0);
                }
                if (sender.getInventory().getNumberOfInventoryItem(item) < amount)
                    return new Result(false, "Sender does not have enough " + item);
                sender.getInventory().removeInventoryItem(item, amount);
                receiver.getInventory().addInventoryItem(item, amount, 0);

            } else if (type.equalsIgnoreCase("request")) {
                if (price > 0) {
                    if (sender.getCoins() < price)
                        return new Result(false, "Sender doesn't have enough coins.");
                    if (receiver.getInventory().getCapacity() < amount){
                        return new Result(false, "You don't have enough inventory space.");
                    }
                } else {
                    if (receiver.getInventory().getCapacity() < targetAmount){
                        return new Result(false, "You don't have enough inventory space.");
                    }
                    if (sender.getInventory().getCapacity() < amount){
                        return new Result(false, "sender doesn't have enough inventory space.");
                    }
                    if (sender.getInventory().getNumberOfInventoryItem(targetItem) < targetAmount)
                        return new Result(false, "Sender doesn't have enough " + targetItem);
                }

                if (receiver.getInventory().getNumberOfInventoryItem(item) < amount)
                    return new Result(false, "You don't have enough " + item);

                if (price > 0) {
                    sender.setCoins(sender.getCoins() - price);
                    receiver.setCoins(receiver.getCoins() + price);
                } else {
                    sender.getInventory().removeInventoryItem(targetItem, targetAmount);
                    receiver.getInventory().addInventoryItem(targetItem, targetAmount, 0);
                }
                receiver.getInventory().removeInventoryItem(item, amount);
                sender.getInventory().addInventoryItem(item, amount, 0);
            }
            removeTrade(menu, id);
            String historyRecord = "Accepted trade: " + sender.getUser().getUsername() +
                    " ↔ " + receiver.getUser().getUsername() + " | Type: " + type +
                    " | " + amount + " x " + item +
                    (price > 0 ? " for " + price + " coins" :
                            (!targetItem.isEmpty() ? " for " + targetAmount + " x " + targetItem : ""));
            sender.addToTradeHistory(historyRecord);
            receiver.addToTradeHistory(historyRecord);
            addFriendship(receiver, sender);
            return new Result(true, "Trade completed successfully.");
        }
        return new Result(false, "Invalid command");
    }
    public Result tradeHistory() {
        Player current = App.getCurrentGame().getCurrentPlayer();
        ArrayList<String> history = current.getTradeHistory();

        if (history.isEmpty()) {
            return new Result(true, "No trade history found.");
        }

        StringBuilder result = new StringBuilder();
        result.append("Trade History:\n");
        for (int i = 0; i < history.size(); i++) {
            result.append((i + 1)).append(". ").append(history.get(i)).append("\n");
        }

        return new Result(true, result.toString());
    }


    private void removeTrade(TradeMenu menu, int id) {
        menu.getUsernames().remove(id);
        menu.getTargetUsernames().remove(id);
        menu.getTypes().remove(id);
        menu.getItems().remove(id);
        menu.getAmounts().remove(id);
        menu.getPrices().remove(id);
        menu.getTargetItems().remove(id);
        menu.getTargetAmounts().remove(id);
    }
    private void addFriendship(Player sender, Player receiver) {
        int id1 = -1, id2 = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            Player p = App.getCurrentGame().getPlayers().get(i);
            if (p.getUser().getUsername().equals(sender.getUser().getUsername())) {
                id1 = i;
            }
            if (p.getUser().getUsername().equals(receiver.getUser().getUsername())) {
                id2 = i;
            }
        }
        sender.addFriendship(id2, 50);
        receiver.addFriendship(id1, 50);
    }
    private void decreseFriendship(Player sender, Player receiver) {
        int id1 = -1, id2 = -1;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            Player p = App.getCurrentGame().getPlayers().get(i);
            if (p.getUser().getUsername().equals(sender.getUser().getUsername())) {
                id1 = i;
            }
            if (p.getUser().getUsername().equals(receiver.getUser().getUsername())) {
                id2 = i;
            }
        }
        sender.addFriendship(id2, -30);
        receiver.addFriendship(id1, -30);
    }
}
