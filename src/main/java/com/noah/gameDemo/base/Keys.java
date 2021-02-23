package com.noah.gameDemo.base;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Keys
 * @Description TODO
 * @Author noah
 * @Date 2/20/21 4:26 PM
 * @Version 1.0
 **/
public enum Keys {
    LEFT(KeyEvent.VK_LEFT),
    RIGHT(KeyEvent.VK_RIGHT),
    SPASE(KeyEvent.VK_SPACE);

    //键值
    private int keyValue;

    //按键
    private final static Set<Integer> keySet = new HashSet<>();

    Keys(int keyValue){
        this.keyValue = keyValue;
    }

    public int getKeyValue(){
        return keyValue;
    }
    /**
     *
     * @Author yz
     * @Description 是否使用了按键
     * @Date 2/20/21 4:30 PM
     * @return boolean
     */
    public boolean use(){
        return keySet.contains(keyValue);
    }

    /**
     *
     * @Author yz
     * @Description 添加按键
     * @Date 2/20/21 4:31 PM
     * @param keyValue
     * @return void
     */
    public static void add(int keyValue){
        Keys.keySet.add(keyValue);
    }

    /**
     *
     * @Author yz
     * @Description 删除按键
     * @Date 2/20/21 4:32 PM
     * @param keyValue
     * @return void
     */
    public static void remove(int keyValue){
        Keys.keySet.remove(keyValue);
    }
}
