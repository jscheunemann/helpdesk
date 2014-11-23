package it.helpdesk.datasources.hibernate;

import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.IUserDatasource;

public class HibernateDatasourceConfiguration implements IDatasourceConfiguration {
	private IUserDatasource datasource = null;
	
	public HibernateDatasourceConfiguration() {
		datasource = new UserDatasource();
	}
	
	@Override
	public IUserDatasource getUserDatasource() {
		return this.datasource;
	}
}
