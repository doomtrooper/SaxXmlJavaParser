package com.sapient.main;

import java.io.File;
import java.io.IOException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.sapient.xmlparsing.XMLErrorHandler;
import com.sapient.xmlparsing.XMLReader;

public class RunParser {
	public static void main(String[] args) throws IOException, SAXException,
			ParserConfigurationException {
		// Create a "parser factory" for creating SAX parsers
		SAXParserFactory spfac = SAXParserFactory.newInstance();
		Source xmlFile = new StreamSource(new File("xmlToBeParsed/Trainee.xml"));
		SchemaFactory schemaFactory = SchemaFactory
				.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(new File(
				"xmlToBeParsed/Trainee.xsd"));
		Validator validator = schema.newValidator();
		validator.setErrorHandler(new XMLErrorHandler());
		try {
			validator.validate(xmlFile);
			// System.out.println(xmlFile.getSystemId() + " is valid");
			// Now use the parser factory to create a SAXParser object
			SAXParser sp = spfac.newSAXParser();

			// Create an instance of this class; it defines all the handler
			// methods
			XMLReader reader = new XMLReader();
			// Finally, tell the parser to parse the input and notify the
			// handler

			sp.parse("xmlToBeParsed/Trainee.xml", reader);
			reader.displayList();
		} catch (SAXException e) {
			System.out.println(xmlFile.getSystemId() + " is NOT valid");
		}
	}
}
