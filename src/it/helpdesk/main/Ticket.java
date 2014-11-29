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

package it.helpdesk.main;

import java.util.Date;

/**
 * View class that allows the user to add a new ticket to the system or update
 * an existing ticket.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class Ticket {
	
	/**
	 * Contains an enumerated list of the current priorities.
	 */
	public enum PriorityEnum{
		LOW, MEDIUM, HIGH, URGENT;

		/**
		 * Method to retrieve the priority based on the index passed to the method.
		 * 
		 * @param i contains the index of the current priority
		 * @return  an PriorityEnum value of the index
		 */
		public static PriorityEnum fromInt(int i) {
			switch(i) {
				case 0:
					return LOW;
				case 1:
					return MEDIUM;
				case 2:
					return HIGH;
				case 3:
					return URGENT;
			}
			
			return null;
		}
	}

	/**
	 * Method to return the index value of the priority passed to the method.
	 * 
	 * @param j contains a PriorityEnum reference
	 * @return  an int value of the PriorityEnum reference
	 */
	public static int toInt(PriorityEnum j){
		switch(j) {
			case LOW: 
				return 0;    			
			case MEDIUM:
				return 1;    			
			case HIGH:
				return 2;    			
			case URGENT:
				return 3;   		
		}

		return 0;
	}

	/**
	 * Contains an enumerated list of the current service categories.
	 */
	public enum ServiceCatEnum {
		ACCESS_ISSUE, HARDWARE, SOFTWARE, DATABASE, SOFTWARE_DEFECT, INQUIRY;

		/**
		 * Method to retrieve the service category based on the index passed to the method.
		 * 
		 * @param i contains the index of the current service cetegory
		 * @return  an ServiceCatEnum value of the index
		 */
		public static ServiceCatEnum fromInt(int i) {
			switch (i){
				case 0: 
					return ACCESS_ISSUE;
				case 1:
					return HARDWARE;
				case 2: 
					return SOFTWARE;
				case 3: 
					return DATABASE;
				case 4: 
					return SOFTWARE_DEFECT;
				case 5: 
					return INQUIRY;
			}
			
			return null;    	
		}

		/**
		 * Method to return the index value of the service category passed to the method.
		 * 
		 * @param j contains a ServiceCatEnum reference
		 * @return  an int value of the ServiceCatEnum reference
		 */
		public static int toInt(ServiceCatEnum j) {
			switch(j) {
				case ACCESS_ISSUE: 
					return 0;    			
				case HARDWARE:
					return 1;    			
				case SOFTAWARE:
					return 2;    			
				case DATABASE:
					return 3;  
				case SOFTWARE_DEFECT:
					return 4;
				case INQUIRY:
					return 5;
			}

			return -1;
		}
	};	

	/**
	 * Contains an enumerated list of the current statuses.
	 */
	public enum StatusEnum {
		NEW, IN_PROGRESS, WAIT_FOR_PROCESS, WITHDRAWN, COMPLETE, DELETE;
		
		/**
		 * Method to retrieve the status based on the index passed to the method.
		 * 
		 * @param i contains the index of the current status
		 * @return  an StatusEnum value of the index
		 */
		public static StatusEnum fromInt(int i){
			switch (i){
				case 0: 
					return NEW;
				case 1:
					return IN_PROGRESS;
				case 2: 
					return WAIT_FOR_PROCESS;
				case 3: 
					return WITHDRAWN;
				case 4: 
					return COMPLETE;
				case 5: 
					return DELETE;
			}
			return null;    	
		}

		/**
		 * Method to return the index value of the status passed to the method.
		 * 
		 * @param j contains a StatusEnum reference
		 * @return  an int value of the StatusEnum reference
		 */
		public static int toInt(StatusEnum j){
			switch(j) {
				case NEW: 
					return 0;    			
				case IN_PROGRESS:
					return 1;    			
				case WAIT_FOR_PROCESS:
					return 2;    			
				case WITHDRAWN:
					return 3;  
				case COMPLETE:
					return 4;
				case DELETE:
					return 5;
			}

			return -1;
		}
	};

	/**
	 * Contains the ticket's ID.
	 */
	private long ID;
	
	/**
	 * Contains the user that opened the ticket.
	 */
	private String openedBy;
	
	/**
	 * Contains the date the user opened the ticket.
	 */
	private Date openedDate;
	
	/**
	 * Contains the client name who requested the ticket.
	 */
	private String client;
	
	/**
	 * Contains the client phone number for the person who requested the ticket.
	 */
	private String clientPhone;
	
	/**
	 * Contains the client email for the person who requested the ticket.
	 */
	private String clientEmail;
	
	/**
	 * Contains an array of priorities.
	 */
	private PriorityEnum priority;
	
	/**
	 * Contains an array of service categories.
	 */
	private ServiceCatEnum serviceCat;
	
	/**
	 * Contains an array of statuses.
	 */
	private StatusEnum status;
	
	/**
	 * Contains the date the ticket was completed.
	 */
	private Date completeDate;
	
	/**
	 * Contains the description of the ticket.
	 */
	private String description;
	
	/**
	 * Contains the log of all of the updates to the ticket.
	 */
	private String log;
	
	/**
	 * Contains the summary of the ticket information.
	 */
	private String summary;

	/**
	 * Default class constructor that will initialize the ticket ID to zero.
	 */
	public Ticket() {
		ID = 0;		
	}

	/**
	 * Method to retrieve the current ticket ID.
	 * 
	 * @return a long value containing the ticket ID
	 */
	public long getID() {
		return ID;
	}

	/**
	 * Method to set the current ticket's ID value.
	 * @param id contains the current ID information
	 */
	public void setID(long id) {
		ID = id;
	}
	
	/**
	 * Method to retrieve the current ticket's opened by value.
	 * 
	 * @return a String value containing the ticket's opened by value
	 */
	public String getOpenedBy(){
		return openedBy;
	}

	/**
	 * Method to set the current ticket's opened by value.
	 * @param opened_by contains the current opened by information
	 */
	public void setOpenedBy(String opened_by){
		openedBy = opened_by;
	}

	/**
	 * Method to retrieve the current ticket's opened on value.
	 * 
	 * @return a Date value containing the ticket's opened on value
	 */
	public Date getOpenedDate(){
		return openedDate;
	}

	/**
	 * Method to set the current ticket's opened on value.
	 * @param opened_date contains the current opened on information
	 */
	public void setOpenedDate(Date opened_date){
		openedDate = opened_date;
	}

	/**
	 * Method to retrieve the current ticket's client name value.
	 * 
	 * @return a String value containing the ticket's client name value
	 */
	public String getClient(){
		return client;
	}

	/**
	 * Method to set the current ticket's client name value.
	 * @param Client contains the current client name information
	 */
	public void setClient(String Client){
		client = Client;
	}

	/**
	 * Method to retrieve the current ticket's client phone number value.
	 * 
	 * @return a String value containing the ticket's client phone number value
	 */
	public String getClientPhone(){
		return clientPhone;
	}

	/**
	 * Method to set the current ticket's client phone value.
	 * @param client_phone contains the current client phone information
	 */
	public void setClientPhone(String client_phone){
		clientPhone = client_phone;
	}

	/**
	 * Method to retrieve the current ticket's client email value.
	 * 
	 * @return a String value containing the ticket's client email value
	 */
	public String getClientEmail(){
		return clientEmail;
	}

	/**
	 * Method to set the current ticket's client email value.
	 * @param client_email contains the current client email information
	 */
	public void setClientEmail(String client_email){
		clientEmail = client_email;
	}

	/**
	 * Method to retrieve the current ticket's completed by value.
	 * 
	 * @return a Date value containing the ticket's completed by value
	 */
	public Date getCompleteDate(){
		return completeDate;
	}

	/**
	 * Method to set the current ticket's completed on value.
	 * @param complete_date contains the current completed on information
	 */
	public void setCompleteDate(Date complete_date){
		completeDate = complete_date;
	}	

	/**
	 * Method to retrieve the current ticket's priority value.
	 * 
	 * @return a PriorityEnum value containing the ticket's priority value
	 */
	public PriorityEnum getPriority(){
		return priority;
	}

	/**
	 * Method to set the current ticket's priority value.
	 * @param Priority contains the current priority information
	 */
	public void setPriority(PriorityEnum Priority){
		priority = Priority;
	}

	/**
	 * Method to retrieve the current ticket's service category value.
	 * 
	 * @return a ServiceCatEnum value containing the ticket's service category value
	 */
	public ServiceCatEnum getServiceCat(){
		return serviceCat;
	}

	/**
	 * Method to set the current ticket's service category value.
	 * @param serviceCategory contains the current service category information
	 */
	public void setServiceCat(ServiceCatEnum serviceCategory){
		serviceCat = serviceCategory;
	}

	/**
	 * Method to retrieve the current ticket's status value.
	 * 
	 * @return a StatusEnum value containing the ticket's status value
	 */
	public StatusEnum getStatus(){
		return status;		
	}

	/**
	 * Method to set the current ticket's status value.
	 * @param Status contains the current status information
	 */
	public void setStatus(StatusEnum Status){
		status = Status;
	}

	/**
	 * Method to retrieve the current ticket's description value.
	 * 
	 * @return a String value containing the ticket's description value
	 */
	public String getDescription(){
		return description;
	}

	/**
	 * Method to set the current ticket's description value.
	 * @param Description contains the current description information
	 */
	public void setDescription(String Description){
		description = Description;
	}

	/**
	 * Method to retrieve the current ticket's summary value.
	 * 
	 * @return a String value containing the ticket's summary value
	 */
	public String getSummary(){
		return summary;
	}
	
	/**
	 * Method to set the current ticket's summary value.
	 * @param Summary contains the current summary information
	 */
	public void setSummary(String Summary){
		summary = Summary;
	}

	/**
	 * Method to retrieve the current ticket's log value.
	 * 
	 * @return a String value containing the ticket's log value
	 */
	public String getLog(){
		return log;
	}

	/**
	 * Method to set the current ticket's log value.
	 * @param Log contains the current log information
	 */
	public void setLog(String Log){
		log = Log;
	}
}
