package com.bilgeadam.basurveyapp.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * @author Eralp Nitelik
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SurveyAssignRequestDto {
    @NotBlank
    @NotNull
    Long surveyId;
    @NotBlank
    @NotNull
    String studentTag;
    @NotBlank
    @NotNull
    Integer days;
    private String startDate;


}
