package it.helpdesk.ui.interfaces.models.datasources;

import it.helpdesk.ui.interfaces.models.IServiceCategory;

import java.util.List;

public interface IServiceCategoryDatasource {
	public List<IServiceCategory> getServiceCategories();
	public void saveServiceCategory(IServiceCategory servieCategory, String categoryName);
}
