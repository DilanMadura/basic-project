package com.dmjtech.application.basic_project.controller;

import com.dmjtech.application.basic_project.model.dto.ErrorResponseDto;
import com.dmjtech.application.basic_project.model.dto.SuccessResponseDto;
import com.dmjtech.application.basic_project.service.IntegrationService;
import com.dmjtech.application.basic_project.util.component.LogMaker;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : Dilan Jayaneththi
 * @mailto : ddmdilan@mail.com
 * @created : 6/29/2024, Saturday, 11:35 PM,
 * @project : basic-project
 * @package : com.dmjtech.application.basic_project.controller
 **/

@RestController
@RequestMapping("${application.base-url.context}")
@RequiredArgsConstructor
public class APIController {
    private final LogMaker logMaker;
    private final IntegrationService integrationService;

    @Operation(summary = "check status", description = "check status")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = SuccessResponseDto.class))),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = ErrorResponseDto.class)))})
    @GetMapping(path = "/check-status")
    public ResponseEntity<SuccessResponseDto> checkStatus(HttpServletRequest request) {
        logMaker.setLog(this.getClass().getSimpleName(), "checkStatus", LogMaker.Protocol.REST, "", request);
        SuccessResponseDto response = integrationService.checkStatus();
        logMaker.setLog(this.getClass().getSimpleName(), "checkStatus", LogMaker.Protocol.REST, response, HttpStatus.OK);
        return ResponseEntity.ok().body(response);
    }
}
