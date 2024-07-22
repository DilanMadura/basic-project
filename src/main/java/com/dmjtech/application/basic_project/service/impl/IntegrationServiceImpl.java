package com.dmjtech.application.basic_project.service.impl;

import com.dmjtech.application.basic_project.model.dto.SuccessResponseDto;
import com.dmjtech.application.basic_project.service.IntegrationService;
import org.springframework.stereotype.Service;

/**
 * @author : Dilan Jayaneththi
 * @mailto : ddmdilan@mail.com
 * @created : 6/30/2024, Sunday, 12:05 PM,
 * @project : basic-project
 * @package : com.dmjtech.application.basic_project.service.impl
 **/

@Service
public class IntegrationServiceImpl implements IntegrationService {
    @Override
    public SuccessResponseDto checkStatus() {
        return new SuccessResponseDto("Your request is accepted.");
    }
}
