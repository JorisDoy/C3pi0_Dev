<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:output method="html"/>
	<xsl:template match="/">
		<xsl:apply-templates/>
	</xsl:template>
	<xsl:template match="Page">
		<html>
			<head>
				<style>					
				</style>
			</head>
			<span>
				<table width="725" height="1025" background="./image1.png">
					<tr valign="top" height="70"> 
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
						<td>
						</td>
					</tr>
					<tr valign="top" height="28">
						<td colspan="8">
							<table width="725">
								<tr height="12">
									<td width="180">
									</td>
									<td width="315">
									</td>
									<td align="center">
										<font size="3" color="#ff0000">
											<p>
												COPY BILL
											</p>
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr height="90">
						<td colspan="8" valign="bottom">
							<table height="90" width="725">
								<tr>
									<td valign="top">
										<table width="240">
											<tr height="13">
												<td>
												</td>
											</tr>
											<tr>
												<td width="8">
												</td>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerTitle) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerTitle"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerLastName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerLastName"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerFirstName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerFirstName"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerMiddleName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerMiddleName"/>
															</xsl:if>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="1">
												</td>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine1"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="1">
												</td>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine2"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="1">
												</td>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine3"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="1">
												</td>
												<td>
												</td>
											</tr>
										</table>
									</td>
									<td>
										<table width="15">
										</table>
									</td>
									<td valign="top">
										<table width="210" height="95">
											<tr height="48">
												<td align="center">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/businessOfficeAddress/@CommercialOffice"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="135">
												</td>
												<td valign="top">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/Service/@ServiceID"/>
														</p>
													</font>
												</td>
											</tr>
											<tr height="12">
												<td>
												</td>
											</tr>
											<tr>
												<td valign="top" colspan="2">
													<table>
														<tr>
															<td width="120">
															</td>
															<td>
																<font size="1" color="#000000">
																	<p>
																		<xsl:value-of select="statementInvoices/Invoice/@InvoiceID"/>
																	</p>
																</font>
															</td>
														</tr>
													</table>
												</td>
											</tr>
										</table>
									</td>
									<td>
									</td>
									<td valign="top" align="left">
										<table width="198" height="95">
											<tr height="38">
												<td>
												</td>
											</tr>
												<td valign="bottom" align="left">
													<table>
														<tr>
															<td width="15">
															</td>
															<td valign="bottom" align="left">
																<font size="1" color="#000000">
																	<p>
																	</p>
																</font>
															</td>
														</tr>
														<tr>
															<td width="17">
															</td>
															<td valign="bottom" align="left">
																<font size="1" color="#000000">
																	<p>
																		<xsl:value-of select="statementInvoices/Invoice/@TarrifType"/>
																	</p>
																</font>
															</td>
														</tr>
													</table>
												</td>
											<tr height="3">
												<td>
												</td>
											</tr>
											<tr valign="bottom">
												<td valign="top" align="left" height="48">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/Service/SupplyPoint/RouteItinerary/@PremiseSequence"/>
															-	
															<xsl:value-of select="statementInvoices/Invoice/Service/SupplyPoint/RouteItinerary/@RouteDescription"/>
														</p>
													</font>
												</td>
											</tr>
											<tr valign="bottom">
												<td valign="bottom" align="right">
													<font size="1" color="#000000">
														<p>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr height="10">
						<td colspan="8" valign="bottom">
							<table height="10" width="725">
								<tr>
									<td width="242" valign="top">
										<table>
											<tr height="10">
												<td width="500">
												</td>
												<td valign="top" width="130" align="left">
													<font size="1" color="#000000">
														<p>
															<xsl:if test="statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterConsumtionType/@meterConsumptionTypeCode = 'CO001' or statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterConsumtionType/@meterConsumptionTypeCode = 'CO002'
															             or statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterConsumtionType/@meterConsumptionTypeCode = 'CO003'">
																<xsl:value-of select='statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterActualReading/@meterReadingDate'/>
															</xsl:if>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
									<td valign="top" width="242">
										<table>
											<tr height="10">
												<td width="138">
												</td>
												<td valign="top">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/@invoiceBillDate"/>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
									<td valign="top" width="242">
										<table>
											<tr height="10">
												<td width="130" colspan="2">
												</td>
												<td valign="top">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/@invoiceDueDate"/>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr align="left" valign="bottom">
						<td colspan="8" width="100" align="left" valign="bottom" height="22">
							<table width="695">
								<tr>
									<td width="230">
									</td>
									<td width="595" valign="bottom">
										<font size="1" color="#000000">
											<p>
												<xsl:if test="statementInvoices/Invoice/Service/DeliveryAddress/@addressLine1 != ' '">
													<xsl:value-of select="statementInvoices/Invoice/Service/DeliveryAddress/@addressLine1"/>,
													<xsl:value-of select="spaces/@space1"/>
												</xsl:if>
												<xsl:if test="statementInvoices/Invoice/Service/DeliveryAddress/@addressLine2 != ' '">
													<xsl:value-of select="statementInvoices/Invoice/Service/DeliveryAddress/@addressLine2"/>,
													<xsl:value-of select="spaces/@space1"/>
												</xsl:if>
												<xsl:value-of select="statementInvoices/Invoice/Service/DeliveryAddress/@addressLine3"/>
											</p>
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr height="42">
						<td colspan="8">
						</td>
					</tr>
					<tr height="312" valign="top">
						<td colspan="8">
							<table height="332" width="723">
								<tr height="1" valign="top">
									<td valign="top" width="10">
									</td>
									<td valign="top" width="195">
										<font size="1" color="#000000">
											<p><xsl:value-of select="statementInvoices/Invoice/balanceBfwd/balanceBfwdInCurrency/@balanceBroughtForwardDescription"/></p>
										</font>
									</td>
									<td valign="top" width="90" align="right">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="right">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/balanceBfwd/balanceBfwdInCurrency/@currencyAmount"/>
												<xsl:if test="not(statementInvoices/Invoice/balanceBfwd)">
													<xsl:value-of select="statementInvoices/Invoice/@ZeroFields"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td>
									</td>
								</tr>
								<tr height="2">
									<td valign="top" width="10">
									</td>
									<td valign="top" width="591" colspan="7">
										<font size="1" color="#000000">
											<p>
												<xsl:if test="statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@currencyAmount != '0.00'">
													<xsl:value-of select="statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@paymentsReceivedDescription"/>
													<xsl:value-of select="spaces/@space1"/>
													<xsl:value-of select="statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/ReceiptsDetails/@ReceiptList"/>
												</xsl:if>
											</p>
										</font>
									</td>
								
									<td valign="top" width="122" align="right">
										<font size="1" color="#000000">
											<p>
												<xsl:if test="statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@currencyAmount != '0.00'">
													<xsl:value-of select="statementInvoices/Invoice/paymentsReceived/paymentsReceivedInCurrency/@currencyAmount"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td>
									</td>
								</tr>
								
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" align="left" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator != 1 and ./@ItemSequenceNumber = 0">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemTotal/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
													<xsl:if test="./@ItemPriceChangeBlockNumber = 0">
														<xsl:value-of select="statementInvoices/Invoice/invoiceItems/Item/@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0 and ./@itemBlockIndicator = 1">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
													<xsl:if test="./@ItemPriceChangeBlockNumber = 0 and ./@ItemPriceChangeBlockNumber = 0">
														<xsl:value-of select="./itemPrice/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
													<xsl:if test="./@ItemPriceChangeBlockNumber = 0">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 6">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock"> 
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@meterNumber"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@previousReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@presentReading"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@meterConstant"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 0">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 7">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" align="left" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											 	<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator != 1 and ./@ItemSequenceNumber = 1">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 1">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemTotal/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 1"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" align="left" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											 	<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator != 1 and ./@ItemSequenceNumber = 2">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 2">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
														<xsl:if test="./@ItemSequenceNumber = 2">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemTotal/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 2"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" align="left" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											 	<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemBlockIndicator != 1 and ./@ItemSequenceNumber = 3">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
													<xsl:if test="./@itemBlockIndicator = 1 and ./@ItemSequenceNumber = 3">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3">
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 0">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
														<xsl:if test="not(./ItemChargeBlock)">
															<xsl:value-of select="./itemTotal/@currencyAmount"/>
														</xsl:if>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 1">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 2">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 3">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 4">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitsCharged"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@UnitRate"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 3"> 
														<xsl:for-each select="./ItemChargeBlock">
															<xsl:if test="./@itemBlockCode = 5">
																<xsl:value-of select="./@itemBlockCharge"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
							<xsl:comment>BKI/UMCMS-139 fetch @previousReading from XML </xsl:comment>
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
							<xsl:comment>BKI/UMCMS-139 fetch @presentReading from XML </xsl:comment>
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
							<xsl:comment>BKI/UMCMS-139 fetch @meterConstant from XML </xsl:comment>
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 4">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4 and ../@itemPercentage != '0.00%'">
														<xsl:value-of select="./@itemPercentage"/>
													</xsl:if>
													<xsl:if test="./@ItemSequenceNumber = 4 and ./@itemPercentage = '0.00%'">
														<xsl:for-each select="./itemPrice">
															<xsl:if test="./@currencyAmount != '0.00'">
																<xsl:value-of select="./@currencyAmount"/>
															</xsl:if>
														</xsl:for-each>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 4">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
							<xsl:comment>BKI/UMCMS-139 fetch @meterNumber from Item in XML </xsl:comment>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./@meterNumber"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
							<xsl:comment>BKI/UMCMS-139 fetch @previousReading from XML </xsl:comment>
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
							<xsl:comment>BKI/UMCMS-139 fetch @presentReading from XML </xsl:comment>
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
							<xsl:comment>BKI/UMCMS-139 fetch @meterConstant from XML </xsl:comment>
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 5">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 5">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 5">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 5">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
<xsl:comment>BKI/UMCMS-136 differentiate between kW usage below 2000 and above </xsl:comment>
					<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
						<xsl:if test="./@ItemSequenceNumber = 6">
							<xsl:choose>
							<xsl:when test="./@itemBilledUsage &lt; 2000 or ./@itemBilledUsage = 2000">
								<tr height="1">
									<td valign="top" width="10" height="0">
									<font size="1" color="#FF0000"></font>
									
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./itemCode/@itemCodeDescription"/>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:value-of select="./@previousReading"/>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:value-of select="./@presentReading"/>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:value-of select="./@meterConstant"/>
											</p>
										</font>
									</td>

									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./@itemBilledUsage"/>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:choose>
													<xsl:when test="./@itemPercentage != '0.00%'">
														<xsl:value-of select="./@itemPercentage"/>
													</xsl:when>
													<xsl:otherwise>
														<xsl:value-of select="./itemPrice/@currencyAmount"/>
													</xsl:otherwise>
												</xsl:choose>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./itemTotal/@currencyAmount"/>
											</p>
										</font>
									</td>
									<td height="0">
									<p></p>
									</td>
								</tr>
							</xsl:when>	
							<xsl:otherwise>
								<tr height="1">
									<td valign="top" width="10" height="0">
									<font size="1" color="#FF0000"></font>
									
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./itemCode/@itemCodeDescription"/>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>												
												<xsl:value-of select="./@previousReading"/>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./@presentReading"/>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="./@meterConstant"/>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">

										<font size="1" color="#000000">
											<p>
												<!--xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 0"-->
														<xsl:value-of select="./@itemBilledUsage"/>
													<!--/xsl:if>
												</xsl:for-each-->												
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<!--xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 0">
														<xsl:value-of select="./@UnitRate"/>
													</xsl:if>
												</xsl:for-each-->
												<!--xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item"-->
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 6">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 6">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
														<xsl:when test="(./itemCode/@itemCodeCode = 'CC300' or ./itemCode/@itemCodeCode='CC310' or ./itemCode/@itemCodeCode='CC320') and ./@ItemSequenceNumber = 6 and ./itemPrice/@currencyAmount = '0.00' ">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												<!--/xsl:for-each-->
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:value-of select="./itemTotal/@currencyAmount"/>
												<!--xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 0">
														<xsl:value-of select="./@itemBlockCharge"/>
													</xsl:if>
												</xsl:for-each-->
											</p>
										</font>
									</td>
									<td height="0">
									<p></p>
									</td>
								</tr>
								
								<tr height="1">
									<td valign="top" width="10" height="0">
									<font size="1" color="#FF0000"></font>
									
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 1">
														<xsl:value-of select="./@UnitsCharged"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 1">
														<xsl:value-of select="./@UnitRate"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="./ItemChargeBlock">
													<xsl:if test="./@itemBlockCode = 1">
														<xsl:value-of select="./@itemBlockCharge"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									<p></p>
									</td>
								</tr>
							</xsl:otherwise>
								
						</xsl:choose>
					</xsl:if>
				</xsl:for-each>		
<xsl:comment>BKI/UMCMS-136 differentiate between kW usage below 2000 and above </xsl:comment>
<xsl:comment>ROK/UMCMS-102  INTERCHANGED ITEM SEQ NUMBER 8 AND 7 TO REORDER VA805 AND CC100 </xsl:comment>
								
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 8">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 8">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 8">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 8">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 8">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 8">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 8">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 8">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 7">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>

											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 7">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 7">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 7">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 7">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 7">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 7">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 7">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
<xsl:comment>ROK/UMCMS-102  INTERCHANGED ITEM SEQ NUMBER 8 AND 7 TO REORDER VA805 AND CC100 </xsl:comment>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 9">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 9">
														<xsl:value-of select="./@previousReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 9">
														<xsl:value-of select="./@presentReading"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 9">
														<xsl:value-of select="./@meterConstant"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 9">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 9">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 9">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 9">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 10">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 10">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 10">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 10">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 10">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 11">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 11">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 11">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 11">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 11">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 12">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 12">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 12">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 12">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 12">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 13">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 13">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 13">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 13">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 13">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 14">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 14">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 14">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 14">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 14">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
								<tr height="1">
									<td valign="top" width="10" height="0">
									</td>
									<td valign="top" width="195" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 15">
														<xsl:value-of select="./itemCode/@itemCodeDescription"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="90" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="70" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="44" align="center" height="0">
										<font size="1" color="#000000">
											<p>
											</p>
										</font>
									</td>
									<td valign="top" width="50" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@itemPercentage = '0.00%' and ./@itemBilledUsage != 0 and ./@ItemSequenceNumber = 15">
														<xsl:value-of select="./@itemBilledUsage"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="71" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:choose>
														<xsl:when test="./@itemPercentage != '0.00%' and ./@ItemSequenceNumber = 15">
															<xsl:value-of select="./@itemPercentage"/>
														</xsl:when>
														<xsl:when test="./itemPrice/@currencyAmount != '0.00' and ./@itemPercentage = '0.00%' and ./@ItemSequenceNumber = 15">
															<xsl:value-of select="./itemPrice/@currencyAmount"/>
														</xsl:when>
													</xsl:choose>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td valign="top" width="122" align="right" height="0">
										<font size="1" color="#000000">
											<p>
												<xsl:for-each select="statementInvoices/Invoice/invoiceItems/Item">
													<xsl:if test="./@ItemSequenceNumber = 15">
														<xsl:value-of select="./itemTotal/@currencyAmount"/>
													</xsl:if>
												</xsl:for-each>
											</p>
										</font>
									</td>
									<td height="0">
									</td>
								</tr>
									<td width="10">
									</td>
									<td colspan="7" valign="top">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/@complaints"/>
											</p>
										</font>
									</td>
									<td width="122">
									</td>
								<tr>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="1">
						</td>
						<td align="left" width="400" height="15">
							<font size="1" color="#000000">
								<p>
									<xsl:if test="statementInvoices/Invoice/@TotalInstallment != '0'">
										<xsl:value-of select="statementInvoices/Invoice/@TotalInstallmentDesc"/>
									</xsl:if>
								</p>
							</font>
						</td>
						<td width="90" align="right">
							<font size="1" color="#000000">
								<p>
									<xsl:if test="statementInvoices/Invoice/@TotalInstallment != '0'">
										<xsl:value-of select="statementInvoices/Invoice/@TotalInstallment"/>
									</xsl:if>
								</p>
							</font>
						</td>
					</tr>
					<tr>
						<td width="1">
						</td>
						<td align="left" width="400" height="15">
							<font size="1" color="#000000">
								<p>
									<xsl:if test="statementInvoices/Invoice/@DueInstallment != '0'">
										<xsl:value-of select="statementInvoices/Invoice/@DueInstallmentDesc"/>
									</xsl:if>
								</p>
							</font>
						</td>
						<td width="90" align="right">
							<font size="1" color="#000000">
								<p>
									<xsl:if test="statementInvoices/Invoice/@DueInstallment != '0'">
										<xsl:value-of select="statementInvoices/Invoice/@DueInstallment"/>
									</xsl:if>
								</p>
							</font>
						</td>
					</tr>
					<tr height="57" valign="top" width="723">
						<td colspan="8" valign="top">
							<table width="723">
								<tr height="42">
									<td>
									</td>
								</tr>
								<tr valign="top">
									<td width="10">
									</td>
									<td align="center" width="192" valign="top">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/balanceOver90Days/balanceOver90DaysInCurrency/@currencyAmount"/>
												<xsl:if test="not(statementInvoices/Invoice/balanceOver90Days)">
													<xsl:value-of select="statementInvoices/Invoice/@ZeroFields"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td align="center" width="170">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/balanceOver60Days/balanceOver60DaysInCurrency/@currencyAmount"/>
												<xsl:if test="not(statementInvoices/Invoice/balanceOver60Days)">
													<xsl:value-of select="statementInvoices/Invoice/@ZeroFields"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td align="center" width="170">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/balanceOver30Days/balanceOver30DaysInCurrency/@currencyAmount"/>
												<xsl:if test="not(statementInvoices/Invoice/balanceOver90Days)">
													<xsl:value-of select="statementInvoices/Invoice/@ZeroFields[not(../balanceOver30Days)]"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td align="center" width="91">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/invoiceTotal/invoiceTotalInCurrency/@currencyAmount"/>
											</p>
										</font>
									</td>
									<td align="right" width="100">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/totalBalance/totalBalanceInCurrency/@currencyAmount"/>
												<xsl:if test="not(statementInvoices/Invoice/totalBalance)">
													<xsl:value-of select="statementInvoices/Invoice/invoiceTotal/invoiceTotalInCurrency/@currencyAmount[not(../../../totalBalance)]"/>
												</xsl:if>
											</p>
										</font>
									</td>
									<td>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr height="8">
						<td colspan="8">
						</td>
					</tr>
					<tr valign="top" height="41">
						<td colspan="8">
							<table width="723">
								<tr valign="top">
									<td width="241" valign="top" align="center">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/@consumptionFromDate"/>
												<xsl:text> to </xsl:text>
												<xsl:value-of select="statementInvoices/Invoice/@consumptionToDate"/>
											</p>
										</font>
									</td>
									<td width="241" valign="bottom" align="center">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/Service/SupplyPoint/serviceMeterInformation/MeterInformation/meterReads/meterConsumption/meterActualReading/meterReadingType/@meterReadingTypeDescription"/>
											</p>
										</font>
									</td>
									<td width="241" align="center" valign="bottom">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/@LastPayDate"/>
											</p>
										</font>
									</td>
								</tr>
								<tr>
									<td colspan="4">
										<table width="715" height="80">
											<tr>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/billMessage/@message"/>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr valign="top">
						<td colspan="8">
							<table>
								<tr>
								</tr>
								<tr height="18" valign="top">
									<td width="100">
										<p>
										</p>
									</td>
									<td align="right" width="100">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/Service/@ServiceID"/>
											</p>
										</font>
									</td>
									<td width="400">
										<p>
										</p>
									</td>
									<td align="right" width="85">
										<font size="1" color="#000000">
											<p>
												<xsl:value-of select="statementInvoices/Invoice/@invoiceBillDate"/>
											</p>
										</font>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr valign="top">
						<td colspan="8">
							<table width="720">
								<tr height="2" valign="top">
									<td width="10">
									</td>
									<td width="400">
										<table>
											<tr>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerTitle) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerTitle"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerLastName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerLastName"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerFirstName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerFirstName"/>
																<xsl:value-of select="spaces/@space1"/>
															</xsl:if>
															<xsl:if test="normalize-space(/Statement/Page/statementIdentification/statementAccount/accountHolder/@customerMiddleName) != ''">
																<xsl:value-of select="statementIdentification/statementAccount/accountHolder/@customerMiddleName"/>
															</xsl:if>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine1"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine2"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td>
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementIdentification/statementAccount/accountAddresses/Address/Address/@addressLine3"/>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td>
												</td>
											</tr>
										</table>
									</td>
									<td align="left" valign="top" width="313">
										<table>
											<tr height="23">
												<td width="170">
												</td>
												<td width="110" align="right">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/@InvoiceID"/>
														</p>
													</font>
												</td>
											</tr>
											<tr valign="top">
												<td width="60">
												</td>
												<td align="right" height="17">
													<font size="1" color="#000000">
														<p>
														</p>
													</font>
												</td>
											</tr>
											<tr>
												<td width="170">
												</td>
												<td align="right" width="110">
													<font size="1" color="#000000">
														<p>
															<xsl:value-of select="statementInvoices/Invoice/totalBalance/totalBalanceInCurrency/@currencyAmount"/>
															<xsl:if test="not(statementInvoices/Invoice/totalBalance)">
																<xsl:value-of select="statementInvoices/Invoice/invoiceTotal/invoiceTotalInCurrency/@currencyAmount[not(../../../totalBalance)]"/>
															</xsl:if>
														</p>
													</font>
												</td>
											</tr>
										</table>
									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
					</tr>
				</table>
			</span>
		</html>
	</xsl:template>
</xsl:stylesheet>

