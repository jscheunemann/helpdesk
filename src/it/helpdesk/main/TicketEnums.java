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

/**
 * View class that allows the user to add a new ticket to the system or update
 * an existing ticket.
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-11-29
 */
public class TicketEnums {

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
		public static PriorityEnum fromString(String priority) {
			if (priority.equalsIgnoreCase("low")) {
				return LOW;
			}
			else if (priority.equalsIgnoreCase("medium")) {
				return MEDIUM;
			}
			if (priority.equalsIgnoreCase("high")) {
				return HIGH;
			}
			if (priority.equalsIgnoreCase("urgent")) {
				return URGENT;
			}
			else {
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
		public static ServiceCatEnum fromString(String category) {
			if (category.equalsIgnoreCase("access issue")) {
				return ACCESS_ISSUE;
			}
			else if (category.equalsIgnoreCase("hardware")) {
				return HARDWARE;
			}
			else if (category.equalsIgnoreCase("software")) {
				return SOFTWARE;
			}
			else if (category.equalsIgnoreCase("database")) {
				return DATABASE;
			}
			else if (category.equalsIgnoreCase("software defect")) {
				return SOFTWARE_DEFECT;
			}
			else if (category.equalsIgnoreCase("inquiry")) {
				return INQUIRY;
			}
			else {
				return null;  
			}
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
			case SOFTWARE:
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
		public static StatusEnum fromString(String status){
			
			if (status.equalsIgnoreCase("new")) {
				return NEW;
			}
			else if (status.equalsIgnoreCase("in progress")) {
				return IN_PROGRESS;
			}
			else if (status.equalsIgnoreCase("wait for process")) {
				return WAIT_FOR_PROCESS;
			}
			else if (status.equalsIgnoreCase("withdrawn")) {
				return WITHDRAWN;
			}
			else if (status.equalsIgnoreCase("complete")) {
				return COMPLETE;
			}
			else if (status.equalsIgnoreCase("delete")) {
				return DELETE;
			}
			else {
				return null;
			}
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
}
