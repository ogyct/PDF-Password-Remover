package com.github.ogyct.pdfpasswordremover.utils;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * Contains application wide useful methods
 * @author avgustisd
 *
 */
public class Utils {
    private static final String DIALOG = "Dialog";

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
        JOptionPane.showMessageDialog(new JFrame(), e.getMessage(), DIALOG, JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Display information message
     * @param message
     */
    public static void processInformationMessage(String message) {
        JOptionPane.showMessageDialog(new JFrame(), message, DIALOG, JOptionPane.INFORMATION_MESSAGE);
    }
}
