package com.foodie.app.service;

import java.util.List;

import com.foodie.app.exceptions.DishExistsException;
import com.foodie.app.exceptions.DishNotFoundException;
import com.foodie.app.model.Dish;

public interface DishService {
    public List<Dish> getDishesList();

    public Dish save(Dish dish) throws DishExistsException;
    public Dish getDishById(String id) throws DishNotFoundException;
	

}
