<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="t" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<style>
.brand{
	font-size:16px;
	font-weight: 600;
}
</style>
<div class="brand"><s:message code="left.menu.title" /></div>
    <i class="fa fa-bars fa-2x toggle-btn" data-toggle="collapse" data-target="#menu-content"></i>

    <div class="menu-list">
        
        <ul id="menu-content" class="menu-content out" >
            <security:authorize access="hasRole('CLIENT')">
            <li id='<s:message code="left.menu.home.id" />'>
              <a href='<c:url value="/client/home"/>'>
              <i class="fa fa-home fa-lg"></i><s:message code="left.menu.home.title" />
              </a>
            </li>

            <li  data-toggle="collapse" data-target="#myprofile" class="collapsed" id='<s:message code="left.menu.myprofile.id" />'>
              <a href="#"><i class="fa fa-user fa-lg"></i>  <s:message code="left.menu.myprofile.title" /> <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="myprofile">
                   
                <s:message code="left.menu.myprofile.viewmyprofile.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.myprofile.viewmyprofile.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.myprofile.viewmyprofile.title" /></a></li>
                         
                <%-- <s:message code="left.menu.myprofile.editmyprofile.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.myprofile.editmyprofile.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.myprofile.editmyprofile.title" /></a></li>
                 --%>
                <s:message code="left.menu.myprofile.changepassword.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.myprofile.changepassword.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.myprofile.changepassword.title" /></a></li>
            </ul>
            
            <li  data-toggle="collapse" data-target="#connections" class="collapsed" id='<s:message code="left.menu.connections.id" />'>
              <a href="#"><i class="fa fa-plug fa-lg"></i>  <s:message code="left.menu.connections.title" /> <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="connections">
                   
               <%--  <s:message code="left.menu.connections.steps.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.instructions.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.steps.title" /></a></li>
                 --%>
                <s:message code="left.menu.connections.instructions.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.instructions.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.instructions.title" /></a></li>
                
                <%-- <s:message code="left.menu.connections.steps.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.steps.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.steps.title" /></a></li> --%>
                
                <s:message code="left.menu.connections.newconnection.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.newconnection.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.newconnection.title" /></a></li>

                <s:message code="left.menu.connections.incomplete.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.incomplete.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.incomplete.title" /></a></li>
                
                <s:message code="left.menu.connections.myapplications.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.myapplications.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.myapplications.title" /></a></li>
                
                <%-- <s:message code="left.menu.connections.searchapplications.href" var="urlvar"></s:message>
                <li id='<s:message code="left.menu.connections.searchapplications.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.connections.searchapplications.title" /></a></li>
             --%>
            </ul>


            <li data-toggle="collapse" data-target="#service"  id='<s:message code="left.menu.mycontract.id" />' class='collapsed'>
              <a href="#"><i class="fa fa-pencil-square-o fa-lg"></i> <s:message code="left.menu.mycontract.title" /><span class="arrow"></span> </a>
            </li>   
             <%-- <li data-toggle="collapse" data-target="#service" id='<s:message code="left.menu.mycontract.id" />'>
             <s:message code="left.menu.mycontracts.href" var="urlvar"></s:message>          
              <a href='<c:url value="${urlvar}"/>'><i class="fa fa-exclamation-triangle fa-lg"></i><s:message code="left.menu.mycontract.title" /><span class="arrow"></span></a>
            </li>  --%>
            
            <!-- CONTRACT START -->
            
            <ul class="sub-menu collapse" id="service">
            <li id='<s:message code="left.menu.mycontractlist.id" />'>
             <s:message code="left.menu.mycontracts.href" var="urlvar"></s:message>          
              <a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontractslist.title" /></a>
            </li>

              <li data-toggle="collapse" data-target="#bill_info" class="collapsed" id='<s:message code="left.menu.mycontract.billing.id" />'>
                  <a href="#"><s:message code="left.menu.mycontract.billing.title" /> <span class="arrow"></span></a>
              </li> 
              <ul class="sub-menu  sub-sub-menu" id="bill_info">
              
                  <s:message code="left.menu.mycontract.billing.listing.href" var="urlvar"></s:message>
                  <li class="" id='<s:message code="left.menu.mycontract.billing.listing.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.billing.listing.title" /> </a></li>
                  
                  <s:message code="left.menu.mycontract.billing.graphical.href" var="urlvar"></s:message>
                  <li class="" id='<s:message code="left.menu.mycontract.billing.graphical.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.billing.graphical.title" /> </a></li>
              </ul>
              <li data-toggle="collapse" data-target="#consumptionmenu" class="collapsed" id='<s:message code="left.menu.mycontract.consumption.id" />'>
                  <a href="#"><s:message code="left.menu.mycontract.consumption.title" /> <span class="arrow"></span></a>
              </li> 
              <ul class="sub-menu sub-sub-menu collapse" id="consumptionmenu">
                  <s:message code="left.menu.mycontract.consumption.usage.href" var="urlvar"></s:message>
                  <li class="" id='<s:message code="left.menu.mycontract.consumption.usage.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.consumption.usage.title" /> </a></li>
                  
                  <s:message code="left.menu.mycontract.consumption.graphical.href" var="urlvar"></s:message>
                  <li class="" id='<s:message code="left.menu.mycontract.consumption.graphical.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.consumption.graphical.title" /> </a></li>
              </ul>
              
              <s:message code="left.menu.mycontract.editbill.href" var="urlvar"></s:message>
              <li class="" id='<s:message code="left.menu.mycontract.editbill.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.editbill.title" /> </a></li>
              
              <%-- <s:message code="left.menu.mycontract.selfreading.href" var="urlvar"></s:message>
              <li class="" id='<s:message code="left.menu.mycontract.selfreading.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.mycontract.selfreading.title" /> </a></li> --%>
            </ul>
            
            <!-- CONTRACT END -->


            <li data-toggle="collapse" data-target="#complaintsmenu" class="collapsed" id='<s:message code="left.menu.complaints.id" />'>
              <a href="#"><i class="fa fa-file-text fa-lg"></i> <s:message code="left.menu.complaints.title" /> <span class="arrow"></span></a>
            </li>
            <ul class="sub-menu collapse" id="complaintsmenu">
              <s:message code="left.menu.complaints.raise.href" var="urlvar"></s:message>
              <li id='<s:message code="left.menu.complaints.raise.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.complaints.raise.title" /></a></li>
              <s:message code="left.menu.complaints.mycomplaints.href" var="urlvar"></s:message>
              <li id='<s:message code="left.menu.complaints.mycomplaints.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.complaints.mycomplaints.title" /></a></li>
            </ul>
			<s:message code="left.menu.outages.combined.href" var="urlvar"></s:message>
            <li data-toggle="collapse" data-target="#power_outages_menu" class="collapsed" id='<s:message code="left.menu.outages.id" />'>
              <a href="<c:url value="${urlvar}"/>"><i class="fa fa-bolt fa-lg"></i> <s:message code="left.menu.outages.title" /> <%-- <span class="arrow"></span> --%></a>
            </li>
            <%-- <ul class="sub-menu collapse" id="power_outages_menu">
               <s:message code="left.menu.outages.planned.href" var="urlvar"></s:message>
              <li id='<s:message code="left.menu.outages.planned.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.outages.planned.title" /></a></li>
              <s:message code="left.menu.outages.unplanned.href" var="urlvar"></s:message>
              <li id='<s:message code="left.menu.outages.unplanned.id" />'><a href='<c:url value="${urlvar}"/>'><s:message code="left.menu.outages.unplanned.title" /></a></li>
              
            </ul> --%>

             <li id='<s:message code="left.menu.emergencies.id" />'>
             <s:message code="left.menu.emergencies.href" var="urlvar"></s:message>          
              <a href='<c:url value="${urlvar}"/>'><i class="fa fa-exclamation-triangle fa-lg"></i><s:message code="left.menu.emergencies.title" /></a>
            </li>
            </security:authorize>
        </ul>
 </div>
 
<c:set var="activeElement"><t:getAsString name="active_elements" /></c:set>
<c:set var="activeElements"  value="${fn:split(activeElement, ',')}" />

 <script>
 var activeElements = new Array();
 <c:forTokens items="${activeElement}" delims="," var="name" >
 activeElements.push('<s:message code="${fn:trim(name)}" />');
</c:forTokens>
 
 $(document).ready(function() {
	 for (idElement in activeElements) {
		 console.log(idElement);
		 $('#' + activeElements[idElement]).addClass('active');
		 $('#' + activeElements[idElement]).removeClass('collapsed');
		 $('li#' + activeElements[idElement]).parent().removeClass('collapse');
	 }
 });
 </script>