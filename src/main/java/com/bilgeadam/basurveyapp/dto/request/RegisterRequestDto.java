package com.bilgeadam.basurveyapp.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

/**
 * @author Eralp Nitelik
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class RegisterRequestDto {
    @Size(min = 8, max = 256, message = "Password should have at least 8 characters")
    @NotBlank(message = "Password must be valid.")
    @NotNull(message = "Password must be valid.")
    private String password;

    // all the fields that you might need when registering...
    @NotNull
    @NotBlank
    @Size(min = 2, max = 128)
    private String firstName;
    @NotNull
    @NotBlank
    @Size(min = 2, max = 128)
    private String lastName;
    @NotNull
    private Set<String> roles;
}
