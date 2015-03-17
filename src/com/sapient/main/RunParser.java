package com.sapient.main;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;

import com.sapient.xmlparsing.XMLReader;

public class RunParser {
	public static void main(String[] args) throws IOException, SAXException,
    ParserConfigurationException{
		//Create a "parser factory" for creating SAX parsers
        SAXParserFactory spfac = SAXParserFactory.newInstance();

        //Now use the parser factory to create a SAXParser object
        SAXParser sp = spfac.newSAXParser();

        //Create an instance of this class; it defines all the handler methods
        XMLReader handler = new XMLReader();

        //Finally, tell the parser to parse the input and notify the handler
        sp.parse("xmlToBeParsed/Trainee.xml", handler);
        handler.displayList();
	}
}
