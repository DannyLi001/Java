public class CopyObj {
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.name = "name1";
		p1.age = 1;

		Tool tool = new Tool();

		Person p2;
		p2 = tool.copy(p1);
		p1.age = 2;
		System.out.println(p2.age);
		System.out.println(p1.age);
	}
}

class Person {
	String name;
	int age;
}
class Tool {
	public Person copy(Person p) {
		Person newp = new Person();
		newp.name = p.name;
		newp.age = p.age;
		return newp;
	}
}