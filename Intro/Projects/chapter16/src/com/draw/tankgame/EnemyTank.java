package com.draw.tankgame;

import java.util.Vector;

/**
 * @author
 */
public class EnemyTank extends Tank implements Runnable {
    private Vector<Bullet> bullets = new Vector<>();

    private static Vector<EnemyTank> enemyTanks = new Vector<>();
    private boolean isAlive = true;
    private int step = 30;
    private int moveSleepT = 30;
    private int bulletAllow = 3;

    public EnemyTank(int x, int y) {
        super(x, y);
    }


    public boolean isTouching() {
        switch (this.getDir()) {
            case 0:
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank != this) {
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            if (getX() >= enemyTank.getX() &&
                                    getX() <= enemyTank.getX() + 40 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 60)
                                return true;
                            if (getX() + 40 >= enemyTank.getX() &&
                                    getX() + 40 <= enemyTank.getX() + 40 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 60)
                                return true;
                        }
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (getX() >= enemyTank.getX() &&
                                    getX() <= enemyTank.getX() + 60 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 40)
                                return true;
                            if (getX() + 40 >= enemyTank.getX() &&
                                    getX() + 40 <= enemyTank.getX() + 60 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 1:
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank != this) {
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            if (getX() + 60 >= enemyTank.getX() &&
                                    getX() + 60 <= enemyTank.getX() + 40 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 60)
                                return true;
                            if (getX() + 60 >= enemyTank.getX() &&
                                    getX() + 60 <= enemyTank.getX() + 40 &&
                                    getY() + 40 >= enemyTank.getY() &&
                                    getY() + 40 <= enemyTank.getY() + 60)
                                return true;
                        }
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (getX() + 60 >= enemyTank.getX() &&
                                    getX() + 60 <= enemyTank.getX() + 60 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 40)
                                return true;
                            if (getX() + 60 >= enemyTank.getX() &&
                                    getX() + 60 <= enemyTank.getX() + 60 &&
                                    getY() + 40 >= enemyTank.getY() &&
                                    getY() + 40 <= enemyTank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 2:
                for (EnemyTank enemyTank : enemyTanks) {
                    if (enemyTank != this) {
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            if (getX() >= enemyTank.getX() &&
                                    getX() <= enemyTank.getX() + 40 &&
                                    getY() + 60 >= enemyTank.getY() &&
                                    getY() + 60 <= enemyTank.getY() + 60)
                                return true;
                            if (getX() + 40 >= enemyTank.getX() &&
                                    getX() + 40 <= enemyTank.getX() + 40 &&
                                    getY() + 60 >= enemyTank.getY() &&
                                    getY() + 60 <= enemyTank.getY() + 60)
                                return true;
                        }
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (getX() >= enemyTank.getX() &&
                                    getX() <= enemyTank.getX() + 60 &&
                                    getY() + 60 >= enemyTank.getY() &&
                                    getY() + 60 <= enemyTank.getY() + 40)
                                return true;
                            if (getX() + 40 >= enemyTank.getX() &&
                                    getX() + 40 <= enemyTank.getX() + 60 &&
                                    getY() + 60 >= enemyTank.getY() &&
                                    getY() + 60 <= enemyTank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    if (enemyTank != this) {
                        if (enemyTank.getDir() == 0 || enemyTank.getDir() == 2) {
                            if (getX()  >= enemyTank.getX() &&
                                    getX()  <= enemyTank.getX() + 40 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 60)
                                return true;
                            if (getX()  >= enemyTank.getX() &&
                                    getX()  <= enemyTank.getX() + 40 &&
                                    getY() + 40 >= enemyTank.getY() &&
                                    getY() + 40 <= enemyTank.getY() + 60)
                                return true;
                        }
                        if (enemyTank.getDir() == 1 || enemyTank.getDir() == 3) {
                            if (getX()  >= enemyTank.getX() &&
                                    getX()  <= enemyTank.getX() + 60 &&
                                    getY() >= enemyTank.getY() &&
                                    getY() <= enemyTank.getY() + 40)
                                return true;
                            if (getX()  >= enemyTank.getX() &&
                                    getX()  <= enemyTank.getX() + 60 &&
                                    getY() + 40 >= enemyTank.getY() &&
                                    getY() + 40 <= enemyTank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
        }
        return false;
    }


    @Override
    public void run() {
        while (true) {
            // shooting bullets
            if (isAlive && bullets.size() < bulletAllow) {
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
                        if (!isTouching())
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
                        if (!isTouching())
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
                        if (!isTouching())
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
                        if (!isTouching())
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

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public static Vector<EnemyTank> getEnemyTanks() {
        return enemyTanks;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        EnemyTank.enemyTanks = enemyTanks;
    }
}
