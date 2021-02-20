package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.noah.gameDemo.base.FrameCon;
import lombok.Data;

import javax.swing.*;

/**
 * @ClassName Enemy
 * @Description TODO
 * @Author noah
 * @Date 2020-06-04 15:14
 * @Version 1.0
 **/
@Data
public class Enemy extends BaseProperties{

    public static boolean directionFlag = true;

    public Enemy(){
        this.image = new ImageIcon(ImagePathCon.FACE_SCREAMING_IN_FEAR).getImage();
        super.width = 50;
        this.height = 50;
    }

    public void action(){
        this.xMove();
    }

    public void xMove(){
        if (Enemy.directionFlag){
            this.setX(this.getX() + 1);
            if (this.getX() == FrameCon.width - this.getWidth()){
                Enemy.directionFlag = false;
            }
        }else{
            this.setX(this.getX() - 1);
            if (this.getX() == 0){
                Enemy.directionFlag = true;
            }
        }

    }

}
