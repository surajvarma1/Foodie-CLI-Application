package com.foodie.app.service;

import java.util.List;
import java.util.Optional;

import com.foodie.app.exceptions.CustomerExistException;
import com.foodie.app.exceptions.DishExistsException;
import com.foodie.app.exceptions.DishNotFoundException;
import com.foodie.app.model.Customer;
import com.foodie.app.model.Dish;
import com.foodie.app.repository.DishRepository;

public class DishServiceImpl implements DishService {
	
	private DishRepository dishRepository;

	

	public DishServiceImpl(DishRepository dishRepository) {
		super();
		this.dishRepository = dishRepository;
	}

	@Override
	public List<Dish> getDishesList() {
		// TODO Auto-generated method stub
		return this.dishRepository.getDishList();
	}

	@Override
	public Dish save(Dish dish) throws DishExistsException {
		// TODO Auto-generated method stub
		Optional<Dish> dishById = this.dishRepository.findDishById(dish.getId());
		if(dishById.isPresent())
			throw new DishExistsException("Dish already exist with this id : " + dish.getId());
		return this.dishRepository.saveDish(dish);
	}

	@Override
	public Dish getDishById(String id) throws DishNotFoundException {
		// TODO Auto-generated method stub
		Optional<Dish> dishById = this.dishRepository.findDishById(id);
		if(!dishById.isPresent()) 
			throw new DishNotFoundException("Dish not Found with id: " + id);
		return dishById.get();
	}

}
