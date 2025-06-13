package com.foodie.app.controller;

import java.util.List;

import com.foodie.app.model.Dish;
import com.foodie.app.service.DishServiceImpl;

public class DishController {
	private DishServiceImpl dishService;

	public DishController(DishServiceImpl dishService) {
		super();
		this.dishService = dishService;
	}
	public List<Dish> getDishesList(){
		return this.dishService.getDishesList();
	}
	

}
