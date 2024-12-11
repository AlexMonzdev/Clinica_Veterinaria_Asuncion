package com.example.ClinicaVeterinaria_Asuncion.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record GuardianRequestDTO(
        @NotBlank(message = "Name cannot be empty")
        @Size(min = 2, max = 100, message = "Name must be between 2 and 100 characters")
        String name,

        @NotBlank(message = "Email cannot be empty")
        @Email(message = "Email must be valid")
        String email,

        @NotBlank(message = "Phone cannot be empty")
        @Pattern(regexp = "\\+?[0-9]{9}", message = "Phone must be a valid number with exactly 9 digits")
        String phone,

        @NotBlank(message = "Address cannot be empty")
        @Size(max = 250, message = "Address must not exceed 250 characters")
        String address
) {
}
