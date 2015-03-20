package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import core.Common;
import core.Configuracion;
import core.Timer;
import database.Conexion;

public class SelectKanji extends Activity {
	
	private Timer timer;
	
	public SelectKanji() {
				
		this.add(new CButton("魚",new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				timer.cancel();
			}
		}));
		
		this.add(new VisualTimer(10,1));
		
		timer = new Timer(9,new TimerTask() {
			@Override
			public void run() {
				Common.errorMessage();
			}
		});
		try{
		Conexion cn = new Conexion(Configuracion.getInstance());
		}catch(Exception ex){
			Common.debugMessage();
		}
		//here do the algorithm for select the kanji
	}
	

}
