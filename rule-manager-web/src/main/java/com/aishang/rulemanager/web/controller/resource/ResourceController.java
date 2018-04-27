package com.aishang.rulemanager.web.controller.resource;

import com.aishang.rulemanager.common.enums.ErrorCode;
import com.aishang.rulemanager.facade.dto.request.resource.ResourceBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.service.IResourceService;
import com.aishang.rulemanager.web.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("resource")
public class ResourceController extends BaseController {

    @Autowired
    IResourceService resourceService;

    @PutMapping("/{id}/update")
    public ResponseDTOWrapper updateResource(@RequestBody ResourceBaseRequestDTO requestDTO,@PathVariable Integer id) throws Exception {
        boolean response = resourceService.update(requestDTO,id);
        if(!response){
            return createResponse(ErrorCode.FAIL);
        }
        return createResponse();
    }

    @PostMapping("/add")
    public ResponseDTOWrapper addResource(@RequestBody ResourceBaseRequestDTO requestDTO) throws Exception {
        boolean response = resourceService.add(requestDTO);
        if(!response){
            return createResponse(ErrorCode.FAIL);
        }
        return createResponse();
    }

    @DeleteMapping("/{id}/delete")
    public ResponseDTOWrapper deleteResource(@Valid @PathVariable String id) throws Exception {
        resourceService.delteById(id);
        return createResponse();
    }


}
