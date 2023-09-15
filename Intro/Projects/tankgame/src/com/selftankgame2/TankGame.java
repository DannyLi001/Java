package com.selftankgame2;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Scanner;

/**
 * @author Danny
 */
@SuppressWarnings({"all"})
public class TankGame extends JFrame {
    MyPanel mp = null;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }

    public TankGame() {
        System.out.println("NEW GAME PRESS 1 \nCONTINUE PRESS 2");
        String key = "";
        do{
            key = scanner.next();
        } while(!key.equals("1") && !key.equals("2"));
        mp = new MyPanel(key);
        Thread thread = new Thread(mp);
        thread.start();     // always refreshing panel
        this.add(mp);
        this.setSize(1280, 750);
        this.addKeyListener(mp);    // add Listener
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        // save record before exit
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Recorder.writeRecord();
                System.out.println("EXIT");
                System.exit(0);
            }
        });
    }
}
