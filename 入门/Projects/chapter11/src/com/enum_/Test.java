package com.enum_;

/**
 * @author
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock frock1 = new Frock();
        System.out.println(frock1);
        Frock frock2 = new Frock();
        System.out.println(frock2);
        Frock frock3 = new Frock();
        System.out.println(frock3);
    }
}

class Frock {
    private static int currentNum = 100000;
    private int serialNumber;

    public Frock() {
        this.serialNumber = getNextNum();
    }

    public static int getNextNum(){
        currentNum += 100;
        return currentNum;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return "Frock{" +
                "serialNumber='" + serialNumber + '\'' +
                '}';
    }
}