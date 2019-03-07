/*package co.ke.telkom.developer.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"reg_date", "dereg_date", "updated_date", "request_type"},
        allowGetters = true
)
public abstract class AuditModelRequests implements Serializable 
{
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date", nullable = false, updatable = false)
    @CreatedDate
    private Date reg_date;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dereg_date", nullable = false, updatable = false)
    @CreatedDate
    private Date dereg_date;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_date", nullable = false, updatable = false)
    @CreatedDate
    private Date updated_date;
	
	@Column(name = "request_type", nullable = false, updatable = false)
	private String request_type;

	public Date getReg_date() {
		return reg_date;
	}

	public void setReg_date(Date reg_date) {
		this.reg_date = reg_date;
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
*/