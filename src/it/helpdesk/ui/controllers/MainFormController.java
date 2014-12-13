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

	/**
	 * Variable for ticket adding/editing
	 */
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
		if (tickets == null) {
			tickets = this.datasource.getTickets();
		}


		activeTickets = new ArrayList<ITicket>();

		for (ITicket ticket : tickets) {
			for (String status : activeTicketStatuses) {
				if (ticket.getStatus().equalsIgnoreCase(status)) {
					this.activeTickets.add(ticket);
				}
			}
		}

		this.view.displayActiveTickets(activeTickets);
	}

	@Override
	public void loadInactiveTickets() {
		if (tickets == null) {
			tickets = this.datasource.getTickets();
		}


		inactiveTickets = new ArrayList<ITicket>();

		for (ITicket ticket : tickets) {
			for (String status : inactiveTicketStatuses) {
				if (ticket.getStatus().equalsIgnoreCase(status)) {
					this.inactiveTickets.add(ticket);
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
		activeTickets.clear();
		this.view.displayActiveTickets(activeTickets);
	}

	@Override
	public void clearInactiveTicketView() {
		inactiveTickets.clear();
		this.view.displayInactiveTickets(inactiveTickets);
	}

	@Override
	public void updateSelectedTicket(long id) {
		this.selectedTicketId = id;
	}

	@Override
	public void clearSelectedTicket() {
		this.selectedTicketId = 0;
	}
}
