package com.healthservice.entity;

import org.slf4j.Logger;
import org.springframework.web.client.RestTemplate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;



@Entity
public class Nutrition {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
private Integer nutritionId;
private String foodItem;
private String caloriesToBeconsumed;
private String proteinToBeconsumed;

RestTemplate restTemplate=new RestTemplate();
String endPoint="df";


public Integer getNutritionId() {
	return nutritionId;
}
public Nutrition(Integer nutritionId, String foodItem, String caloriesToBeconsumed, String proteinToBeconsumed,
		String carbohydratesToBeconsumed, String fatsToBeconsumed, String fiberToBeconsumed,
		String vitaminsAndMineralsToBeconsumed, String sugarToBeconsumed, String sodiumToBeconsumed) {
	super();
	this.nutritionId = nutritionId;
	this.foodItem = foodItem;
	this.caloriesToBeconsumed = caloriesToBeconsumed;
	this.proteinToBeconsumed = proteinToBeconsumed;
	this.carbohydratesToBeconsumed = carbohydratesToBeconsumed;
	this.fatsToBeconsumed = fatsToBeconsumed;
	this.fiberToBeconsumed = fiberToBeconsumed;
	this.vitaminsAndMineralsToBeconsumed = vitaminsAndMineralsToBeconsumed;
	this.sugarToBeconsumed = sugarToBeconsumed;
	this.sodiumToBeconsumed = sodiumToBeconsumed;
}
public void setNutritionId(Integer nutritionId) {
	this.nutritionId = nutritionId;
}
public String getFoodItem() {
	return foodItem;
}
@Override
public String toString() {
	return "NutritionTable [nutritionId=" + nutritionId + ", foodItem=" + foodItem + ", caloriesToBeconsumed="
			+ caloriesToBeconsumed + ", proteinToBeconsumed=" + proteinToBeconsumed + ", carbohydratesToBeconsumed="
			+ carbohydratesToBeconsumed + ", fatsToBeconsumed=" + fatsToBeconsumed + ", fiberToBeconsumed="
			+ fiberToBeconsumed + ", vitaminsAndMineralsToBeconsumed=" + vitaminsAndMineralsToBeconsumed
			+ ", sugarToBeconsumed=" + sugarToBeconsumed + ", sodiumToBeconsumed=" + sodiumToBeconsumed + "]";
}
public void setFoodItem(String foodItem) {
	this.foodItem = foodItem;
}
public String getCaloriesToBeconsumed() {
	return caloriesToBeconsumed;
}
public void setCaloriesToBeconsumed(String caloriesToBeconsumed) {
	this.caloriesToBeconsumed = caloriesToBeconsumed;
}
public String getProteinToBeconsumed() {
	return proteinToBeconsumed;
}
public void setProteinToBeconsumed(String proteinToBeconsumed) {
	this.proteinToBeconsumed = proteinToBeconsumed;
}
public String getCarbohydratesToBeconsumed() {
	return carbohydratesToBeconsumed;
}
public void setCarbohydratesToBeconsumed(String carbohydratesToBeconsumed) {
	this.carbohydratesToBeconsumed = carbohydratesToBeconsumed;
}
public String getFatsToBeconsumed() {
	return fatsToBeconsumed;
}
public void setFatsToBeconsumed(String fatsToBeconsumed) {
	this.fatsToBeconsumed = fatsToBeconsumed;
}
public String getFiberToBeconsumed() {
	return fiberToBeconsumed;
}
public void setFiberToBeconsumed(String fiberToBeconsumed) {
	this.fiberToBeconsumed = fiberToBeconsumed;
}
public String getVitaminsAndMineralsToBeconsumed() {
	return vitaminsAndMineralsToBeconsumed;
}
public void setVitaminsAndMineralsToBeconsumed(String vitaminsAndMineralsToBeconsumed) {
	this.vitaminsAndMineralsToBeconsumed = vitaminsAndMineralsToBeconsumed;
}
public String getSugarToBeconsumed() {
	return sugarToBeconsumed;
}
public void setSugarToBeconsumed(String sugarToBeconsumed) {
	this.sugarToBeconsumed = sugarToBeconsumed;
}
public String getSodiumToBeconsumed() {
	return sodiumToBeconsumed;
}
public void setSodiumToBeconsumed(String sodiumToBeconsumed) {
	this.sodiumToBeconsumed = sodiumToBeconsumed;
}
private String carbohydratesToBeconsumed;
private String fatsToBeconsumed;
private String fiberToBeconsumed;
private String vitaminsAndMineralsToBeconsumed;
private String sugarToBeconsumed;
private String sodiumToBeconsumed;
}
