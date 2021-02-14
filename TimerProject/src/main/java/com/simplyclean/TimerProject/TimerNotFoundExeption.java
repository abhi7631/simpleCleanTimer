package com.simplyclean.TimerProject;

@SuppressWarnings("serial")
public class TimerNotFoundExeption extends RuntimeException{
	TimerNotFoundExeption(Long id) {
	    super("Could not find timer " + id);
	  }
}
