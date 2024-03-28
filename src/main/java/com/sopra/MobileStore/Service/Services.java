package com.sopra.MobileStore.Service;

import java.util.List;

import com.sopra.MobileStore.Model.Mobile;

public interface Services {
	
	public String addMob(Mobile mb);
	
	public List<Mobile> getall();
	
	public Mobile getByIMEI(String imei);
	
	public String delete(String imei);
	
}
