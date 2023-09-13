public class RecursionEx01 {
	public static void main(String[] args) {
		Cal cal = new Cal();
		int day = 0;
		int peaches = cal.cal(day);
		System.out.println(peaches);
	}
}

class Cal {
	public int cal(int day) {
		if(day == 10) {
			return 1;
		} else if (day <= 9){
			return (cal(day + 1) + 1) * 2;
		} else {
			return 0;
		}
	}
}