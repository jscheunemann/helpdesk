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

import java.util.Comparator;

/**
 * TicketCategoryComparator class comparator class of ticket using category as the key
 *
 * @author	Helpdesk Tracker Team
 * @version	1.0
 * @since	2014-12-01
 */
public class TicketCategoryComparator  implements Comparator<Ticket>{

	@Override
	/**
	 * Method used to compare between 2 tickets.
	 * @param o1 contains object Ticket to compare
	 * @param o2 contains object Ticket to compare
	 * 
	 */
	public int compare(Ticket o1, Ticket o2) {
		// TODO Auto-generated method stub
		return Ticket.ServiceCatEnum.toInt(o1.getServiceCat()) - Ticket.ServiceCatEnum.toInt(o2.getServiceCat());
	}

}
