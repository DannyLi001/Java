package com.selftankgame2;

import java.util.Vector;

/**
 * @author Danny
 */
@SuppressWarnings({"all"})
public class Tank {
    private int x;
    private int y;
    private int dir;    // 0: up, 1: right, 2: down, 3: left
    private int speed = 1;
    private boolean isAlive = true;


    private Vector<Bullet> bullets = new Vector<>();

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }


    private static Vector<EnemyTank> enemyTanks = new Vector<>();
    private static MyTank myTank = null;
    private static Vector<Tank> tanks = new Vector<>();

    public static void setMyTank(MyTank myTank) {
        Tank.myTank = myTank;
    }

    public static void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        Tank.enemyTanks = enemyTanks;
    }


    public boolean isTouching() {
        tanks.addAll(MyPanel.enemyTanks);
        tanks.add(myTank);
        switch (this.getDir()) {
            case 0:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    if(!tank.isAlive)
                        return false;
                    if (tank != this) {
                        if (tank.getDir() == 0 || tank.getDir() == 2) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 40 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 60)
                                return true;
                            if (getX() + 40 >= tank.getX() &&
                                    getX() + 40 <= tank.getX() + 40 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 60)
                                return true;
                        }
                        if (tank.getDir() == 1 || tank.getDir() == 3) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 60 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 40)
                                return true;
                            if (getX() + 40 >= tank.getX() &&
                                    getX() + 40 <= tank.getX() + 60 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 1:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    if(!tank.isAlive)
                        return false;
                    if (tank != this) {
                        if (tank.getDir() == 0 || tank.getDir() == 2) {
                            if (getX() + 60 >= tank.getX() &&
                                    getX() + 60 <= tank.getX() + 40 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 60)
                                return true;
                            if (getX() + 60 >= tank.getX() &&
                                    getX() + 60 <= tank.getX() + 40 &&
                                    getY() + 40 >= tank.getY() &&
                                    getY() + 40 <= tank.getY() + 60)
                                return true;
                        }
                        if (tank.getDir() == 1 || tank.getDir() == 3) {
                            if (getX() + 60 >= tank.getX() &&
                                    getX() + 60 <= tank.getX() + 60 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 40)
                                return true;
                            if (getX() + 60 >= tank.getX() &&
                                    getX() + 60 <= tank.getX() + 60 &&
                                    getY() + 40 >= tank.getY() &&
                                    getY() + 40 <= tank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    if(!tank.isAlive)
                        return false;
                    if (tank != this) {
                        if (tank.getDir() == 0 || tank.getDir() == 2) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 40 &&
                                    getY() + 60 >= tank.getY() &&
                                    getY() + 60 <= tank.getY() + 60)
                                return true;
                            if (getX() + 40 >= tank.getX() &&
                                    getX() + 40 <= tank.getX() + 40 &&
                                    getY() + 60 >= tank.getY() &&
                                    getY() + 60 <= tank.getY() + 60)
                                return true;
                        }
                        if (tank.getDir() == 1 || tank.getDir() == 3) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 60 &&
                                    getY() + 60 >= tank.getY() &&
                                    getY() + 60 <= tank.getY() + 40)
                                return true;
                            if (getX() + 40 >= tank.getX() &&
                                    getX() + 40 <= tank.getX() + 60 &&
                                    getY() + 60 >= tank.getY() &&
                                    getY() + 60 <= tank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < tanks.size(); i++) {
                    Tank tank = tanks.get(i);
                    if(!tank.isAlive)
                        return false;
                    if (tank != this) {
                        if (tank.getDir() == 0 || tank.getDir() == 2) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 40 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 60)
                                return true;
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 40 &&
                                    getY() + 40 >= tank.getY() &&
                                    getY() + 40 <= tank.getY() + 60)
                                return true;
                        }
                        if (tank.getDir() == 1 || tank.getDir() == 3) {
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 60 &&
                                    getY() >= tank.getY() &&
                                    getY() <= tank.getY() + 40)
                                return true;
                            if (getX() >= tank.getX() &&
                                    getX() <= tank.getX() + 60 &&
                                    getY() + 40 >= tank.getY() &&
                                    getY() + 40 <= tank.getY() + 40)
                                return true;

                        }
                    }
                }
                break;
        }
        return false;
    }


    public void moveUp() {
        if (y - speed < 0)
            return;
        y -= speed;
    }

    public void moveRight() {
        if (x + speed + 60 > 1000)
            return;
        x += speed;
    }

    public void moveDown() {
        if (y + speed + 60 > 750)
            return;
        y += speed;
    }

    public void moveLeft() {
        if (x - speed < 0)
            return;
        x -= speed;
    }

    public int getDir() {
        return dir;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDir(int dir) {
        this.dir = dir;
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

}
