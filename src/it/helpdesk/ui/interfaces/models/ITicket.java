package it.helpdesk.ui.interfaces.models;

import java.util.Date;

public interface ITicket {
	public long getId();
	public void setId(long id);
	public IServiceCategory getServiceCategory();
	public void setServiceCategory(IServiceCategory serviceCategory);
	public IStatus getStatus();
	public void setStatus(IStatus status);
	public IOperator getOperator();
	public void setOperator(IOperator operator);
	public ITechnician getAssignedTo();
	public void setAssignedTo(ITechnician assignedTo);
	public Date getOpenedOn();
	public void setOpenedOn(Date openedOn);
	public Date getCompletedOn();
	public void setCompletedOn(Date completedOn);
}
