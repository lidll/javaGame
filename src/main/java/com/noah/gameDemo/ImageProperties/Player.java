package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

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
}
