<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<div id="main" class="wrap post-template">
	<div class="container">
		<div class="row-fluid">
			<div class="span12 post-page">
				<h3 class="module-title-short">
					<span class="selected">Application List</span>
				</h3>
				<div class="panel panel-default panel-size"> 
                <div class="panel-body">
                     <div class="row-fluid">
                                        <div class="span9">
                                            
                                        </div>
                    <div class="span3">
                                            <button class="btn btn-lg btn-primary" type="submit">New Application</button>
                                        </div>

                                    </div>
                <hr/>
                <table class="table table-condensed table-hover">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Application Date</th>
                            <th>Application No.</th>
                            <th>Application type</th>
                            <th>Application Status</th>
                            <th>District</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="active">
                            <td>1011</td>
                            <td>2015/09/30</td>
                            <td>P89090053644</td>
                            <td>Domestic</td>
                            <td>Pending Approval</td>
                            <td>Kampala</td>
                        </tr>
                        <tr class="success">
                            <td>900</td>
                            <td>2015/05/30</td>
                            <td>P89090053677</td>
                            <td>Domestic</td>
                            <td>Approved</td>
                            <td>Banda</td>
                        </tr>
                        <tr class="danger">
                            <td>894</td>
                            <td>2015/03/30</td>
                            <td>P89090053623</td>
                            <td>Domestic</td>
                            <td>Rejected</td>
                            <td>Lira</td>
                        </tr>
                        <tr class="warning">
                            <td>200</td>
                            <td>2015/01/30</td>
                            <td>P89090053623</td>
                            <td>Domestic</td>
                            <td>Incomplete information</td>
                            <td>Kasese</td>
                        </tr>
                    </tbody>
                </table>
                </div>
            </div>

				<div class="bottom-border">&nbsp;</div>
			</div>
		</div>
	</div>
</div>