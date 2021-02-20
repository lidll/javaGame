package com.noah.gameDemo.utils;

import com.noah.gameDemo.base.ITimer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName TaskUtil
 * @Description TODO
 * @Author noah
 * @Date 2/20/21 4:07 PM
 * @Version 1.0
 **/
public class TaskUtil {

    public static Timer task(long ms, ITimer iTimer){
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask(){
            @Override
            public void run(){
                iTimer.run();
            }
        };
        timer.schedule(timerTask,0,ms);
        return timer;
    }
}
