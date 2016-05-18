package com.github.ogyct.pdfpasswordremover;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.github.ogyct.pdfpasswordremover.actionlisteners.ChooseDirectoryListener;
import com.github.ogyct.pdfpasswordremover.actionlisteners.RemovePasswordListener;
import com.github.ogyct.pdfpasswordremover.decryptor.Decryptor;
import com.github.ogyct.pdfpasswordremover.gui.GUI;
import com.github.ogyct.pdfpasswordremover.utils.Utils;

/**
 * Program starts here
 * @author avgustisd
 *
 */
public class Main {

    public static void main(String[] args) {
        final Decryptor dec = new Decryptor("", "");
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    GUI window = new GUI();
                    window.getFrmPdfPasswordRemover().setVisible(true);
                    window.getBtnChoose().addActionListener(new ChooseDirectoryListener(window));
                    window.getBtnRemove().addActionListener(new RemovePasswordListener(window, dec));
                } catch (Exception e) {
                    Utils.processError(e);
                }
            }
        });
        
        
    }



}
