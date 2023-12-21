package com.itext.prueba;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.border.Border;
import com.itextpdf.layout.border.DashedBorder;
import com.itextpdf.layout.border.DottedBorder;
import com.itextpdf.layout.border.DoubleBorder;
import com.itextpdf.layout.border.RoundDotsBorder;
import com.itextpdf.layout.border.SolidBorder;
import com.itextpdf.layout.element.AreaBreak;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		String path = "C:/Users/csjn/Desktop/ejemplo.pdf";

		try {
			// PdfWriter representing the path of the file where the PDF is to be created.
			PdfWriter pdfWriter = new PdfWriter(path);
			// represents the PDF Document in iText. To instantiate this class (in writing
			// mode), you need to pass an object of the class PdfWriter to its constructor.
			PdfDocument pdfDocument = new PdfDocument(pdfWriter);
			// PdfDocument class is used to create an empty page in the PDF document Pagina
			// en blanco
			pdfDocument.addNewPage();
			// Document is the root element while creating a self-sufficient PDF.
			Document document = new Document(pdfDocument, PageSize.A4);
			// AreaBreak he current context area will be terminated and a new one will be
			// created with the same size
			AreaBreak aB = new AreaBreak();
			// agregamos el area al documento.

			document.add(aB);
			// parrafos String
			String para1 = "Las velas aromáticas han ganado popularidad no solo como elementos decorativos, sino también como potentes herramientas para mejorar el bienestar y crear ambientes acogedores. Estas velas no solo iluminan los espacios, sino que también desprenden fragancias que pueden tener propiedades relajantes, energizantes o incluso terapéuticas. Algunas velas están infusionadas con aceites esenciales naturales que, al quemarse, liberan aromas que pueden influir positivamente en el estado de ánimo y reducir el estrés. Por ejemplo, la lavanda se asocia comúnmente con la relajación, mientras que el eucalipto puede brindar una sensación refrescante y revitalizante.";
			String para2 = "Además, la variedad de aromas disponibles ofrece opciones para adaptarse a los gustos y preferencias individuales. Desde las notas florales y dulces hasta las fragancias más herbáceas o amaderadas, las velas aromáticas están diseñadas para satisfacer una amplia gama de estilos y preferencias. Los formatos de presentación también son diversos, con opciones que van desde pequeñas velas individuales hasta conjuntos elegantes y sofisticados. Con grados de presentación que varían en tamaño y estilo, estas velas se convierten no solo en una fuente de luz aromática, sino también en un accesorio decorativo que puede personalizar y embellecer cualquier espacio. Presentaciones del producto:";
			// Paragraph class represents a self-contained block of textual and graphical
			// information.
			Paragraph parrafo = new Paragraph(para1);
			Paragraph parrafo2 = new Paragraph(para2);
			// agrego el parrafo al documento
			document.add(parrafo.setTextAlignment(TextAlignment.JUSTIFIED));
			document.add(parrafo2.setTextAlignment(TextAlignment.JUSTIFIED));

			// The List class represents a series of objects that are vertically outlined
			List list = new List();
			list.add("320 GR");
			list.add("180 GR");
			list.add("60 GR");
			document.add(list);

			// definimos el ancho de las columnas
			float[] pointColumnWidths = { 150F, 150F };
			// Table class represents a two-dimensional grid filled with cells ordered in
			// rows and columns.
			Table table = new Table(pointColumnWidths);
			// agregamos un encabezado a la tabla
//			table.addHeaderCell("Encabezado de la tabla");
			/*
			 * Adding cells to the table Add the contents of the cell using the add() method
			 * of this class.
			 * 
			 * Finally, to add this cell to the table, call the addCell() method of the
			 * Table class and pass the cell object as a parameter to this method, as shown
			 * below.
			 */

			// Populating row 1 and adding it to the table
			Cell c1 = new Cell(); // Creating cell 1
			c1.add("Name"); // Adding name to cell 1
			c1.setBackgroundColor(Color.DARK_GRAY); // Setting background color
			c1.setBorder(Border.NO_BORDER); // Setting border
			c1.setTextAlignment(TextAlignment.CENTER); // Setting text alignment
			table.addCell(c1); // Adding cell 1 to the table

			Cell c2 = new Cell();
			c2.add("Raju");
			c2.setBackgroundColor(Color.GRAY);
			c2.setBorder(new DottedBorder(Color.RED, 2)); // The iText library provides various classes representing the
															// border such as DashedBorder, SolidBorder, DottedBorder,
															// DoubleBorder, RoundDotsBorder, etc.accept two parameters:
															// a color object representing the color of the border and
															// an integer representing the width of the border
			c2.setTextAlignment(TextAlignment.CENTER);
			table.addCell(c2);

			// Populating row 2 and adding it to the table
			Cell c3 = new Cell();
			c3.add("Id");
			c3.setBackgroundColor(Color.WHITE);
			c3.setBorder(new DashedBorder(Color.GREEN, 3));
			c3.setTextAlignment(TextAlignment.CENTER);
			table.addCell(c3);

			Cell c4 = new Cell();
			c4.add("001");
			c4.setBackgroundColor(Color.WHITE);
			c4.setBorder(new DoubleBorder(Color.MAGENTA, 1));
			c4.setTextAlignment(TextAlignment.CENTER);
			table.addCell(c4);

			// Populating row 3 and adding it to the table
			Cell c5 = new Cell();
			c5.add("Designation");
			c5.setBackgroundColor(Color.DARK_GRAY);
			c5.setTextAlignment(TextAlignment.CENTER);
			c5.setBorder(new RoundDotsBorder(Color.BLUE, 4));
			table.addCell(c5);

			Cell c6 = new Cell();
			c6.add("Programmer");
			c6.setBackgroundColor(Color.GRAY);
			c6.setTextAlignment(TextAlignment.CENTER);
			c6.setBorder(new SolidBorder(Color.YELLOW, 5));
			table.addCell(c6);

			// agregamos un footer a la tabla
//			table.addFooterCell("Footer de la tabla");

			// AGREGAMOS IMAGENES

			// Populating row 5 and adding it to the table
			Cell cell9 = new Cell();
			cell9.add("Tutorial Icon");
			table.addCell(cell9);

			// Creating the cell10
			Cell cell10 = new Cell();

			// Creating an ImageData object
			String imageFile = "C:/Users/csjn/Downloads/MILEI.jpg";
			// ImageData object using the create() method of the ImageDataFactory class. As
			// a parameter of this method, pass a string parameter representing the path of
			// the image,
			ImageData data = null;
			try {
				data = ImageDataFactory.create(imageFile);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			// Creating the image
			Image img = new Image(data);

			// Adding image to the cell10
			cell10.add(img.setAutoScale(true));

			// Adding cell110 to the table
			table.addCell(cell10);

			
			// Adding Nested Tables in a Pdf
			Cell contact = new Cell();    // Creating a cell 
			// Creating nested table for contact   
			float [] pointColumnWidths2 = {150f, 150f}; 
			Table nestedTable = new Table(pointColumnWidths2);    

			// Populating row 1 and adding it to the nested table  
			Cell nested1 = new Cell(); 
			nested1.add("Phone"); 
			nestedTable.addCell(nested1);       

			Cell nested2 = new Cell(); 
			nested2.add("9848022338"); 
			nestedTable.addCell(nested2);  

			// Populating row 2 and adding it to the nested table  
			Cell nested3 = new Cell(); 
			nested3.add("email"); 
			nestedTable.addCell(nested3);

			Cell nested4 = new Cell(); 
			nested4.add("Raju123@gmail.com"); 
			nestedTable.addCell(nested4);     

			// Populating row 3 and adding it to the nested table  
			Cell nested5 = new Cell(); 
			nested5.add("Address"); 
			nestedTable.addCell(nested5);  

			Cell nested6 = new Cell(); 
			nested6.add("Hyderabad"); 
			nestedTable.setTextAlignment(TextAlignment.JUSTIFIED);
			nestedTable.addCell(nested6);  
			// ------------------
			// agregamos la tabla a la celda y esa celda la agregamos a la tabla principal
			contact.add(nestedTable); 
			table.addCell(contact);
			table.setTextAlignment(TextAlignment.CENTER);
			// agregamos la tabla al documento
			document.add(table);
			document.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
