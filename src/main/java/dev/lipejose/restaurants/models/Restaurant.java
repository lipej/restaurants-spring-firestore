package dev.lipejose.restaurants.models;

import com.google.cloud.firestore.annotation.DocumentId;
import com.google.cloud.spring.data.firestore.Document;
import dev.lipejose.restaurants.enums.Stars;

import java.util.UUID;

@Document(collectionName = "restaurantsCollection")
public class Restaurant {

    @DocumentId
    private UUID id = UUID.randomUUID();

    private String name;
    private String phone;
    private String address;
    private Stars stars;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Stars getStars() {
        return stars;
    }

    public void setStars(Stars stars) {
        this.stars = stars;
    }
}
