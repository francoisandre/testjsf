package com.mkyong.common;
import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="message")
@SessionScoped
public class MessageBean implements Serializable {

	public String getContent() {
		return "toto";
	}

}