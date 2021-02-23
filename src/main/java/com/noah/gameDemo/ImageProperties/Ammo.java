package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.noah.gameDemo.base.FrameCon;
import com.noah.gameDemo.base.Keys;
import com.noah.gameDemo.common.PlayerIndex;
import com.noah.gameDemo.common.Status;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Map;

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
        this.y = 500;
        this.height = 50;
        this.width = 50;
    }

    private boolean shooting = false;

    public void action(){
        this.shoot();
        this.xMove();
    }

    public void xMove(){
    }

    public void shoot(){
        if (Keys.SPASE.use()) {
            //发射子弹
            if (!shooting) {
                shooting = true;
                this.setY(FrameCon.height - this.height * 2);
                this.setX(PlayerIndex.X + this.width / 9 * 8);
            }
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
            if (!Status.enemyByHurt) {
                Rectangle ammoRectangle = this.getRectangle();
                Map<String,BaseProperties> map = Status.getMap();
                BaseProperties enemy = map.get("enemy");
                if (ammoRectangle.intersects(enemy.getRectangle())) {
                    //击中敌人
                    Status.enemyByHurt = true;
                }
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
