package com.aishang.rulemanager.web.controller.base;


import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by neeke on 17-9-9.
 */
public abstract class BaseController {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    protected ResponseDTOWrapper createResponse(Object data) {
        ResponseDTOWrapper responseDTOWrapper = createResponse();
        responseDTOWrapper.setData(data);
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse(ErrorCode errorCode) {
        ResponseDTOWrapper responseDTOWrapper = createResponse();
        responseDTOWrapper.setCode(errorCode.getCode());
        responseDTOWrapper.setMessage(errorCode.getMessage());
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse() {
        ResponseDTOWrapper responseDTOWrapper = new ResponseDTOWrapper();
        responseDTOWrapper.setCode(ErrorCode.OK.getCode());
        responseDTOWrapper.setMessage(ErrorCode.OK.getMessage());
        return responseDTOWrapper;
    }

    protected ResponseDTOWrapper createResponse(Object data, Long totalCount) {
        ResponseDTOWrapper responseDTOWrapper = createResponse(data);
        responseDTOWrapper.setTotalCount(totalCount);
        return responseDTOWrapper;
    }
}
