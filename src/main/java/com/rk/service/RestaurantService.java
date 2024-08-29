package com.rk.service;

import java.util.List;

import com.rk.entity.Restaurant;

public interface RestaurantService {



	Object getAllRestaurants();

	Object getRestaurantById(Long id);

	Object updateRestaurant(Long id, Restaurant restaurant);

	void deleteRestaurant(Long id);

	Object getRestaurantsByHotel(Long hotelId);


     Object createRestaurant(Restaurant restaurant);


}
