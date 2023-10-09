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

	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
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

	public String buttonHome_action()
	{
		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_welcome";
	}

	// void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
}
