package com.mkyong.common;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class PageController implements Serializable {

	public String moveToPage2(){
	    return "page2?faces-redirect=true"; //outcome
	}
}