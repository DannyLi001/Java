package com.hspedu.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class SmallChangeSys {
    public static void main(String[] args) {
        // 1. 显示菜单并可以选择菜单,给出对于提示
        // 2. 完成零钱通明细
        // 3. 完成收益入账
        // 4. 完成消费
        // 5. 退出
        // 6. 确认推出
        // 7. 校验收益入账和消费金额


        // 全局主要变量
        boolean loop = true;
        Scanner scanner = new Scanner(System.in);
        String key = "";
        // 使用String拼接零钱通明细
        String details = "-------------零钱通明细------------";
        // 收益入账变量
        double money = 0;
        double balance = 0;
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        // 消费变量
        String note = "";
        do {
            System.out.println("\n=============零钱通菜单==========");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退      出");

            System.out.print("请选择(1-4): ");
            key = scanner.next();
            // 使用switch操控
            switch (key) {
                case "1":
                    System.out.println(details);
                    break;
                case "2":
                    System.out.print("收益入账金额: ");
                    money = scanner.nextDouble();
                    // 校验money输入
                    // 找出不正确的金额条件, 给出提示并退出
                    if(money < 1){
                        System.out.println("请输入正确金额 > 0");
                        break;
                    }

                    balance += money;
                    // 拼接收益入账details
                    date = new Date(); //获取当前日期
                    details += "\n收益入账\t+" + money + "\t" + sdf.format(date) + "\t" + balance;
                    break;
                case "3":
                    System.out.print("消费金额: ");
                    money = scanner.nextDouble();
                    // 校验
                    if(money < 1 || money > balance){
                        System.out.println("请输入正确金额 0 - " + balance);
                        break;
                    }
                    System.out.print("消费说明: ");
                    note = scanner.next();

                    balance -= money;
                    // 拼接消费details
                    date = new Date(); //获取当前日期
                    details += "\n" + note + "\t-" + money + "\t" + sdf.format(date) + "\t" + balance;

                    break;
                case "4":
                    System.out.println("4 退      出");

                    String choice = "";
                    while (true) {
                        System.out.println("确定退出吗? y/n");
                        choice = scanner.next();
                        if ("y".equals(choice) || "n".equals(choice)) {
                            break;
                        }
                    }
                    if ("y".equals(choice)) {
                        loop = false;
                    }
                    break;
                default:
                    System.out.println("选择有误");
            }
        } while (loop);
    }
}
