package fr.isika.cda26.project1.groupe4.frontpackage.views.classes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.stream.Stream;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Generate pdf.
 * 
 * @author Yoann François
 *
 */

public class AddingTableToPDF {
	
	//********************************** ATTRIBUTS ************************************
		private Document document = new Document();
		private PdfPTable table = new PdfPTable(5);
		private Font mainTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
		private Font tableHeaderCellFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
		private Paragraph pDFTitle = new Paragraph("My interns directory Extraction", mainTitleFont);

		//********************************** CONSTRUCTOR ************************************
		/**
		 * Empty Constructor to initialized PdfWriter.
		 */
		public AddingTableToPDF() throws Exception {
			String userHome = System.getProperty("user.home");
			PdfWriter.getInstance(document, new FileOutputStream(userHome + "/Downloads/MyInternsDirectoryExtraction.pdf"));
			document.open();
			Image isikaLogo = Image.getInstance("src/main/java/pictures/Isika_logo.png".toString());
			isikaLogo.scaleToFit(150, 150); 
			isikaLogo.setAlignment(Element.ALIGN_CENTER);
			document.add(isikaLogo);
			pDFTitle.setAlignment(Element.ALIGN_CENTER);
			document.add(pDFTitle);
			table.setSpacingBefore(20);
			table.setWidths(new int[] {3, 3, 2, 2, 3});
			addTableHeader(table);
			//addRows(table);
			addCustomRows(table);
			document.add(table);
			document.close();	
		}	
		//********************************** PRIVATES METHODS ************************************
		/**
		 * Treating first row as a table header.
		 * 
		 * @param table (:PdfPTable)
		 */
		private void addTableHeader(PdfPTable table) {
		    Stream.of("Name", "Forename", "Location", "Promotion", "PromotionYear")
		 .forEach(columnTitle -> {
		        PdfPCell header = new PdfPCell();
		        header.setBackgroundColor(BaseColor.LIGHT_GRAY);
		        header.setHorizontalAlignment(Element.ALIGN_CENTER);
		        header.setBorderWidth(1);
		        header.setPhrase(new Phrase(columnTitle, tableHeaderCellFont));
		        
		        table.addCell(header);
		    });
		}
		
		/**
		 * Treating other rows.
		 * 
		 * @param table (:PdfPTable)
		 */
//		private void addRows(PdfPTable table) {
//		    table.addCell("row 1, col 1");
//		    table.addCell("row 1, col 2");
//		    table.addCell("row 1, col 3");
//		    table.addCell("row 1, col 4");
//		    table.addCell("row 1, col 5");
//		}
		
		private void addCustomRows(PdfPTable table) 
				  throws URISyntaxException, BadElementException, IOException {;

				    PdfPCell cell1 = new PdfPCell(new Phrase("Je suis vraiment très loooooooooooooooooooooooooooooooooooooooong !"));
				    cell1.setVerticalAlignment(Element.ALIGN_CENTER);
				    table.addCell(cell1);

				    PdfPCell cell2 = new PdfPCell(new Phrase("Cell2"));
				    cell2.setVerticalAlignment(Element.ALIGN_CENTER);
				    table.addCell(cell2);
				    
				    PdfPCell cell3 = new PdfPCell(new Phrase("Cell3"));
				    cell3.setVerticalAlignment(Element.ALIGN_CENTER);
				    table.addCell(cell3);

				    PdfPCell cell4 = new PdfPCell(new Phrase("Cell4"));
				    cell4.setVerticalAlignment(Element.ALIGN_CENTER);
				    table.addCell(cell4);
				    
				    PdfPCell cell5 = new PdfPCell(new Phrase("Cell5"));
				    cell5.setVerticalAlignment(Element.ALIGN_CENTER);
				    table.addCell(cell5);
				}
}
