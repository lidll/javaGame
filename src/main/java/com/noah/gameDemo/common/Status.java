package com.noah.gameDemo.common;

import com.noah.gameDemo.ImageProperties.BaseProperties;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Status
 * @Description TODO
 * @Author noah
 * @Date 2/23/21 4:22 PM
 * @Version 1.0
 **/
public class Status {

    public static Boolean enemyByHurt = false;

    public static Map<String,BaseProperties> entityMap = new HashMap<>();

    public static ArrayList<BaseProperties> entityList = new ArrayList<>();

    public static void addList(BaseProperties... entity){
        entityList.addAll(Arrays.asList(entity));
    }

    public static void putEntity(String name,BaseProperties entity){
        entityMap.put(name,entity);
    }

    public static List getList(){
        return entityList;
    }

    public static BaseProperties getEntity(String name){
        return entityMap.get(name);
    }

    public static Map<String,BaseProperties> getMap(){
        return entityMap;
    }
}
