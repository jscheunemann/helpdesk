package it.helpdesk.ui.interfaces.models.datasources;

import java.util.List;

import it.helpdesk.ui.interfaces.models.IStatus;

public interface IStatusDatasource {
	public List<IStatus> getStatuses();
	public void saveStatus(IStatus status, String statusName);
}
