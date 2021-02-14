package com.simplyclean.TimerProject;

import java.sql.Timestamp;
import java.util.Date;

public class TimerResponse {
	  private int startVal;
	  private int stepVal;
	  private Timestamp createDate;
	  
	  TimerResponse(){}
	  
	  TimerResponse(Integer startVal, Integer stepVal, Timestamp createDate)
	  {
		  this.startVal = startVal;
		  this.stepVal = stepVal;
		  this.createDate = createDate;
	  }
	  
	public int getStartVal()
	{
		return startVal;
	}
	public void setStartVal(int startVal) {
		this.startVal = startVal;
	}
	public int getStepVal() {
		return stepVal;
	}
	public void setStepVal(int stepVal) {
		this.stepVal = stepVal;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	  

}
