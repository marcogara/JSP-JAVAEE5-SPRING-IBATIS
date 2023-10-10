<?xml version="1.0" encoding="UTF-8"?>

<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>

    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Registrieren"></ui:head>
				<ui:body id="body1" style="background-color: grey;">
					<ui:form id="form1">

						<ui:label for="textFieldBrief" id="labelBrief" text=""/>

						<ui:panelLayout id="layoutPanelInput" panelLayout="flow" style="text-align: center; margin-bottom: 100px;">

								<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="2" id="gridPanelLogin">

									<ui:label for="textFieldBenutzernvoraname" id="labelBenutzervorname" text="Vorname" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
									<ui:textField binding="#{Registrieren.textFieldBenutzernvoraname}" id="textFieldBenutzernvoraname" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>

									<ui:label for="textFieldBenutzernnachname" id="labelBenutzernnachname" text="Nachname" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
									<ui:textField binding="#{Registrieren.textFieldBenutzernnachname}" id="textFieldBenutzernnachname" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>

									<ui:label for="textFieldGuthaben" id="labelGuthaben" text="Guthaben" requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
									<ui:textField binding="#{Registrieren.textFieldGuthaben}" converter="javax.faces.Integer" id="textFieldGuthaben" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>

								</h:panelGrid>

						</ui:panelLayout>

						<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="text-align: center;">

							<ui:button action="#{Registrieren.buttonHome_action()}" id="buttonHome" text="Back Home" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 10px;"/>
							<ui:button action="#{Registrieren.buttonBestaetigung_action()}" id="buttonBestaetigung" text="Bestätigen" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 10px;"/>
							<ui:button action="#{Registrieren.buttonKundenLoeschen_action()}" id="buttonKundenloeschen" text="Löschen" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 10px;"/>
							<ui:button action="#{Registrieren.buttonKundeSelect_action()}" id="buttonKundeSelect" text="Select" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 10px;"/>

								<ui:label for="textFieldKN" id="labelKN" text="kundennummer" requiredIndicator="true" style="font-size: 18px; margin-top:25px;"/>
								<ui:textField binding="#{Registrieren.textFieldKN}" converter="javax.faces.Integer" id="textFieldKN" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
						</ui:panelLayout>

							<h:outputText value="#{Registrieren.errorMessage}" />

					</ui:form>
				</ui:body>
			</ui:html>
		</ui:page>
	</f:view>
</jsp:root>