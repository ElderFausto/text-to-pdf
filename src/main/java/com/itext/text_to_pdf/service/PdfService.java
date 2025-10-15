package com.itext.text_to_pdf.service;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;

@Service
public class PdfService {

  public byte[] createPdf(String text) {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    try {
      PdfWriter writer = new PdfWriter(baos);
      PdfDocument pdf = new PdfDocument(writer);
      Document document = new Document(pdf);

      document.add(new Paragraph(text));

      document.close();

      return baos.toByteArray();

    } catch (Exception e) {
      e.printStackTrace();
      return new byte[0];
    }
  }
}
