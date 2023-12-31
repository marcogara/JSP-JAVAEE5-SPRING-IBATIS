<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Registrieren"></ui:head>
				<ui:body id="body1" style="background-color: grey;">
					<ui:form binding="#{Registrieren.form}" id="form" virtualFormsConfig="
						home
							|
							| layoutPanelButtonsAuswahl:buttonHome,
						registrieren
							| layoutPanelInput:gridPanelLogin:textFieldBenutzernvorname
							layoutPanelInput:gridPanelLogin:textFieldBenutzernnachname
							layoutPanelInput:gridPanelLogin:textFieldGuthaben
							| layoutPanelButtonsAuswahl:buttonBestaetigung,
						loechenSelect
							| layoutPanelButtonsAuswahl:textFieldKN
							| layoutPanelButtonsAuswahl:buttonKundenloeschen
							layoutPanelButtonsAuswahl:buttonKundeSelect,">
						<ui:label for="textFieldBrief" id="labelBrief" text=""/>
						<ui:panelLayout id="layoutPanelInput" panelLayout="flow" style="text-align: center; margin-bottom: 100px;">
							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="2" id="gridPanelLogin">
								<ui:label for="textFieldBenutzernummer" id="labelBenutzernummer" text="Kunden-Nr." style="font-size: 30px; margin-top:25px;"/>
								<ui:textField binding="#{Registrieren.textFieldBenutzernummer}" id="textFieldBenutzernummer" disabled="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
								<ui:label for="textFieldBenutzernvorname" id="labelBenutzervorname" text="Vorname" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
								<ui:textField binding="#{Registrieren.textFieldBenutzernvorname}" id="textFieldBenutzernvorname" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
								<ui:label for="textFieldBenutzernnachname" id="labelBenutzernnachname" text="Nachname" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
								<ui:textField binding="#{Registrieren.textFieldBenutzernnachname}" id="textFieldBenutzernnachname" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
								<ui:label for="textFieldGuthaben" id="labelGuthaben" text="Guthaben" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
								<ui:textField binding="#{Registrieren.textFieldGuthaben}" converter="javax.faces.Integer" id="textFieldGuthaben" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
							</h:panelGrid>
						</ui:panelLayout>
						<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="text-align: left; margin-bottom: 50px; margin-left: 50px;">
							<ui:button action="#{Registrieren.buttonHome_action}" id="buttonHome" text="Back Home" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 30px;"/>
							<ui:button action="#{Registrieren.buttonBestaetigung_action}" id="buttonBestaetigung" text="Bestätigen" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 30px;"/>
							<ui:button action="#{Registrieren.buttonKundenLoeschen_action}" id="buttonKundenloeschen" text="Löschen" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 30px;"/>
							<ui:button action="#{Registrieren.buttonKundeSelect_action}" id="buttonKundeSelect" text="Select" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 10px;"/>
							<ui:label for="textFieldKN" id="labelKN" text="kundennummer" requiredIndicator="true" style="font-size: 18px; margin-top:25px;"/>
							<ui:textField binding="#{Registrieren.textFieldKN}" converter="javax.faces.Integer" id="textFieldKN" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
						</ui:panelLayout>
						<h:outputText value="#{Registrieren.errorMessage}" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-top: 50px; margin-right: 120px;"/>
					</ui:form>
				</ui:body>
			</ui:html>
		</ui:page>
	</f:view>
</jsp:root>

<!--virtualForm Info -->
<!--Zeile 10. Home Section: Wenn die SchaltflächeHome gedrückt wird, kümmert sich die Seite dank dieses Codes nicht darum, ob die Felder ausgefüllt sind oder nicht -->
<!-- Dient zur Rückkehr zur Startseite ohne Probleme -->
<!-- Zeile 13. „Registrieren-Abschnitt“: dieser Abschnitt bezieht sich auf den Registrierungsprozess. -->
<!-- Hier sind die Eingabefelder für die Benutzerregistrierung wie Name und Guthaben enthalten. -->
<!-- Zeile 18. Löschen und Auswahl Section: Stellen Sie klar, dass es in diesem Abschnitt um das Löschen und Auswählen von Kundendaten geht -->
