package com.indra.iopen.util;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

public class DomainSort {
	
	public static Sort sort(Direction order,String column){
		if(order == null)
			return new Sort(Sort.DEFAULT_DIRECTION, column);
		else
			return new Sort(order, column);
	}
	

}
