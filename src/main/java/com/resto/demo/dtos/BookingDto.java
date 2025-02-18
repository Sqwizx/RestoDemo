package com.resto.demo.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.resto.demo.entities.Booking}
 */
@Value
public class BookingDto implements Serializable {
    Integer id;
    @NotNull
    CustomerDto customer;
    @NotNull
    Integer pax;
    @NotNull
    LocalDateTime bookingDatetime;
    String message;
    @Size(max = 20)
    @NotNull
    String status;
}