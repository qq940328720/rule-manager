package com.aishang.rulemanager.web.controller.log;

import com.aishang.rulemanager.facade.dto.info.Log.OperationLogInfoDTO;
import com.aishang.rulemanager.facade.dto.request.Log.LoginLogPaginationRequestDTO;
import com.aishang.rulemanager.facade.dto.request.Log.OperationLogPaginationRequestDTO;
import com.aishang.rulemanager.facade.dto.response.Log.LoginLogResponseDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.service.ILoginLogService;
import com.aishang.rulemanager.facade.service.IOperationLogService;
import com.aishang.rulemanager.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "日志接口")
@RequestMapping("/logs")
public class SystemLogController extends BaseController {
    @Autowired
    private IOperationLogService logService;
    @Autowired
    private ILoginLogService loginLogService;

    @GetMapping(value = "/operating/get")
    @ApiOperation(value = "操作日志")
    ResponseDTOWrapper getOperationLogPagination(OperationLogPaginationRequestDTO request) throws Exception {
        List<? extends OperationLogInfoDTO> dtos = logService.selectAll(request);
        Long count = logService.selectCount(request);
        return createResponse(dtos, count);
    }

    @GetMapping(value = "/login/get")
    @ApiOperation(value = "登录日志")
    ResponseDTOWrapper getLoginPagination(LoginLogPaginationRequestDTO request) throws Exception {
        List<? extends LoginLogResponseDTO> dtos = loginLogService.selectAll(request);
        Long count = loginLogService.selectCount(request);
        return createResponse(dtos, count);
    }

}
