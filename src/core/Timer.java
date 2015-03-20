package core;

import java.util.TimerTask;

public class Timer{
	
	java.util.Timer timer;
	
	public Timer(int duration,TimerTask task){
		timer = new java.util.Timer();
		timer.schedule(task,1000*duration);
	}
	
	public void cancel(){
		timer.cancel();
	}
}