package com.garagna.uebungsprojekt.dao;

import com.garagna.uebungsprojekt.types.Kunde;

public interface KundeDAO
{
	void insert(Kunde kunde);

	int delete(Integer nummer);

	Kunde select(Integer nummer);

	// int askAvailableID(); //???
	Integer getNextAvailableId();

}
