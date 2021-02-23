package com.noah.gameDemo.ImageProperties;

import lombok.Data;

import java.awt.*;
import java.util.ArrayList;

/**
 * @ClassName BaseProperties
 * @Description TODO
 * @Author noah
 * @Date 2020-06-04 15:24
 * @Version 1.0
 **/
@Data
public class BaseProperties {
    public int x,y,height,width;
    java.awt.Image image;

    /**
     * 获取自身矩形
     *
     * @return
     */
    protected Rectangle getRectangle() {
        return new Rectangle(this.x, this.y, this.width, this.height);
    }
}
