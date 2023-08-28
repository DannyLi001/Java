public class ForceConvert {
	public static void main(String[] args) {
		//只针对最近的操作数有效
		// int x = (int)10 * 3.5 - 5; 错误
		int x = (int)(10 * 3.5 - 5);
		System.out.println(x);

		// char可以保存int的常量值, 但不能保存int的变量值, 需强转
		char c1 = 100;
		int m = 100;
		// char c2 = m; // 错误
		System.out.println((char)m);
	}
}