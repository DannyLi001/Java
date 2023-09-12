package com.draw.tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author
 */
public class MyPanel extends JPanel implements KeyListener {
    // MyTank
    MyTank myTank = null;
    // enemyTanks
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        myTank = new MyTank(100, 100);
        myTank.setSpeed(5);
        for (int i = 0; i < enemyTankSize; i++) {
            EnemyTank enemyTank = new EnemyTank((100 * (i + 1)), 0);
            enemyTank.setDir(2);
            enemyTanks.add(enemyTank);
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    // AWSD Listener
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDir(0);
            myTank.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDir(1);
            myTank.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDir(2);
            myTank.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDir(3);
            myTank.moveLeft();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        // draw tank
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDir(), 0);
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDir(), 1);
        }


    }

    // function to draw tank

    /**
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
}
