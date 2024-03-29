package com.bilgeadam.basurveyapp.controller;

import com.bilgeadam.basurveyapp.dto.request.CreateMainTagRequestDto;
import com.bilgeadam.basurveyapp.dto.request.UpdateTagDto;
import com.bilgeadam.basurveyapp.dto.request.UpdateTagNameAndTagClassesDto;
import com.bilgeadam.basurveyapp.dto.request.UpdateTagNameDto;
import com.bilgeadam.basurveyapp.dto.response.MainTagResponseDto;
import com.bilgeadam.basurveyapp.exceptions.custom.QuestionTagNotFoundException;
import com.bilgeadam.basurveyapp.services.MainTagService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/main-tags")
@RequiredArgsConstructor
public class MainTagController {

    private final MainTagService mainTagService;

    @PostMapping("/")
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @Operation(
            summary = "Ana Etiket Oluşturma",
            description = "Belirtilen etiket sınıfında ve isimde ana etiket oluşturan metot. Etiket sınıfları: (QUESTION, STUDENT, SURVEY, TRAINER). #35",
            tags = {"Main Tag Controller"}
    )
    public ResponseEntity<Boolean> createMainTag(@RequestBody CreateMainTagRequestDto dto){
        mainTagService.createMainTag(dto);
        return ResponseEntity.ok(true);
    }

    @GetMapping("/find-by-tag-names")
    @Operation(
            summary = "Etiket İsimlerine Göre Arama",
            description = "Belirtilen etiket isimlerine göre main etiketleri arayan metot. #36",
            tags = {"Main Tag Controller"},
            parameters = {
                    @Parameter(name = "tagName", description = "Aranacak etiket ismi", required = true)
            }
    )
    public ResponseEntity<List<MainTagResponseDto>> findByTagNames(@RequestParam String tagName){
        return ResponseEntity.ok(mainTagService.findByTagNames(tagName));
    }

    @GetMapping("/find-by-tag-name-and-tag-class")
    @Operation(
            summary = "Etiket İsmi ve Etiket Sınıfına Göre Arama",
            description = "Belirtilen etiket ismi ve etiket sınıfına göre ana etiketi arayan metot. Etiket sınıfları: (QUESTION, STUDENT, SURVEY, TRAINER). #37",
            tags = {"Main Tag Controller"},
            parameters = {
                    @Parameter(name = "tagName", description = "Aranacak etiket ismi", required = true),
                    @Parameter(name = "tagClass", description = "Aranacak etiket sınıfı", required = true)
            }
    )
    public ResponseEntity<MainTagResponseDto> findByTagNameAndTagClass(@RequestParam String tagName,@RequestParam String tagClass){
        return ResponseEntity.ok(mainTagService.findByTagNameAndTagClass(tagName,tagClass));
    }

    @PutMapping("/update-tag-by-tag-name")
    @Operation(
            summary = "Etiket İsmi ile Güncelleme",
            description = "Belirtilen etiket ismiyle ana etiketi güncelleyen metot. #38",
            tags = {"Main Tag Controller"}
    )
    public ResponseEntity<Boolean> updateTagByTagName(@RequestBody UpdateTagNameDto dto){
        return ResponseEntity.ok(mainTagService.updateTagByTagName(dto));
    }

    @PutMapping("/update-tag-by-tag-name-and-tag-class")
    @Operation(
            summary = "Etiket İsmi ve Etiket Sınıfı ile Güncelleme",
            description = "Belirtilen etiket ismi ve etiket sınıfıyla ana etiketi güncelleyen metot. Etiket sınıfları: (QUESTION, STUDENT, SURVEY, TRAINER). #39",
            tags = {"Main Tag Controller"}
    )
    public ResponseEntity<Boolean> updateTagByTagNameAndTagClass(@RequestBody UpdateTagDto dto){
        return ResponseEntity.ok(mainTagService.updateTagByTagNameAndTagClass(dto));
    }

    @GetMapping("/")
    @Operation(
            summary = "Tüm Etiketleri Getir",
            description = "Sistemdeki tüm etiketleri getiren metot. #40",
            tags = {"Main Tag Controller"}
    )
    public ResponseEntity<List<MainTagResponseDto>> findAllTags(){
        return ResponseEntity.ok(mainTagService.findAllTags());
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @DeleteMapping("/delete-by-tag-string/{tagString}")
    @Operation(
            summary = "Etiket İsmine Göre Silme",
            description = "Belirtilen etiket ismine göre ana etiketi silen metot. #41",
            tags = {"Main Tag Controller"},
            parameters = {
                    @Parameter(name = "tagString", description = "Silinecek etiketin ismi", required = true)
            }
    )
    public ResponseEntity<Boolean> deleteByTagName(@PathVariable String tagString) {
        try {
            boolean deleted = mainTagService.deleteByTagName(tagString);
            return ResponseEntity.ok(deleted);
        } catch (QuestionTagNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/update-tag-by-tag-name-and-tag-classes-all")
    @Operation(
            summary = "Tüm Tag Sınıfları İle Etiket Güncelleme",
            description = "Belirtilen etiketin adını ve tüm etiket sınıflarını güncelleyen metot. #42",
            tags = {"Main Tag Controller"}
    )
    public ResponseEntity<Boolean> updateTagByTagNameAndTagClassesFrontEnd(@RequestBody UpdateTagNameAndTagClassesDto dto){
        mainTagService.updateTagByTagNameAndTagClassesFrontEnd(dto);
        return ResponseEntity.ok(true);
    }

}
