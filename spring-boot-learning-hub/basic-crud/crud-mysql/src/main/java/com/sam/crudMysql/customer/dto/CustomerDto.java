package com.sam.crudMysql.customer.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    private Integer id;

    @NotBlank(message = "Name is mandatory.")
    private String name;

    @NotNull(message = "Age is mandatory.")
    @Min(value = 1, message = "Age must be between greater than 0")
    private Integer age;

    @NotBlank(message = "Gender is mandatory.")
    private String gender;

    @NotBlank(message = "Country is mandatory.")
    private String country;

    @NotNull(message = "Mobile Number is mandatory.")
    @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number format")
    private String mobileNo;

    @NotBlank(message = "Email is mandatory.")
    private String email;

    private String createdBy;
    private LocalDateTime createdAt;
    private String updatedBy;
    private LocalDateTime updatedAt;

}
