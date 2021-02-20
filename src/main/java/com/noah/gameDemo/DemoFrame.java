package com.noah.gameDemo;

import com.noah.gameDemo.ImageProperties.Ammo;
import com.noah.gameDemo.ImageProperties.Enemy;
import com.noah.gameDemo.ImageProperties.Player;
import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import sun.security.krb5.internal.ktab.KeyTabEntry;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @ClassName DemoFrame
 * @Description TODO
 * @Author noah
 * @Date 2020-06-03 17:30
 * @Version 1.0
 **/
public class DemoFrame extends JFrame {

    private final int PRINT = 10;

    public DemoFrame() throws Exception{
        this.setTitle("demo");//窗体标题
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//窗体退出方式
        this.setSize(500,500);

        //实例化图片属性对象
        //玩家
        Player player = new Player();
        //敌人
        Enemy enemy = new Enemy();
        //子弹
        Ammo ammo = new Ammo();
        ammo.setY(500);
        player.setY(350);
        //实例化demoPlane
        DemoPanel demoPanel = new DemoPanel(player,enemy,ammo);
        this.add(demoPanel);//把panel添加到窗体中
        this.setVisible(true);//设置显示窗体,默认为false
        this.addKeyListener(new KeyListener() {//键盘监听
            @Override
            public void keyTyped(KeyEvent e) {
                //有按键操作时
            }
            @Override
            public void keyPressed(KeyEvent e) {
                //有按键按下时
                if (KeyEvent.VK_LEFT == e.getKeyCode()){
                    player.setX(player.getX() - PRINT);
                }
                if (KeyEvent.VK_RIGHT == e.getKeyCode()){
                    player.setX(player.getX() + PRINT);
                }
                if (KeyEvent.VK_SPACE == e.getKeyCode()){
                    player.setImage(new ImageIcon(ImagePathCon.KISSING_FACE_WITH_CLOSED_EYES).getImage());
                    ammo.setY(player.getY());
                    ammo.setX(player.getX() + player.getWidth()/2);
                }
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //有按键松开时
                if (KeyEvent.VK_SPACE == e.getKeyCode()){
                    player.setImage(new ImageIcon(ImagePathCon.DROOLING_FACE).getImage());
                }
            }
        });
        while (true){
            Thread.sleep(5);

            if (Enemy.directionFlag){
                enemy.setX(enemy.getX() + 1);
                if (enemy.getX() == this.getWidth()-enemy.getWidth()){
                    Enemy.directionFlag = false;
                }
            }else{
                enemy.setX(enemy.getX() - 1);
                if (enemy.getX() == 0){
                    Enemy.directionFlag = true;
                }
            }
            // 子弹发射
            if (ammo.getY() < 500){
                ammo.setY(ammo.getY() - 5);
                Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
                Rectangle ammoRectangle = new Rectangle(ammo.getX(), ammo.getY(), ammo.getWidth(), ammo.getHeight());
                if (enemyRectangle.intersects(ammoRectangle)) {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                enemy.setImage(new ImageIcon(ImagePathCon.NAUSEATED_FACE).getImage());
                                Thread.sleep(500);
                                enemy.setImage(new ImageIcon(ImagePathCon.FACE_WITH_OPEN_MOUTH).getImage());
                                Thread.sleep(1000);
                                enemy.setImage(new ImageIcon(ImagePathCon.FACE_SCREAMING_IN_FEAR).getImage());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }).start();
                }
            }

            demoPanel.repaint();
        }
    }

    public static void main(String[] args) throws Exception {
        new DemoFrame();
    }
}
