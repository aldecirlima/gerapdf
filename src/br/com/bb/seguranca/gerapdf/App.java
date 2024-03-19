package br.com.bb.seguranca.gerapdf;

import java.io.FileNotFoundException;

import com.lowagie.text.DocumentException;

import br.com.bb.seguranca.gerapdf.model.PrimeiroPdf;

public class App {

	public static void main(String[] args) throws DocumentException, FileNotFoundException {

		new PrimeiroPdf("Testando 123 novo");

	}

}
