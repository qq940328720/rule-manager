package com.aishang.rulemanager.facade.service;


import com.aishang.rulemanager.facade.dto.info.user.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.request.user.*;
import com.aishang.rulemanager.facade.dto.response.user.UserAuthResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserBaseResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserInfoListRresponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

import java.util.List;

public interface IUserService extends IBaseService<UserBaseRequestDTO, UserBaseResponseDTO, Integer> {

    UserAuthResponseDTO auth(UserAuthRequestDTO userAuthRequestDTO) throws Exception;

    UserBaseResponseDTO enableUser(String userName,UserEnableRequestDTO requestDTO) throws Exception;

    UserBaseResponseDTO assignRole(String userName, UserAssignRoleRequestDTO requestDTO) throws Exception;

    List<RoleInfoDTO> getUserRolesByUserName(String userName) throws Exception;

    UserInfoListRresponseDTO getUserInfoList(UserInfoListRequestDTO requestDTO) throws Exception;
}
