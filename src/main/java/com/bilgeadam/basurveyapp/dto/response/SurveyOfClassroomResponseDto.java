package com.bilgeadam.basurveyapp.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author Eralp Nitelik
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SurveyOfClassroomResponseDto {
    private Long surveyOid;
    private String surveyTitle;
    private String courseTopic;
    private List<QuestionWithAnswersResponseDto> surveyAnswers;
}
