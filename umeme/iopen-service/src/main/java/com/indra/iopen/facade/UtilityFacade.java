package com.indra.iopen.facade;


import org.springframework.validation.BindingResult;
/**
 * This interface will be used to perform Utility activities UMESCI-713
 * @author smaina
 *
 */
public interface UtilityFacade {
	void validateRequest(BindingResult bindingResult) throws Exception;
}
