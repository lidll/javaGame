package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.noah.gameDemo.base.Keys;
import com.noah.gameDemo.common.PlayerIndex;
import lombok.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @ClassName Player
 * @Description TODO
 * @Author noah
 * @Date 2020-06-03 17:48
 * @Version 1.0
 **/
@Data
public class Player extends BaseProperties{

    private Image df = new ImageIcon(ImagePathCon.DROOLING_FACE).getImage();
    private Image kf = new ImageIcon(ImagePathCon.KISS_FACE).getImage();

    public Player(){
        this.image = df;
        this.height = 100;
        this.width = 100;
        this.y = 350;
    }

    public void action(){
        this.xMove();
        this.space();
    }

    public void xMove(){
        if (Keys.LEFT.use()) {
            this.setX(this.getX() - 1);
        }
        if (Keys.RIGHT.use()) {
            this.setX(this.getX() + 1);
        }
        PlayerIndex.X = this.getX();
    }

    public void space(){
        if (Keys.SPASE.use()) {
            this.image = kf;
        }else{
            this.image = df;
        }
    }
}
