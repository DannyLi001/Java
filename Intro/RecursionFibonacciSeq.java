public class RecursionFibonacciSeq {
	public static void main(String[] args) {
		int index = 8;
		Tool cal = new Tool();
		int result = cal.cal(index);
		System.out.println(result);
	}
}

class Tool {
	public int cal(int i) {
		if (i < 1){
			return 0;
		} else {
			if(i == 1 || i == 2) {
				return 1;
			} else {
				return cal(i - 1) + cal(i - 2);
			}
		}
	}
}