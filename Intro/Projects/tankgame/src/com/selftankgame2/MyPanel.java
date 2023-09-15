package com.selftankgame2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.Vector;

/**
 * @author Danny
 * add health bar for both enemy and player
 * add multi player
 * add boss
 * add sound
 * add score system
 * add ranking board
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // MyTank
    MyTank myTank = null;
    // enemyTanks
    static Vector<EnemyTank> enemyTanks = new Vector<>();
    // nodes to restore previous game
    Vector<Node> nodes = new Vector<>();
    int enemyTankSize = 5;  // number of enemies
    // explosion
    Vector<Explosion> explosions = new Vector<>();

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    // initialize game
    public MyPanel(String key) {
        myTank = new MyTank(500, 500);
        myTank.setSpeed(5);
        Tank.setMyTank(myTank);

        File file = new File(Recorder.getRecordFile());
        if(file.exists()){
            nodes = Recorder.getNodes();
        } else {
            if(key.equals("2")){
                System.out.println("NO PREVIOUS GAME FOUND");
                key = "1";
            }
        }

        switch (key){
            case "1":
                for (int i = 0; i < enemyTankSize; i++) {
                    // create each enemy tank
                    EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
                    enemyTank.setDir(2);
                    // make thread to each enemy tank
                    new Thread(enemyTank).start();
                    // enemy tank shoots
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDir());
                    enemyTank.getBullets().add(bullet);
                    // make thread to each bullet
                    new Thread(bullet).start();
                    // add it to enemy tanks vector
                    enemyTanks.add(enemyTank);
                }
                break;
            case "2":
                for (int i = 0; i < nodes.size(); i++) {
                    Node node = nodes.get(i);
                    // create each enemy tank
                    EnemyTank enemyTank = new EnemyTank(node.getX(), node.getY());
                    enemyTank.setDir(node.getDir());
                    // make thread to each enemy tank
                    new Thread(enemyTank).start();
                    // enemy tank shoots
                    Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDir());
                    enemyTank.getBullets().add(bullet);
                    // make thread to each bullet
                    new Thread(bullet).start();
                    // add it to enemy tanks vector
                    enemyTanks.add(enemyTank);
                }
                break;
        }
//        System.out.println(MyPanel.class.getResource("/explode_1.gif").getPath());
        // get explode image
        image1 = Toolkit.getDefaultToolkit().getImage(com.tankgame.MyPanel.class.getResource("/explode_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(com.tankgame.MyPanel.class.getResource("/explode_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(com.tankgame.MyPanel.class.getResource("/explode_3.gif"));


        // play sound
        new AePlayWave("src\\sound.wav").start();
    }

    // check if a tank got hit
    public Tank hitTank(Bullet bullet, Tank tank) {
        switch (tank.getDir()) {
            // up and down
            case 0:
            case 2:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 40
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 60) {
                    bullet.setAlive(false);
                    tank.setAlive(false);
                    Explosion explosion = new Explosion(tank.getX(), tank.getY());
                    explosions.add(explosion);
                    return tank;
                }
                // left and right
            case 1:
            case 3:
                if (bullet.getX() > tank.getX() && bullet.getX() < tank.getX() + 60
                        && bullet.getY() > tank.getY() && bullet.getY() < tank.getY() + 40) {
                    bullet.setAlive(false);
                    tank.setAlive(false);
                    Explosion explosion = new Explosion(tank.getX(), tank.getY());
                    explosions.add(explosion);
                    return tank;
                }
        }
        return null;
    }

    // check if myTank got hit
    public void hitMe() {
        if (enemyTanks == null)
            return;
        // iterate through each bullet from each enemy tank
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.getBullets() == null)
                return;
            for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                if (enemyTank.getBullets().get(j).isAlive() && myTank.isAlive()) {
                    Tank tank = hitTank(enemyTank.getBullets().get(j), myTank);
                    // myTank got hit
                    if (tank == myTank) {
                        System.out.println("game over");
                    }
                }
            }
        }
    }

    // check if enemy tank got hit
    public void hitEnemy() {
        if (enemyTanks == null)
            return;
        // iterate through each enemy and each of my bullets
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (myTank.getBullets() == null)
                return;
            for (int j = 0; j < myTank.getBullets().size(); j++) {
                Bullet bullet = myTank.getBullets().get(j);
                Tank tank = hitTank(bullet, enemyTank);
                if (tank != null) {
                    // if enemy tank got hit, remove it from vector
                    enemyTanks.remove(tank);
                    Recorder.addEnemyKilled();
                }
            }
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    // keyboard Listener
    @Override
    public void keyPressed(KeyEvent e) {
        // do nothing if game over
        if (!myTank.isAlive()) {
            return;
        }
        // AWSD for movement and SPACE for shooting
        if (e.getKeyCode() == KeyEvent.VK_W) {          // moving up
            myTank.setDir(0);
            if (!myTank.isTouching())
                myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {   // moving right
            myTank.setDir(1);
            if (!myTank.isTouching())
                myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {   // moving down
            myTank.setDir(2);
            if (!myTank.isTouching())
                myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {   // moving left
            myTank.setDir(3);
            if (!myTank.isTouching())
                myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {   // shooting
            myTank.shoot();

        }
        this.repaint(); // refresh the panel
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);        // filling background

        // draw my tank
        if (myTank.isAlive()) {
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDir(), 0);
        }
        // draw enemy tanks
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isAlive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 1);
                // draw enemies' bullets
                for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                    Bullet bullet = enemyTank.getBullets().get(j);
                    if (bullet.isAlive()) {
                        g.setColor(Color.GREEN);
                        g.fill3DRect(bullet.getX() - 1, bullet.getY() - 1, 3, 3, false);
                    } else {
                        enemyTank.getBullets().remove(bullet);
                    }
                }
            }
        }

        // draw my bullets
        for (int i = 0; i < myTank.getBullets().size(); i++) {
            Bullet bullet = myTank.getBullets().get(i);
            if (bullet != null && bullet.isAlive()) {
                g.setColor(Color.MAGENTA);
                g.fill3DRect(bullet.getX() - 1, bullet.getY() - 1, 3, 3, false);
            } else {
                myTank.getBullets().remove(bullet);
            }
        }

        // draw explosion
        for (int i = 0; i < explosions.size(); i++) {
            Explosion explosion = explosions.get(i);
            if (explosion.getLife() > 6) {
                g.drawImage(image1, explosion.getX(), explosion.getY(), 60, 60, this);
            } else if (explosion.getLife() > 3) {
                g.drawImage(image2, explosion.getX(), explosion.getY(), 60, 60, this);
            } else {
                g.drawImage(image3, explosion.getX(), explosion.getY(), 60, 60, this);
            }
            explosion.lifeDown();
            // remove finished explosion
            if (explosion.getLife() == 0) {
                explosions.remove(explosion);
            }
        }


        // draw scoreboard
        drawScoreboard(g);
    }

    /**
     * function to draw tank
     *
     * @param x    x-axis value
     * @param y    y-axis value
     * @param g    graphic tool
     * @param dir  tank's direction
     * @param type tank type
     */
    public void drawTank(int x, int y, Graphics g, int dir, int type) {
        switch (type) {
            case 0:
                g.setColor(Color.MAGENTA);
                break;
            case 1:
                g.setColor(Color.GREEN);
                break;
        }
        // 0: up, 1: right, 2: down, 3: left
        switch (dir) {
            case 0:
                g.fill3DRect(x, y, 10, 60, false);  // left wheel
                g.fill3DRect(x + 30, y, 10, 60, false);   // right wheel
                g.fill3DRect(x + 10, y + 10, 20, 40, false);    // body
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            case 1:
                g.fill3DRect(x, y, 60, 10, false);  // left wheel
                g.fill3DRect(x, y + 30, 60, 10, false);   // right wheel
                g.fill3DRect(x + 10, y + 10, 40, 20, false);    // body
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            case 2:
                g.fill3DRect(x, y, 10, 60, false);  // left wheel
                g.fill3DRect(x + 30, y, 10, 60, false);   // right wheel
                g.fill3DRect(x + 10, y + 10, 20, 40, false);    // body
                g.fillOval(x + 10, y + 20, 20, 20);
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            case 3:
                g.fill3DRect(x, y, 60, 10, false);  // left wheel
                g.fill3DRect(x, y + 30, 60, 10, false);   // right wheel
                g.fill3DRect(x + 10, y + 10, 40, 20, false);    // body
                g.fillOval(x + 20, y + 10, 20, 20);
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;

            default:
        }
    }

    //draw scoreboard
    public void drawScoreboard(Graphics g) {
        g.setColor(Color.BLACK);
        Font font = new Font("Times New Roman", Font.BOLD, 25);
        g.setFont(font);

        g.drawString("Enemy Killed", 1020, 30);
        drawTank(1020, 60, g, 0, 1);
        g.setColor(Color.BLACK);
        g.drawString(Recorder.getEnemyKilledNum() + "",1080,100);
    }

    // add thread to refresh panel consistently
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // check enemy tanks' existence
            hitEnemy();

            // check my tank's existence
            hitMe();
            this.repaint();
        }
    }

}
