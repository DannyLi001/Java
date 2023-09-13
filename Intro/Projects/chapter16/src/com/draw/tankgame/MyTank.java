package com.draw.tankgame;

import java.util.Vector;

/**
 * @author
 */
public class MyTank extends Tank {
    Vector<Bullet> bullets = new Vector<>();
    Bullet bullet = null;
    private int bulletAllow = 5;

    public MyTank(int x, int y) {
        super(x, y);
    }

    // Shooting bullet
    public void shoot() {
        if (bullets.size() > bulletAllow - 1) {
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

        bullets.add(bullet);
        new Thread(bullet).start();

        // new thread to track bullet
    }

    public Vector<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(Vector<Bullet> bullets) {
        this.bullets = bullets;
    }

    public Bullet getBullet() {
        return bullet;
    }

    public void setBullet(Bullet bullet) {
        this.bullet = bullet;
    }
}
