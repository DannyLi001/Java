public class Homework3 {
	public static void main(String[] args) {
		int money = 100000;
		int count = 0;
		while(money > 0) {
			if(money > 50000){
				money *= 0.95;
				count++;
			} else {
				money -= 1000;
				if(money < 0){
					break;
				}
				count++;
			}
		}
		System.out.println(count);
	}
}