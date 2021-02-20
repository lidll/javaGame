package com.noah.gameDemo.ImageProperties;

import com.noah.gameDemo.ImageProperties.imagePath.ImagePathCon;
import com.sun.xml.internal.rngom.parse.host.Base;
import lombok.Data;

import javax.swing.*;
import java.awt.*;

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
}
