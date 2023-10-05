package com.garagna.uebungsprojekt.types;

public class Kunde
{
	private int nummer;

	private String Vorname;

	private String name;

	private double guthaben;

	public int getNummer()
	{
		return nummer;
	}

	public String getVorname()
	{
		return Vorname;
	}

	public void setVorname(String Vorname)
	{
		this.Vorname = Vorname;
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

	public void setGuthaben(double guthaben)
	{
		this.guthaben = guthaben;
	}

}
