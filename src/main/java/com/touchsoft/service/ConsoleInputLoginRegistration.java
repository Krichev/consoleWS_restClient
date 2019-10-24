package com.touchsoft.service;

import com.touchsoft.endpoint.LoginRegister;
import com.touchsoft.model.User;

import java.util.Scanner;

public class ConsoleInputLoginRegistration {
    private final static String AGENT = "agent";
    private final static String CLIENT = "client";

    static Scanner scanner = new Scanner(System.in, "utf-8");
    static String role;
    static String username;
    static String password;

    public static void doLoginRegistration() {
        one:
        while (true) {
            System.out.println("Are you registered user? [y/n]");

            while (scanner.hasNext()) {
                String command = scanner.nextLine();
                if (command.equals("y")) {
                    enterLogin();
                    int code = new LoginRegister().loginClient(username, password);
                    if (code == 500) {
                        System.out.println("Something went wrong ");
                        doLoginRegistration();
                    }
                    break one;
                } else if (command.equals("n")) {
                    enterRegister();
                    int code = new LoginRegister().registerClient(username, password, role);
                    if (code != 200) {
                        System.out.println("Server answer with this code " + code + " try again");
                        doLoginRegistration();
                    }
                    break one;
                }
            }
            System.out.println("we will be in infinite loop, until you enter correct command");

//            }
        }

    }

    public static void enterRegister() {
        enterLogin();

        while (true) {
            System.out.println("Are you agent or client [a/c]: ");
            role = scanner.nextLine();
            if (role.contains("a")) {
                role = AGENT;
                break;
            } else if (role.contains("c")) {
                role = CLIENT;
                break;
            }
        }
    }


    public static void enterLogin() {

        while (true) {
            System.out.println("Username: ");
            username = scanner.nextLine();
            username.trim();

            if (username != "" && !username.contains(" ")) {
                System.out.println("Password: ");
                password = scanner.nextLine();
                password.trim();

                if (password != "" && !password.contains(" ") && password.length() > 3) {
                    User.username = username;
                    User.password = password;
                    break;
                } else {
                    System.out.println("Password shouldn`t contain spaces, there should be at least 4 symbols  ");
                }
            } else {
                System.out.println("Username shouldn`t contain spaces");
            }
        }
    }
}
