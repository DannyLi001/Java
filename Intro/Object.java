public class Object {
	public static void main(String[] args) {
		Cat cat1 = new Cat();
		cat1.name = "miao";
		cat1.age = 3;
		cat1.color = "white";
		cat1.weight = 12;

		// cat1 和 2 都是猫类的一个对象
		Cat cat2 = new Cat();
		cat2.name = "kao";
		cat2.age = 5;
		cat2.color = "black";
		cat2.weight = 10;

	}
}

class Cat {
	String name;
	int age;
	String color;
	double weight;

}