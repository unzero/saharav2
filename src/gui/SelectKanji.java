package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.TimerTask;

import core.Timer;

public class SelectKanji extends Activity {
	
	private Timer timer;
	
	public SelectKanji(){
		timer = new Timer(1,new TimerTask() {
			@Override
			public void run() {
				System.out.println("TIME IS OVER!!");
			}
		});
		this.add(new CButton("魚",new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				System.out.println("OK");
			}
		}));
		
	}
	

}
