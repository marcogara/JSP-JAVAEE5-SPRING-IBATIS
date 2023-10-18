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

	public int pruefeBuchSchonAusgeliehen(Integer id)
	{
		Integer buchAusgeliehen = this.ausleiheDAO.pruefeBuch(id);
		return buchAusgeliehen != null && buchAusgeliehen > 0 ? 1 : 0;      // 0 is not ausgeliehen, 1 is already ausgeliehen
	}
}
