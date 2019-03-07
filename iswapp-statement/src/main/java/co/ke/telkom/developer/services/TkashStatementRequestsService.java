package co.ke.telkom.developer.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
/*import java.text.SimpleDateFormat;
import java.util.Date;*/

import co.ke.telkom.developer.connections.DBUtility;
import co.ke.telkom.developer.model.TkashStatementRegs;
import co.ke.telkom.developer.model.TkashStatementRequests;

public class TkashStatementRequestsService 
{
private Connection connection;
	
	public TkashStatementRequestsService()
	{
		connection = DBUtility.getConnection();
	}
	
	//2.	Update users email address in requests to have most updated email
	public void updateUserEmailinRequest(TkashStatementRegs tkashStatementRegs)
	{
		try 
		{
			PreparedStatement ps = connection.prepareStatement("update tkash_statement_requests set email_to = ? where msidn = ?");
			ps.setString(1, tkashStatementRegs.getEmail());
			ps.setLong(2, tkashStatementRegs.getMsisdn());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//1.	Statement request - Insert into table for requests
	public void postStatementRequest(TkashStatementRequests tkashStatementRequests)
	{
		try
		{
			String sql ="INSERT INTO tkash_statement_requests(\r\n" + 
					"            category, email_to, to_date, msisdn, period_in_months, process_date, \r\n" + 
					"            status, resq_type, from_date)\r\n" + 
					"    VALUES (?, ?, ?, ?, ?, ?, \r\n" + 
					"            ?, ?, ?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			//Date dt = new Date();
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			//String regDate = sdf.format(dt);
			ps.setString(1, tkashStatementRequests.getCategory());
			ps.setString(2, tkashStatementRequests.getEmail_to());
			ps.setString(3, tkashStatementRequests.getStart_date());
			ps.setString(4, tkashStatementRequests.getMsisdn());
			ps.setString(5, tkashStatementRequests.getPeriod_in_months());
			ps.setString(6, tkashStatementRequests.getProcess_date());
			ps.setInt(7, 0);
			ps.setString(8, tkashStatementRequests.getResq_type());
			ps.setString(9, tkashStatementRequests.getEnd_date());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
}
