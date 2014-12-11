package it.helpdesk.ui.controllers;

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

	/**
	 * Variable for ticket adding/editing
	 */
	private List<ITicket> activeTickets;
	
	private List<ITicket> inactiveTickets;
	
	private long selectedTicketId = 0;
	
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
		activeTickets = this.datasource.getOpenTickets();
		this.view.displayActiveTickets(activeTickets);
	}

	@Override
	public void loadInactiveTickets() {
		inactiveTickets = this.datasource.getClosedTickets();
		this.view.displayInactiveTickets(inactiveTickets);
	}

	@Override
	public void openTicketForm() {
		ITicketFormController ticketFormController = new TicketFormController(this.viewConfiguration, this.datasourceConfiguration);
		
		if (this.selectedTicketId > 0) {
			ticketFormController.setTicket(this.datasource.getTicketById(selectedTicketId));
		}
		
		ticketFormController.openForm();
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
