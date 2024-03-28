package com.sopra.MobileStore.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sopra.MobileStore.Model.Mobile;


public interface Repos extends JpaRepository<Mobile, String>{
	@Query(nativeQuery = true, value = "Select * from mobile_store where imei=?")	
	public Mobile findbyIMEI(String imei);
		
	
}
