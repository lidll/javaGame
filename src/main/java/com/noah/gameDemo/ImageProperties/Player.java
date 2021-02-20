package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.noah.gameDemo.base.Keys;
import com.noah.gameDemo.common.PlayerIndex;
import lombok.Data;

import javax.swing.*;
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
    public Player(){
        this.image = new ImageIcon(ImagePathCon.DROOLING_FACE).getImage();
        this.height = 100;
        this.width = 100;
    }

    public void action(){
        this.xMove();
    }

    public void xMove(){
        if (Keys.use(KeyEvent.VK_LEFT)) {
            this.setX(this.getX() - 1);
        }
        if (Keys.use(KeyEvent.VK_RIGHT)) {
            this.setX(this.getX() + 1);
        }
        PlayerIndex.X = this.getX();

    }
}
