package com.dgs.sportClub.domain;

import java.time.LocalDateTime;
import java.util.Date;

public class Reservation {
	private int idPrenotazione,idPersona,idCampo;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	private String note;
	private boolean lezione;
	
	public Reservation(int idPrenotazione, int idPersona, int idCampo, LocalDateTime dataInizio, LocalDateTime dataFine, String note,
			boolean lezione) {
		this.idPrenotazione = idPrenotazione;
		this.idPersona = idPersona;
		this.idCampo = idCampo;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.note = note;
		this.lezione = lezione;
	}
	
	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
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
