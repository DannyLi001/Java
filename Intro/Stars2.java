public class Stars2 {
	public static void main(String[] args) {
		int layer = 15;
		int half = (layer % 2 == 1) ? layer/2+1 : layer/2;
		for(int i = 1; i <= layer; i++) {
			if(i > half){
				for(int z = 1; z <= i - half; z++){
					System.out.print(' ');
				}
				for(int j = 1; j <= (i - (i - half)*2)*2-1; j++){
					if(j == 1 || j == (i - (i - half)*2)*2-1){
						System.out.print('*');
					} else {
						System.out.print(" ");
					}
				}
			} else {
				for(int z = 1; z <= half - i; z++){
					System.out.print(' ');
				}
				for(int j = 1; j <= 2*i-1; j++){
					if(j == 1 || j == 2*i-1){
						System.out.print('*');
					} else {
						System.out.print(" ");
					}
				}
			}
			System.out.println("");
		}
	}
}