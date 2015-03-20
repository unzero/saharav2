package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame{
	
	private static MainWindow instance;
	private JPanel centralPanel;
	
	private MainWindow(){
		centralPanel = new JPanel(new FlowLayout());
		this.add(centralPanel);
		this.setSize(new Dimension(800,600));
		this.setTitle("Sahara - Kanji App");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setJMenuBar(MainMenu.getInstance());
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void changeActivity(String type){
		centralPanel.removeAll();
		centralPanel.add( ActivityFactory.getInstance().getActivity(type));
		centralPanel.updateUI();
		repaint();
	}
	
	public static MainWindow getInstance(){
		if( instance == null){
			instance = new MainWindow();
		}
		return instance;
	}
	
}
