package com.garagna.uebungsprojekt.types;

import java.util.ArrayList;
import java.util.List;

public class Kunde
{
	private int nummer;

	private String Vorname;

	private String name;

	private int guthaben;

	private static List<Kunde> registeredCustomers = new ArrayList<>();

	public static List<Kunde> getRegisteredCustomers()
	{
		return registeredCustomers;
	}

	public static void addRegisteredCustomers(Kunde kunde)
	{
		registeredCustomers.add(kunde);
	}

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

	public void setGuthaben(int guthaben)
	{
		this.guthaben = guthaben;
	}

}
