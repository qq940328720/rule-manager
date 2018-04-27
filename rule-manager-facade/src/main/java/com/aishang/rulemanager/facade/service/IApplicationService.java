package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.request.app.AppEnableRequestDTO;
import com.aishang.rulemanager.facade.dto.request.app.ApplicationRequestDTO;
import com.aishang.rulemanager.facade.dto.response.app.ApplicationResponseDTO;
import com.aishang.rulemanager.facade.dto.response.app.GetAppResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

public interface IApplicationService extends IBaseService<ApplicationRequestDTO, ApplicationResponseDTO, Integer> {

    ApplicationResponseDTO queryAll() throws Exception;

    Boolean insertApplication(ApplicationRequestDTO requestDTO) throws Exception;

    GetAppResponseDTO getApplicationById(String code) throws Exception;

    Boolean updApplication(ApplicationRequestDTO requestDTO,String code) throws Exception;

    Boolean uptAvailable(String code,AppEnableRequestDTO requestDTO) throws Exception;

    void deleteApp(String code) throws Exception;

}
