package it.helpdesk.main;

import java.sql.Date;

public class Ticket {
	private long ID;
	private String openedBy;
	private Date openedDate;
	private String client;
	private String clientPhone;
	private String clientEmail;
	enum priority{LOW,MEDIUM, HIGH, URGENT};
	enum serviceCategory {ACCESS_ISSUE, HARDWARE, SOFTWARE, DATABASE, SOFTWARE_DEFECT, INQUIRY};		
	enum status{NEW, IN_PROGRESS, WAIT_FOR_PROCESS, WITHDRAWN, COMPLETE, DELETE};
	
	private Date completeDate;
	
		
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

}
