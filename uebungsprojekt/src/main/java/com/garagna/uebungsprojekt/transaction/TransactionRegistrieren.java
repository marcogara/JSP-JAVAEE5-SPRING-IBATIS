package com.garagna.uebungsprojekt.transaction;

import com.garagna.uebungsprojekt.dao.KundeDAO;
import com.garagna.uebungsprojekt.types.Kunde;

public class TransactionRegistrieren
{
	private KundeDAO kundeDAO;

	public void setKundeDAO(KundeDAO kundeDAO)
	{
		this.kundeDAO = kundeDAO;
	}

	public void speichern(Kunde kunde)
	{
		if (kunde.getNummer() == null)
		{
			this.kundeDAO.insert(kunde);
		}
	}
}
