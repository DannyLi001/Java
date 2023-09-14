package com.tankgame;

/**
 * @author
 */
public class Tank {
    private int x;
    private int y;
    private int dir;    // 0: up, 1: right, 2: down, 3: left
    private int speed = 1;
    private boolean isAlive = true;

    public Tank(int x, int y) {
        this.x = x;
        this.y = y;
    }



    public void moveUp(){
        if(y - speed < 0)
            return;
        y -= speed;
    }

    public void moveRight(){
        if(x + speed + 60 > 1000)
            return;
        x += speed;
    }

    public void moveDown(){
        if(y + speed + 60 > 750)
            return;
        y += speed;
    }

    public void moveLeft(){
        if(x - speed < 0)
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
}
