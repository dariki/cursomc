package com.netcracker.cursomc.resource;

import java.util.Calendar;

import com.netcracker.cursomc.domain.MainDomain;

public class MainResource {

	protected void setDefaultValues(MainDomain mainDomain) {
		if(mainDomain instanceof MainDomain) {
			MainDomain mainDomainCasted = (MainDomain) mainDomain;
			mainDomainCasted.setTimestamp(Calendar.getInstance());
			
			
		}
	}
	
}
