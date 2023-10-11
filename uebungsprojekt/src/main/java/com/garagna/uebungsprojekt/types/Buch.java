package com.garagna.uebungsprojekt.types;

public class Buch
{

	private int id;

	private String titel;

	private String autor;

	private String genre;

	private String erscheinungsjahr;

	private int verlag_id;   // to change later with FK from Verlag class

	private String isbn;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getTitel()
	{
		return titel;
	}

	public void setTitel(String titel)
	{
		this.titel = titel;
	}

	public String getAutor()
	{
		return autor;
	}

	public void setAutor(String autor)
	{
		this.autor = autor;
	}

	public String getGenre()
	{
		return genre;
	}

	public void setGenre(String genre)
	{
		this.genre = genre;
	}

	public String getErscheinungsjahr()
	{
		return erscheinungsjahr;
	}

	public void setErscheinungsjahr(String erscheinungsjahr)
	{
		this.erscheinungsjahr = erscheinungsjahr;
	}

	public int getVerlag_id()
	{
		return verlag_id;
	}

	public void setVerlag_id(int verlag_id)
	{
		this.verlag_id = verlag_id;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

}
