package com.sapient.xmlparsing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.sapient.pojo.Address;
import com.sapient.pojo.Trainee;

public class XMLReader extends DefaultHandler {
	private String temp;
	private Trainee tempTrainee;
	private Address addr=null;
	private String addrType;
	private ArrayList<Trainee> traineeList = new ArrayList<>();
	private Date date=null;

	public void characters(char ch[], int start, int length)
			throws SAXException {
		temp = new String(ch, start, length);
	}
	
	/*
     * When the parser encounters the start of an element, it calls this method
     */
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		
		temp = "";
		if (qName.equalsIgnoreCase("trainee")) {
			tempTrainee = new Trainee();
		}else if(qName.equalsIgnoreCase("address")){
			addr=new Address();
			addrType="";
			addrType=attributes.getValue("type");
			//looking for the error
			/*System.out.println(addrType);*/
		}
	}
	
	/*
     * When the parser encounters the end of an element, it calls this method
     */
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		
		if(qName.equalsIgnoreCase("trainee")){
			// add it to the list
			traineeList.add(tempTrainee);
		}else if(qName.equalsIgnoreCase("name")){
			tempTrainee.setTraineeName(temp);
		}else if (qName.equalsIgnoreCase("contact")) {
			tempTrainee.setTraineeContact(temp);
		}else if(qName.equalsIgnoreCase("housenumber")){
			addr.setHouseNo(Integer.parseInt(temp));
		}else if(qName.equalsIgnoreCase("street")){
			addr.setStreeNo(Integer.parseInt(temp));
		}else if(qName.equalsIgnoreCase("city")){
			addr.setCity(temp);
		}else if (qName.equalsIgnoreCase("address") && addrType.equalsIgnoreCase("current")) {
			tempTrainee.setTraineeCurAddr(addr);
		}else if (qName.equalsIgnoreCase("address") && addrType.equalsIgnoreCase("permanent")) {
			tempTrainee.setTraineePerAddr(addr);
		}else if (qName.equalsIgnoreCase("stream")) {
			tempTrainee.setTraineeStream(temp);			
		}else if (qName.equalsIgnoreCase("score")) {
			tempTrainee.setTraineeScore(Integer.parseInt(temp));			
		}else if (qName.equalsIgnoreCase("dateofjoining")) {
			//Don't Know what to do :/ :(
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			try {
				date = formatter.parse(temp);
				tempTrainee.setTraineeJoinDate(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public ArrayList<Trainee> getList(){
		return traineeList;
	}
	
	public void displayList(){
		System.out.println("Total No. of Trainees: "+traineeList.size());
		for(Trainee temp:traineeList){
			System.out.println(temp);
		}
	}

}
