package com.garagna.uebungsprojekt.web;

import com.garagna.uebungsprojekt.transaction.TransactionRegistrieren;
import com.garagna.uebungsprojekt.types.Kunde;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.rave.web.ui.component.TextField;

public class Registrieren extends AbstractPageBean
{
	private TextField textFieldBenutzernvoraname = new TextField();

	public TextField getTextFieldBenutzernvoraname()
	{
		return textFieldBenutzernvoraname;
	}

	public void setTextFieldBenutzernvoraname(TextField tf)
	{
		this.textFieldBenutzernvoraname = tf;
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

	private String errorMessage = "test";           // Für Meldungen und oder testing

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;  //  Meldungen für User
	}

	private TransactionRegistrieren transactionRegistrieren;

	public void setTransactionRegistrieren(TransactionRegistrieren transactionRegistrieren)
	{
		this.transactionRegistrieren = transactionRegistrieren;
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

	private TextField textFieldBenutzernummer = new TextField();

	public void setTextFieldBenutzernummer(TextField textFieldBenutzernummer)
	{
		this.textFieldBenutzernummer = textFieldBenutzernummer;
	}

	public TextField getTextFieldBenutzernummer()
	{
		return textFieldBenutzernummer;
	}

	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}

		// kundennummer fragen und autofüllen ? next available id.
		// this.textFieldBenutzernummer.setText(this.transactionRegistrieren.loadNextAvailableId());
	}

	public void buttonBestaetigung_action() // ist String als Rückgabewert korrekt?
	{

		String vorname = (String) this.textFieldBenutzernvoraname.getText();  // alles muss so gemacht werden
		String name = (String) this.textFieldBenutzernnachname.getText();
		Integer guthaben = (Integer) this.textFieldGuthaben.getText();

		Kunde kunde = new Kunde();

		kunde.setVorname(vorname);
		kunde.setName(name);
		kunde.setGuthaben(guthaben);

		// transaction Aufruf
		this.transactionRegistrieren.speichern(kunde);

		// Implement any validation logic here
		// SQL mit Kundendaten abfragen und ID abrufen
		// Redirect to a success page or perform other actions as needed
		// refresh page and display kundendaten registration with kundennummer and confirmation. after that kunde can go to Ausleihen page for instance....
		this.errorMessage = "registration_success";   // ??

	}

	public void buttonKundenLoeschen_action() // ist String als Rückgabewert korrekt?
	{
		Integer kundennummer = (Integer) this.textFieldKN.getText();

		// if kundendaten stimmen und kundennumemr existiert dann kann gelöscht werden ?? sinnvoll ?
		// transaction Aufruf
		this.transactionRegistrieren.loeschen(kundennummer);

		this.errorMessage = "kunde gelöscht";   // ??

	}

	public void buttonKundeSelect_action() // ist String als Rückgabewert korrekt?           // not complete
	{
		Integer kundennummer = (Integer) this.textFieldKN.getText();

		// transaction Aufruf
		// this.transactionRegistrieren.loeschen(kundennummer);
		this.errorMessage = "kunde gelöscht";   // ??

	}

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
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
}
