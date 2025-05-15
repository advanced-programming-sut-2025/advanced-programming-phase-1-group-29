package org.example.models;

public class TradeMenu {
    public Result startTrade(){
        StringBuilder result = new StringBuilder();
        result.append("Trade Menu\n");
        for (Player player : App.getCurrentGame().getPlayers()) {
            result.append(player.getUser().getUsername() + "\n");
        }
        return new Result(true, result.toString());
    }
    public Result trade(String username, String type, String item, String amountString, String priceString, String targetItem, String targetAmountString) {
        Player player = App.getCurrentGame().getCurrentPlayer();
        int ind = -1;
        Player player2 = null;
        for (int i = 0; i < App.getCurrentGame().getPlayers().size(); i++) {
            if (App.getCurrentGame().getPlayers().get(i).getUser().getUsername().equals(username)) {
                ind = i;
                player2 = App.getCurrentGame().getPlayers().get(i);
            }
        }
        if (ind == -1){
            return new Result(false, "invalid username");
        }
        if (!amountString.matches("\\d+")){
            return new Result(false, "invalid amount");
        }
        if (!type.equalsIgnoreCase("offer") && !type.equalsIgnoreCase("request"){
            return new Result(false, "invalid type");
        }

    }
}
