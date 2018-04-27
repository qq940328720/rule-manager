package com.aishang.rulemanager.facade.dto.response.Log;

import com.aishang.rulemanager.facade.dto.info.Log.OperationLogInfoDTO;
import com.aishang.rulemanager.facade.dto.response.base.BaseResponseDTO;

import java.util.List;

/**
 * lt
 */
public class OperationLogResponseDTO extends BaseResponseDTO {
    List<OperationLogInfoDTO> operationLogInfos;
    int count;

    public List<OperationLogInfoDTO> getOperationLogInfos() {
        return operationLogInfos;
    }

    public void setOperationLogInfos(List<OperationLogInfoDTO> operationLogInfos) {
        this.operationLogInfos = operationLogInfos;
    }
}
