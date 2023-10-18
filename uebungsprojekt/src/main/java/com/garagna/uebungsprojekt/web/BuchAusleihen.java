package com.garagna.uebungsprojekt.web;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import java.util.Calendar;
import java.sql.Date;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.event.ValueChangeEvent;

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

	private TransactionAusleihen transactionAusleihen;

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

	/**
	 *
	 *
	 * private TextField textFieldBenutzernvorname = new TextField();
	 *
	 * public TextField getTextFieldBenutzernvorname() { return textFieldBenutzernvorname; }
	 *
	 * public void setTextFieldBenutzernvorname(TextField tf) { this.textFieldBenutzernvorname = tf; }
	 *
	 * private TextField textFieldBenutzernnachname = new TextField();
	 *
	 * public TextField getTextFieldBenutzernnachname() { return textFieldBenutzernnachname; }
	 *
	 * public void setTextFieldBenutzernnachname(TextField tf) { this.textFieldBenutzernnachname = tf; }
	 *
	 * private TextField textFieldGuthaben = new TextField();
	 *
	 * public TextField getTextFieldGuthaben() { return textFieldGuthaben; }
	 *
	 * public void setTextFieldGuthaben(TextField tf) { this.textFieldGuthaben = tf; }
	 *
	 * *
	 */
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
		//TODO: eventuell brauchen wir hier ein Validierung um den kunden daten name und nachname schön in datenbank sind weil
		// ein >Problem kann sein dass, wenn ich drücke auf select und den kunden daten schön da sind auf den textenfelder es solle unmöglich sein auf Bestätigen zu Drücken mit eien datensatz schön in datenbank

		Integer kundennummer = (Integer) this.textFieldBenutzernummer.getText();
		Integer buchId = (Integer) this.listboxBuecher.getSelected();

		// if ID is in database
		Kunde kunde = this.transactionRegistrieren.selectedKundeLaden(kundennummer);
		Buch buch = this.transactionBuecherliste.buecherlisteLaden().get(buchId);

		if (kunde != null) // und Buch verfügbar ist zb.
		// Prüfen, ob das Kundenobjekt nicht null ist
		//Wenn Der Kunde existiert, weitergehen mit Ausleihen transaction
		{
			ausleihe.setBuch(buch);
			ausleihe.setKunde(kunde);

			Date sqlDate = new Date(System.currentTimeMillis());
			ausleihe.setDatum(sqlDate);

			// this.errorMessage = "Kundennummer: " + kunde.getNummer() + " ausgewählt"; // Der Kunde wurde ausgewählt  // ??
			// transaction Aufruf
			this.transactionAusleihen.speichern(ausleihe);

			// Implement any validation logic here
			this.errorMessage = "Ausleihe erfolgreich.";
		}
		else
		{
			this.textFieldBenutzernummer.setText(null);
			// discard auch Buch Auswahlt von listBox falls Buch nicht voranden ist ??
			this.errorMessage = "Kundennummer: " + kundennummer + " nicht vorhanden!"; // Die Kundennummer existiert nicht
		}
	}

	public void buchlisteErzeugen()
	{
		Map<Integer, Buch> buchMap = this.transactionBuecherliste.buecherlisteLaden();
		List<Option> items = new LinkedList<Option>();
		String sp = this.SP;

		for (Buch buch : buchMap.values())
		{
			int idI = buch.getId(); // Assuming buch.getId() returns an int
			String idAsString = String.valueOf(idI);

			String id = TextUtils.rpad(idAsString, 6, sp);
			String titel = TextUtils.rpad(buch.getTitel(), 50, sp);
			String autor = TextUtils.rpad(buch.getAutor(), 38, sp);
			String genre = TextUtils.rpad(buch.getGenre(), 18, sp);
			String year = TextUtils.rpad(buch.getErscheinungsjahr(), 12, sp);
			String velagName = TextUtils.rpad(buch.getVerlag().getName(), 60, sp);
			String isbn;
			isbn = TextUtils.rpad(buch.getIsbn(), 20, sp);

			String anzeige = id + titel + autor + genre + year + velagName + isbn;

			items.add(new Option(buch.getId(), anzeige));
		}
		this.listboxBuecher.setItems(items);
	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

}
