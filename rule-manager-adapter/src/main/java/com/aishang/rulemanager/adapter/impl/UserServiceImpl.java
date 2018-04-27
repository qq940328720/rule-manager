package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.common.inrerface.Logs;
import com.aishang.rulemanager.dal.mapper.RoleMapper;
import com.aishang.rulemanager.dal.mapper.UserMapper;
import com.aishang.rulemanager.dal.mapper.UserRoleMapper;
import com.aishang.rulemanager.dal.model.User;
import com.aishang.rulemanager.dal.model.UserExample;
import com.aishang.rulemanager.dal.model.UserRole;
import com.aishang.rulemanager.dal.model.vo.RoleVo;
import com.aishang.rulemanager.dal.model.vo.UserInfoConditionVo;
import com.aishang.rulemanager.dal.model.vo.UserVo;
import com.aishang.rulemanager.facade.dto.info.user.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.info.user.UserInfoDTO;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.request.user.*;
import com.aishang.rulemanager.facade.dto.response.user.UserAuthResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserBaseResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserInfoListRresponseDTO;
import com.aishang.rulemanager.facade.service.IUserService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl extends BaseServiceImpl<UserBaseRequestDTO, UserBaseResponseDTO, Integer> implements IUserService {


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    //ObjectMapper转换忽略多余字段
    private ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    @Override
    public UserAuthResponseDTO auth(UserAuthRequestDTO userAuthRequestDTO) throws Exception {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUsernameEqualTo(userAuthRequestDTO.getUsername());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size() > 0) {
            User user = userList.get(0);
            return new UserAuthResponseDTO(user.getUsername(), user.getPassword(), user.getEnabled(), user.getRealName(),
                    user.getLastLogin(), user.getLastAuth(), user.getCreatedAt(), user.getUpdatedAt());
        }
        return null;
    }

    @Logs
    @Override
    public UserBaseResponseDTO enableUser(String userName, UserEnableRequestDTO requestDTO) throws Exception {
        UserBaseResponseDTO responseDTO = new UserAuthResponseDTO();
        Integer enable = 0;
        if (requestDTO.getEnabled()) enable = 1;
        userMapper.updateUserState(userName, enable);
        return responseDTO;
    }

    @Logs
    @Override
    public UserBaseResponseDTO assignRole(String userName, UserAssignRoleRequestDTO requestDTO) throws Exception {

        List<UserRole> userRoles = new ArrayList<>();
        if (requestDTO.getData() != null && requestDTO.getData().size() > 0) {
            for (RoleInfoDTO info : requestDTO.getData()) {
                userRoles.add(new UserRole(userName, info.getCode()));
            }
        }
        userRoleMapper.deleteByUserName(userName);
        if (userRoles.size() > 0)
            userRoleMapper.insertList(userRoles);
        return new UserAuthResponseDTO();
    }

    @Override
    public List<RoleInfoDTO> getUserRolesByUserName(String userName) throws Exception {
        List<RoleVo> roleVos = roleMapper.getUserRolesByUserName(userName);
        List<RoleInfoDTO> ret = new ArrayList<>();
        if (roleVos != null) {
            for (RoleVo vo : roleVos) {
                RoleInfoDTO infoDTO = objectMapper.readValue(objectMapper.writeValueAsString(vo), RoleInfoDTO.class);
                ret.add(infoDTO);
            }
        }
        return ret;
    }

    @Override
    public UserInfoListRresponseDTO getUserInfoList(UserInfoListRequestDTO requestDTO) throws Exception {

        User user = userMapper.selectByPrimaryKey(1);

        UserInfoListRresponseDTO responseDTO = new UserInfoListRresponseDTO();
        if (requestDTO.getOffset() < 1) requestDTO.setOffset(1);
        if (requestDTO.getLimit() < 1) requestDTO.setLimit(15);
        Integer offset = requestDTO.getLimit() * (requestDTO.getOffset() - 1);
        requestDTO.setOffset(offset);
        UserInfoConditionVo conditionVo = objectMapper.readValue(objectMapper.writeValueAsString(requestDTO), UserInfoConditionVo.class);
        Integer count = userMapper.getUserInfoListCount(conditionVo);
        List<UserInfoDTO> userInfos = new ArrayList<>();
        if (count > 0) {
            List<UserVo> userVos = userMapper.getUserInfoList(conditionVo);
            if (userVos != null) {
                for (UserVo vo : userVos) {
                    UserInfoDTO infoDTO = objectMapper.readValue(objectMapper.writeValueAsString(vo), UserInfoDTO.class);
                    userInfos.add(infoDTO);
                }
            }
        }
        responseDTO.setTotal(count);
        responseDTO.setList(userInfos);
        return responseDTO;
    }

    @Override
    public List<? extends UserBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public UserBaseResponseDTO selectById(Integer id) throws Exception {
        return null;
    }

    @Override
    public void deleteById(Integer id) throws Exception {

    }

    @Override
    public void deleteById(Integer... id) throws Exception {

    }

    @Override
    public void deleteById(List<Integer> idList) throws Exception {

    }

    @Override
    public UserBaseResponseDTO create(UserBaseRequestDTO userBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public UserBaseResponseDTO update(UserBaseRequestDTO userBaseRequestDTO) throws Exception {
        return null;
    }
}
