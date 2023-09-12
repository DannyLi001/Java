package com.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author
 */
public class DrawCircle extends JFrame{
    // 定义一个面板
    private MyPanel mp = null;
    public static void main(String[] args) {
        new DrawCircle();
    }
    public DrawCircle(){
        mp = new MyPanel();
        // 把画板放入窗口
        this.add(mp);
        this.setSize(400, 300);
        // 关闭窗口 退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
// 1. 先定义一个MyPanel，继承Jpanel类
class MyPanel extends JPanel{
    // 1. Mypanel对象就是一个画板
    // 2. g就是一支笔
    // 3. Graphics 提供了很多绘画的方法
    @Override
    public void paint(Graphics g) { // 绘图方法
        super.paint(g); // 调用父类方法完成初始化
        g.drawOval(10,10,100,100);

        // 绘制不同图形
        g.drawLine(10,10,100,100);
        Image image = Toolkit.getDefaultToolkit().getImage("/");

    }
}