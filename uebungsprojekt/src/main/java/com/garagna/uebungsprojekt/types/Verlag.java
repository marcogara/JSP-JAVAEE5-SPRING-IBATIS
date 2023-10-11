package com.garagna.uebungsprojekt.types;

public class Verlag
{
	private int id;

	private String name;

	private String sitz;

	private int gruendungsjahr;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getSitz()
	{
		return sitz;
	}

	public void setSitz(String sitz)
	{
		this.sitz = sitz;
	}

	public int getGruendungsjahr()
	{
		return gruendungsjahr;
	}

	public void setGruendungsjahr(int gruendungsjahr)
	{
		this.gruendungsjahr = gruendungsjahr;
	}

}
