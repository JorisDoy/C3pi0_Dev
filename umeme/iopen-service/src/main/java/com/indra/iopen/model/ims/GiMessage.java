package com.indra.iopen.model.ims;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GI_MESSAGES database table.
 * 
 */
@Entity
@Table(name="GI_MESSAGES")
@NamedQuery(name="GiMessage.findAll", query="SELECT g FROM GiMessage g")
public class GiMessage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private GiMessagePK id;

	@Column(name="\"MODULE\"")
	private String module;

	private String msgbutton;

	private BigDecimal msgdefaultbutton;

	private String msgicon;

	private String msgprint;

	private BigDecimal msgseverity;

	private String msgtext;

	private String msgtitle;

	private String msguserinput;

	public GiMessage() {
	}

	public GiMessagePK getId() {
		return this.id;
	}

	public void setId(GiMessagePK id) {
		this.id = id;
	}

	public String getModule() {
		return this.module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getMsgbutton() {
		return this.msgbutton;
	}

	public void setMsgbutton(String msgbutton) {
		this.msgbutton = msgbutton;
	}

	public BigDecimal getMsgdefaultbutton() {
		return this.msgdefaultbutton;
	}

	public void setMsgdefaultbutton(BigDecimal msgdefaultbutton) {
		this.msgdefaultbutton = msgdefaultbutton;
	}

	public String getMsgicon() {
		return this.msgicon;
	}

	public void setMsgicon(String msgicon) {
		this.msgicon = msgicon;
	}

	public String getMsgprint() {
		return this.msgprint;
	}

	public void setMsgprint(String msgprint) {
		this.msgprint = msgprint;
	}

	public BigDecimal getMsgseverity() {
		return this.msgseverity;
	}

	public void setMsgseverity(BigDecimal msgseverity) {
		this.msgseverity = msgseverity;
	}

	public String getMsgtext() {
		return this.msgtext;
	}

	public void setMsgtext(String msgtext) {
		this.msgtext = msgtext;
	}

	public String getMsgtitle() {
		return this.msgtitle;
	}

	public void setMsgtitle(String msgtitle) {
		this.msgtitle = msgtitle;
	}

	public String getMsguserinput() {
		return this.msguserinput;
	}

	public void setMsguserinput(String msguserinput) {
		this.msguserinput = msguserinput;
	}

}