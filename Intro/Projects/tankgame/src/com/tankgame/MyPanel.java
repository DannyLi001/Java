package com.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author
 */
@SuppressWarnings({"all"})
public class MyPanel extends JPanel implements KeyListener, Runnable {
    // MyTank
    MyTank myTank = null;
    // enemyTanks
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;  // number of enemies
    // explosion
    Vector<Explosion> explosions = new Vector<>();

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    public MyPanel() {
        myTank = new MyTank(500, 500);
        myTank.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            // create each enemy tank
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDir(2);
            // make thread to let them move randomly
            new Thread(enemyTank).start();
            Bullet bullet = new Bullet(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDir());
            enemyTank.getBullets().add(bullet);
            new Thread(bullet).start();
            // add it to enemy tanks vector
            enemyTanks.add(enemyTank);
        }
//        System.out.println(MyPanel.class.getResource("/explode_1.gif").getPath());
        image1 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/explode_1.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/explode_2.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(MyPanel.class.getResource("/explode_3.gif"));
    }

    public void hitMe(){
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.getBullets().size(); j++) {
                if(enemyTank.getBullets().get(j) != null && enemyTank.getBullets().get(j).isAlive() && myTank.isAlive()){
                    hitEnemy(enemyTank.getBullets().get(j), myTank);
                }
            }
        }
    }

    public void hitEnemy(Bullet bullet, Tank enemyTank) {
        switch (enemyTank.getDir()) {
            // up and down
            case 0:
            case 2:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 40
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 60) {
                    bullet.setAlive(false);
                    enemyTank.setAlive(false);
                    Explosion explosion = new Explosion(enemyTank.getX(), enemyTank.getY());
                    explosions.add(explosion);
                    enemyTanks.remove(enemyTank);
                }
                break;
            // left and right
            case 1:
            case 3:
                if (bullet.getX() > enemyTank.getX() && bullet.getX() < enemyTank.getX() + 60
                        && bullet.getY() > enemyTank.getY() && bullet.getY() < enemyTank.getY() + 40) {
                    bullet.setAlive(false);
                    enemyTank.setAlive(false);
                    Explosion explosion = new Explosion(enemyTank.getX(), enemyTank.getY());
                    explosions.add(explosion);
                    enemyTanks.remove(enemyTank);
                }
                break;
        }
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    // keyboard Listener
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {          // moving up
            myTank.setDir(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {   // moving right
            myTank.setDir(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {   // moving down
            myTank.setDir(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {   // moving left
            myTank.setDir(3);
            myTank.moveLeft();
        } else if (e.getKeyCode() == KeyEvent.VK_SPACE) {   // shooting
            // one bullet at a time
//            if (myTank.bullet == null || !myTank.bullet.isAlive())
//                myTank.shoot();
            // multi bullets at a time
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

        // draw tanks
        if(myTank.isAlive()){
            drawTank(myTank.getX(), myTank.getY(), g, myTank.getDir(), 0);
        }
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.isAlive()) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 1);
                // enemies' bullets
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

        // draw bullet

        // one bullet at a time
//        if (myTank.bullet != null && myTank.bullet.isAlive()) {
//            g.setColor(Color.MAGENTA);
//            g.fill3DRect(myTank.bullet.getX() - 1, myTank.bullet.getY() - 1, 3, 3, false);
//        }

        // multi bullets at a time
        for (int i = 0; i < myTank.bullets.size(); i++) {
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

    // add thread to refresh panel consistently
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // check enemy tanks' existence
            for (int i = 0; i < myTank.bullets.size(); i++) {
                if (myTank.bullets.get(i) != null && myTank.bullets.get(i).isAlive()) {
                    for (int j = 0; j < enemyTanks.size(); j++) {
                        EnemyTank enemyTank = enemyTanks.get(j);
                        hitEnemy(myTank.bullets.get(i), enemyTank);
                    }
                }
            }
//            if (myTank.bullet != null && myTank.bullet.isAlive()) {
//                for (int i = 0; i < enemyTanks.size(); i++) {
//                    EnemyTank enemyTank = enemyTanks.get(i);
//                    hitEnemy(myTank.bullet, enemyTank);
//                }
//            }


            // check my tank's existence
            hitMe();
            this.repaint();
        }
    }

}

