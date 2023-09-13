package com.hspedu.houserent.view;

import com.hspedu.houserent.dimain.House;
import com.hspedu.houserent.service.HouseService;

import java.util.Scanner;

public class HouseView {
    // 显示主菜单
    private boolean loop = true;
    private char key = ' ';
    private HouseService houseService = new HouseService(10);
    Scanner scanner = new Scanner(System.in);

    public void updateHouse() {
        System.out.println("--------------修改房屋---------------");
        System.out.println("选择修改房屋编号(-1退出): ");
        int findId = scanner.nextInt();
        if (findId == -1) {
            System.out.println("取消修改");
        } else {
            House house = houseService.findById(findId);
            if (house == null) {
                System.out.println("该房屋不存在");
            } else {
                System.out.println("name(" + house.getName() + "): ");
                String newName = scanner.next();
                if (!"".equals(newName)) {
                    house.setName(newName);
                }
                System.out.println("phone(" + house.getPhone() + "): ");
                String newPhone = scanner.next();
                if (!"".equals(newPhone)) {
                    house.setPhone(newPhone);
                }
                System.out.println("address(" + house.getAddress() + "): ");
                String newAddress = scanner.next();
                if (!"".equals(newAddress)) {
                    house.setAddress(newAddress);
                }
                System.out.println("rent(" + house.getRent() + "): ");
                String newRent = scanner.next();
                if (!"".equals(newRent)) {
                    int rent = Integer.parseInt(newRent);
                    house.setRent(rent);
                }
                System.out.println("state(" + house.getState() + "): ");
                String newState = scanner.next();
                if (!"".equals(newState)) {
                    house.setState(newState);
                }
                System.out.println("==============修改成功==============");
            }
        }
    }


    public void findHouse() {
        System.out.println("--------------查找房屋---------------");
        System.out.println("输入你要查找的id: ");
        int findId = scanner.nextInt();
        House house = houseService.findById(findId);
        if (house == null) {
            System.out.println("--------------没有该房屋------------");
        } else {
            System.out.println(house);
        }
    }

    public void exit() {

        char c = ' ';
        while (c != 'y' && c != 'n') {
            System.out.println("是否确认退出(y/n)");
            c = scanner.next().charAt(0);
        }
        if (c == 'y') {
            System.out.println("成功退出");
            loop = false;
        }
    }

    public void delHouse() {
        System.out.println("===============删除房屋==============");
        System.out.println("选择删除编号(-1退出):");
        int delId = scanner.nextInt();
        if (delId == -1) {
            System.out.println("============退出删除界面=============");
            return;
        }
        char c = ' ';
        while (c != 'y' && c != 'n') {
            System.out.println("确认是否删除(y/n)");
            c = scanner.next().charAt(0);
        }
        if (c == 'y') {
            if (houseService.del(delId)) {
                System.out.println("==========删除成功==========");
            } else {
                System.out.println("==============该编号不存在==============");
            }
        } else {
            System.out.println("==========放弃删除============");
        }
    }

    public void addHouse() {
        System.out.println("==================添加房屋===============");
        System.out.print("姓名: ");
        String name = scanner.next();
        System.out.print("电话: ");
        String phone = scanner.next();
        System.out.print("地址: ");
        String address = scanner.next();
        System.out.print("月租: ");
        int rent = scanner.nextInt();
        System.out.print("状态: ");
        String state = scanner.next();

        House house = new House(0, name, phone, address, rent, state);
        if (houseService.add(house)) {
            System.out.println("success");
        } else {
            System.out.println("failed");
        }
    }

    public void listHouses() {
        System.out.println("============房屋列表============");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        House[] houses = houseService.list();
        for (int i = 0; i < houses.length; i++) {
            if (houses[i] == null) {
                break;
            }
            System.out.println(houses[i]);
        }
        System.out.println("================显示完毕==============");
    }

    public void mainMenu() {
        do {
            System.out.println("===========菜单============");
            System.out.println("\t\t\t1 新增房源");
            System.out.println("\t\t\t2 查找房屋");
            System.out.println("\t\t\t3 删除房屋信息");
            System.out.println("\t\t\t4 修改房屋信息");
            System.out.println("\t\t\t5 房屋列表");
            System.out.println("\t\t\t6 退      出");
            System.out.println("输入选择(1-6): ");
            key = scanner.next().charAt(0);

            switch (key) {
                case '1':
                    addHouse();
                    break;
                case '2':
                    findHouse();
                    break;
                case '3':
                    delHouse();
                    break;
                case '4':
                    updateHouse();
                    break;
                case '5':
                    listHouses();
                    break;
                case '6':
                    exit();
                    break;
            }
        } while (loop);
    }
}
