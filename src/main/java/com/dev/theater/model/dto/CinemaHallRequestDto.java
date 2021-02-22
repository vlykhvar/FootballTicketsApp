package com.dev.theater.model.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class CinemaHallRequestDto {
    @Min(1)
    private int capacity;
    @NotNull
    private String description;

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
