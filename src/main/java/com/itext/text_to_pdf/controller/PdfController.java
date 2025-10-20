package com.itext.text_to_pdf.controller;

import com.itext.text_to_pdf.service.PdfService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pdf")
@RequiredArgsConstructor
public class PdfController {

  private final PdfService pdfService;

  @PostMapping(value = "/generate", consumes = "text/html")
  public ResponseEntity<byte[]> generatePdf(@RequestBody String html) {
    byte[] pdfBytes = pdfService.createPdf(html);

    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_PDF);
    headers.setContentDispositionFormData("attachment", "documento.pdf");
    headers.setContentLength(pdfBytes.length);

    return ResponseEntity.ok()
        .headers(headers)
        .cacheControl(CacheControl.noStore())
        .header("Pragma", "no-cache")
        .header("Expires", "0")
        .body(pdfBytes);
  }
}