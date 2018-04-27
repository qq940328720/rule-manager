package com.aishang.rulemanager.web.controller.role;

import com.aishang.rulemanager.facade.dto.info.role.RoleApplicationPowerInfo;
import com.aishang.rulemanager.facade.dto.info.role.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleResourceRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.QueryRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.response.base.ResponseDTOWrapper;
import com.aishang.rulemanager.facade.service.IRoleService;
import com.aishang.rulemanager.web.controller.base.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(description = "角色接口")
@RestController
@RequestMapping("/roles")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService roleService;

    @ApiOperation(value = "角色新增/更新", response = ResponseDTOWrapper.class, notes = "角色新增/更新")
    @RequestMapping(value = "/role", method = RequestMethod.POST)
    public ResponseDTOWrapper createRole(@RequestBody @Valid AddRoleRequestDTO addRoleRequestDTO) throws Exception {
        this.roleService.createOrUpdate(addRoleRequestDTO);
        return createResponse();
    }

    @ApiOperation(value = "角色删除", response = ResponseDTOWrapper.class, notes = "角色删除")
    @RequestMapping(value = "{ids}/role", method = RequestMethod.DELETE)
    public ResponseDTOWrapper deleteRole(@PathVariable String ids) throws Exception {
        this.roleService.deleteByIds(ids);
        return createResponse();
    }

    @ApiOperation(value = "过滤查询角色信息", response = ResponseDTOWrapper.class, notes = "过滤查询角色信息")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseDTOWrapper selectRoles(@Valid QueryRoleRequestDTO queryRoleRequestDTO) throws Exception {
        List<RoleInfoDTO> roles = this.roleService.selectRoles(queryRoleRequestDTO);
        return createResponse(roles);
    }

    @ApiOperation(value = "查询角色权限树", response = ResponseDTOWrapper.class, notes = "查询角色权限树")
    @RequestMapping(value = "app/{roleCode}/powerTree", method = RequestMethod.GET)
    public ResponseDTOWrapper selectRolePowerTree(@PathVariable String roleCode) throws Exception {
        List<RoleApplicationPowerInfo> roleAppPowerTree = this.roleService.selectRolePowerTree(roleCode);
        return createResponse(roleAppPowerTree);
    }

    @ApiOperation(value = "新增角色权限", response = ResponseDTOWrapper.class, notes = "新增角色权限")
    @RequestMapping(value = "/{roleCode}/resources", method = RequestMethod.POST)
    public ResponseDTOWrapper addRolePower(@PathVariable String roleCode, @RequestBody AddRoleResourceRequestDTO addRoleResourceRequest) throws Exception {
        this.roleService.addRolePower(roleCode, addRoleResourceRequest);
        return createResponse();
    }
}
