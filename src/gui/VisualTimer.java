package gui;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EtchedBorder;

public class VisualTimer extends Activity{
	
	private JProgressBar bar;
	private Timer timer;
	private double totalTime,lambda,delta;
	
	/**3
	 * 
	 * @param time The total time that the timer is going to run
	 * @param p the period of the execution
	 */
	public VisualTimer(int time,int p){
		bar = new JProgressBar(0,100);
		bar.setBorder( BorderFactory.createEtchedBorder(EtchedBorder.RAISED) );
		timer = new Timer();
		totalTime = time;
		lambda = 0;
		delta = p;
		bar.setValue((int)getLambdaValue());
		this.add(bar);
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				if( totalTime == lambda){
					cancel();
				}
				lambda += delta;
				bar.setValue((int)getLambdaValue());
			}
		}, 0, p*1000);
		repaint();
	}
	
	private double getLambdaValue(){
		return (totalTime-lambda)/totalTime * 100;
	}
	
}
