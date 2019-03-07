package co.ke.telkom.developer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import co.ke.telkom.developer.model.TkashStatementRequests;
import org.springframework.stereotype.Repository;

@Repository
public interface TkashStatementRequestsRepository extends JpaRepository <TkashStatementRequests, Long>
{
	/*String updateUserEmail(String msisdn);
	
	String postUserReqDetails();*/
}
