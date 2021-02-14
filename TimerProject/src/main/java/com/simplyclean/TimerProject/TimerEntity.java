package com.simplyclean.TimerProject;


import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "simplyclean_timers")
public class TimerEntity {

  @Column(name = "timer_id")
  private @Id @GeneratedValue Long timerId;
  
  @Column(name ="start_val")
  private int startVal;
  
  @Column(name ="step_val")
  private int stepVal;
  
  @Column(name ="create_time")
  private Timestamp createDate;
  
  @Column(name ="modofied_time")
  private Timestamp modifiedDate;
  
  @Column(name ="pause_ind")
  private int pauseInd;
  
  @Column(name ="active_ind")
  private int activeInd;
  TimerEntity() {}

  TimerEntity(int startVal, int stepVal) {

    this.startVal = startVal;
    this.stepVal = stepVal;
  }

  public Long getId() {
    return this.timerId;
  }

  public int getStartVal() {
    return this.startVal;
  }

  public int getStepVal() {
    return this.stepVal;
  }

  public void setId(Long timerId) {
    this.timerId = timerId;
  }

  public void setStartVal(int startVal) {
    this.startVal = startVal;
  }

  public void setStepVal(int stepVal) {
    this.stepVal = stepVal;
  }


  public Timestamp getCreateDate() {
	return createDate;
  }

  public void setCreateDate(Timestamp createDate) {
	this.createDate = createDate;
  }	

  public Timestamp getModifiedDate() {
	return modifiedDate;
  }

  public void setModifiedDate(Timestamp modifiedDate) {
	this.modifiedDate = modifiedDate;
  }

public int getPauseInd() {
	return pauseInd;
}

public void setPauseInd(int pauseInd) {
	this.pauseInd = pauseInd;
}

public int getActiveInd() {
	return activeInd;
}

public void setActiveInd(int activeInd) {
	this.activeInd = activeInd;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	TimerEntity other = (TimerEntity) obj;
	if (activeInd != other.activeInd)
		return false;
	if (createDate == null) {
		if (other.createDate != null)
			return false;
	} else if (!createDate.equals(other.createDate))
		return false;
	if (modifiedDate == null) {
		if (other.modifiedDate != null)
			return false;
	} else if (!modifiedDate.equals(other.modifiedDate))
		return false;
	if (pauseInd != other.pauseInd)
		return false;
	if (startVal != other.startVal)
		return false;
	if (stepVal != other.stepVal)
		return false;
	if (timerId == null) {
		if (other.timerId != null)
			return false;
	} else if (!timerId.equals(other.timerId))
		return false;
	return true;
}

  @Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + activeInd;
	result = prime * result + ((createDate == null) ? 0 : createDate.hashCode());
	result = prime * result + ((modifiedDate == null) ? 0 : modifiedDate.hashCode());
	result = prime * result + pauseInd;
	result = prime * result + startVal;
	result = prime * result + stepVal;
	result = prime * result + ((timerId == null) ? 0 : timerId.hashCode());
	return result;
}

  @Override
public String toString() {
	return "TimerEntity [timerId=" + timerId + ", startVal=" + startVal + ", stepVal=" + stepVal + ", createDate="
			+ createDate + ", modifiedDate=" + modifiedDate + ", pauseInd=" + pauseInd + ", activeInd=" + activeInd
			+ "]";
}
}
