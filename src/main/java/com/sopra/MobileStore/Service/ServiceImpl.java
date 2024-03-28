package com.sopra.MobileStore.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sopra.MobileStore.Model.Mobile;
import com.sopra.MobileStore.Repository.Repos;

@Service
public class ServiceImpl implements Services {

	
	@Autowired
	private Repos repo;
	
	
	@Override
	public String addMob(Mobile mb) {
		repo.save(mb);
		return "Mobile added";
	}

	@Override
	public List<Mobile> getall() {
		return repo.findAll();
	}

	@Override
	public Mobile getByIMEI(String imei) {
		
		Mobile mob= repo.findbyIMEI(imei);
		return mob;
	}

	@Override
	public String delete(String imei) {
		repo.deleteById(imei);
		return "Deleted Successfully";
	}

	

	

}
