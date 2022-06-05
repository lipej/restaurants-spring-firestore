package dev.lipejose.restaurants.repositories;

import com.google.cloud.spring.data.firestore.FirestoreReactiveRepository;
import dev.lipejose.restaurants.models.Restaurant;

public interface RestaurantRepository extends FirestoreReactiveRepository<Restaurant> {
}
