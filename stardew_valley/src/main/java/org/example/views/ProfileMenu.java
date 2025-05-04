package org.example.views;

import org.example.controllers.Controller;
import org.example.controllers.ProfileMenuController;
import org.example.models.enums.ProfileMenuCommands;

import java.util.Collection;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu implements AppMenu{
    private final ProfileMenuController controller = new ProfileMenuController();
    @Override
    public void check(Scanner scanner) {
        String input = scanner.nextLine();
        Matcher matcher;
        if ((matcher = ProfileMenuCommands.ChangeUsername.getMatcher(input)) != null) {
            System.out.println(controller.changeUsername(matcher.group("username").trim()));
        }
        else if ((matcher = ProfileMenuCommands.ChangeNickname.getMatcher(input)) != null) {
            System.out.println(controller.changeNickname(matcher.group("nickname").trim()));
        }
        else if ((matcher = ProfileMenuCommands.ChangeEmail.getMatcher(input)) != null) {
            System.out.println(controller.changeEmail(matcher.group("email").trim()));
        }
        else if ((matcher = ProfileMenuCommands.ChangePassword.getMatcher(input)) != null) {
            System.out.println(controller.changePassword(matcher.group("oldPassword").trim(), matcher.group("newPassword").trim()));
        }
        else if ((matcher = ProfileMenuCommands.UserInfo.getMatcher(input)) != null) {
            System.out.println(controller.userInfo());
        }
        else if ((matcher = ProfileMenuCommands.MenuExit.getMatcher(input)) != null) {
            controller.menuExit();
        }
        else{
            System.out.println("Invalid command");
        }
    }
}
