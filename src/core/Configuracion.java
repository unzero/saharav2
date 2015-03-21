package core;

import java.awt.Font;
import java.io.IOException;
import java.util.LinkedList;

/**
 * 
 * Sahara - Programa para el aprendizaje de la lengua japonesa
 * 
 * @author Ciro Iván Garcia López - Universidad Nacional de Colombia
 *
 */
public class Configuracion {

	/*
	 * DEFAULT FIELDS FOR CONFIGURATION
	 */
	private static String fontPath = "./bin/resources/MicroHei.ttc";
	private static int strokes = 10;
	private static String jlpt = "N5";
	private static int fontSize = 70;
	private static int repetitions = 15;

	private String fileName = "data.dat";
	private Fuente fuente;
	private static Configuracion instance;

	private Configuracion() {
		try {
			fuente = new Fuente(fontPath, fontSize);
		} catch (Exception ex) {
		}
	}

	public String getFileName() {
		return "lvl_"+strokes+".dat";
	}

	/**
	 * we need to clone it
	 * 
	 * @return
	 */
	public Font getFont() {
		return fuente.getFont();
	}

	
	
	
	/**
	 * get methods
	 * @return
	 */
	public String getJLPT(){
		return jlpt;
	}
	
	public int getStrokes(){
		return strokes;
	}
	
	public int getFontSize(){
		return fontSize;
	}
	
	public int getRepeats(){
		return repetitions;
	}
	
	/**
	 * startup methods and close methods
	 */

	public static Configuracion getInstance() {
		if (instance == null) {
			instance = new Configuracion();
		}
		return instance;
	}

	public static void startup() {
		try {
			FileReader fr = new FileReader("./bin/resources/config.dat");
			jlpt = fr.fileContent.get(0);
			strokes = Integer.parseInt(fr.fileContent.get(1));
			fontPath = fr.fileContent.get(2);
			fontSize = Integer.parseInt(fr.fileContent.get(3));
			repetitions = Integer.parseInt(fr.fileContent.get(4));
		} catch (Exception ex) {
			Common.errorMessage("Archivo de configuración no encontrado ó corrupto, se usarán los valores por defecto");
			jlpt = "N5";
			repetitions = 15;
			strokes = 10;
			fontPath = "./bin/resources/MicroHei.ttc";
			fontSize = 80;
		}
	}

	public static void close() {
		try {
			LinkedList<String> data = new LinkedList<String>();
			data.add(jlpt);
			data.add(strokes+"");
			data.add(fontPath);
			data.add(fontSize + "");
			data.add(repetitions + "");
			new FileWriter("./bin/resources/config.dat", data);
		} catch (Exception ex) {
			Common.errorMessage("No se ha podido guardar la configuración actual");
		}
	}
}
