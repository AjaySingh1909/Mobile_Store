package com.sopra.MobileStore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sopra.MobileStore.Exception.MobileNotFoundException;
import com.sopra.MobileStore.Model.Mobile;
import com.sopra.MobileStore.Service.Services;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/Mobile")
public class Controller {
	
	@Autowired
	private Services serv;
	
	@GetMapping("/all")
	public ResponseEntity<List<Mobile>> getall(){
		List<Mobile> res=serv.getall();
		return new ResponseEntity<>(res,HttpStatus.OK);
	}
	
	@GetMapping("/getbyimei/{imei}")
	public ResponseEntity<Mobile> getbyimei(@PathVariable("imei") String imei ){
		if(serv.getByIMEI(imei)!=null) {
			Mobile mp=serv.getByIMEI(imei);
			return new ResponseEntity<Mobile>(mp, HttpStatus.OK);
		}
		else throw new MobileNotFoundException("Mobile not found");
		
	}
	
	@DeleteMapping("/delete/{imei}")
	public ResponseEntity<Void> deletebyid(@PathVariable("imei") String imei){
		serv.delete(imei);
		return new ResponseEntity<>( HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<Void> add(@RequestBody Mobile mb){
		serv.addMob(mb);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

}
