package gui;

import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import core.Configuracion;

public class CButton extends JButton{
	
	protected CButton(String title,MouseAdapter adp){
		this.setFont(Configuracion.getInstance().getFont());
		this.addMouseListener(adp);
		//this.setOpaque(true);
		this.setIcon(loadImage());
		//this.setSize(100,100);
		this.setBorder(LineBorder.createBlackLineBorder());
		this.setText(title);
		this.setHorizontalTextPosition(JButton.CENTER);
		this.setVerticalTextPosition(JButton.CENTER);
		repaint();
	}

	
	private ImageIcon loadImage(){
		return new ImageIcon(getClass().getResource("/resources/Button.png"));
		
	}
}
