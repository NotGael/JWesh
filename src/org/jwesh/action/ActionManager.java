package org.jwesh.action;

import java.util.HashMap;
import java.util.Map;

public class ActionManager {
	
	private static ActionManager instance;
	
	public static ActionManager getInstance() {
		if (instance == null) {
			instance = new ActionManager();
		}
		return instance;
	}
	
	private ActionManager() {
		actions = new HashMap<String, Action>();
	}
	
	private Map<String, Action> actions;
	
	public void addAction(String mapping, Action action) {
		actions.put(mapping, action);
	}
	
	public Action getAction(String mapping) {
		return actions.get(mapping);
	}
	
}