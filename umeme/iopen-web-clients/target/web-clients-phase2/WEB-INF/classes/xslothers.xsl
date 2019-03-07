<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
  xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
  xmlns:fo="http://www.w3.org/1999/XSL/Format">
 
 <xsl:template match="/">
   <xsl:param name="count" select="0"/>
 <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
 
     <fo:layout-master-set>
     <fo:simple-page-master master-name="simple"
                   page-height="760px" 
				   page-width="528px" 
				   margin-top="0.1in"
                   margin-bottom="0.1in" 
				   margin-left="0in" 
				   margin-right="0in">
                   
	   <fo:region-body margin-bottom="0in" margin-left="0in" margin-right="0in" margin-top="0in"/>
	  </fo:simple-page-master> 
   </fo:layout-master-set>

 
 
   <fo:page-sequence master-reference="simple">
   	<fo:flow flow-name="xsl-region-body">
   	       
         <fo:table table-layout="fixed" width="100%"  >
         <fo:table-column column-width="190px" border-style="hidden"/>
         <fo:table-column column-width="190px" border-style="hidden"/>
         <fo:table-column column-width="145px" border-style="hidden"/>
         <fo:table-body>
		 
		 <fo:table-row height="13px" border-style="hidden">
		<fo:table-cell number-columns-spanned="2">
		<fo:block></fo:block>
		</fo:table-cell>
		</fo:table-row>

        <!--First Row-->
        <fo:table-row height="29px" border-style ="hidden">
        <fo:table-cell  display-align="after">
        <fo:block padding-top="90px" text-align="center" font-size="8">
        <xsl:value-of select="Statement/Page/statementIdentification/statementAccount/accountHolder/@customerLastName"/>
        <xsl:text> </xsl:text>
        <xsl:value-of select="Statement/Page/statementIdentification/statementAccount/accountHolder/@customerMiddleName"/>
       <xsl:text> </xsl:text>
       <xsl:value-of select="Statement/Page/statementIdentification/statementAccount/accountHolder/@customerFirstName"/>
       
		</fo:block>
       </fo:table-cell>
       
        </fo:table-row>

<!--SECOND ROW-->
<fo:table-row height="21px" border-style="hidden">
<fo:table-cell display-align="left">
<fo:block padding-top="9px" font-size="8" text-align="center">
<xsl:value-of select="Statement/Page/statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine2"/>
<xsl:text> </xsl:text>
<xsl:value-of select="Statement/Page/statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine3"/>
</fo:block>
</fo:table-cell>
<fo:table-cell  display-align="after">
<fo:block padding-top="10px" text-indent="40px" text-align="center" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/@ServiceID"/>
</fo:block>
</fo:table-cell>
<fo:table-cell  display-align="after">
<fo:block text-indent="35px" text-align="left" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/serviceRate/@rateDescription"/>
</fo:block>
</fo:table-cell>
</fo:table-row>

         
       <fo:table-row height="5px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
 </fo:table-row>

      <!--ROW 3-->
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell >
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell  display-align="after">
<fo:block text-indent="15px" text-align="center" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@InvoiceID"/>
</fo:block>
</fo:table-cell>

<fo:table-cell  display-align="after">
<fo:block text-indent="40px" text-align="left" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/SupplyPoint/RouteItinerary/@RouteDescription"/>
</fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<!--ROW 4-->
<fo:table-row height="20px" border-style="hidden">
<fo:table-cell >
<fo:block text-indent="120px" text-align="left" font-size="8"> 
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@consumptionToDate"/>
 </fo:block>
</fo:table-cell>
<fo:table-cell  >
<fo:block text-indent="25px" text-align="center" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@invoiceBillingDate"/>
</fo:block>
</fo:table-cell>
<fo:table-cell  >
<fo:block text-indent="70px" text-align="left" font-size="8" font-weight="bold" color="red">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@invoiceDueDate"/>
</fo:block>
</fo:table-cell>
</fo:table-row>
<!--ROW 5-->
<fo:table-row height="12px" border-style="hidden">
<fo:table-cell number-columns-spanned="3">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="10px" border-style="hidden">
<fo:table-cell >
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell number-columns-spanned="2">
<fo:block  text-align="left" font-size="8">
<xsl:if test="Statement/Page/statementInvoices/Invoice/Service/DeliveryAddress/@addressLine1 != ' '">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/DeliveryAddress/@addressLine1"/>,
<xsl:value-of select="Statement/Page/spaces/@space1"/>
</xsl:if>
<xsl:if test="Statement/Page/statementInvoices/Invoice/Service/DeliveryAddress/@addressLine2 != ' '">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/DeliveryAddress/@addressLine2"/>,
<xsl:value-of select="Statement/Page/spaces/@space1"/>
</xsl:if>
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/DeliveryAddress/@addressLine3"/>
</fo:block>
</fo:table-cell>
</fo:table-row>


<fo:table-row height="12px" border-style="hidden">
<fo:table-cell number-columns-spanned="3">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="12px" border-style="hidden">
<fo:table-cell number-columns-spanned="3">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="15px" border-style="hidden">
<fo:table-cell number-columns-spanned="3">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<!--ROW6-->
<fo:table-row height="12px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block start-indent="15px"  text-align="left" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/balanceBfwd/balanceBfwdInCurrency/@balanceBroughtForwardDescription"/>
</fo:block>
</fo:table-cell>

<fo:table-cell  display-align="center">
<fo:block  text-align="right" font-size="8">
 <xsl:value-of select="Statement/Page/statementInvoices/Invoice/balanceBfwd/balanceBfwdInCurrency/@currencyAmount"/>
</fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="12px" border-style="hidden">
<fo:table-cell number-columns-spanned="2" >
<fo:block start-indent="14px"  font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@paymentsReceivedDescription"/>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block  font-size="8"  text-align="right">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@currencyAmount"/>
</fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="1px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>


   
     </fo:table-body>

          </fo:table>
<!--BBE table 2 -->
<fo:table table-layout="fixed" width="100%" border-style="hidden">
<fo:table-column column-width="115px" border-style="hidden"/>
<fo:table-column column-width="60px" border-style="hidden"/>
<fo:table-column column-width="55px" border-style="hidden"/>
<fo:table-column column-width="10px" border-style="hidden"/>
<fo:table-column column-width="50px" border-style="hidden"/>
<fo:table-column column-width="30px" border-style="hidden"/>
<fo:table-column column-width="55px" border-style="hidden"/>
<fo:table-column column-width="60px" border-style="hidden"/>
<fo:table-column column-width="89px" border-style="hidden"/>

<fo:table-body>


  <xsl:apply-templates select="Statement/Page/statementInvoices/Invoice/invoiceItems"/>
   

<!--PADDING-->


</fo:table-body>
</fo:table>

<fo:table table-layout="fixed" width="100%" border-style="hidden">
<fo:table-column border-style="hidden"/>
<fo:table-column border-style="hidden"/>
<fo:table-body>
<fo:table-row height="40px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell number-rows-spanned="4">
<fo:block font-size="11">
</fo:block>

</fo:table-cell>
</fo:table-row>


<fo:table-row height="10px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<!--<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>-->
</fo:table-row>
<fo:table-row height="10px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<!--<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>-->
</fo:table-row>


<fo:table-row height="10px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

</fo:table-body>
</fo:table>

<fo:table table-layout="fixed" width="100%" border-style="hidden">
<fo:table-column column-width="150px" border-style="hidden"/>
<fo:table-column column-width="110px" border-style="hidden"/>
<fo:table-column column-width="90px" border-style="hidden"/>
<fo:table-column column-width="90px" border-style="hidden"/>
<fo:table-column column-width="87px" border-style="v"/>
<fo:table-body>
<!--CREDITS-->
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell  display-align="center">
<fo:block padding-top="2px" font-size="8" text-align="center">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/balanceOver90Days/balanceOver90DaysInCurrency/@currencyAmount"/>

</fo:block>
</fo:table-cell>

<fo:table-cell  display-align="center">
<fo:block padding-top="2px" font-size="8" text-align="center" >
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/balanceOver60Days/balanceOver60DaysInCurrency/@currencyAmount"/>
</fo:block>
</fo:table-cell>
<fo:table-cell  display-align="center">
<fo:block padding-top="2px" font-size="8" text-align="center" >
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/balanceOver30Days/balanceOver30DaysInCurrency/@currencyAmount"/>
</fo:block>
</fo:table-cell>
<fo:table-cell  display-align="center">
<fo:block padding-top="2px" font-size="8" text-align="center">

<xsl:value-of select="Statement/Page/statementInvoices/Invoice/invoiceDebt/invoiceDebtInCurrency/@currencyAmount"/>

</fo:block>
</fo:table-cell>
<fo:table-cell  display-align="center">
<fo:block padding-top="2px" font-size="8" text-align="right" font-weight="bold">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/totalBalance/totalBalanceInCurrency/@currencyAmount"/>
</fo:block>
</fo:table-cell>

</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="2px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<!--READING DAY-->
<fo:table-row height="8px" border-style="hidden">
<fo:table-cell  number-columns-spanned="2">
<fo:block text-indent="60px" font-size="8"   >
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@consumptionFromDate"/>
  -  
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@consumptionToDate"/>

</fo:block>
</fo:table-cell>
<fo:table-cell  >
<fo:block text-indent="10px" text-align="left" font-size="8">
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterActualReading/meterReadingType/@meterReadingTypeDescription"/>
</fo:block>
</fo:table-cell>

<fo:table-cell number-columns-spanned="2"  >
<fo:block text-indent="10px" text-align="center" font-size="8" >
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/@LastPayDate"/>

</fo:block>
</fo:table-cell>

</fo:table-row>

<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="15px" border-style="hidden">
<fo:table-cell number-columns-spanned="5">
<fo:block start-indent="10px" text-align="center" font-size="8" >
<xsl:value-of select="Statement/Page/statementInvoices/Invoice/billMessage/@message"/>
</fo:block>
</fo:table-cell>
</fo:table-row>
<!--PADDING-->
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<fo:table-row height="9px" border-style="hidden">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

<!--SUPPLY POINT ADDRESS-->
<fo:table-row height="13px" border-style="hidden">
<fo:table-cell number-columns-spanned="2">
<fo:block></fo:block>
</fo:table-cell>

</fo:table-row>

</fo:table-body>
</fo:table>


    <xsl:apply-templates select="data"/>
		   <xsl:value-of select="data/name"/>
   	</fo:flow>
   </fo:page-sequence>

  </fo:root> 
 </xsl:template>
 
<xsl:template match="Statement/Page/statementInvoices/Invoice/invoiceItems">
 <xsl:param name="total-items" select ="count(./Item) "/>
    <xsl:for-each select="Item">
           
   <xsl:sort select="@ItemSequenceNumber"/>
    <xsl:if test="./itemCode/@itemCodeCode != 'CC111'" >
      <!--BBE normal Bills-->
	  
	  <xsl:if test="./itemCode/@itemCodeCode = 'CC110'" >
      
	    <xsl:for-each select="./ItemChargeBlock">

         <fo:table-row height="12px" border-style="hidden">
   
	
			<fo:table-cell>
			<fo:block start-indent="15px" font-size="8"  text-align="left" number-columns-spanned="4">
			<xsl:if test="./@itemBlockCode = 0 " >
			<xsl:value-of select="./ancestor::Item/itemCode/@itemCodeDescription"/>
			</xsl:if>
			</fo:block>
			</fo:table-cell>
    
			<fo:table-cell>
			<fo:block  font-size="8" text-align="center">
			<xsl:if test="./@itemBlockCode = 0 " >
			<xsl:value-of select="ancestor::Page/statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/@meterNumber"/>
			</xsl:if>
			</fo:block>
			</fo:table-cell>
   
		     <fo:table-cell >
			<fo:block font-size="8" text-indent="20px" text-align="center">
			<xsl:if test="./@itemBlockCode = 0 " >
			<xsl:value-of select="./ancestor::Item/@previousReading"/>
			</xsl:if>
			</fo:block>
			</fo:table-cell>
	
	
			<fo:table-cell number-columns-spanned="2">
			<fo:block  font-size="8" text-align="center">
			<xsl:if test="./@itemBlockCode = 0 " >
			<xsl:value-of select="./ancestor::Item/@presentReading"/>
			</xsl:if>
			</fo:block>
			</fo:table-cell>
    
			<fo:table-cell>
			<fo:block font-size="8" text-align="center">
			<xsl:if test="./@itemBlockCode = 0 " >
			<xsl:value-of select="./ancestor::Item/@meterConstant"/>
			</xsl:if>
			</fo:block>
			</fo:table-cell>

		     <fo:table-cell>
			<fo:block font-size="8" text-align="center">
			<xsl:value-of select="./@UnitsCharged"/>
			</fo:block>
			</fo:table-cell>

		     <fo:table-cell>
			<fo:block font-size="8" text-align="center">
			<xsl:value-of select="./@UnitRate"/>
			</fo:block>
			</fo:table-cell>

		     <fo:table-cell>
			<fo:block font-size="8" text-align="right">
			<xsl:value-of select="./@itemBlockCharge"/>
			</fo:block>
			</fo:table-cell>

	     </fo:table-row>
        </xsl:for-each>
       </xsl:if>


     <!--BBE LV Bills-->
	<xsl:if test="./itemCode/@itemCodeCode != 'CC110'" >
	
	  <fo:table-row height="12px" border-style="hidden">
	
		<fo:table-cell>
		<fo:block start-indent="15px" font-size="8"  text-align="left" number-columns-spanned="4">
		<xsl:if test="./itemCode/@itemCodeCode != 'CC111'" >
			<xsl:value-of select="./itemCode/@itemCodeDescription"/>
		</xsl:if>
		</fo:block>
		</fo:table-cell>
    
	    <fo:table-cell>
		<fo:block  font-size="8" text-align="center">
		<xsl:if test="./@ItemSequenceNumber = 0 " >
		<xsl:value-of select="ancestor::Page/statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/@meterNumber"/>
		</xsl:if>
		</fo:block>
		</fo:table-cell>

   

	     <fo:table-cell >
		<fo:block font-size="8" text-indent="20px" text-align="center">
		<xsl:value-of select="./@previousReading"/>
		</fo:block>
		</fo:table-cell>
	
	
		<fo:table-cell number-columns-spanned="2">
		<fo:block  font-size="8" text-align="center">
		<xsl:value-of select="./@presentReading"/>
			<xsl:value-of select="@total-items"/>
		</fo:block>
		</fo:table-cell>
    
		<fo:table-cell>
		<fo:block font-size="8" text-align="center">
		<xsl:if test="./@ItemSequenceNumber = 0">
		<xsl:value-of select="./@meterConstant"/>
		</xsl:if>
		</fo:block>
		</fo:table-cell>

	     <fo:table-cell>
		<fo:block font-size="8" text-align="center">
		<xsl:value-of select="./@itemBilledUsage"/>
		<xsl:for-each select="./ItemChargeBlock">
		<xsl:value-of select="./@UnitsCharged"/>
		</xsl:for-each>

		<xsl:if test="./@ItemSequenceNumber != 0">
		<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 4 and ./@itemConsumptionType != 'CO005'">
		<xsl:value-of select="./@itemBilledUsage"/>
		</xsl:if>
		</xsl:if>
		</fo:block>
		</fo:table-cell>

	     <fo:table-cell>
		<fo:block font-size="8" text-align="center">
		<xsl:if test="./itemCode/@itemCodeCode != 'CC111'" >
		<xsl:for-each select="./ItemChargeBlock">
		<xsl:value-of select="./@UnitRate"/>
		</xsl:for-each>
		</xsl:if>
		<xsl:if test="not(./ItemChargeBlock)">
        <xsl:if test="./itemCode/@itemCodeCode !='CT800'">
		<xsl:value-of select="./itemPrice/@currencyAmount"/>
        </xsl:if>
		</xsl:if>
		<xsl:if test="./@ItemSequenceNumber != 0">
		<xsl:if test="./@itemPercentage != '0.00%'">
		<xsl:value-of select="./@itemPercentage "/>
		</xsl:if>
		<xsl:if test="./itemCode/@itemCodeCode != 'CC111'" >
		<xsl:if test="./@itemPercentage = '0.00%'">
		<xsl:if test="./@currencyAmount != '0.00'">
		<xsl:value-of select="./@currencyAmount"/>
		</xsl:if>
		</xsl:if>
		</xsl:if>
		</xsl:if>
		</fo:block>
		</fo:table-cell>

	     <fo:table-cell>
		<fo:block font-size="8" text-align="right">
		<xsl:if test="./@ItemSequenceNumber = 0">
		<xsl:if test="ItemChargeBlock/@itemBlockCode = 0">
		<xsl:value-of select="ItemChargeBlock/@itemBlockCharge"/>
		</xsl:if>
		<xsl:if test="not(./ItemChargeBlock)">
		<xsl:value-of select="./itemTotal/@currencyAmount"/>
		</xsl:if>
		</xsl:if>
		<xsl:if test="./@ItemSequenceNumber != 0">
		<xsl:value-of select="itemTotal/@currencyAmount"/>
		</xsl:if>
		</fo:block>
		</fo:table-cell>
         
		</fo:table-row>
       </xsl:if>
	  
	 
	
     </xsl:if>
</xsl:for-each>

  <xsl:call-template name="dots">
      <xsl:with-param name="count" select="21 - $total-items"/>
    </xsl:call-template>


 
</xsl:template>

<xsl:template match="Item">
<xsl:for-each select="ItemChargeBlock">
<xsl:if test="@itemBlockCode &lt; 8 and @itemBlockCode &gt; 0 or ./@ItemPriceChangeBlockNumber = 0">
<fo:table-row height="13.6px">
<fo:table-cell>
<fo:block></fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<!--Put Meter-->
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:value-of select="./@previousReading"/>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:value-of select="./@presentReading"/>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:value-of select="./@meterConstant"/>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:if test="./@itemBlockCode = 1">
<xsl:if test="../@itemBlockIndicator = 1">
<xsl:value-of select="./@UnitsCharged"/>
</xsl:if>
<xsl:if test="../@ItemPriceChangeBlockNumber = 0">
<xsl:value-of select="./@itemBilledUsage"/>
</xsl:if>
</xsl:if>
<xsl:if test="./@itemBlockCode != 1">
<xsl:value-of select="./@UnitsCharged"/>
</xsl:if>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:if test="./@itemBlockCode = 1">
<xsl:if test="../@itemBlockIndicator = 1">
<xsl:value-of select="./@UnitRate"/>
</xsl:if>
<xsl:if test="./@ItemPriceChangeBlockNumber = 0">
<xsl:value-of select="./itemPrice/@currencyAmount"/>
</xsl:if>
</xsl:if>
<xsl:if test="./@itemBlockCode != 1">
<xsl:value-of select="./@UnitRate"/>
</xsl:if>
</fo:block>
</fo:table-cell>
<fo:table-cell>
<fo:block end-indent="10px" text-align="right">
<xsl:if test="./@itemBlockCode = 1">
<xsl:if test="../@itemBlockIndicator = 1">
<xsl:value-of select="./@itemBlockCharge"/>
</xsl:if>
<xsl:if test="./@ItemPriceChangeBlockNumber = 0">
<xsl:value-of select="./itemPrice/@currencyAmount"/>
</xsl:if>
</xsl:if>
<xsl:if test="./@itemBlockCode != 1">
<xsl:value-of select="./@itemBlockCharge"/>
</xsl:if>
</fo:block>
</fo:table-cell>
</fo:table-row>
</xsl:if>
</xsl:for-each>
</xsl:template>

<xsl:template name="pad">
<fo:table-row height="25px">
<fo:table-cell number-columns-spanned="8" border-style="hidden">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="50px" border-style="hidden">
<fo:table-cell number-columns-spanned="8">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>
<fo:table-row height="50px" border-style="hidden">
<fo:table-cell number-columns-spanned="8">
<fo:block></fo:block>
</fo:table-cell>
</fo:table-row>

</xsl:template>


  <xsl:template name="dots">
  
      <xsl:param name="count" select="1"/>

      <xsl:if test="$count > 0">
        <fo:table-row height="12px" border-style="hidden">
		<fo:table-cell number-columns-spanned="8">
		<fo:block></fo:block>
		</fo:table-cell>
		</fo:table-row>
        <xsl:call-template name="dots">
          <xsl:with-param name="count" select="$count - 1"/>
        </xsl:call-template>
      </xsl:if>
      
  </xsl:template>



 </xsl:stylesheet>
 

<!-- Stylus Studio meta-information - (c)1998-2001 eXcelon Corp.
<metaInformation>
<scenarios ><scenario default="yes" name="Scenario1" userelativepaths="yes" url="output.xml" htmlbaseurl="" processortype="internal" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext=""/><scenario default="no" name="Scenario1" userelativepaths="yes" url="output.xml" htmlbaseurl="" processortype="internal" commandline="" additionalpath="" additionalclasspath="" postprocessortype="none" postprocesscommandline="" postprocessadditionalpath="" postprocessgeneratedext=""/></scenarios><MapperInfo  srcSchemaPath="" srcSchemaRoot="" srcSchemaPathIsRelative="yes" destSchemaPath="" destSchemaRoot="" destSchemaPathIsRelative="yes" />
</metaInformation>
-->