package it.helpdesk.ui.interfaces.models.datasources;

import java.util.List;

import it.helpdesk.ui.interfaces.models.IPriority;

public interface IPriorityDatasource {
	public List<IPriority> getPriorities();
	public void savePriority(IPriority priority, String priorityName);
}
