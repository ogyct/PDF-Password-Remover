package com.github.ogyct.pdfpasswordremover;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;

import com.github.ogyct.pdfpasswordremover.utils.Utils;

public class Main {

	public static void main(String[] args) {
		try {
			File file = new File("1.pdf");
			InputStream is = new FileInputStream(file);
			PDFParser parser = new PDFParser(is);
			parser.parse();
			
			PDDocument originialPdfDoc = parser.getPDDocument();
			originialPdfDoc.setAllSecurityToBeRemoved(true);
			
			boolean isOriginalDocEncrypted = originialPdfDoc.isEncrypted();
	        if (isOriginalDocEncrypted) {
	            originialPdfDoc.openProtection(new StandardDecryptionMaterial("Pay$l1p"));
	        }
	        
	        new File("decrypted").mkdir();
	        originialPdfDoc.save("decrypted/12.pdf");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Utils.processError(e);
		}

	}

}
