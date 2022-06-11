package dev.lipejose.restaurants.services;

import dev.lipejose.restaurants.models.RestaurantModel;
import dev.lipejose.restaurants.repositories.RestaurantRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RestaurantService {
    final RestaurantRepository restaurantRepository;

    public RestaurantService(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    public List<RestaurantModel> getAll(Integer page) {
        var take = 10;
        var calculatedSkip = page == 0 ? 0 : (page - 1) * take;
        return restaurantRepository.findAll().take(take).skip(calculatedSkip).collectList().block();
    }
    public RestaurantModel getById(String id) {
        var modelFromDb = restaurantRepository.findById(id).block();

        if (modelFromDb == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return modelFromDb;
    }

    @Transactional
    public RestaurantModel save(RestaurantModel restaurantModel) {
       return restaurantRepository.save(restaurantModel).block();
    }

    @Transactional
    public void delete(String id) {
        var modelFromDb = restaurantRepository.findById(id).block();

        if (modelFromDb == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

       restaurantRepository.deleteById(id).block();
    }

    @Transactional
    public RestaurantModel update(RestaurantModel restaurantModel) {
        var modelFromDb = restaurantRepository.findById(restaurantModel.getId()).block();

        if (modelFromDb == null) {
            throw  new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        BeanUtils.copyProperties(restaurantModel, modelFromDb);

        return restaurantRepository.save(modelFromDb).block();
    }
}
