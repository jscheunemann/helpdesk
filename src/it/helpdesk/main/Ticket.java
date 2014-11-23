/*
 * Copyright (C) 2014  Helpdesk Tracker Group, Fall Semester, UMUC
 * 
 * This software is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 */

package it.helpdesk.main;

import java.util.Date;

public class Ticket {
	public enum PriorityEnum{
		LOW, MEDIUM, HIGH, URGENT;

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

	public enum ServiceCatEnum {
		ACCESS_ISSUE, HARDWARE, SOFTWARE, DATABASE, SOFTWARE_DEFECT, INQUIRY;

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

	public enum StatusEnum {
		NEW, IN_PROGRESS, WAIT_FOR_PROCESS, WITHDRAWN, COMPLETE, DELETE;
		
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

	private long ID;
	private String openedBy;
	private Date openedDate;
	private String client;
	private String clientPhone;
	private String clientEmail;
	private PriorityEnum priority;
	private ServiceCatEnum serviceCat;
	private StatusEnum status;
	private Date completeDate;
	private String description;
	private String log;
	private String summary;



	public Ticket() {
		ID = 0;		
	}

	public long getID() {
		return ID;
	}

	public void setID(long id) {
		ID = id;
	}
	public String getOpenedBy(){
		return openedBy;
	}

	public void setOpenedBy(String opened_by){
		openedBy = opened_by;
	}

	public Date getOpenedDate(){
		return openedDate;
	}

	public void setOpenedDate(Date opened_date){
		openedDate = opened_date;
	}

	public String getClient(){
		return client;
	}

	public void setClient(String Client){
		client = Client;
	}

	public String getClientPhone(){
		return clientPhone;
	}

	public void setClientPhone(String client_phone){
		clientPhone = client_phone;
	}

	public String getClientEmail(){
		return clientEmail;
	}

	public void setClientEmail(String client_email){
		clientEmail = client_email;
	}

	public Date getCompleteDate(){
		return completeDate;
	}

	public void setCompleteDate(Date complete_date){
		completeDate = complete_date;
	}	

	public PriorityEnum getPriority(){
		return priority;
	}

	public void setPriority(PriorityEnum Priority){
		priority = Priority;
	}

	public ServiceCatEnum getServiceCat(){
		return serviceCat;
	}

	public void setServiceCat(ServiceCatEnum serviceCategory){
		serviceCat = serviceCategory;
	}

	public StatusEnum getStatus(){
		return status;		
	}

	public void setStatus(StatusEnum Status){
		status = Status;
	}

	public String getDescription(){
		return description;
	}

	public void setDescription(String Description){
		description = Description;
	}

	public String getSummary(){
		return summary;
	}

	public void setSummary(String Summary){
		summary = Summary;
	}

	public String getLog(){
		return log;
	}

	public void setLog(String Log){
		log = Log;
	}
}
