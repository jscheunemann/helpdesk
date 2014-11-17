package it.helpdesk.main;

import java.sql.Date;

public class Ticket {
	enum PriorityEnum{LOW,MEDIUM, HIGH, URGENT};
	enum ServiceCatEnum {ACCESS_ISSUE, HARDWARE, SOFTWARE, DATABASE, SOFTWARE_DEFECT, INQUIRY};		
	enum StatusEnum{NEW, IN_PROGRESS, WAIT_FOR_PROCESS, WITHDRAWN, COMPLETE, DELETE};

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
