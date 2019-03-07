<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<!-- <div id="main" class="wrap post-template">
	<div class="container"> -->
		<div class="row-fluid">
			<div class="span12 post-page">
				<h3 class="module-title-short">
					<span class="selected"><s:message code="application.successfultitle" /></span>
				</h3>
				
			</div>
			<div class="row-fluid">
			
							<div class="span12" style="overflow: auto">
			<table class="table table-condensed table-hover">
                    <thead>
                        <tr> 
                            <th><s:message code="applicationlist.iopentackingno.label" /></th>
                           <!--  <th>Application type</th> -->
                            <%-- <th><s:message code="common.inspectionfeetext" /></th>  --%>
                        </tr>
                    </thead>
                    <tbody>
		                
		               <tr class="active"> 
		               		<td>${iopenApplication.codApplication }</td>
		               		<%-- <td>${iopenApplication.applicationType }</td> --%>
		               		<%-- <td><s:message code="common.UGX" /> <fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${iopenApplication.inspectionFee}" /> </td> 		                --%>
		               </tr> 
                    </tbody>
                </table>
                </div>
                <div class="span12"><p><s:message code="application.nextstep" /></p></div>
			</div>
		</div>
		
<!-- 	</div>
</div> -->