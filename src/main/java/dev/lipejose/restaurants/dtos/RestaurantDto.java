package dev.lipejose.restaurants.dtos;

import dev.lipejose.restaurants.enums.Stars;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;

public class RestaurantDto {
    @NotBlank
    private String name;

    @NotBlank
    @Size(max = 11)
    private String phone;

    @NotBlank
    private String address;

    @NotNull
    private Stars stars;

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
