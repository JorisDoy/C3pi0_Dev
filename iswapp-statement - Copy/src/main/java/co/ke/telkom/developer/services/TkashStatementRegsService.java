package co.ke.telkom.developer.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import co.ke.telkom.developer.connections.DBUtility;
import co.ke.telkom.developer.model.TkashStatementRegs;

public class TkashStatementRegsService 
{
	private Connection connection;
	
	public TkashStatementRegsService()
	{
		connection = DBUtility.getConnection();
	}
	
	//5.	Opt out from the statement service
	public void updatereg_status(TkashStatementRegs tkashStatementRegs)
	{
		try 
		{
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String updatedDate = sdf.format(dt);
			PreparedStatement ps = connection.prepareStatement("update tkash_statement_regs set reg_status = 0, updated_date=? where msidn = ?");
			ps.setString(1, updatedDate);
			ps.setLong(2, tkashStatementRegs.getMsisdn());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	//2.	Update users email address
	public void updateUserEmail(TkashStatementRegs tkashStatementRegs)
	{
		try 
		{
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String updatedDate = sdf.format(dt);
			PreparedStatement ps = connection.prepareStatement("update tkash_statement_regs set email = ?, updated_date=? where msidn = ?");
			ps.setString(1, tkashStatementRegs.getEmail());
			ps.setString(2, updatedDate);
			ps.setLong(3, tkashStatementRegs.getMsisdn());	
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	//4.	Registration of a customer to the statement engine from the app
	public List<TkashStatementRegs> registerUsertoTkashStatements()
	{
		TkashStatementRegs tkashStatementRegs = new TkashStatementRegs();
		try 
		{
			PreparedStatement ps = connection.prepareStatement("INSERT INTO tkash_statement_regs(\r\n" + 
					"            dereg_date, email, id_no, msisdn, reg_date, reg_status, request_type, \r\n" + 
					"            updated_date)\r\n" + 
					"    VALUES ( ?, ?, ?, ?, ?, ?, ?, \r\n" + 
					"            ?)");
			Date dt = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String regDate = sdf.format(dt);
			ps.setTimestamp(1, tkashStatementRegs.getDereg_date());
			ps.setString(2, tkashStatementRegs.getEmail());
			ps.setString(3, tkashStatementRegs.getId_no());
			ps.setLong(4, tkashStatementRegs.getMsisdn());
			ps.setString(5, regDate);
			ps.setInt(6, tkashStatementRegs.getReg_status());
			ps.setString(7, tkashStatementRegs.getRequest_type());
			ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return (List<TkashStatementRegs>) tkashStatementRegs;
	}
}
