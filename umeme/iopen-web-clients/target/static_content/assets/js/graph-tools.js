function createBarGraphic(data, id, units) {
	
	if (units == null || units == undefined) {
		units = 'UGX';
	}
  var barChartData = {
      labels : ["January","February","March","April","May","June","July","August","September",
               "October", "November", "December"],
      datasets : [
          {
              label: "Annual Billing Report",
              fillColor : "rgba(166, 208, 138,0.5)",
              strokeColor : "rgba(166, 208, 138,0.8)",
              highlightFill: "rgba(109, 170, 69,0.75)",
              highlightStroke: "rgba(166, 208, 138,1)",
              data : data
          }
      ]

  }
  
	var ctx = document.getElementById(id).getContext("2d");
	  if (window.myBar != null || window.myBar != undefined) {
		  window.myBar.destroy();
	  }
	  window.myBar = new Chart(ctx).Bar(barChartData, {
	      responsive : true,
	      maintainAspectRatio: false,
	      showScale: true,
	      scaleLabel: "<%=value%> " +  units,
	      tooltipTemplate: "<%if (label){%><%=label%>: <%}%><%= value %> " +  units
	      
	  });
  }
	  
  function loadContractNumberAvailableYears(contractNumber) {
      if ( contractNumber != null) {
          
          if (contractNumber != null && billingData.contractBillingList[contractNumber].yearlyBilling != null && billingData.contractBillingList[contractNumber].yearlyBilling.length>0) {
              for (year in billingData.contractBillingList[contractNumber].yearlyBilling) {
                  $('#year').append($('<option>', {
                      value: year,
                      text:  billingData.contractBillingList[contractNumber].yearlyBilling[year].year
                  }));
              }
          }
      }
  }
	  
  function loadGraphData(contract, year, id, units, showUnits) {
	  if (showUnits === undefined) {
		  showUnits = false;
	  }
      if (contract!=null && year!=null) {
          monthData = [0,0,0,0,0,0,0,0,0,0,0,0];
          
          for (month in billingData.contractBillingList[contract].yearlyBilling[year].monthBills) {
              if (billingData.contractBillingList[contract].yearlyBilling[year].monthBills[month] != null) {
            	  if (showUnits) {
            		  monthData[billingData.contractBillingList[contract].yearlyBilling[year].monthBills[month].month -1] = 
            			  billingData.contractBillingList[contract].yearlyBilling[year].monthBills[month].consumption;
            	  } else {
            		  monthData[billingData.contractBillingList[contract].yearlyBilling[year].monthBills[month].month -1] = 
            			  billingData.contractBillingList[contract].yearlyBilling[year].monthBills[month].invoiceAmount;
            	  }
              } else {
                  monthData.push(0);
              }
          }
          

          createBarGraphic(monthData, id, units);
      }
  }