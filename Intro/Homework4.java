public class Homework4 {
	public static void main(String[] args) {
		int[] arr1 = {13,21,34,35,36,43,44,46,54,72};
		int num = 12;
		int[] arr2 = new int[arr1.length + 1];
		int index = -1;
		for(int i = 0; i < arr1.length; i++) {
			if(arr1[i] > num) {
				index = i;
				arr2[i] = num;
				break;
			} else {
				arr2[i] = arr1[i];
			}
		}
		if(index == -1){
			arr2[arr2.length - 1] = num;
		} else {
			for(int i = index; i < arr1.length; i++) {
				arr2[i + 1] = arr1[i];
			}
		}
		arr1 = arr2;
		for(int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i] + " ");
		}
	}
}