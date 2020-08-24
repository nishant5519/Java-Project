package com.jaxb;
import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement(name = "student")
public class Student implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	    private int id;
	    private String subject;
	    Student(){
	    }
	    Student(String name,int id,String subject){
	        this.name=name;
	        this.id=id;
	        this.subject=subject;
	    }
	    @XmlElement
	    public String getName() {
	        return name;
	    }
	    public void setName(String name) {
	        this.name = name;
	    }
	    @XmlAttribute
	    public int getId() {
	        return id;
	    }
	    public void setId(int id) {
	        this.id = id;
	    }
	    @XmlElement
	    public String getSubject() {
	        return subject;
	    }
	    public void setSubject(String subject) {
	        this.subject = subject;
	    }

}