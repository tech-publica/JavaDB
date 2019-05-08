package com.dgs.sportClub.domain;

import java.util.Date;

public class Reservation {
	private int idPrenotazione,idPersona,idCampo;
	private Date dataPrenotazione;
	private String note;
	private boolean lezione;
	
	public Reservation(int idPrenotazione, int idPersona, int idCampo, Date dataPrenotazione, String note,
			boolean lezione) {
		this.idPrenotazione = idPrenotazione;
		this.idPersona = idPersona;
		this.idCampo = idCampo;
		this.dataPrenotazione = dataPrenotazione;
		this.note = note;
		this.lezione = lezione;
	}
	
	public int getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(int idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public int getIdCampo() {
		return idCampo;
	}
	public void setIdCampo(int idCampo) {
		this.idCampo = idCampo;
	}
	public Date getDataPrenotazione() {
		return dataPrenotazione;
	}
	public void setDataPrenotazione(Date dataPrenotazione) {
		this.dataPrenotazione = dataPrenotazione;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isLezione() {
		return lezione;
	}
	public void setLezione(boolean lezione) {
		this.lezione = lezione;
	}
	
	
	
}
