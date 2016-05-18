package com.github.ogyct.pdfpasswordremover.decryptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;

import com.github.ogyct.pdfpasswordremover.utils.Utils;

public class Decryptor {
    private static final String DECRYPTED = "decrypted";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    private String password;
    private String path;

    public Decryptor(String password, String path) {
        this.password = password;
        this.path = path;
    }

    /**
     * Calls decrypt method for all files in specified folder
     */
    public void decryptFolder() {

        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) {
            Utils.processInformationMessage("No file selected");
            return;
        }
        for (File file : listOfFiles) {
            String path = file.getPath();
            if (file.isFile() && path.endsWith("pdf")) {
                decrypt(path);
            }
        }
        //TODO fix info message
        //Utils.processInformationMessage("Successfully saved to " + path);
    }

    /**
     * Decrypts pdf file using provided password
     * @param fileName
     * @return
     */
    private String decrypt(String fileName) {
        String decryptedPath = "";
        try {
            File file = new File(fileName);
            InputStream is = new FileInputStream(file);
            PDFParser parser = new PDFParser(is);
            parser.parse();
            PDDocument originialPdfDoc = parser.getPDDocument();
            originialPdfDoc.setAllSecurityToBeRemoved(true);
            boolean isOriginalDocEncrypted = originialPdfDoc.isEncrypted();
            if (isOriginalDocEncrypted) {
                originialPdfDoc.openProtection(new StandardDecryptionMaterial(password));
            }
            //create folder for decrypted pdfs
            String parent = file.getCanonicalFile().getParent();
            String name = file.getName();
            decryptedPath = parent + "\\" + DECRYPTED;
            new File(decryptedPath).mkdir();

            originialPdfDoc.save(decryptedPath + "\\" + name);
            
        } catch (Exception e) {
            Utils.processError(e);
        }
        return decryptedPath;

    }

}
