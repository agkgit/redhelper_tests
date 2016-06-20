package com.redhelper;

public class RCOperator {

	public String number;
	public String timeStart;
	public String timeStop;

	RCOperator(String number) {
		this.number = number;
		this.timeStart = "00:00";
		this.timeStop = "00:00";
	}

	RCOperator(String number, String timeStart, String timeStop) {
		this.number = number;
		this.timeStart = timeStart;
		this.timeStop = timeStop;
	}
}