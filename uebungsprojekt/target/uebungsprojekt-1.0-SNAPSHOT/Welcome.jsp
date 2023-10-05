<?xml version="1.0" encoding="UTF-8"?>

<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>

    <f:view>
		 <ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Hallo">

                </ui:head>

				        <ui:body id="body1">

							<ui:label for="textFieldBrief" id="labelBrief" text=""/>

							<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="height: 36px;">

												<ui:button action="#{Welcome.buttonRegistrieren_action}" id="buttonRegistrieren" text="Registrieren"/>
												<ui:button action="#{Welcome.buttonBuecherliste_action}" id="buttonBuecherliste" text="Bücherliste ansehen"/>
												<ui:button action="#{Welcome.buttonAusleihen_action}" id="buttonAusleihen" text="Buch ausleihen"/>
							</ui:panelLayout>

						</ui:body>

			</ui:html>
		</ui:page>


	</f:view>

</jsp:root>



