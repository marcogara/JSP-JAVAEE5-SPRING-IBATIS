package com.garagna.uebungsprojekt.types;

public class Kunde
{
	private Integer nummer;

	private String vorname;

	private String name;

	private int guthaben;

	public Integer getNummer()   // immer  mit ID Integer benutzen Andere Klassen überprüfen
	{
		return nummer;
	}

	public void setNummer(Integer nummer)
	{
		this.nummer = nummer;
	}

	public String getVorname()
	{
		return vorname;
	}

	public void setVorname(String vorname)
	{
		this.vorname = vorname;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public double getGuthaben()
	{
		return guthaben;
	}

	public void setGuthaben(int guthaben)
	{
		this.guthaben = guthaben;
	}
}
