package com.dgs.sportClub.data.jdbc;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.dgs.sportClub.AbstractReservationDAO;
import com.dgs.sportClub.data.DataException;
import com.dgs.sportClub.domain.Reservation;


public class ReservationDAOJdbc implements AbstractReservationDAO {
	
	private Connection conn;
	public static final String QUERY_RESERVATION_BYFIELD_BYTIME = "select Prenotazione.IdPrenotazione,NomeCampo, DataInizio, DataFine, NotePrenotazione,LezionePrenotazione, Prenotazione.IdPersona, Prenotazione.IdCampo from Prenotazione join Campo on Prenotazione.IdCampo = Campo.IdCampo " +
	                       " where  Campo.IdCampo= ? " +
	                       " and ( ( DataInizio >= ? and DataInizio < ? ) or  (DataFine > ? and DataFine <= ?) )";
	
	public ReservationDAOJdbc(Connection conn)
	{
		this.conn=conn;
	}
	
	public Iterable<Reservation> reservationByFieldAndTime(int fieldId, LocalDateTime dateStart, LocalDateTime dateEnd) throws DataException {
		
	//	try (Statement st=conn.createStatement()) {
		try (PreparedStatement pst = conn.prepareStatement(QUERY_RESERVATION_BYFIELD_BYTIME)) {
			
			pst.setInt(1,  fieldId);
			
			java.sql.Timestamp ds=java.sql.Timestamp.valueOf(dateStart);
			java.sql.Timestamp de=java.sql.Timestamp.valueOf(dateEnd);
			
			
			pst.setTimestamp(2, ds);
			pst.setTimestamp(3, de);
			
			pst.setTimestamp(4, ds);
			pst.setTimestamp(5, de);
			
			try(ResultSet rs = pst.executeQuery()) {
				List <Reservation> reservations = new ArrayList <> ();
				while(rs.next()) {
					reservations.add(new Reservation (rs.getInt("IdPrenotazione"),
							rs.getInt("IdPersona"),
							rs.getInt("IdCampo"),
							rs.getObject("DataInizio", LocalDateTime.class),
							rs.getObject("DataFine", LocalDateTime.class),
							rs.getString("NotePrenotazione"),
							rs.getBoolean("LezionePrenotazione")));
				}
				return reservations;
				
			}
			

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataException(e.getMessage(), e);
			
		}
	}

}
