package gui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * 
 * @author ui
 *
 */
public class MenuList {
	
	private JMenu menu_list;
	
	public MenuList(String name){
		menu_list = new JMenu(name);
	}
	
	public void addMenuComponent(String name,MouseAdapter ad){
		menu_list.add(new MenuComponent(name, ad));
	}
	
	public JMenu getMenuList(){
		return menu_list;
	}
	
}

class MenuComponent extends JMenuItem{
	
	public MenuComponent(String name,MouseAdapter ad){
		this.setText(name);
		this.addMouseListener(ad);
	}
	
}
