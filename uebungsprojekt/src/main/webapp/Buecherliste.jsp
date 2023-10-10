<?xml version="1.0" encoding="UTF-8"?>

<jsp:root version="1.2" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:ui="http://www.sun.com/web/ui">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>

    <f:view>
		<ui:page id="page1">
            <ui:html id="html1">
                <ui:head id="head1" title="Buecherliste">

                </ui:head>

				<ui:body id="body1" style="background-color: grey;">
					<ui:form id="form1">

						<ui:label for="textFieldBrief" id="labelBrief" text=""/>

						<ui:panelLayout id="layoutPanelInput" panelLayout="flow" style="text-align: center; margin-bottom: 100px;">

							<h:panelGrid columnClasses="gridlabelfrei,griddata" columns="2" id="gridPanelLogin">


								<ui:listbox binding="#{Buecherliste.listboxBuecher}" converter="javax.faces.Integer" id="listboxTitel" rows="20" style="width: 1000px; font-family: monospace;"/>


							</h:panelGrid>

						</ui:panelLayout>


						<ui:panelLayout id="layoutPanelButtonsAuswahl" panelLayout="flow" style="text-align: center;">

							<ui:button action="#{Buecherliste.buttonHome_action}" id="buttonHome" text="Back Home" style="font-size: 18px; padding: 10px 20px 30px 30px; margin-right: 10px;"/>

						</ui:panelLayout>

					</ui:form>

				</ui:body>

			</ui:html>
		</ui:page>


	</f:view>

</jsp:root>