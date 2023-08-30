public class YangHuiTri {
	public static void main(String[] args) {
		int layer = 10;
		int[][] tri = new int[layer][];
		for(int i = 0; i < layer; i++) {
			tri[i] = new int[i + 1];
			for(int j = 0; j < i + 1; j++) {
				if(j == 0 || j == i) {
					tri[i][j] = 1;
				} else {
					tri[i][j] = tri[i - 1][j - 1] + tri[i - 1][j];
				}
			}
		}
		for(int i = 0; i < tri.length; i++) {
			for(int j = 0; j < tri[i].length; j++){
				System.out.print(tri[i][j] + " ");
			}
			System.out.println();
		}
	}
}