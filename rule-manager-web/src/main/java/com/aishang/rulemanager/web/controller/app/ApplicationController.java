package com.aishang.rulemanager.web.controller.app;

import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.request.app.AppEnableRequestDTO;
import com.aishang.rulemanager.facade.dto.request.app.ApplicationRequestDTO;
import com.aishang.rulemanager.facade.dto.response.app.ApplicationResponseDTO;
import com.aishang.rulemanager.facade.dto.response.app.GetAppResponseDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.service.IApplicationService;
import com.aishang.rulemanager.facade.service.IResourceService;
import com.aishang.rulemanager.web.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("applications")
public class ApplicationController extends BaseController {

    @Autowired
    private IApplicationService applicationService;
    @Autowired
    IResourceService resourceService;


    @GetMapping("/get")
    @ApiOperation(value = "查询全部子系统", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper selectll() throws Exception {
        ApplicationResponseDTO applicationResponse = applicationService.queryAll();
        if(null == applicationResponse){
            return createResponse();
        }
        return createResponse(applicationResponse);
    }

    @PostMapping("/add")
    @ApiOperation(value = "新增", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper creatApp(@RequestBody ApplicationRequestDTO requestDTO) throws Exception{
        Boolean responseDTO = applicationService.insertApplication(requestDTO);
        if(responseDTO){
            return createResponse();
        }
        return createResponse(ErrorCode.FAIL);
    }

    @GetMapping("/{code}/get")
    @ApiOperation(value = "根据code查询", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper getApplicationById(@PathVariable String code) throws Exception {
        GetAppResponseDTO applicationResponse = applicationService.getApplicationById(code);
        if(null == applicationResponse){
            return createResponse();
        }
        return createResponse(applicationResponse.getAppInfo());
    }

    @PutMapping("{code}/update")
    @ApiOperation(value = "编辑", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper uptApp(@RequestBody ApplicationRequestDTO requestDTO,@PathVariable String code) throws Exception{
        Boolean responseDTO = applicationService.updApplication(requestDTO,code);
        if(responseDTO){
            return createResponse();
        }
        return createResponse(ErrorCode.FAIL);
    }


    @PutMapping("{code}/enable")
    @ApiOperation(value = "启用/禁用", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper uptAvailable(@PathVariable String code, AppEnableRequestDTO requestDTO) throws Exception{
        Boolean responseDTO = applicationService.uptAvailable(code,requestDTO);
        if(responseDTO){
            return createResponse();
        }
        return createResponse(ErrorCode.FAIL);
    }

    @DeleteMapping("{code}/delete")
    @ApiOperation(value = "删除(批量删除)", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper creatApp(@PathVariable String code) throws Exception{
        applicationService.deleteApp(code);
        return createResponse();
    }


    @GetMapping("{appCode}/resources")
    public ResponseDTOWrapper selectTreeByAppCode(@Valid @PathVariable String appCode) throws Exception {
        List list = resourceService.selectTreeByAppCode(appCode);
        return createResponse(list);
    }

}
