package it.helpdesk.ui.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import it.helpdesk.ui.interfaces.IDatasourceConfiguration;
import it.helpdesk.ui.interfaces.ILoginFormController;
import it.helpdesk.ui.interfaces.IMainFormController;
import it.helpdesk.ui.interfaces.IMainFormView;
import it.helpdesk.ui.interfaces.ITicketFormController;
import it.helpdesk.ui.interfaces.IViewConfiguration;
import it.helpdesk.ui.interfaces.models.ITicket;
import it.helpdesk.ui.interfaces.models.datasources.ITicketDatasource;
import it.helpdesk.ui.desktop.swing.*;

public class MainFormController implements IMainFormController {
	/**
	 * Contains an IViewConfiguration object.
	 */
	private IViewConfiguration viewConfiguration;

	/**
	 * Contains an IDatasourceConfiguration object.
	 */
	private IDatasourceConfiguration datasourceConfiguration;

	/**
	 * Contains an IMainFormView object
	 */
	private IMainFormView view;

	/**
	 * Contains an ITechnicianDatasource object.
	 */
	private ITicketDatasource datasource;

	private List<ITicket> tickets = null;

	private List<ITicket> activeTickets = null;

	private List<ITicket> inactiveTickets = null;

	private long selectedTicketId = 0;

	private String[] activeTicketStatuses = {"New", "In Progress", "Wait For Process"};

	private String[] inactiveTicketStatuses = {"Withdrawn", "Complete", "Delete"};

	public MainFormController(IViewConfiguration viewConfiguration, IDatasourceConfiguration datasourceConfiguration) {
		this.viewConfiguration = viewConfiguration;
		this.datasourceConfiguration = datasourceConfiguration;
	}

	public void openForm() {
		if (this.view == null) {
			this.view = viewConfiguration.getMainFormView();
			this.view.setController(this);
		}

		if (this.datasource == null) {
			this.datasource = datasourceConfiguration.getTicketDatasource();
		}

		this.view.open();
	}

	@Override
	public void loadActiveTickets() {
		if (this.tickets == null) { 
			tickets = this.datasource.getTickets();
		}

		if (activeTickets == null) {
			this.activeTickets = new ArrayList<ITicket>();	
		}
		
		activeTickets.clear();

		for (ITicket ticket : tickets) {
			for (String status : activeTicketStatuses) {
				if (ticket.getStatus().equalsIgnoreCase(status)) {
					activeTickets.add(ticket);
				}
			}
		}
		
		this.view.displayActiveTickets(activeTickets);
	}

	@Override
	public void loadInactiveTickets() {
		if (this.tickets == null) { 
			tickets = this.datasource.getTickets();
		}

		if (inactiveTickets == null) {
			this.inactiveTickets = new ArrayList<ITicket>();
		}
		
		inactiveTickets.clear();
		
		for (ITicket ticket : tickets) {
			for (String status : inactiveTicketStatuses) {
				if (ticket.getStatus().equalsIgnoreCase(status)) {
					inactiveTickets.add(ticket);
				}
			}
		}

		this.view.displayInactiveTickets(inactiveTickets);
	}

	@Override
	public void openTicketForm() {
		ITicketFormController ticketFormController = new TicketFormController(this.viewConfiguration, this.datasourceConfiguration);

		if (this.selectedTicketId > 0) {
			for (ITicket ticket : tickets) {
				if (ticket.getId() == selectedTicketId) {
					ticketFormController.setTicket(ticket);
				}
			}
		}

		ticketFormController.openForm();

		this.loadActiveTickets();
		this.loadInactiveTickets();
		
		long lastId = 0;
		
		for (ITicket ticket : this.tickets) {
			if (ticket.getId() > lastId) {
				lastId = ticket.getId();
			}
		}
		
		List<ITicket> newTickets = this.datasource.getTicketUpdates(lastId);
		
		for (ITicket ticket : newTickets) {
			this.tickets.add(ticket);
		}
		
		this.loadActiveTickets();
		this.loadInactiveTickets();
	}

	public void openCreateTicketForm() {
		this.selectedTicketId = 0;
		this.openTicketForm();
	}

	@Override
	public void openLoginForm() {
		ILoginFormController loginController = new LoginFormController(this.viewConfiguration, this.datasourceConfiguration);
		loginController.openForm();
	}

	@Override
	public void closeForm() {
		this.view.close();
	}

	public void setApplicationParentFrame(JFrame frame) {
		((SwingViewConfiguration) this.viewConfiguration).setApplicationParentFrame(frame);
	}

	@Override
	public void clearActiveTicketView() {
		this.view.displayActiveTickets(new ArrayList<ITicket>());
	}

	@Override
	public void clearInactiveTicketView() {
		this.view.displayInactiveTickets(new ArrayList<ITicket>());
	}

	@Override
	public void updateSelectedTicket(long id) {
		this.selectedTicketId = id;
	}

	@Override
	public void clearSelectedTicket() {
		this.selectedTicketId = 0;
	}

	@Override
	public void updateSelectedActiveTicketIndex(int index) {
		this.selectedTicketId = activeTickets.get(index).getId();
	}

	@Override
	public void updateSelectedInactiveTicketIndex(int index) {
		this.selectedTicketId = inactiveTickets.get(index).getId();
	}
}
