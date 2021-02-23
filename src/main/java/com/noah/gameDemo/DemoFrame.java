package com.noah.gameDemo;

import com.noah.gameDemo.ImageProperties.Ammo;
import com.noah.gameDemo.ImageProperties.Enemy;
import com.noah.gameDemo.ImageProperties.Player;
import com.noah.gameDemo.base.FrameCon;
import com.noah.gameDemo.base.Keys;
import com.noah.gameDemo.common.Status;
import com.noah.gameDemo.utils.TaskUtil;

import javax.swing.*;
import java.awt.event.*;

/**
 * @ClassName DemoFrame
 * @Description TODO
 * @Author noah
 * @Date 2020-06-03 17:30
 * @Version 1.0
 **/
public class DemoFrame extends JFrame {

    public DemoFrame(){
        //窗体标题
        this.setTitle("demo");
        //窗体退出方式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(FrameCon.width,FrameCon.height);

        //实例化图片属性对象
        //玩家
        Player player = new Player();
        //敌人
        Enemy enemy = new Enemy();
        //子弹
        Ammo ammo = new Ammo();
        //实例化demoPlane
        DemoPanel demoPanel = new DemoPanel(player,enemy,ammo);
        Status.putEntity("enemy",enemy);
        //把panel添加到窗体中
        this.add(demoPanel);
        //设置显示窗体,默认为false
        this.setVisible(true);
        //键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Keys.add(e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {
                Keys.remove(e.getKeyCode());
            }
        });

        //每5毫秒执行一次的定时任务
        TaskUtil.task(5,()->{
            demoPanel.repaint();
            //玩家行动
            player.action();
            //子弹行动
            ammo.action();
            //敌人行动
            enemy.action();
            //重绘画板
            demoPanel.repaint();
        });
    }

    public static void main(String[] args) {
        new DemoFrame();
    }
}
