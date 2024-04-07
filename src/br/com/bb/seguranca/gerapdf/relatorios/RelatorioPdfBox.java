package br.com.bb.seguranca.gerapdf.relatorios;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.apache.pdfbox.pdmodel.graphics.state.PDExtendedGraphicsState;
import org.apache.pdfbox.util.Matrix;

public class RelatorioPdfBox {

	static String PATH = "C:\\JAVA\\pdf\\RelatorioPdfBox.pdf";
	static String PATH_IMAGE = "./images/Banco_do_Brasil_logo10.svg.png";

	public static void main(String[] args) throws IOException {

		PDDocument document = new PDDocument();

		addPage(document, "First line \nSecond line \nThird line");

		addLocalImage(document, PATH_IMAGE);

		addWatermark(document, "F0394519 - 07/04/2024 16:30:35");

		document.save(PATH);
		document.close();

	}

	private static void addWatermark(PDDocument document, String watermark) throws IOException {
		watermark = watermark + "     " + watermark + "     " + watermark + "     " + watermark + "     " + watermark
				+ "     " + watermark + "     " + watermark;
		for (int i = 0; i < document.getNumberOfPages(); i++) {

			PDPage page = document.getPage(i);
			PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true);

			contentStream.setFont(PDType1Font.TIMES_BOLD, 14);
			PDExtendedGraphicsState extGState = new PDExtendedGraphicsState();
			extGState.setNonStrokingAlphaConstant(0.09f);
			contentStream.setGraphicsStateParameters(extGState);
			contentStream.beginText();

			Matrix matrix = Matrix.getRotateInstance(Math.PI / 4, 10, 100);
			contentStream.setTextMatrix(matrix);
			contentStream.newLineAtOffset(10, 500);

			for (int j = 0; j < 16; j++) {
				contentStream.showText(watermark);
				contentStream.newLineAtOffset(-50, -80);
			}

			contentStream.endText();
			contentStream.close();
		}

	}

	private static void addPage(PDDocument document, String content) throws IOException {
		PDPage page = new PDPage(PDRectangle.A4);
		document.addPage(page);

		PDPageContentStream contentStream = new PDPageContentStream(document, page);

		contentStream.setFont(PDType1Font.COURIER, 14);

		float margin = 50;
		float yStart = page.getMediaBox().getHeight() - margin;
		float yPosition = yStart;
		float lineHeight = 17;

		String[] lines = content.split("\n");

		for (String line : lines) {
			contentStream.beginText();
			contentStream.newLineAtOffset(margin, yPosition);
			contentStream.showText((line));
			contentStream.endText();
			yPosition -= lineHeight;
		}

		contentStream.close();
	}

	private static void addLocalImage(PDDocument document, String imagePath) throws IOException {

		PDPage page = new PDPage();
		document.addPage(page);
		PDImageXObject image = PDImageXObject.createFromFile(imagePath, document);
		addImageToPageCentered(document, page, image);

	}

	private static void addImageToPageCentered(PDDocument document, PDPage page, PDImageXObject image)
			throws IOException {
		float pageWidth = page.getMediaBox().getWidth();
		float pageHeight = page.getMediaBox().getHeight();

		float imageWidth = image.getWidth();
		float imageHeight = image.getHeight();

		float scale = Math.min(pageWidth / imageWidth, pageHeight / imageHeight);

		float scaleWidth = imageWidth * scale;
		float scaledHeight = imageHeight * scale;

		float x = (pageWidth - scaleWidth) / 2;
		float y = (pageHeight - scaledHeight) / 2;

		addImageToPage(document, page, image, x, y, scaleWidth, scaledHeight);

	}

	private static void addImageToPage(PDDocument document, PDPage page, PDImageXObject image, float x, float y,
			float width, float height) throws IOException {

		PDPageContentStream contentStream = new PDPageContentStream(document, page);
		contentStream.drawImage(image, x, y, width, height);
		contentStream.close();
	}

}
