package co.ke.telkom.developer.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "tkash_statement_regs")
public class TkashStatementRegs 
{
	/**
	 * 
	 */
	/*private static final long serialVersionUID = 1510883528114852269L;*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition ="text")
	private Long msisdn;
	
	@Column(columnDefinition ="text")
	private String id_no;
	
	@Column(columnDefinition ="text")
	private String email;
	
	@Column(columnDefinition="date")
	private Date reg_date;
	
	@Column(columnDefinition ="integer")
	private Integer reg_status;

	@Column(columnDefinition="date")
	private Timestamp dereg_date;
	
	@Column(columnDefinition="date")
	private Date updated_date;
	
	@Column(columnDefinition ="text")
	private String request_type;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(Long msisdn) {
		this.msisdn = msisdn;
	}

	public String getId_no() {
		return id_no;
	}

	public void setId_no(String id_no) {
		this.id_no = id_no;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
	}

	public Integer getReg_status() {
		return reg_status;
	}

	public void setReg_status(Integer reg_status) {
		this.reg_status = reg_status;
	}

	public Timestamp getDereg_date() {
		return dereg_date;
	}

	public void setDereg_date(Timestamp dereg_date) {
		this.dereg_date = dereg_date;
	}

	public Date getUpdated_date() {
		return updated_date;
	}

	public void setUpdated_date(Date updated_date) {
		this.updated_date = updated_date;
	}

	public String getRequest_type() {
		return request_type;
	}

	public void setRequest_type(String request_type) {
		this.request_type = request_type;
	}
	
	
}
