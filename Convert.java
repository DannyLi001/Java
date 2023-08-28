public class Convert {
	public static void main(String[] args) {

		int n1 = 10;
		// 当多种类型数据混合计算时,系统将首先自动将所有数据转换成容量最大的数据类型, 然后计算
		// float d1 = n1 + 1.1; // 错误 计算结果是double
		double d1 = n1 + 1.1;
		float d2 = n1 + 1.1F;

		// 当把精度大的数据赋值给精度小的数据时, 会报错, 反之自动转换
		// int n2 = 1.1 // 错误


		// 当把数赋给byte时,先判断数值是否在byte范围内,如果是就可以
		byte b1 = 10; // 对

		int n2 = 1;
		// byte b2 = n2; // 错误 变量赋值,判断类型

		// byte,short 和char之间不能相互自动转换
		// char c1 = b1; // 错误

		// byte, short, char 三者可以计算, 但首先转换为int类型
		byte b2 = 1;
		short s1 = 1;
		// short s2 = b2 + s1; //错误
		// byte b4 = b2 + b3; // 错误
	}
}
