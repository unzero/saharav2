package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MainMenu extends JMenuBar{
	
	private static MainMenu instance;
	
	private MainMenu(){
		
		MenuList file = new MenuList("File");
		file.addMenuComponent("Exit", new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				if( e.getButton() == 1){
					System.exit(0);
				}
				System.out.println("Button: "+e.getButton());
			}
		});
		
		MenuList study = new MenuList("Study");
		study.addMenuComponent("Select Reading", new MouseAdapter(){
			@Override
			public void mousePressed(MouseEvent e){
				if( e.getButton() == 1){
					MainWindow.getInstance().changeActivity("select-kanji");
				}
			}
		});
		study.addMenuComponent("Visual Timer", new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e){
				if( e.getButton() == 1){
					MainWindow.getInstance().changeActivity("visual-timer");
				}
			}
		});
		
		
		this.add(file.getMenuList());
		this.add(study.getMenuList());
		
	}
	
	public static MainMenu getInstance(){
		if( instance == null){
			instance = new MainMenu();
		}
		return instance;
	}
}