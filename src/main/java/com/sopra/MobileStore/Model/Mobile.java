package com.sopra.MobileStore.Model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Mobile_store")
public class Mobile {
	
	@Nonnull
	String brand;
	
	@Nonnull
	String model;
	
	@Id
	String imei;
	
	@Nonnull
	double price;
	
	@Nonnull
	String ram;
	
	@Nonnull
	String rom;
	
	@Nonnull
	String color;
	
	@Nonnull
	String image;

}
