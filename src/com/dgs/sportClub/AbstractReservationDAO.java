package com.dgs.sportClub;

import java.sql.SQLException;
import java.time.LocalDateTime;

import com.dgs.sportClub.data.DataException;
import com.dgs.sportClub.domain.Reservation;

public interface AbstractReservationDAO {
	Iterable<Reservation> reservationByFieldAndTime(int fieldId,LocalDateTime dateStart,LocalDateTime dateEnd) 
			throws DataException;
	
}
