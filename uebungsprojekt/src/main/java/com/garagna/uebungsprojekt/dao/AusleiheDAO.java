package com.garagna.uebungsprojekt.dao;

import com.garagna.uebungsprojekt.types.Ausleihe;

public interface AusleiheDAO
{
	void insert(Ausleihe ausleihe);

	public boolean buchAusgeliehen(Integer buch_id);
}
