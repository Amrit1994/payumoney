package com.toi.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class States implements Serializable {

	private String statename;
	private String stateid;
	
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getStateid() {
		return stateid;
	}
	public void setStateid(String stateid) {
		this.stateid = stateid;
	}
	
}
