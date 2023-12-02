package app;

import javax.swing.UnsupportedLookAndFeelException;

import interfaces.InterfazDarAltaPoliza;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		InterfazDarAltaPoliza interfaz = new InterfazDarAltaPoliza();
		interfaz.setVisible(true);
	}

}
