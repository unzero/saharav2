package core;

import java.util.TimerTask;

/**
 * 
 * Sahara - Programa para el aprendizaje de la lengua japonesa
 * @author Ciro Iván Garcia López - Universidad Nacional de Colombia
 *
 */

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