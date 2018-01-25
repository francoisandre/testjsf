package com.mkyong.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	
	@ManagedProperty(value="#{message}")
	private MessageBean message;


	public void setMessage(MessageBean message) {
		this.message = message;
	}
	
	public MessageBean getMessage() {
		return message;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSayWelcome(){
		   //check if null?
		   if("".equals(name) || name ==null){
			return "";
		   }else{
			return "Ajax message : Welcome " + name;
		   }
		}

}