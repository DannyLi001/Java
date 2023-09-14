package com.tankgame;

/**
 * @author
 */
public class Bullet implements Runnable {
    private int x;
    private int y;
    private int dir;
    private int speed = 10;
    private boolean isAlive = true;

    public Bullet(int x, int y, int dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    // add thread for bullet lifecycle
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (dir) {
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
//            System.out.println("x = " + x + "; y = " + y);
            if (x < 0 || y < 0 || x > 1000 || y > 750 || !isAlive) {    // out of panel
                isAlive = false;
                break;
            }
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
