package com.Chatclient.view;


import com.Chatclient.service.UserClientService;


import java.util.Scanner;

/**
 * @author
 */
public class ChatView {
    private boolean loop = true;
    private UserClientService userClientService = new UserClientService();

    // test main function
    public static void main(String[] args) {
        new ChatView().mainMenu();
    }

    private void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        while (loop) {
            // login menu
            System.out.println("=======Welcome========");
            System.out.println("1. Login");
            System.out.println("9. Exit");
            System.out.print("Please Enter: ");
            String key = scanner.next();

            switch (key) {
                case "1":
                    System.out.print("UID: ");
                    String userID = scanner.next();
                    System.out.print("Password: ");
                    String pwd = scanner.next();

                    // user interface
                    if (userClientService.checkUser(userID,pwd)) {
                        System.out.println("========Welcome " + userID + "=========");
                        while(loop){
                            System.out.println("\n==========Sub Menu " + userID + "===============");
                            System.out.println("\t\t1 Show Online User List");
                            System.out.println("\t\t2 Group Message");
                            System.out.println("\t\t3 Direct Message");
                            System.out.println("\t\t4 File Sending");
                            System.out.println("\t\t9 Exit");
                            System.out.print("Please Enter: ");

                            key = scanner.next();
                            switch (key){
                                case "1":
                                    userClientService.onlineUserList();
                                    break;
                                case "2":
                                    break;
                                case "3":
                                    break;
                                case "4":
                                    break;
                                case "9":
                                    loop = false;
                                    userClientService.logout();
                                    break;
                                default:
                                    System.out.println("Please enter valid number");
                            }
                        }
                    } else {
                        System.out.println("Login Failed");
                    }
                    break;
                case "9":
                    loop = false;
                    System.out.println("Exited");
                    break;
                default:
                    System.out.println("Please enter 1 or 9");
            }
        }
    }
}
