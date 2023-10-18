package com.garagna.uebungsprojekt.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.sql.Date;

import com.garagna.uebungsprojekt.business.TextUtils;
import com.garagna.uebungsprojekt.transaction.TransactionAusleihen;
import com.garagna.uebungsprojekt.transaction.TransactionBuecherliste;
import com.garagna.uebungsprojekt.transaction.TransactionRegistrieren;
import com.garagna.uebungsprojekt.types.Ausleihe;
import com.garagna.uebungsprojekt.types.Buch;
import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;

import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.Listbox;
import com.sun.rave.web.ui.component.TextField;
import com.sun.rave.web.ui.model.Option;

public class BuchAusleihen extends AbstractPageBean
{
	private final String SP = "\u00A0";

	private TransactionAusleihen transactionAusleihen;			// das sollte die einzige Trasaction verantwortlich für alle in diesen Klassen

	public void setTransactionAusleihen(TransactionAusleihen transactionAusleihen)
	{
		this.transactionAusleihen = transactionAusleihen;
	}

	private TransactionBuecherliste transactionBuecherliste;

	public void setTransactionBuecherliste(TransactionBuecherliste transactionBuecherliste)
	{
		this.transactionBuecherliste = transactionBuecherliste;
	}

	private TransactionRegistrieren transactionRegistrieren;

	public void setTransactionRegistrieren(TransactionRegistrieren transactionRegistrieren)
	{
		this.transactionRegistrieren = transactionRegistrieren;
	}

	private Listbox listboxBuecher = new Listbox();

	public Listbox getListboxBuecher()
	{
		return listboxBuecher;
	}

	public void setListboxBuecher(Listbox l)
	{
		this.listboxBuecher = l;
	}

	private TextField textFieldBenutzernummer = new TextField();

	public void setTextFieldBenutzernummer(TextField textFieldBenutzernummer)
	{
		this.textFieldBenutzernummer = textFieldBenutzernummer;
	}

	public TextField getTextFieldBenutzernummer()
	{
		return textFieldBenutzernummer;
	}

	private Form form = new Form();

	public Form getForm()
	{
		return this.form;
	}

	public void setForm(Form f)
	{
		this.form = f;
	}

	private String errorMessage = " ";           // Für Meldungen und oder testing

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;  //  Meldungen für User
	}

	@Override
	public void prerender()
	{
		// prerender sorgt dafür, dass die Daten am Anfang der Seite angezeigt werden.
		buchlisteErzeugen();
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	public void buttonBestaetigung_action()
	{
		Ausleihe ausleihe = new Ausleihe();

		Integer kundennummer = (Integer) this.textFieldBenutzernummer.getText();
		Integer buchId = (Integer) this.listboxBuecher.getSelected();

		Kunde kunde = this.transactionRegistrieren.selectedKundeLaden(kundennummer);
		Buch buch = this.transactionBuecherliste.buecherlisteLaden().get(buchId);
		boolean buchAusgelihen = this.transactionAusleihen.pruefeBuchSchonAusgeliehen(buchId); // Prüft ob buchId ist ins Datenbank (tabelle ausleihe)

		if (kunde == null)
		{
			this.textFieldBenutzernummer.setText(null);
			this.errorMessage = "Kundennummer: " + kundennummer + " nicht vorhanden!"; // Kundennummer existiert nicht
			return;
		}

		if (buchAusgelihen) // falls Id ist ins Datenbank (tabelle ausleihe)
		{
			this.errorMessage = "Buch mit ID: " + buchId + " ist bereits ausgeliehen!";
			return;
		}

		ausleihe.setBuch(buch);
		ausleihe.setKunde(kunde);

		Date sqlDate = new Date(System.currentTimeMillis());
		ausleihe.setDatum(sqlDate);

		// transaction Aufruf
		this.transactionAusleihen.speichern(ausleihe);
		this.errorMessage = "Ausleihe erfolgreich.";
	}

	public void buchlisteErzeugen()
	{
		Map<Integer, Buch> buchMap = this.transactionBuecherliste.buecherlisteLaden();
		List<Option> items = new LinkedList<Option>();
		String sp = this.SP;

		for (Buch buch : buchMap.values())
		{
			String id = TextUtils.rpad(String.valueOf(buch.getId()), 5, sp);
			String titel = TextUtils.rpad(buch.getTitel(), 49, sp);
			String autor = TextUtils.rpad(buch.getAutor(), 37, sp);
			String genre = TextUtils.rpad(buch.getGenre(), 17, sp);
			String year = TextUtils.rpad(buch.getErscheinungsjahr(), 11, sp);
			String velagName = TextUtils.rpad(buch.getVerlag().getName(), 59, sp);
			String isbn = TextUtils.rpad(buch.getIsbn(), 19, sp);

			boolean buchAusgelihen = this.transactionAusleihen.pruefeBuchSchonAusgeliehen(buch.getId()); // Prüft ob buchId ist ins Datenbank (tabelle ausleihe)
			String buchFlag = "";
			// if Buch in der tabelle ist flag hinzufügen sonst nicht
			if (buchAusgelihen)
			{
				buchFlag = "X";
			}

			String anzeige = id + sp + titel + sp + autor + sp + genre + sp + year + sp + velagName + sp + isbn + sp + buchFlag;

			items.add(new Option(buch.getId(), anzeige));
		}
		this.listboxBuecher.setItems(items);
	}

	public String buttonHome_action()
	{
		return "go_welcome";
	}
}
