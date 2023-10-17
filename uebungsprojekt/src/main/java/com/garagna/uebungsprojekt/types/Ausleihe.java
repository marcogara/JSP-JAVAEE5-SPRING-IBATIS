package com.garagna.uebungsprojekt.types;

import java.sql.Date;

public class Ausleihe
{
	private Integer ausleihe_id;

	private Integer buch_id; // Add this property

	private Integer kunde_nummer; // Add this property

	private Date datum;

	public Integer getAusleihe_id()
	{
		return ausleihe_id;
	}

	public void setAusleihe_id(Integer ausleihe_id)
	{
		this.ausleihe_id = ausleihe_id;
	}

	// Getter and setter methods for buch_id and kunde_nummer
	public Integer getBuch_id()
	{
		return buch_id;
	}

	public void setBuch_id(Integer buch_id)
	{
		this.buch_id = buch_id;
	}

	public Integer getKunde_nummer()
	{
		return kunde_nummer;
	}

	public void setKunde_nummer(Integer kunde_nummer)
	{
		this.kunde_nummer = kunde_nummer;
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
