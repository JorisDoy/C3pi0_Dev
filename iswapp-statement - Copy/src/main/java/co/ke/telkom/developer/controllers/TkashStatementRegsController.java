package co.ke.telkom.developer.controllers;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
/*import org.springframework.ui.Model;*/
import org.springframework.web.bind.annotation.*;

import co.ke.telkom.developer.exception.ResourceNotFoundException;
import co.ke.telkom.developer.model.TkashStatementRegs;
import co.ke.telkom.developer.repositories.TkashStatementRegsRepository;
import co.ke.telkom.developer.services.TkashStatementRegsService;

import java.util.List;
/*import java.util.Map;*/
import java.util.Optional;
import java.text.ParseException;

import javax.validation.Valid;

@RestController
public class TkashStatementRegsController 
{
	@Autowired
	private TkashStatementRegsRepository tkashStatementRegsRepository;
	
	TkashStatementRegsService tkashStatementRegsService = new TkashStatementRegsService();
	
/*	@RequestMapping(value="/admin/api/v1/statement/users/registerforstatementservice", 
					method = RequestMethod.POST,headers="Accept=application/json")
	public int registerUsertoTkashStatements() throws ParseException 
	{
		TkashStatementRegs tkashStatementRegs = new TkashStatementRegs();
		tkashStatementRegs.setMsisdn(tkashStatementRegs.getMsisdn());
		tkashStatementRegs.setId_no(tkashStatementRegs.getId_no());
		tkashStatementRegs.setEmail(tkashStatementRegs.getEmail());
		tkashStatementRegs.setReg_status(tkashStatementRegs.getReg_status());
		tkashStatementRegs.setRequest_type(tkashStatementRegs.getRequest_type());
		tkashStatementRegsService.registerUsertoTkashStatements();
		
		return Response.SC_OK;
				//.ok(entity).build();.
				//SC_OK.entity(tkashStatementRegs).build();
	}*/
/*	@PutMapping("/users/updateuseremail/{msisdn}")
	public String updateTkashStatementRegs(@PathVariable("msisdn") String msisdn,
											@RequestParam Map<String, String> queryMap,
											Model  TkashStatementRegs)
	{
	
		TkashStatementRegs.addAttribute("reg_status", "employee request by "
				+ "id and query map : "+
                msisdn+", "+ queryMap.toString());
		
		return "User email updated succesfully" ;	
		 if(!tkashStatementRegsRepository.existsById(msisdn))
		 {
	            throw new ResourceNotFoundException("Subscriber with tis number " + msisdn + " does not exists");
	     }
		 else
		 {
			 return tkashStatementRegsRepository.findById(msisdn);
		 }
	}*/
	//@PutMapping("/questions/{questionId}")
	@PutMapping("/users/updateuseremail/{msisdn}")
    public TkashStatementRegs updateTkashStatementRegs(@PathVariable String msisdn,
                                   @Valid @RequestBody TkashStatementRegs tkashStatementRegsRequest) {
        CrudRepository<TkashStatementRegs, Long> TkashStatementRegsRepository1 = null;
		return TkashStatementRegsRepository1.findById(Long.valueOf(msisdn))
                .map(tkashStatementRegsRequest1 -> 
                {
                	tkashStatementRegsRequest.setReg_status(tkashStatementRegsRequest.getReg_status());
                	return tkashStatementRegsRepository.save(tkashStatementRegsRequest);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User with number: " + msisdn + " not found"));
    }
	
	@PostMapping("/users/registerforstatementservice")
	//@RequestMapping(value="/users/registerforstatementservice", method = RequestMethod.POST)
	public TkashStatementRegs createTkashStatementRegs(@Valid  @RequestBody TkashStatementRegs tkashStatementRegs)
	{
			 return tkashStatementRegsRepository.save(tkashStatementRegs);
					 //.saveAll(tkashStatementRegsRepository);
	}
	
	@PostMapping("/users/updateuserstatus/{msisdn}")
	public Optional<TkashStatementRegs> updateUserRegsStatus(@PathVariable Long msisdn, 
													   @Valid @RequestBody TkashStatementRegs tkashStatementRegs)
	{
		 if(!tkashStatementRegsRepository.existsById(tkashStatementRegs.getMsisdn())) 
		 {
	            throw new ResourceNotFoundException("Subscriber with tis number " + msisdn + " does not exists");
	     }
		 else
		 {
			 return tkashStatementRegsRepository.findById(msisdn);
		 }
	}
}
