package com.github.ogyct.pdfpasswordremover.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Utils {
	private Utils() {
		// Not to be instantiated
	}

	/**
	 * Error processing
	 * 
	 * @param e
	 */
	public static void processError(Exception e) {
		e.printStackTrace();
		JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), "Dialog", JOptionPane.ERROR_MESSAGE);
	}
}
