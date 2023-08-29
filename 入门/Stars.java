public class Stars {
	public static void main(String[] args) {
		
		int layer = 9;
		for(int i = 1; i <= layer; i++) {
			for(int z = 1; z <= layer - i; z++){
				System.out.print(' ');
			}
			for(int j = 1; j <= 2*i-1; j++){
				if(j == 1 || j == 2*i-1 || i == layer) {
					System.out.print('*');	
				} else {
					System.out.print(' ');
				}
			}
			System.out.print('\n');
		}
	}
}