package com.aishang.rulemanager.adapter.provider;

import com.aishang.rulemanager.dal.mapper.ResourceMapper;
import com.aishang.rulemanager.dal.mapper.RoleResourceMapper;
import com.aishang.rulemanager.dal.mapper.UserRoleMapper;
import com.aishang.rulemanager.facade.dto.request.user.UserAuthRequestDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserAuthResponseDTO;
import com.aishang.rulemanager.facade.provider.IUserProvider;
import com.aishang.rulemanager.facade.service.IUserService;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

@Service(version = "1.0")
public class UserProviderImpl implements IUserProvider {

    @Autowired
    IUserService userService;

    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    RoleResourceMapper roleResourceMapper;

    @Autowired
    ResourceMapper resourceMapper;
//    @Autowired

    @Override
    public UserAuthResponseDTO auth(UserAuthRequestDTO userAuthRequestDTO) throws Exception {
        return userService.auth(userAuthRequestDTO);
    }

    @Override
    public List<String> getPermissions(String username, String appCode) throws Exception {
        //List<String> url=new ArrayList();
        List<String> permissions = new ArrayList<>();
//        List<String> url = resourceMapper.selectUrl(username, appCode);
//        for (String s : url) {
//            permissions.add(s);
//        }
        permissions.add("123");
        permissions.add("456");
        return permissions;
    }
}
