package com.toi.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class AuditionCity implements Serializable {
	
	private String acityname;
	private String acityId;
	
	public String getAcityname() {
		return acityname;
	}
	public void setAcityname(String acityname) {
		this.acityname = acityname;
	}
	public String getAcityId() {
		return acityId;
	}
	public void setAcityId(String acityId) {
		this.acityId = acityId;
	}
	
	
}
