package com.selftankgame;



/**
 * @author Danny
 */
public class MyTank extends Tank{
    private int bulletAllow = 5;
    private Bullet bullet;

    public MyTank(int x, int y) {
        super(x, y);
    }

    // Shooting bullet
    public void shoot() {
        if (getBullets().size() > bulletAllow - 1) {
            return;
        }
        // set bullet position
        switch (getDir()) {
            case 0:
                bullet = new Bullet(getX() + 20, getY(), 0);
                break;
            case 1:
                bullet = new Bullet(getX() + 60, getY() + 20, 1);
                break;
            case 2:
                bullet = new Bullet(getX() + 20, getY() + 60, 2);
                break;
            case 3:
                bullet = new Bullet(getX(), getY() + 20, 3);
                break;
        }

        getBullets().add(bullet);
        new Thread(bullet).start();

        // new thread to track bullet
    }

    public int getBulletAllow() {
        return bulletAllow;
    }

    public void setBulletAllow(int bulletAllow) {
        this.bulletAllow = bulletAllow;
    }
}
