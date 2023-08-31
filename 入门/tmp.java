class A03 {
	public int[] copyArr(int[] arr) {
		if(arr !=  null && arr.length > 0) {

			int[] tmp = new int[arr.length];
			for(int i = 0; i < arr.length; i++) {
				tmp[i] = arr[i];
			}
			return tmp;

		} else {
			return null;
		}
	}
}