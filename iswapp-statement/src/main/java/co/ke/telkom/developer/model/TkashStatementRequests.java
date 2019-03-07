package co.ke.telkom.developer.model;

import javax.persistence.*;


@Entity
@Table(name = "tkash_statement_requests")
public class TkashStatementRequests 
{
	@Id
	/*@GeneratedValue(generator ="reqs_generator")
	@SequenceGenerator(
			name ="reqs_generator",
			sequenceName = "reqs_generator",
			initialValue = 0001
			)*/
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(columnDefinition ="text", name="msisdn")
	private String msisdn;
	
	@Column(columnDefinition ="text", name="resq_type")
	private String resq_type; //or request_type
	
	@Column(columnDefinition ="integer", name="status")
	private Integer process_status;
	
	@Column(columnDefinition ="text", name="process_date")
	private String process_date;
	
	@Column(columnDefinition ="text", name="from_date")
	private String start_date;
	
	@Column(columnDefinition ="text", name="to_date")
	private String end_date;
	
	@Column(columnDefinition ="String", name="period_in_months")
	private String period_in_months;
	
	@Column(columnDefinition ="text", name="email_to")
	private String email_to;
	
	@Column(columnDefinition ="text", name="category")
	private String category;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMsisdn() {
		return msisdn;
	}

	public void setMsisdn(String msisdn) {
		this.msisdn = msisdn;
	}

	public String getResq_type() {
		return resq_type;
	}

	public void setResq_type(String resq_type) {
		this.resq_type = resq_type;
	}

	public Integer getProcess_status() {
		return process_status;
	}

	public void setProcess_status(Integer process_status) {
		this.process_status = process_status;
	}

	public String getProcess_date() {
		return process_date;
	}

	public void setProcess_date(String process_date) {
		this.process_date = process_date;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getPeriod_in_months() {
		return period_in_months;
	}

	public void setPeriod_in_months(String period_in_months) {
		this.period_in_months = period_in_months;
	}

	public String getEmail_to() {
		return email_to;
	}

	public void setEmail_to(String email_to) {
		this.email_to = email_to;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
	
}
