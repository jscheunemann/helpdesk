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

package it.helpdesk.ui.interfaces;

import java.util.List;

public interface ITicketFormView {
	
	/**
	 * Method to set the current controller to the object passed to the method.
	 * 
	 * @param controller contains an ITechnicianFormController object
	 */
	public void setController(ITicketFormController controller);
	
	/**
	 * Method to open the technician form.
	 */
	public void open();
	
	/**
	 * Method to close the technician form.
	 */
	public void close();
	
	public void saveButtonPressed();
	
	public void cancelButtonPressed();
	
	public void addInformationPressed();
	
	/**
	 * Method to set the applicable service categories
	 * 
	 * @param the categories to load
	 */
	public void setServiceCategories(List<String> categories);
	
	/**
	 * Method to set the applicable priorities
	 * 
	 * @param the priorities to load
	 */
	public void setPriorities(List<String> priorities);
	
	/**
	 * Method to set the applicable statuses
	 * 
	 * @param the statuses to load
	 */
	public void setStatuses(List<String> statuses);
	
	/**
	 * Method to set the service categories
	 * 
	 * @param the selected service category
	 */
	public void setSelectedServiceCategory(String selectedServiceCategory);
	
	/**
	 * Method to get the selected service categories
	 * 
	 * @return the selected service category
	 */
	public String getSelectedServiceCategory();
	
	/**
	 * Method to set the selected priority
	 * 
	 * @param the selected priority
	 */
	public void setSelectedPriority(String selectedPriority);
	
	/**
	 * Method to get the selected priority
	 * 
	 * @return the selected priority
	 */
	public String getSelectedPriority();
	
	/**
	 * Method to set the selected status
	 * 
	 * @param the selected status
	 */
	public void setSelectedStatus(String selectedStatus);
	
	/**
	 * Method to get the selected status
	 * 
	 * @return the selected status
	 */
	public String getSelectedStatus();
	
	/**
	 * Method to set the date the ticket was opened
	 * 
	 * @param the date the ticket was opened
	 */
	public void setDateOpened(String dateEntered);
	
	/**
	 * Method to set the client first name
	 * 
	 * @param clientFirstName
	 */
	public void setClientFirstName(String clientFirstName);
	
	public String getClientFirstName();
	
	public void setClientLastName(String clientLastName);
	
	public String getClientLastName();
	
	public void setClientPhoneNumber(String clientPhoneNumber);
	
	public String getClientPhoneNumber();
	
	public void setClientEmailAddress(String clientEmailAddress);
	
	public String getClientEmailAddress();
	
	public void setSummary(String summary);
	
	public String getSummary();
	
	public String getInformationToAddText();
	
	public void setLogText(String logText);
	
	/**
	 * Method to show any validation error messages to the user
	 */
	public void showValidationErrorDialog();
}
