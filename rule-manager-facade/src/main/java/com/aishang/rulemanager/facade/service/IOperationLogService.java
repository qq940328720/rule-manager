package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.info.Log.OperationLogInfoDTO;
import com.aishang.rulemanager.facade.dto.request.Log.OperationLogRequestDTO;
import com.aishang.rulemanager.facade.dto.response.Log.OperationLogResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

/**
 * lt
 */
public interface IOperationLogService extends IBaseService<OperationLogRequestDTO, OperationLogInfoDTO, Integer> {

    OperationLogResponseDTO operationLogIntsert(OperationLogRequestDTO request) throws Exception;


}
