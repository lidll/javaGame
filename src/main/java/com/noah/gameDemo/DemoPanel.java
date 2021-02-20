package com.noah.gameDemo;

import com.noah.gameDemo.ImageProperties.BaseProperties;

import javax.swing.*;
import java.awt.*;

/**
 * @ClassName DemoPanel
 * @Description 面板
 * @Author noah
 * @Date 2020-06-03 17:24
 * @Version 1.0
 **/
public class DemoPanel extends JPanel {

    private BaseProperties[] parts;

    public DemoPanel(BaseProperties...parts) {
        this.parts = parts;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (BaseProperties part : parts) {
            g.drawImage(part.getImage(),part.getX(),part.getY(),part.getWidth(),part.getHeight(),this);
        }
    }
}
