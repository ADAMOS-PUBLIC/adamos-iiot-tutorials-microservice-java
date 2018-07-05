package com.adamos.javamicroservice.logging;

import java.util.LinkedList;
import java.util.List;

import org.joda.time.DateTime;

public class Log {

	private String name;
	private String time = DateTime.now().toString();
	private List<String> logs = new LinkedList<>();
	
	public Log(String name) {
		this.name = name;
	}
	
	public void log(String log) {
		logs.add(log);
	}
	
	public String getName() {
		return name;
	}

	public String getTime() {
		return time;
	}

	public List<String> getLogs() {
		return logs;
	}

	public String toString() {
		String result = "Result from " + name + "\r\n";
		result += "Time: " + time.toString() + "\r\n";
		
		for (String string : logs) {
			result += logs + "\r\n";
		}
		
		return result;
		
	}
	
}
