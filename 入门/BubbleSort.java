public class BubbleSort {
	public static void main(String[] args) {
		int[] arr1 = {32,45,74,245,467,45,34,654,234,756,0,-12,-31,-523,1};
		for(int i = arr1.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr1[j] > arr1[j + 1]){
					int tmp = arr1[j];
					arr1[j] = arr1[j + 1];
					arr1[j + 1] = tmp;
				}
			}
		}
		for(int i = 0; i < arr1.length; i++){
			System.out.print(arr1[i] + " ");
		}
	}
}