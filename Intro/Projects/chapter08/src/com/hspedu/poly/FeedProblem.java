package com.hspedu.poly;

public class FeedProblem {
    public static void main(String[] args) {
        Food food = new Bone();
        Pet pet = new Pig();
        Master master = new Master();
        master.feed(pet, food);
        pet = new Tiger();
        food = new Corn();
        master.feed(pet,food);
    }
}

class Master {
    public void feed(Pet pet, Food food) {
        System.out.println(pet.name + " " + food.name);
    }
}

class Pet {
    String name;
}

class Food {
    String name;
}

class Bone extends Food {
    String name = "bone";

    public Bone() {
        super.name = name;
    }
}

class Corn extends Food {
    String name = "corn";

    public Corn() {
        super.name = name;
    }
}

class Pig extends Pet {
    String name = "pig";

    public Pig() {
        super.name = name;
    }
}

class Tiger extends Pet {
    String name = "tiger";

    public Tiger() {
        super.name = name;
    }
}