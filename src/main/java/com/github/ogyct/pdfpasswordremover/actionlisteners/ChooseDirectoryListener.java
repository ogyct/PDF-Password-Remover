package com.github.ogyct.pdfpasswordremover.actionlisteners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import com.github.ogyct.pdfpasswordremover.gui.GUI;

public class ChooseDirectoryListener implements ActionListener {
    private static final String CHOOSERTITLE = "choosertitle";
    private GUI gui;

    public ChooseDirectoryListener(GUI gui) {
        this.gui = gui;
    }

    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new java.io.File("."));
        chooser.setDialogTitle(CHOOSERTITLE);
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            gui.getTextField().setText(chooser.getSelectedFile().toString());
        }

    }

}
