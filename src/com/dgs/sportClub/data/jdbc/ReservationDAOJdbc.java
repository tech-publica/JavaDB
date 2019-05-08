package com.dgs.sportClub.data.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.dgs.sportClub.AbstractReservationDAO;
import com.dgs.sportClub.data.DataException;
import com.dgs.sportClub.domain.Reservation;


public class ReservationDAOJdbc implements AbstractReservationDAO {
	
	private Connection conn;
	public static final String QUERY_RESERVATION_BYFIELD_BYTIME = "select Prenotazione.IdPrenotazione,NomeCampo,DataPrenotazione,NotePrenotazione,LezionePrenotazione, Prenotazione.IdPersona, Prenotazione.IdCampo from Prenotazione join Campo on Prenotazione.IdCampo = Campo.IdCampo where DataPrenotazione >= ? and  DataPrenotazione<= ? and Campo.IdCampo= ?";
	
	public ReservationDAOJdbc(Connection conn)
	{
		this.conn=conn;
	}
	
	public Iterable<Reservation> reservationByFieldAndTime(int fieldId, Date dateStart, Date dateEnd) throws DataException {
		
	//	try (Statement st=conn.createStatement()) {
		try (PreparedStatement pst = conn.prepareStatement(QUERY_RESERVATION_BYFIELD_BYTIME)) {
			
			java.sql.Date ds=new java.sql.Date(dateStart.getTime());
			pst.setDate(1, ds);
			
			java.sql.Date de=new java.sql.Date(dateEnd.getTime());
			pst.setDate(2, de);
			
			pst.setInt(3, fieldId);
			
			try(ResultSet rs = pst.executeQuery()) {
				List <Reservation> reservations = new ArrayList <> ();
				while(rs.next()) {
					reservations.add(new Reservation (rs.getInt("IdPrenotazione"),
							rs.getInt("IdPersona"),
							rs.getInt("IdCampo"),
							rs.getDate("DataPrenotazione"),
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
