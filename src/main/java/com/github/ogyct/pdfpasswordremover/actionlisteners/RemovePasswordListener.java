package com.github.ogyct.pdfpasswordremover.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.github.ogyct.pdfpasswordremover.decryptor.Decryptor;
import com.github.ogyct.pdfpasswordremover.gui.GUI;

/**
 * ActionListener for Remove password button
 * @author avgustisd
 *
 */
public class RemovePasswordListener implements ActionListener {
    private GUI gui;
    private Decryptor dec;

    public RemovePasswordListener(GUI gui, Decryptor dec) {
        super();
        this.gui = gui;
        this.dec = dec;
    }

    public void actionPerformed(ActionEvent e) {
        String path = gui.getTextField().getText();
        String password = String.valueOf(gui.getPasswordField().getPassword());
        dec.setPassword(password);
        dec.setPath(path);
        dec.decryptFolder();
    }

}
