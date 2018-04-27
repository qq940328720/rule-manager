package com.aishang.rulemanager.web.controller.user;

import com.aishang.rulemanager.facade.dto.info.user.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.request.user.UserAssignRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.user.UserEnableRequestDTO;
import com.aishang.rulemanager.facade.dto.request.user.UserInfoListRequestDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.dto.response.user.UserBaseResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserInfoListRresponseDTO;
import com.aishang.rulemanager.facade.provider.IUserProvider;
import com.aishang.rulemanager.facade.service.IUserService;
import com.aishang.rulemanager.web.controller.base.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController extends BaseController {

    @Autowired
    IUserService userService;

    @Autowired
    IUserProvider iUserProvider;

    @PutMapping("{userName}/enable")
    @ApiOperation(value = "启用/禁用用户", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper enableUser(@PathVariable String userName, @RequestBody UserEnableRequestDTO requestDTO) throws Exception {
        UserBaseResponseDTO responseDTO = userService.enableUser(userName, requestDTO);
        return createResponse();
    }

    @PutMapping("{userName}/roles/put")
    @ApiOperation(value = "分配角色", response = ResponseDTOWrapper.class)
    public ResponseDTOWrapper assignRole(@PathVariable String userName, @RequestBody UserAssignRoleRequestDTO requestDTO) throws Exception {
        UserBaseResponseDTO responseDTO = userService.assignRole(userName, requestDTO);
        return createResponse();
    }

    @GetMapping("{userName}/roles/get")
    @ApiOperation(value = "获取用户角色", response = RoleInfoDTO.class)
    public ResponseDTOWrapper getUserRolesByUserName(@PathVariable String userName) throws Exception {
        List<RoleInfoDTO> responseDTO = userService.getUserRolesByUserName(userName);
        return createResponse(responseDTO);
    }

    @GetMapping("/get")
    @ApiOperation(value = "获取用户列表", response = UserInfoListRresponseDTO.class)
    public ResponseDTOWrapper getUserInfoList(UserInfoListRequestDTO requestDTO) throws Exception {
        UserInfoListRresponseDTO responseDTO = userService.getUserInfoList(requestDTO);
        return createResponse(responseDTO);
    }

    @GetMapping("{userName}/applications/{appCode}/resources/get")
    @ApiOperation(value = "获取用户权限列表")
    public ResponseDTOWrapper getPermissions(@PathVariable String userName, @PathVariable String appCode) throws Exception {
        List<String> responseDTO = iUserProvider.getPermissions(userName, appCode);
        return createResponse(responseDTO);
    }
}
