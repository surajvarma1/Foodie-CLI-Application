package com.foodie.app.repository;

import java.util.List;
import java.util.Optional;

import com.foodie.app.model.Dish;
import com.foodie.app.util.Factory;

public class DishRepository {
    List<Dish> dishList;

    public DishRepository() {
        this.dishList = Factory.getCsvReader().readDishesFromCsv();
    }

    public List<Dish> getDishList() {
        return this.dishList;
    }

    public Dish saveDish(Dish dish) {
        this.dishList.add(dish);
        return dish;
    }

    public Optional<Dish> findDishById(String id) {
        return this.dishList.stream().filter(dish -> dish.getId().equals(id)).findFirst();
    }

}
