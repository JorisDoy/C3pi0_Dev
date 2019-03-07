package com.indra.iopen.repositories.model;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.indra.iopen.model.Unicom;

public interface UnicomRepository extends CrudRepository<Unicom, Long> {

	List<Unicom> findUnicomByNomUnicomLike(String likeString);

	List<Unicom> findUnicomByCodUnicom(Long codUnicom);

	//SMA 20160317
	@Query("SELECT DISTINCT un FROM "
			+ " Sumcon sumc , Fincas fin, Suministro sumi , EmpUnicom empU ,  LectArea lectA, LectNatur lectN ,"
			+ "  Unicom un ,  IopenApplication io " + "  WHERE ( io.codApplication= ?1 ) "
			+ " and ( sumc.nisRad = io.expediente.nisRad) and ( sumi.numSum = sumc.numSum  )  "
			+ " and  ( fin.nif = sumi.nif ) and  " + " ( lectA.id.codLectArea = fin.areaLect )  "
			+ " and ( empU.id.codUnicom = un.codUnicom ) and "
			+ "  ( un.tipUnicom = 'UN001' ) and ( empU.id.codUnicom = lectA.id.codUnicom ) "
			+ " and (  empU.id.codUnicom = lectN.id.codUnicom ) and     (  empU.id.codUnicom = un.codUnicom ) ")
	List<Unicom> findUnicomMrDivByCodApplication(Long codApplication);
}
