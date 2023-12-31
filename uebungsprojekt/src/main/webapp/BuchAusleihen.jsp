<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Ausleihen"><ui:link id="link1" url="/resources/stylesheet.css"/></ui:head>
				<ui:body id="body1" style="background-color: grey;">
					<ui:form binding="#{BuchAusleihen.form}" id="form" virtualFormsConfig="
						home
							|
							| layoutPanelButtonsAuswahl:buttonHome,
						ausleihenBestaetigen
							| layoutPanelInput:gridPanelKundendaten:textFieldBenutzernummer
							layoutPanelList:gridPanelList:listboxTitel
							| layoutPanelButtonsAuswahl:buttonBestaetigung,">
						<ui:label for="textFieldBrief" id="labelBrief" text=""/>
						<ui:panelLayout id="layoutPanelInput" panelLayout="flow" style="text-align: center; margin-bottom: 100px;">
							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="2" id="gridPanelKundendaten">
								<ui:label for="textFieldBenutzernummer" id="labelBenutzernummer" text="Kunden-Nr." requiredIndicator="true" style="font-size: 30px; margin-top:25px;"/>
								<ui:textField binding="#{BuchAusleihen.textFieldBenutzernummer}" converter="javax.faces.Integer" id="textFieldBenutzernummer" required="true" style="font-size: 24px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>
							</h:panelGrid>
						</ui:panelLayout>
						<h:outputLabel for="listboxTitel" value="ID" style="font-size: 24px; padding: 4px; text-align:left;"/>
						<h:outputLabel for="listboxTitel" value="TITEL" style="font-size: 24px; padding: 4px 10px 30px; margin-right: 290px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="AUTOR" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 160px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="GENRE" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 20px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="JAHR" style="font-size: 24px; padding: 20px 10px 10px; margin-right: 8px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="VERLAG" style="font-size: 24px; padding: 10px; margin-right: 330px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="ISBN" style="font-size: 24px; padding: 10px 20px 30px; margin-right: 50px; text-align:center;"/>
						<h:outputLabel for="listboxTitel" value="ausgeliehen " style="font-size: 24px; padding: 10px 20px 30px; margin-right: 10px; text-align:center;"/>
						<ui:panelLayout id="layoutPanelList" panelLayout="flow" style="text-align: center; margin-bottom: 50px;">
							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="5" id="gridPanelList">
								<ui:listbox binding="#{BuchAusleihen.listboxBuecher}" converter="javax.faces.Integer" id="listboxTitel" required="true"
									rows="20" style="width: 1700px; font-family: monospace; font-size: 14px"  styleClass="black-listbox"/>
							</h:panelGrid>
						</ui:panelLayout>
						<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="text-align: left; margin-bottom: 50px; margin-left: 50px;">
							<ui:button action="#{BuchAusleihen.buttonHome_action}" id="buttonHome" text="Back Home" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 30px;"/>
							<ui:button action="#{BuchAusleihen.buttonBestaetigung_action}" id="buttonBestaetigung" text="Bestätigen" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-right: 30px;"/>
						</ui:panelLayout>
						<h:outputText value="#{BuchAusleihen.errorMessage}" style="font-size: 18px; padding: 10px 20px 30px 10px; margin-top: 50px; margin-right: 120px;"/>
					</ui:form>
				</ui:body>
			</ui:html>
		</ui:page>
	</f:view>
</jsp:root>