package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.common.MyObjectMapper;
import com.aishang.rulemanager.common.UniqueCodeGenerator;
import com.aishang.rulemanager.dal.mapper.ApplicationMapper;
import com.aishang.rulemanager.dal.mapper.ResourceMapper;
import com.aishang.rulemanager.dal.mapper.RoleMapper;
import com.aishang.rulemanager.dal.mapper.RoleResourceMapper;
import com.aishang.rulemanager.dal.model.*;
import com.aishang.rulemanager.facade.dto.info.role.RoleApplicationPowerInfo;
import com.aishang.rulemanager.facade.dto.info.role.RoleInfoDTO;
import com.aishang.rulemanager.facade.dto.info.role.RoleResourcePowerInfo;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.AddRoleResourceRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.QueryRoleRequestDTO;
import com.aishang.rulemanager.facade.dto.request.role.RoleBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.role.RoleBaseResponseDTO;
import com.aishang.rulemanager.facade.service.IRoleService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class RoleServiceImpl extends BaseServiceImpl<RoleBaseRequestDTO, RoleBaseResponseDTO, Integer> implements IRoleService {

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    @Autowired
    private RoleResourceMapper roleResourceMapper;

    @Override
    public List<? extends RoleBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public RoleBaseResponseDTO selectById(Integer id) throws Exception {
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
    public RoleBaseResponseDTO create(RoleBaseRequestDTO roleBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public RoleBaseResponseDTO update(RoleBaseRequestDTO roleBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public void createOrUpdate(AddRoleRequestDTO addRoleRequestDTO) throws Exception {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userDetails == null) throw new Exception("登录用户信息异常");
        String roleName = addRoleRequestDTO.getRoleName();
        /*RoleExample roleExample = new RoleExample();
        roleExample.createCriteria().andNameEqualTo(roleName)
        .andIsDeleteEqualTo(false);
        List<Role> roles = this.roleMapper.selectByExample(roleExample);*/
        Role role = this.roleMapper.selectByRoleName(roleName);
        if (role != null) {
            role.setCreator(userDetails.getUsername());
            role.setDescription(addRoleRequestDTO.getDescription());
            role.setUpdatedAt(System.currentTimeMillis());
            int update = this.roleMapper.updateByPrimaryKey(role);
            if (update != 1) throw new Exception("更新角色失败");
        } else {
            role = new Role();
            role.setCode(UniqueCodeGenerator.generateRoleCode());
            role.setName(addRoleRequestDTO.getRoleName());
            role.setDescription(addRoleRequestDTO.getDescription());
            role.setCreator(userDetails.getUsername());
            role.setCreatedAt(System.currentTimeMillis());
            role.setUpdatedAt(System.currentTimeMillis());
            role.setIsDelete(false);
            int insert = this.roleMapper.insert(role);
            if (insert != 1) throw new Exception("新增角色失败");
        }
    }

    @Override
    public void deleteByIds(String ids) throws Exception {
        List<String> list = Arrays.asList(ids.split(","));
        int delete = this.roleMapper.deleteByPrimaryKeys(list);
        if (delete != list.size()) throw new Exception("角色删除失败");
    }

    @Override
    public List<RoleInfoDTO> selectRoles(QueryRoleRequestDTO queryRoleRequestDTO) {
        RoleExample roleExample = new RoleExample();
        long startTime = queryRoleRequestDTO.getCreateStartTime().getTime();
        long endTime = queryRoleRequestDTO.getCreateEndTime().getTime();
        roleExample.createCriteria().andCodeEqualTo(queryRoleRequestDTO.getRoleCode())
                .andNameLike(queryRoleRequestDTO.getRoleName())
                .andCreatorEqualTo(queryRoleRequestDTO.getCreateName())
                .andCreatedAtBetween(startTime, endTime);
        roleExample.setLimit(queryRoleRequestDTO.getLimit());
        roleExample.setOffset(queryRoleRequestDTO.getOffset());
        List<Role> roles = roleMapper.selectByExample(roleExample);
        List<RoleInfoDTO> list = MyObjectMapper.getInstance().convertValue(roles, List.class);
        return list;
    }

    @Override
    public List<RoleApplicationPowerInfo> selectRolePowerTree(String roleCode) throws Exception{
        // 所有的系统资源包含角色拥有的权限
        List<RoleApplicationPowerInfo> listRaps = new ArrayList<>();
        // 所有的子系统
        List<Application> apps = this.applicationMapper.queryAll();
        if (apps == null || apps.isEmpty()) {
            throw new Exception("无满足条件的数据");
        }
        // 角色拥有的资源
        List<String> listRoleResCode = this.roleResourceMapper.selectByRoleCode(roleCode);
        // 循环子系统查询所有的系统资源listRaps
        for (Application app : apps) {
            List<RoleResourcePowerInfo> listResInfo = new ArrayList<>();
            RoleApplicationPowerInfo rapInfo = MyObjectMapper.getInstance().convertValue(app, RoleApplicationPowerInfo.class);
            List<Resource> resources = this.resourceMapper.selectTreeByAppCode(app.getCode());
            if (resources == null || resources.isEmpty()) continue;
            List<Boolean> list = new ArrayList<>(resources.size());
            for (Resource resource : resources) {
                RoleResourcePowerInfo resourcePowerInfo = new RoleResourcePowerInfo();
                BeanUtils.copyProperties(resource, resourcePowerInfo);
                boolean contains = listRoleResCode.contains(resource.getCode());
                list.add(contains);
                resourcePowerInfo.setPower(contains);
                listResInfo.add(resourcePowerInfo);
            }
            boolean appPower = list.contains(true);
            rapInfo.setPower(appPower);
            rapInfo.setListRes(listResInfo);
            listRaps.add(rapInfo);
        }
        return listRaps;
    }

    @Override
    public void addRolePower(String roleCode, AddRoleResourceRequestDTO addRoleResourceRequest) throws Exception {
        Role role = this.roleMapper.selectByCode(roleCode);
        if (role == null) {
            throw new Exception("不存在的角色");
        }
        // 清空角色权限
        RoleResourceExample example = new RoleResourceExample();
        example.createCriteria().andRoleCodeEqualTo(roleCode);
        this.roleResourceMapper.deleteByExample(example);
        List<String> resCodes = addRoleResourceRequest.getResCodes();
        if (resCodes == null || resCodes.isEmpty()) return;
        List<RoleResource> list = new ArrayList<>();
        for (String resCode : resCodes) {
            Resource resource = this.resourceMapper.selectByCode(resCode);
            if (resource == null) continue;
            RoleResource roleResource = new RoleResource();
            roleResource.setRoleCode(roleCode);
            roleResource.setResourceCode(resCode);
            list.add(roleResource);
        }
        if (!list.isEmpty()) {
            this.roleResourceMapper.insertBatch(list);
        }
    }

}
