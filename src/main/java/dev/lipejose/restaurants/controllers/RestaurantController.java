package dev.lipejose.restaurants.controllers;

import dev.lipejose.restaurants.dtos.RestaurantDto;
import dev.lipejose.restaurants.models.RestaurantModel;
import dev.lipejose.restaurants.services.RestaurantService;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/v1/restaurants")
public class RestaurantController {

    final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public ResponseEntity<RestaurantModel> saveRestaurant(@RequestBody @Valid RestaurantDto restaurantDto){
        var restaurantModel = new RestaurantModel();
        BeanUtils.copyProperties(restaurantDto, restaurantModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(restaurantService.save(restaurantModel));
    }

    @GetMapping
    public ResponseEntity<List<RestaurantModel>> getRestaurants(@RequestParam(name = "page", required = false, defaultValue = "0") Integer page) {
        var restaurants =  restaurantService.getAll(page);
        return ResponseEntity.status(HttpStatus.OK).body(restaurants);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestaurantModel> getRestaurant(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(restaurantService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<RestaurantModel> delete(@PathVariable String id) {
        restaurantService.delete(id);
        return ResponseEntity.status(200).body(null);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestaurantModel> update(@PathVariable String id, @RequestBody RestaurantDto restaurantDto) {
        var restaurantModel =  new RestaurantModel();
        BeanUtils.copyProperties(restaurantDto, restaurantModel);
        restaurantModel.setId(id);
        return ResponseEntity.status(200).body(restaurantService.update(restaurantModel));
    }

}
