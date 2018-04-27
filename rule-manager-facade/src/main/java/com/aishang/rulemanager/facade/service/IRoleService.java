package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.info.role.RoleApplicationPowerInfo;
import com.aishang.rulemanager.facade.dto.info.role.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleResourceRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.QueryRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.RoleBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.role.RoleBaseResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

import java.util.List;

public interface IRoleService extends IBaseService<RoleBaseRequestDTO, RoleBaseResponseDTO, Integer> {

    void createOrUpdate(AddRoleRequestDTO addRoleRequestDTO) throws Exception;

    void deleteByIds(String ids) throws Exception;

    List<RoleInfoDTO> selectRoles(QueryRoleRequestDTO queryRoleRequestDTO) throws Exception;

    List<RoleApplicationPowerInfo> selectRolePowerTree(String roleCode) throws Exception;

    void addRolePower(String roleCode, AddRoleResourceRequestDTO addRoleResourceRequest) throws Exception;
}
