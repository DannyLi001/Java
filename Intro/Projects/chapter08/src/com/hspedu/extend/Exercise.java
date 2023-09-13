package com.hspedu.extend;

public class Exercise {
    public static void main(String[] args) {
        PC pc = new PC();
        NotePad notePad = new NotePad();
        pc.brand = "123";
        notePad.color = "321";
        pc.printInfo();

    }
}

class Computer {
    public String CPU;
    public String Mem;
    public String Disk;

    public String getDetails() {
        return CPU + Mem + Disk;
    }
}

class PC extends Computer {
    public String brand;

    public void printInfo(){
        System.out.println(getDetails() + brand);
    }
}

class NotePad extends Computer {
    String color;
}
