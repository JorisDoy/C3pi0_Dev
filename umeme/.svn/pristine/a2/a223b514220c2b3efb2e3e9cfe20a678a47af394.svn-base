package com.indra.iopen.repositories.model;

import java.util.List;

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

/**
 * Method declaraion for Applications.
 * @author mbaez
 *
 */
public interface ApplicationRepository {

    String getNumExpNextVal();

    List<DistrictDepto> findAllDistricts();

    CosteExp findCoste(String tipTarriff, String tipMov);

    DistrictDepto findDistrict(String nomDistrict);

    TipCliTipSolicMapping findTipCliTipSolicMapping(String tipSolic);

    Fincas getFinca(Long id);

    void saveActividades(Actividade actividade);

    void saveBdgActOfiAux();

    void saveClienteProfile(ClienteProfile clienteProfile);

    void saveClientes(Cliente cliente);

    void saveClientesIdentificador(ClienteIdentificador clienteIdentificador);

    void saveCuentasCu(CuentasCu cuentasCu);

    void saveDireccionCta(DireccionCta direccionCta);

    void saveExpedientes(Expediente expediente);

    void saveFincasExp(FincasExp fincasExp);

    void saveInvGroup(InvGroup invGroup);

    void saveIopenApplications(IopenApplication iopenApplication);

    void savePresupuestosExped(PresupuestosExped presupuestosExped);

    void saveSumExp(SumExp sumExp);
}
