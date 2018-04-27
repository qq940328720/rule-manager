package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.request.Log.LoginLogRequestDTO;
import com.aishang.rulemanager.facade.dto.response.Log.LoginLogResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

/**
 * lt
 */
public interface ILoginLogService extends IBaseService<LoginLogRequestDTO, LoginLogResponseDTO, Integer> {

    LoginLogResponseDTO loginInsert(LoginLogRequestDTO request);


}
