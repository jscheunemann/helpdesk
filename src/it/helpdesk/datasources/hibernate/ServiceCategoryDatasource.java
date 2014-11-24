/*
 * 
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 51 Franklin Street, Fifth Floor, Boston, MA 02110-1301 USA.
 * 
 */

package it.helpdesk.datasources.hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import it.helpdesk.ui.interfaces.models.IServiceCategory;
import it.helpdesk.ui.interfaces.models.datasources.IServiceCategoryDatasource;

public class ServiceCategoryDatasource implements IServiceCategoryDatasource {

	@SuppressWarnings("unchecked")
	@Override
	public List<IServiceCategory> getServiceCategories() {
		List<IServiceCategory> serviceCategories = null;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		serviceCategories = (List<IServiceCategory>) session.createQuery("from ServiceCategory").list();
		session.close();

		return serviceCategories;
	}

	@Override
	public void saveServiceCategory(IServiceCategory serviceCategory, String serviceCategoryName) {
		boolean newServiceCategory = false;
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();

		if (serviceCategory == null) {
			serviceCategory = new ServiceCategory();
			newServiceCategory = true;
		}
		
		serviceCategory.setCategoryName(serviceCategoryName);
		
		session.beginTransaction();
		
		if (newServiceCategory) {
			session.save(serviceCategory);
		}
		else {
			session.update(serviceCategory);
		}
	
		session.getTransaction().commit();
		session.close();
	}

}
