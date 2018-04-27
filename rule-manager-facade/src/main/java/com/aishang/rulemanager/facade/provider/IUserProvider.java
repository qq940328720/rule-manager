package com.aishang.rulemanager.facade.provider;

import com.aishang.rulemanager.facade.dto.request.user.UserAuthRequestDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserAuthResponseDTO;

import java.io.Serializable;
import java.util.List;

public interface IUserProvider extends Serializable {

    /**
     * 登录认证
     * @param userAuthRequestDTO
     * @return
     * @throws Exception
     */
    UserAuthResponseDTO auth(UserAuthRequestDTO userAuthRequestDTO) throws Exception;

    /**
     * 读取用户接口访问权限
     * @param username 工号
     * @param appCode 子系统编号
     * @return
     * @throws Exception
     */
    List<String> getPermissions(String username, String appCode) throws Exception;
}
