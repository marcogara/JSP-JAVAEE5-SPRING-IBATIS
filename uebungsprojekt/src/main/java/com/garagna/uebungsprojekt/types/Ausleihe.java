package com.garagna.uebungsprojekt.types;

import java.sql.Date;

public class Ausleihe
{
	private Integer ausleihe_id;

	private Buch buch;

	private Kunde kunde;

	private Date datum;

	public Integer getAusleihe_id()
	{
		return ausleihe_id;
	}

	public void setAusleihe_id(Integer ausleihe_id)
	{
		this.ausleihe_id = ausleihe_id;
	}

	public Buch getBuch()
	{
		return buch;
	}

	public void setBuch(Buch buch)
	{
		this.buch = buch;
	}

	public Kunde getKunde()
	{
		return kunde;
	}

	public void setKunde(Kunde kunde)
	{
		this.kunde = kunde;
	}

	public Date getDatum()
	{
		return datum;
	}

	public void setDatum(Date date)
	{
		this.datum = date;
	}
	// ... (other getter and setter methods)
}
