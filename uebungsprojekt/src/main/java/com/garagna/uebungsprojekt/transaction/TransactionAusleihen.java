package com.garagna.uebungsprojekt.transaction;

import com.garagna.uebungsprojekt.dao.AusleiheDAO;
import com.garagna.uebungsprojekt.types.Ausleihe;

public class TransactionAusleihen
{
	private AusleiheDAO ausleiheDAO;

	public void setAusleiheDAO(AusleiheDAO ausleiheDAO)
	{
		this.ausleiheDAO = ausleiheDAO;
	}

	public void speichern(Ausleihe ausleihe)
	{
		if (ausleihe.getAusleihe_id() == null)
		{
			this.ausleiheDAO.insert(ausleihe);
		}
	}

	public boolean pruefeBuchSchonAusgeliehen(Integer id)
	{
		boolean buchAusgeliehen = this.ausleiheDAO.buchAusgeliehen(id);
		return buchAusgeliehen;
	}
}
