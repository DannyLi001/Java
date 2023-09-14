package com.tankgame;

import java.util.Vector;

/**
 * @author
 */
public class EnemyTank extends Tank implements Runnable {
    private Vector<Bullet> bullets = new Vector<>();
    private int step = 30;
    private int moveSleepT = 30;
    private int bulletAllow = 3;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    @Override
    public void run() {
        while (true) {
            // shooting bullets
            if (super.isAlive() && bullets.size() < bulletAllow) {
                Bullet bullet = null;
                switch (getDir()) {
                    case 0:
                        bullet = new Bullet(getX() + 20, getY(), getDir());
                        break;
                    case 1:
                        bullet = new Bullet(getX() + 60, getY() + 20, getDir());
                        break;
                    case 2:
                        bullet = new Bullet(getX() + 20, getY() + 60, getDir());
                        break;
                    case 3:
                        bullet = new Bullet(getX(), getY() + 20, getDir());
                        break;

                }
                bullets.add(bullet);
                Thread thread = new Thread(bullet);
                thread.start();
            }
            // randomly moving
            switch (getDir()) {
                case 0:
                    for (int i = 0; i < step; i++) {
                        moveUp();
                        try {
                            Thread.sleep(moveSleepT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    break;
                case 1:
                    for (int i = 0; i < step; i++) {
                        moveRight();
                        try {
                            Thread.sleep(moveSleepT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < step; i++) {
                        moveDown();
                        try {
                            Thread.sleep(moveSleepT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < step; i++) {
                        moveLeft();
                        try {
                            Thread.sleep(moveSleepT);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }
            setDir((int) (Math.random() * 4));
            if (!isAlive()) {
                break;
            }
        }
    }



    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }
}
