package com.indra.iopen.repositories.model.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.indra.iopen.model.Actividade;
import com.indra.iopen.model.Cliente;
import com.indra.iopen.model.ClienteIdentificador;
import com.indra.iopen.model.ClienteProfile;
import com.indra.iopen.model.CosteExp;
import com.indra.iopen.model.CuentasCu;
import com.indra.iopen.model.DireccionCta;
import com.indra.iopen.model.DistrictDepto;
import com.indra.iopen.model.Expediente;
import com.indra.iopen.model.Fincas;
import com.indra.iopen.model.FincasExp;
import com.indra.iopen.model.InvGroup;
import com.indra.iopen.model.IopenApplication;
import com.indra.iopen.model.PresupuestosExped;
import com.indra.iopen.model.SumExp;
import com.indra.iopen.model.TipCliTipSolicMapping;
import com.indra.iopen.repositories.model.ApplicationRepository;

@Repository
public class ApplicationRepositoryJPA implements ApplicationRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public String getNumExpNextVal(){
		String numExp = null;
		BigDecimal num = (BigDecimal) this.entityManager.createNativeQuery("SELECT ICSPROD.NUM_EXP.NEXTVAL FROM DUAL").getSingleResult();
		
		numExp = String.valueOf(num);
		
		return "P"+numExp;
	}
	
	@Override
	public List<DistrictDepto> findAllDistricts() {
		return this.entityManager.createNamedQuery("DistrictDepto.findAll", DistrictDepto.class).getResultList();
	}

	@Override
	public CosteExp findCoste(String tipTarriff, String tipMov) {
		System.out.println("tipmov="+tipMov+" tipTarriff="+tipTarriff);
		return (CosteExp) this.entityManager
				.createQuery("select cost from CosteExp cost where cost.id.tipTarriff = :tipTarriff and cost.id.tipMov = :tipMov")
				.setParameter("tipTarriff", tipTarriff)
				.setParameter("tipMov", tipMov)
				.getSingleResult();
	}

	@Override
	public DistrictDepto findDistrict(String nomDistrict) {
		return (DistrictDepto) this.entityManager
				.createQuery("select d from DistrictDepto d where d.nomDistrict= :nomDistrict")
				.setParameter("nomDistrict", nomDistrict).getSingleResult();
	}

	@Override
	public TipCliTipSolicMapping findTipCliTipSolicMapping(String tipSolic) {
		return (TipCliTipSolicMapping) this.entityManager
				.createQuery("select map from TipCliTipSolicMapping map where map.id.tipSolic = :tipSolic ")
				.setParameter("tipSolic", tipSolic).getSingleResult();
	}

	@Override
	public Fincas getFinca(Long id) {
		Fincas fincas = this.entityManager.find(Fincas.class, id);
		return fincas;
	}

	@Override
	public void saveActividades(Actividade actividade) {
		this.entityManager.persist(actividade);
	}

	@Override
	public void saveBdgActOfiAux() {

	}

	@Override
	public void saveClienteProfile(ClienteProfile clienteProfile) {
		this.entityManager.persist(clienteProfile);

	}

	@Override
	public void saveClientes(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	public void saveClientesIdentificador(ClienteIdentificador clienteIdentificador) {
		this.entityManager.persist(clienteIdentificador);
	}

	@Override
	public void saveCuentasCu(CuentasCu cuentasCu) {
		this.entityManager.persist(cuentasCu);
	}

	@Override
	public void saveDireccionCta(DireccionCta direccionCta) {
		this.entityManager.persist(direccionCta);
	}

	@Override
	public void saveExpedientes(Expediente expediente) {
		this.entityManager.persist(expediente);
	}

	@Override
	public void saveFincasExp(FincasExp fincasExp) {
		this.entityManager.persist(fincasExp);
	}

	@Override
	public void saveInvGroup(InvGroup invGroup) {
		this.entityManager.persist(invGroup);
	}

	@Override
	public void saveIopenApplications(IopenApplication iopenApplication) {
		this.entityManager.persist(iopenApplication);

	}

	@Override
	public void savePresupuestosExped(PresupuestosExped presupuestosExped) {
		this.entityManager.persist(presupuestosExped);
	}

	@Override
	public void saveSumExp(SumExp sumExp) {
		this.entityManager.persist(sumExp);
	}

}
