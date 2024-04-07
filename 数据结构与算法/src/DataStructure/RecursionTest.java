package DataStructure;

public class RecursionTest {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        map[3][1] = 1;
        map[3][2] = 1;

        setWay(map, 1, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

    }

    /* 
     * 从地图（1，1）出发
     * 如果到达（6，5）说明找到通路
     * 约定：0表示没有走过，1表示墙，2表示可以走，3表示已经走过，但是不通
     * 策略：下->右->上->左，如果不通，回溯
     */
    /**
     * 
     * @param map 地图
     * @param i   从哪个位置开始找
     * @param j
     * @return 如果找到返回true 否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        } else {
            if(map[i][j] == 0) {
                map[i][j] = 2;
                if (setWay(map, i+1, j)) {
                    return true;
                } else if (setWay(map, i, j + 1)){
                    return true;
                } else if (setWay(map, i - 1, j)){
                    return true;
                } else if (setWay(map, i, j - 1)){
                    return true;
                } else {
                    map[i][j] = 3;
                    return false;
                }
            } else {
                return false;
            }
        }

    }

}