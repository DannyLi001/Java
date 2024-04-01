package DataStructure;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SparseArray {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        int chessArr1[][] = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;

        for (int[] row : chessArr1) {
            for (int data  : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }

        int sparseArr1[][] = new int[sum+1][3];
        sparseArr1[0][0] = 11;
        sparseArr1[0][1] = 11;
        sparseArr1[0][2] = sum;


        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(chessArr1[i][j] != 0){
                    count++;
                    sparseArr1[count][0] = i;
                    sparseArr1[count][1] = j;
                    sparseArr1[count][2] = chessArr1[i][j];

                }
            }
        }

        System.out.println("---------------------------------");
        for (int i = 0; i < sparseArr1.length; i++) {
            System.out.printf("%d\t%d\t%d", sparseArr1[i][0], sparseArr1[i][1], sparseArr1[i][2]);
            System.out.println();
        }

        String path = "map.data";
        ObjectOutputStream oos  = new ObjectOutputStream(new FileOutputStream(path));
        oos.writeObject(sparseArr1);
        oos.close();


        System.out.println("-----------------------------------------");

        // int sparseArr2[][] = sparseArr1.clone();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
        Object o = ois.readObject();
        int sparseArr2[][] = (int[][]) o;
        ois.close();

        int chessArr2[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];

        for (int i = 1; i < sparseArr2.length; i++) {
            chessArr2[sparseArr2[i][0]][sparseArr2[i][1]] = sparseArr2[i][2];
        }





        for (int[] row : chessArr2) {
            for (int data  : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }






    }
    
}
