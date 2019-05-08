package com.dgs.sportClub;

import java.sql.SQLException;
import java.util.Date;

import com.dgs.sportClub.data.DataException;
import com.dgs.sportClub.domain.Reservation;

public interface AbstractReservationDAO {
	Iterable<Reservation> reservationByFieldAndTime(int fieldId,Date dateStart,Date dateEnd) 
			throws DataException;
	
}
