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

	@Override
	public void searchByTicket() {
		long searchId = -1;
		
		try {
			searchId = Long.parseLong(this.view.getSearchByTicketText());
		}
		catch (NumberFormatException ex) {
			
		}
		
		boolean found = false;
		
		for (ITicket ticket : tickets) {
			if (ticket.getId() == searchId) {
				searchId = ticket.getId();
				found = true;
			}
		}
		
		if (found) {
			this.selectedTicketId = searchId;
		}
		else {
			this.selectedTicketId = -1;
		}
		
		if (this.selectedTicketId >= 0) {
			this.openTicketForm();
		}
		else {
			this.view.showDialog("Ticket Not Found", "The ticket ID could not be found, please try again.");
		}
	}
}
