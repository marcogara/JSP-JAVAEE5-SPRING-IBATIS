package com.garagna.uebungsprojekt.types;

public class Buch
{
	private int id;

	private String titel;

	private String autor;

	private String genre;

	private String erscheinungsjahr;

	private String isbn;

	private Verlag verlag;

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

	public String getIsbn()
	{
		return isbn;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public Verlag getVerlag()
	{
		return verlag;
	}

	public void setVerlag(Verlag verlag)
	{
		this.verlag = verlag;
	}

}
