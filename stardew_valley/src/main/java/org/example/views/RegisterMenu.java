package org.example.views;

import org.example.controllers.RegisterMenuController;
import org.example.models.enums.RegisterMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class RegisterMenu implements AppMenu{
    private final RegisterMenuController controller = new RegisterMenuController();

    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if (RegisterMenuCommands.MenuEnter.getMatcher(input) != null) {
            System.out.println(controller.menuEnter());
        } else if (RegisterMenuCommands.ShowCurrentMenu.getMatcher(input) != null) {
            System.out.println(controller.showCurrentMenu());
        } else if ((matcher = RegisterMenuCommands.Register.getMatcher(input)) != null) {
            System.out.println(controller.register(
                    matcher.group("username").trim(),
                    matcher.group("password").trim(),
                    matcher.group("passwordConfirm").trim(),
                    matcher.group("nickname").trim(),
                    matcher.group("email").trim(),
                    matcher.group("gender").trim()
            ));
        } else if (RegisterMenuCommands.YesOrNo.getMatcher(input) != null) {
            System.out.println(controller.selectSuggestedUsername(input));
        } else if (RegisterMenuCommands.RandomPassword.getMatcher(input) != null) {
            System.out.println(controller.selectRandomPassword(input));
        } else if ((matcher = RegisterMenuCommands.PickQuestion.getMatcher(input)) != null) {
            System.out.println(controller.pickQuestion(
                    matcher.group("questionNumber").trim(),
                    matcher.group("answer").trim(),
                    matcher.group("answerConfirm").trim()
            ));
        } else if (RegisterMenuCommands.MenuExit.getMatcher(input) != null) {
            controller.menuExit();
        } else {
            System.out.println(controller.passwordConfirmation(input));
        }
    }
}
