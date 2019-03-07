/*package co.ke.telkom.developer.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@SuppressWarnings("serial")
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(
        value = {"reg_date", "dereg_date", "updated_date", "request_type"},
        allowGetters = true
)
public abstract class AuditModelRegistrations implements Serializable
{
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "reg_date", nullable = false, updatable = false)
    @CreatedDate
    private Date reg_date;
	
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dereg_date", nullable = false, updatable = false)
    @CreatedDate
    private Date dereg_date;
	
    @Column(name = "regs_channel", nullable = false, updatable = false)
    private String regs_channel;
	
    @Column(name = "request_type", nullable = false, updatable = false)
    private Date request_type;

	public Date getRegistered_date() {
		return reg_date;
	}

	public void setRegistered_date(Date reg_date) {
		this.reg_date = reg_date;
	}
	
	public String getRegs_channel() {
		return regs_channel;
	}

	public void setRegs_channel(String regs_channel) {
		this.regs_channel = regs_channel;
	}

	public Date getRequest_type() {
		return request_type;
	}

	public void setRequest_type(Date request_type) {
		this.request_type = request_type;
	}
    
    
}
*/