package co.ke.telkom.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import co.ke.telkom.developer.model.TkashStatementRegs;
import org.springframework.stereotype.Repository;

@Repository
public interface TkashStatementRegsRepository extends JpaRepository<TkashStatementRegs, Long>
{

	//TkashStatementRegs saveAll(TkashStatementRegsRepository tkashStatementRegsRepository);
/*	//String getUserRegStatus(String msisdn);
	String updateUserEmail(String msisdn);//update the email
	
	String updateUserStatus(String msisdn);//deactivate or activate user to statement status
	
	String postUserRegDetails();//create a new registration entry		

	TkashStatementRegs save(TkashStatementRegsRepository tkashStatementRegsRepository);*/
}
