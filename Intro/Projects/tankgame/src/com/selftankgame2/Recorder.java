package com.selftankgame2;


import java.io.*;
import java.util.Vector;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class Recorder {
    private static int enemyKilledNum = 0;      // number of enemy tank you have killed
    private static FileWriter fw = null;
    private static BufferedWriter bw = null;
    private static BufferedReader br = null;
    private static String recordFile = "src\\myRecord.txt";
    private static Vector<EnemyTank> enemyTanks = MyPanel.enemyTanks;
    private static Vector<Node> nodes = new Vector<>();

    // restore previous game data
    public static Vector<Node> getNodes() {
        try {
            br = new BufferedReader(new FileReader(recordFile));
            enemyKilledNum = Integer.parseInt(br.readLine());
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] xyd = line.split(" ");
                Node node = new Node(Integer.parseInt(xyd[0]), Integer.parseInt(xyd[1]), Integer.parseInt(xyd[2]));
                nodes.add(node);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return nodes;
    }

    public static void writeRecord() {
        try {
            bw = new BufferedWriter(new FileWriter(recordFile));
            bw.write(enemyKilledNum + "\r\n");

            for (int i = 0; i < enemyTanks.size(); i++) {
                // record number of enemy tank you have killed
                EnemyTank enemyTank = enemyTanks.get(i);
                if (enemyTank.isAlive()) {
                    // record the positions of tanks which are alive
                    String record = enemyTank.getX() + " " + enemyTank.getY() + " " + enemyTank.getDir();
                    bw.write(record + "\r\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static int getEnemyKilledNum() {
        return enemyKilledNum;
    }

    public static void setEnemyKilledNum(int enemyKilledNum) {
        Recorder.enemyKilledNum = enemyKilledNum;
    }

    public static void addEnemyKilled() {
        Recorder.enemyKilledNum++;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Recorder.enemyTanks = enemyTanks;
    }

    public static String getRecordFile() {
        return recordFile;
    }
}
