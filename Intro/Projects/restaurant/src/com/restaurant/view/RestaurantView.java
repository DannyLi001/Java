package com.restaurant.view;

import com.restaurant.domain.Bill;
import com.restaurant.domain.DiningTable;
import com.restaurant.domain.Employee;
import com.restaurant.domain.Menu;
import com.restaurant.service.BillService;
import com.restaurant.service.DiningTableService;
import com.restaurant.service.EmployeeService;
import com.restaurant.service.MenuService;
import com.restaurant.utils.Utility;

import java.beans.Transient;
import java.util.List;

/**
 * @author
 */
public class RestaurantView {
    private boolean loop = true;
    private String key = "";
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService diningTableService = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new RestaurantView().mainMenu();
    }

    public void mainMenu() {
        while (loop) {
            System.out.println("==========Restaurant===========");
            System.out.println("\t\t1 Login");
            System.out.println("\t\t2 Exit");
            System.out.print("Please Enter: ");
            key = Utility.readString(1);
            switch (key) {
                case "1":
                    System.out.print("Username: ");
                    String empId = Utility.readString(50);
                    System.out.print("Password: ");
                    String pwd = Utility.readString(50);
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, pwd);
                    if (employee != null) {
                        System.out.println("============Login Success[" + employee.getName() + "]=============");
                        while (loop) {
                            System.out.println("============Submenu==============");
                            System.out.println("\t\t1 View Table Status");
                            System.out.println("\t\t2 Reserve Table");
                            System.out.println("\t\t3 View All Dishes");
                            System.out.println("\t\t4 Order");
                            System.out.println("\t\t5 View Bills");
                            System.out.println("\t\t6 Check");
                            System.out.println("\t\t9 Exit");
                            System.out.print("Please Enter: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    listDiningTable();
                                    break;
                                case "2":
                                    orderDiningTable();
                                    break;
                                case "3":
                                    listMenu();
                                    break;
                                case "4":
                                    orderMenu();
                                    break;
                                case "5":
                                    listBill();
                                    break;
                                case "6":
                                    payBill();
                                    break;
                                case "9":
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("Please Enter Valid Choice");
                            }
                        }
                    } else {
                        System.out.println("============Login Failed=============");
                    }
                    break;
                case "2":
                    loop = false;
                    break;
                default:
                    System.out.println("Please Enter Valid Choice");
            }
        }
    }

    public void listDiningTable() {
        List<DiningTable> list = diningTableService.list();
        System.out.println("\nTable ID\t\tTable Status");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("=============End==============");
    }

    public void orderDiningTable() {
        System.out.println("==========Reserve Table=========");
        System.out.print("Table ID(Exit -1): ");
        int i = Utility.readInt();
        if (i == -1) {
            System.out.println("==============Exit=============");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            DiningTable diningTable = diningTableService.getDiningTableById(i);
            if (diningTable == null) {
                System.out.println("=============Table Doesn't Exist============");
                return;
            }
            if (!"empty".equals(diningTable.getState())) {
                System.out.println("=============Table Is Reserved/Occupied===========");
                return;
            }
            System.out.print("Guest's Name: ");
            String orderName = Utility.readString(50);
            System.out.print("Guest's Phone Number: ");
            String orderTel = Utility.readString(50);
            if (diningTableService.orderDiningTable(i, orderName, orderTel)) {
                System.out.println("==============Reserved Success============");
            } else {
                System.out.println("===============Reserved Failed===============");
            }
        } else {
            System.out.println("==========Exit=============");
        }
    }

    public void listMenu() {
        List<Menu> list = menuService.list();
        System.out.println("\nID\t\tName\t\tType\t\tPrice");
        for (Menu menu : list) {
            System.out.println(menu);
        }

        System.out.println("=========End===========");
    }

    public void orderMenu() {
        System.out.println("==============Order============");
        System.out.print("Oder Table ID(-1 Exit): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("Canceled");
            return;
        }
        System.out.print("Dish ID(-1 Exit): ");
        int dishId = Utility.readInt();
        if (dishId == -1) {
            System.out.println("Canceled");
            return;
        }
        System.out.print("Number(-1 Exit): ");
        int orderNum = Utility.readInt();
        if (orderNum == -1) {
            System.out.println("Canceled");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("============Table ID Doesn't Exist===============");
            return;
        }
        Menu menu = menuService.getMenuById(dishId);
        if (menu == null) {
            System.out.println("============Dish Doesn't Exist=============");
            return;
        }

        if (billService.orderMenu(dishId, orderNum, orderDiningTableId)) {
            System.out.println("=============Order Success===============");
        } else {
            System.out.println("=============Order Failed================");
        }
    }

    public void listBill() {
        List<Bill> billList = billService.list();
        System.out.println("\nID\t\tDish\t\tNums\t\tTotal Price\t\tTable ID\t\tDate\t\t\t\t\tStatus");
        for (Bill bill : billList) {
            System.out.println(bill);
        }
        System.out.println("============End==============");

    }

    public void payBill() {
        System.out.println("=============Check============");
        System.out.print("Oder Table ID(-1 Exit): ");
        int orderDiningTableId = Utility.readInt();
        if (orderDiningTableId == -1) {
            System.out.println("Canceled");
            return;
        }
        DiningTable diningTable = diningTableService.getDiningTableById(orderDiningTableId);
        if (diningTable == null) {
            System.out.println("=============Table ID Doesn't Exist=============");
            return;
        }
        if (!billService.hasPayBillByDiningTableId(orderDiningTableId)) {
            System.out.println("=============No Bill Found=============");
            return;
        }
        System.out.print("Payment Method(Press Enter to Exit): ");
        String method = Utility.readString(20, "");
        if ("".equals(method)) {
            System.out.println("Canceled");
            return;
        }
        char key = Utility.readConfirmSelection();
        if (key == 'Y') {
            if (billService.payBill(orderDiningTableId, method)) {
                System.out.println("==============Payment Success============");
            } else {
                System.out.println("==============Payment Failed=============");
            }
        } else {
            System.out.println("Canceled");
        }
    }
}
