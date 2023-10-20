package com.garagna.uebungsprojekt.web;

import com.sun.rave.web.ui.appbase.AbstractPageBean;

public class Welcome extends AbstractPageBean      // https://docs.oracle.com/cd/E17824_01/dsc_docs/docs/jscreator/apis/jsfcl/com/sun/jsfcl/app/AbstractPageBean.html
{
	@Override
	public void prerender()
	{
		// Für RadioButton Eventuell ->  if (! isPostBack()){...}
	}

	public String buttonRegistrieren_action()
	{

		// Registrieren reg = (Registrieren) getBean("Registrieren");
		return "go_registrieren";
	}

	public String buttonBuecherliste_action()
	{
		return "go_buecherliste";   // navigation.xml anpassen
	}

	public String buttonAusleihen_action()
	{

		return "go_ausleihen";   // navigation.xml von syAbo anpassen
	}
}

// Button Methode Erklärung:  void wenn ich bleibe auf der Seite und String wenn ich navigieren auf neuer Seite -->  navigation.xml von syAbo anpassen
/**
 *
 *
 * Schritt zum Hinzufügen einer neuen Seite:
 *
 *
 *
 * 1) JAVA-Datei: Die Java-Datei benötigt eine Methode, um einen String wie oben zurückzugeben: „public String buttonAusleihen_action()“
 *
 * 2) JSP-SEITE: Die entsprechende JSP-Datei benötigt eine Elementbindung mit der Methode wie in diesem Beispiel:
 *
 * <ui:button action="#{Welcome.buttonAusleihen_action}" id="buttonAusleihen" text="Buch ausleihen"/>
 *
 * 3) In navigation.xml muss die Verbindung so registriert sein
 *
 * <navigation-rule>
 * <from-view-id>/Welcome.jsp</from-view-id>
 * <navigation-case>
 * <from-outcome>go_registrieren</from-outcome>
 * <to-view-id>/Registrieren.jsp</to-view-id>
 * </navigation-case>
 * </navigation-rule>
 *
 * 4) Die neue Seite benötigt eine Bean in der Datei „managed-beans.xml“.
 *
 * <managed-bean>
 * <managed-bean-name>Registrieren</managed-bean-name>
 * <managed-bean-class>com.garagna.uebungsprojekt.web.Registrieren</managed-bean-class>
 * <managed-bean-scope>request</managed-bean-scope>
 * </managed-bean>
 *
 *
 * Für die anderen Funktionalitäten benötigen wir ein Dao-Paket unter dem Root-Paket, damit wir mit der Modellierung unserer ersten Klasse beginnen können. In diesem Fall haben wir
 * mit KundeDAO.java als Interface begonnen und die Implementierung muss in einer Klasse namens KundeDAOImpl.java erfolgen
 *
 */
