package it.helpdesk.datasources.memory;

import it.helpdesk.ui.interfaces.*;

public class MemoryDatasourceConfiguration implements IDatasourceConfiguration {
	IUserDatasource datasource = null;
	
	public MemoryDatasourceConfiguration() {
		datasource = new UserDatasource();
		datasource.saveUser(null, "test", "test", "Jason", "Scheunemann", "jason.scheunemann@example.com");
	}
	
	@Override
	public IUserDatasource getUserDatasource() {
		return datasource;
	}
}
