package app;

import java.text.ParseException;

import javax.swing.UnsupportedLookAndFeelException;

import interfaces.CreacionPoliza;
import interfaces.InterfazDarAltaPoliza;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException {
		InterfazDarAltaPoliza interfaz = new InterfazDarAltaPoliza();
		interfaz.setVisible(true);
		
	}

}
