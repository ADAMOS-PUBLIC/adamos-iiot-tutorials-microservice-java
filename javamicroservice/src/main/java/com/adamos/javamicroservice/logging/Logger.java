package com.adamos.javamicroservice.logging;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class Logger {

	
	private Runresults results = new Runresults();
	
	public void log(String name, String line) {
		Log log = new Log(name);
		log.getLogs().add(line);
		results.addLog(log);
	}
	
	public List<Log> getLogs() {
		return results.getLogs();
	}
	
	
}
