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

	public boolean loeschen(Integer id)
	{
		boolean ok = true;
		try
		{
			this.kundeDAO.delete(id);
		}
		catch (Exception e)
		{
			ok = false;
		}
		return ok;
	}

	public Integer loadNextAvailableId()
	{
		Integer id = this.kundeDAO.getNextAvailableId();
		return id;
	}

	public Kunde selectedKundeLaden(Integer id)
	{
		Kunde kunde = this.kundeDAO.select(id);
		return kunde;
	}
}
