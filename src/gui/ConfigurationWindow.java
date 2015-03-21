package gui;

import java.awt.GridLayout;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfigurationWindow extends Activity{
	
	private JComboBox<String> jlptComboBox = new JComboBox<>();
	//we need to change the model of the spinner
	private JSpinner strokesSpinner = new JSpinner();
	private JSpinner fontSizeSpinner = new JSpinner();
	private JSpinner repeatSpinner = new JSpinner();
	private JLabel sampleLabel = new JLabel("This is a Sample");
	
	public ConfigurationWindow(){
		
		jlptComboBox.addItem("N5");
		jlptComboBox.addItem("N4");
		jlptComboBox.addItem("N3");
		jlptComboBox.addItem("N2");
		jlptComboBox.addItem("N1");
		
		this.setLayout(new GridLayout(6,2));
		this.add(new JLabel("JLPT"));
		this.add(jlptComboBox);
		this.add(new JLabel("Strokes"));
		this.add(strokesSpinner);
		this.add(new JLabel("Font Type"));
		this.add(new JTextField());
		this.add(new JLabel("Font Size"));
		this.add(fontSizeSpinner);
		this.add(new JLabel("Repeats"));
		this.add(repeatSpinner);
	}

}
