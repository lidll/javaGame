package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import lombok.Data;

import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;

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

}
