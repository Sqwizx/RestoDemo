package com.resto.demo.dtos;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.resto.demo.entities.Customer}
 */
@Value
public class CustomerDto implements Serializable {
    Integer id;
    @NotNull
    @Size(max = 100)
    String name;
    @NotNull
    @Size(max = 100)
    String email;
    @NotNull
    @Size(max = 20)
    String phone;
}