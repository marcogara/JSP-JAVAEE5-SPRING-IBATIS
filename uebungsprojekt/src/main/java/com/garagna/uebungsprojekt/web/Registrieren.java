package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.transaction.TransactionRegistrieren;
import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.Form;
import com.sun.rave.web.ui.component.TextField;

public class Registrieren extends AbstractPageBean
{
	private TransactionRegistrieren transactionRegistrieren;

	public void setTransactionRegistrieren(TransactionRegistrieren transactionRegistrieren)
	{
		this.transactionRegistrieren = transactionRegistrieren;
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

	private TextField textFieldBenutzernummer = new TextField();

	public void setTextFieldBenutzernummer(TextField textFieldBenutzernummer)
	{
		this.textFieldBenutzernummer = textFieldBenutzernummer;
	}

	public TextField getTextFieldBenutzernummer()
	{
		return textFieldBenutzernummer;
	}

	private TextField textFieldBenutzernvorname = new TextField();

	public TextField getTextFieldBenutzernvorname()
	{
		return textFieldBenutzernvorname;
	}

	public void setTextFieldBenutzernvorname(TextField tf)
	{
		this.textFieldBenutzernvorname = tf;
	}

	private TextField textFieldBenutzernnachname = new TextField();

	public TextField getTextFieldBenutzernnachname()
	{
		return textFieldBenutzernnachname;
	}

	public void setTextFieldBenutzernnachname(TextField tf)
	{
		this.textFieldBenutzernnachname = tf;
	}

	private TextField textFieldGuthaben = new TextField();

	public TextField getTextFieldGuthaben()
	{
		return textFieldGuthaben;
	}

	public void setTextFieldGuthaben(TextField tf)
	{
		this.textFieldGuthaben = tf;
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

	private TextField textFieldKN = new TextField();

	public TextField getTextFieldKN()
	{
		return textFieldKN;
	}

	public void setTextFieldKN(TextField textFieldKN)
	{
		this.textFieldKN = textFieldKN;
	}

	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}

		// kundennummer fragen und autofüllen ? next available id.
		// this.textFieldBenutzernummer.setText(this.transactionRegistrieren.loadNextAvailableId());
	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

	public void buttonBestaetigung_action() // ist String als Rückgabewert korrekt?
	{
		//TODO: eventuell brauchen wir hier ein Validierung um den kunden daten name und nachname schön in datenbank sind weil
		// ein >Problem kann sein dass, wenn ich drücke auf select und den kunden daten schön da sind auf den textenfelder es solle unmöglich sein auf Bestätigen zu Drücken mit eien datensatz schön in datenbank

		String vorname = (String) this.textFieldBenutzernvorname.getText();  // alles muss so gemacht werden
		String name = (String) this.textFieldBenutzernnachname.getText();
		Integer guthaben = (Integer) this.textFieldGuthaben.getText();

		Kunde kunde = new Kunde();

		kunde.setVorname(vorname);
		kunde.setName(name);
		kunde.setGuthaben(guthaben);

		// transaction Aufruf
		this.transactionRegistrieren.speichern(kunde);

		// Implement any validation logic here
		// Erst nach dem Aufruf der Funktion „Speichern“ verfügt „Kunde“ über eine ID, die abgefragt werden kann, da die SQL-Abfrage die ID (Nummer) aus der Datenbank zurückgibt, in der sich die Abfrage in „Kunde.xml“ befindet
		int id = kunde.getNummer();
		this.textFieldBenutzernummer.setText(id);
		this.form.discardSubmittedValue(this.textFieldBenutzernummer);

		// Redirect to a success page or perform other actions as needed
		// refresh page and display kundendaten registration with kundennummer and confirmation. after that kunde can go to Ausleihen page for instance....
		this.errorMessage = "Registrierung erfolgreich. Sie sind Kundennummer: " + id;   // ??
	}

	public void buttonKundenLoeschen_action() // ist String als Rückgabewert korrekt?
	{
		Integer kundennummer = (Integer) this.textFieldKN.getText();

		// TODO: if kundendaten stimmen und kundennumemr existiert dann kann gelöscht werden ?? sinnvoll ?
		// transaction Aufruf
		this.transactionRegistrieren.loeschen(kundennummer);

		this.form.discardSubmittedValues("registrieren");
		//TODO: Überprüfen, ob der Kunde gelöscht werden kann, beispielsweise aufgrund eines positiven
		// oder Nullsaldo und keiner offenen Ausleihbücher. Dies kann nach Implementierung der Verleihfunktion(Klassen und modellierung) getan werden.

		alleFelderLoeschen();
		this.errorMessage = "kunde gelöscht";
	}

	public void buttonKundeSelect_action()
	{
		Integer kundennummer = (Integer) this.textFieldKN.getText();
		Kunde kunde = this.transactionRegistrieren.selectedKundeLaden(kundennummer);

		if (kunde != null)
		// Prüfen, ob das Kundenobjekt nicht null ist
		//Wenn Der Kunde existiert, setze seine Werte
		{
			this.form.discardSubmittedValues("registrieren");
			kundendatenAusfüllen(kunde);
			this.errorMessage = "Kundennummer: " + kunde.getNummer() + " ausgewählt"; // Der Kunde wurde ausgewählt  // ??
		}
		else
		{
			this.form.discardSubmittedValues("registrieren");
			alleFelderLoeschen();
			this.errorMessage = "Kundennummer: " + kundennummer + " nicht vorhanden"; // Die Kundennummer existiert nicht
		}
	}

	private void kundendatenAusfüllen(Kunde kunde)
	{
		this.textFieldBenutzernvorname.setText(kunde.getVorname());
		this.textFieldBenutzernnachname.setText(kunde.getName());
		this.textFieldGuthaben.setText(kunde.getGuthaben());
		this.textFieldBenutzernummer.setText(kunde.getNummer());
		this.form.discardSubmittedValue(this.textFieldBenutzernummer);
		this.textFieldKN.setText(null);
	}

	private void alleFelderLoeschen()
	{
		this.textFieldBenutzernvorname.setText(null);
		this.textFieldBenutzernnachname.setText(null);
		this.textFieldGuthaben.setText(null);
		this.textFieldBenutzernummer.setText(null);
		this.form.discardSubmittedValue(this.textFieldBenutzernummer);
		this.textFieldKN.setText(null);
	}
}

// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
/**
 * step to add a new entity in the app to do all the other operation (to save in the database)
 *
 * Transaction class
 *
 * transaction.xml needs to have the correct bean (Trasnsaction class)
 *
 * DAO interface
 *
 * DAOImpl class
 *
 * add bean in ibatisdao.xml
 *
 * faces-config file has to be present
 *
 * sqlmap-config.xml
 *
 * needs to have the entity as exemple below show
 *
 * <typeAlias alias="Buch" type="com.garagna.uebungsprojekt.types.Buch"/>
 * <typeAlias alias="Kunde" type="com.garagna.uebungsprojekt.types.Kunde"/>
 *
 * <sqlMap resource="com/garagna/uebungsprojekt/sqlmap/buch.xml"/>
 * <sqlMap resource="com/garagna/uebungsprojekt/sqlmap/kunde.xml"/>
 *
 *
 */
