<?xml version="1.0" encoding="UTF-8"?>
<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Welcome"></ui:head>
				<ui:body id="body1" style="background-color: black;">
					<ui:form id="form1">
						<ui:label for="textFieldBrief" id="labelBrief" text="Buchverleih Anwendung" style="font-size: 24px; color: white; text-align: center; display: block; width: 100%; margin-top: 40px; margin-bottom: 40px;"/>
						<ui:panelLayout id="layoutPanel" panelLayout="grid" style="text-align: center;">
							<ui:image id="imageBild" style="max-height: 800.0px; max-width: 1600.0px;" url="/images/pexels-ivo-rainha-1261180.jpg" />
						</ui:panelLayout>
						<ui:panelLayout id="layoutPanelButtons" panelLayout="flow" style="text-align: center;">
							<ui:button action="#{Welcome.buttonRegistrieren_action}" id="buttonRegistrieren" text="Registrieren" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-right: 20px; margin-top: 40px"/>
							<ui:button action="#{Welcome.buttonBuecherliste_action}" id="buttonBuecherliste" text="Bücherliste ansehen" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-right: 20px; margin-top: 40px"/>
							<ui:button action="#{Welcome.buttonAusleihen_action}" id="buttonAusleihen" text="Buch ausleihen" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-top: 40px"/>
						</ui:panelLayout>
					</ui:form>
				</ui:body>
			</ui:html>
		</ui:page>
	</f:view>
</jsp:root>



