public class HanoiTower {
	public static void main(String[] args) {
		Tower t1 = new Tower();
		t1.move(5,'A','B','C');
	}
}
class Tower{
	public void move(int num, char a, char b, char c) {
		//如果只有一个盘
		if(num == 1){
			System.out.println(a + "->" + c);
		} else {
			// 如果多个盘, 当成两个,最下面和上面的
			// 1. 先移动上面所有盘到b, 借助c
			move(num - 1, a, c, b);
			// 2. 把最下面的盘移动到c
			System.out.println(a + "->" + c);
			// 3. 把b的所有盘移动到c,借助a
			move(num - 1, b, a, c);
		}
	}
}