package com.adamos.javamicroservice.logging;

import java.util.LinkedList;
import java.util.List;

public class Runresults {

	private List<Log> logs = new LinkedList<>();

	public List<Log> getLogs() {
		return logs;
	}

	public void addLog(Log log) {
		logs.add(log);
		while (logs.size() > 10) {
			logs.remove(0);
		}
	}

	
}
