public class ObjectMethod {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.speak();
	}
}


class Person {
	String name;
	int age;

	// speak 方法名 	() 形参列表
	public void speak() {
		System.out.println("something...");
	}
}