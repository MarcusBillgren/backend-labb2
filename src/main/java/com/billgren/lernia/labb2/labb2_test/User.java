package com.billgren.lernia.labb2.labb2_test;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.glassfish.jersey.server.JSONP;


@XmlRootElement(name = "user")
public class User implements Serializable {
	
	private static final long serialVersionUID =1L;
	private int id;
	private String name;
	private String profession;
	
	public User() {
		super();
	}

	public User(int id, String name, String profession) {
		super();
		this.id = id;
		this.name = name;
		this.profession = profession;
	}

	public int getId() {
		return id;
	}
	@XmlElement
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	@XmlElement
	public void setName(String name) {
		this.name = name;
	}

	public String getProfession() {
		return profession;
	}
	@XmlElement
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	
	
	
	
	

}
