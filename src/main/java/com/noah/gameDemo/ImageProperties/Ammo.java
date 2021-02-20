package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.noah.gameDemo.base.FrameCon;
import com.noah.gameDemo.base.Keys;
import com.noah.gameDemo.common.PlayerIndex;
import lombok.Data;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * @ClassName Ammo
 * @Description TODO
 * @Author noah
 * @Date 2020-06-04 15:20
 * @Version 1.0
 **/
@Data
public class Ammo extends BaseProperties {

    public Ammo(){
        this.image = new ImageIcon(ImagePathCon.SPLASHING_SWEAT_SYMBOL).getImage();
        this.height = 50;
        this.width = 50;
    }

    private boolean shooting = false;

    public void action(){
        this.shoot();
        this.xMove();
    }

    public void xMove(){
        //跟随玩家移动
        if (!shooting) {
            this.setX(PlayerIndex.X);
        }
    }

    public void shoot(){
        if (Keys.use(KeyEvent.VK_SPACE)) {
            //发射子弹
            shooting = true;
        }
        // 子弹发射,未发射完毕不再重新发射
        if (shooting){
            if (this.getY() >= 0) {
                this.setY(this.getY() - 5);
            }else{
                //发射完毕
                shooting = false;
                this.setY(FrameCon.height);
            }
//            Rectangle enemyRectangle = new Rectangle(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
//            Rectangle ammoRectangle = new Rectangle(ammo.getX(), ammo.getY(), ammo.getWidth(), ammo.getHeight());
//            //判断子弹是否与敌人相交
//            if (enemyRectangle.intersects(ammoRectangle)) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        try {
//                            enemy.setImage(new ImageIcon(ImagePathCon.NAUSEATED_FACE).getImage());
//                            Thread.sleep(500);
//                            enemy.setImage(new ImageIcon(ImagePathCon.FACE_WITH_OPEN_MOUTH).getImage());
//                            Thread.sleep(1000);
//                            enemy.setImage(new ImageIcon(ImagePathCon.FACE_SCREAMING_IN_FEAR).getImage());
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                }).start();
//            }
        }
    }

}
