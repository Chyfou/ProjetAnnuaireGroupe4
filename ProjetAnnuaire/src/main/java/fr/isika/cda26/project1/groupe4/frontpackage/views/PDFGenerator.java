package fr.isika.cda26.project1.groupe4.frontpackage.views;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
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
import fr.isika.cda26.project1.groupe4.backpackage.internDirTree.Intern;

/**
 * Generate pdf with current TableView.
 * 
 * @author Yoann FRANCOIS.
 *
 */

public class PDFGenerator implements FrontConstants {

	// ********************************** ATTRIBUTS
	// ************************************
	private List<Intern> internList;
	private Document document;
	private PdfPTable table;
	private Font mainTitleFont;
	private Font tableHeaderCellFont;
	private Paragraph pDFTitle;

	// ********************************** CONSTRUCTOR
	// ************************************
	/**
	 * Empty Constructor to initialized PdfWriter.
	 */
	public PDFGenerator(List<Intern> interList) {
		this.internList = new ArrayList<Intern>(interList);
		this.document = new Document();
		this.table = new PdfPTable(5);
		this.mainTitleFont = new Font(Font.FontFamily.TIMES_ROMAN, 25, Font.BOLD);
		this.tableHeaderCellFont = new Font(Font.FontFamily.TIMES_ROMAN, 13, Font.BOLD);
		this.pDFTitle = new Paragraph("My interns directory Extraction", mainTitleFont);

	}

	//********************PUBLIC METHOD********************
	/**
	 * Print a PDF in file download of user's computer.
	 * 
	 * @return (:boolean)
	 * @throws Exception
	 */
	public boolean generateDFWithTable() throws Exception {
		String userHome = System.getProperty("user.home");
		PdfWriter.getInstance(document, new FileOutputStream(userHome + PRINT_INTERNS_DIRECTORY_PDF_URL));
		document.open();
		Image isikaLogo = Image.getInstance("src/main/java/Isika_logo.png".toString());
		isikaLogo.scaleToFit(150, 150);
		isikaLogo.setAlignment(Element.ALIGN_CENTER);
		document.add(isikaLogo);
		pDFTitle.setAlignment(Element.ALIGN_CENTER);
		document.add(pDFTitle);
		table.setSpacingBefore(20);
		table.setWidths(new int[] { 3, 3, 2, 2, 3 });
		addTableHeader(table);
		addCustomRows(table);
		document.add(table);
		document.close();
		return true;
	}

	//********************PRIVATES METHODS********************
	/**
	 * Treating first row as a table header.
	 * 
	 * @param table (:PdfPTable)
	 */
	private void addTableHeader(PdfPTable table) {
		Stream.of(NAME_LABEL, FORENAME_LABEL, LOCATION_LABEL, PROMOTION_LABEL, PROMOTION_YEAR_LABEL).forEach(columnTitle -> {
			PdfPCell header = new PdfPCell();
			header.setBackgroundColor(BaseColor.LIGHT_GRAY);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(1);
			header.setPhrase(new Phrase(columnTitle, tableHeaderCellFont));

			table.addCell(header);
		});
	}

	/**
	 * Add value to each cells of the table on the pdf.
	 * 
	 * @param table (:PdfPTable)
	 * @throws URISyntaxException
	 * @throws BadElementException
	 * @throws IOException
	 */
	private void addCustomRows(PdfPTable table) throws URISyntaxException, BadElementException, IOException {

		for (Intern intern : this.internList) {
			PdfPCell cell1 = new PdfPCell(new Phrase(intern.getName()));
			cell1.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell1);

			PdfPCell cell2 = new PdfPCell(new Phrase(intern.getForename()));
			cell2.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell2);

			PdfPCell cell3 = new PdfPCell(new Phrase(intern.getLocation()));
			cell3.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell3);

			PdfPCell cell4 = new PdfPCell(new Phrase(intern.getPromotion()));
			cell4.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell4);

			PdfPCell cell5 = new PdfPCell(new Phrase(intern.getPromotionYear().toString()));
			cell5.setVerticalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell5);
		}
	}
	
}
