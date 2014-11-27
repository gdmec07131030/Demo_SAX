package com.example.demo_sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class MyHandler extends DefaultHandler{
    List<User> users;
    User user;
    String content;
    List<User> getUsers(){
    	return users;
    }
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		super.characters(ch, start, length);
		content=new String(ch,start,length);
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.endDocument();
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		// TODO Auto-generated method stub
		super.endElement(uri, localName, qName);
		if("name".equals(localName)){
			user.setName(content);
		}
		if("password".equals(localName)){
			user.setPassword(content);
		}
		if("user".equals(localName)){
			users.add(user);
			user=null;
		}
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		super.startDocument();
		this.users=new ArrayList<User>();
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		// TODO Auto-generated method stub
		super.startElement(uri, localName, qName, attributes);
		if("user".equals(localName)){
			user=new User();
			user.setId(Integer.parseInt(attributes.getValue("id")));
		}
	}

}
