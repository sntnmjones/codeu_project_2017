package codeu.chat.client.simplegui.originalgui;

/**
 * Created by student on 6/1/17.
 */

import java.util.Timer;
import java.util.TimerTask;


public class MessagePanelTimer extends Timer{
    static final long serialVersionUID = 1L;

    private int initDelay = 500;
    private int currentDelay = 1000;
    private int myInitPause = 5000;

    public void initialize(OriginalMessagePanel.MessageTimerTask timerTask){
        schedule(timerTask, myInitPause, initDelay);
    }

    public int getDelay(){
        return currentDelay;
    }

    public void setDelay(int delay){
        currentDelay = delay;
    }



}
