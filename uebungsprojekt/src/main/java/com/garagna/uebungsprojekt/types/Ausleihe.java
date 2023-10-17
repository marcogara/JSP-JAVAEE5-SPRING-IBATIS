package com.garagna.uebungsprojekt.types;

import java.sql.Date;

public class Ausleihe
{
	private Integer id;

	private Buch buch;

	private Kunde kunde;

	private Date date;

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
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

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
}
