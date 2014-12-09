package it.helpdesk.main;

import it.helpdesk.ui.interfaces.models.ITechnician;

public class ApplicationState {
	private ITechnician loggedInTechnician;
	private static volatile ApplicationState instance = null;
	
	private ApplicationState() {}
 
    public static ApplicationState getInstance() {
        if (instance == null) {
            synchronized (ApplicationState.class) {
                if (instance == null) {
                    instance = new ApplicationState();
                }
            }
        }
 
        return instance;
    }
	
	public void setLoggedInTechnician(ITechnician technician) {
		this.loggedInTechnician = technician;
	}
	
	public ITechnician getLoggedInTechnician() {
		return this.loggedInTechnician;
	}
}
