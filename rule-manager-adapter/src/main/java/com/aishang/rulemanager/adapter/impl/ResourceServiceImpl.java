package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.common.UniqueCodeGenerator;
import com.aishang.rulemanager.common.inrerface.Logs;
import com.aishang.rulemanager.dal.mapper.ResourceMapper;
import com.aishang.rulemanager.dal.model.Resource;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.request.resource.ResourceBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.resource.ResourceBaseResponseDTO;
import com.aishang.rulemanager.facade.dto.response.resource.ResourceOnlyUriResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserBaseResponseDTO;
import com.aishang.rulemanager.facade.service.IResourceService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class ResourceServiceImpl extends BaseServiceImpl<ResourceBaseRequestDTO, ResourceBaseResponseDTO, Integer> implements IResourceService {

    @Autowired
    ResourceMapper resourceMapper;

    private final String one = "1";

    private final String zero = "0";

    @Override
    public List<? extends ResourceBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public ResourceBaseResponseDTO selectById(Integer id) throws Exception {
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
    public ResourceBaseResponseDTO create(ResourceBaseRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public ResourceBaseResponseDTO update(ResourceBaseRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Logs
    @Override
    public Boolean update(ResourceBaseRequestDTO resourceBaseRequestDTO, Integer id) throws Exception {
        Resource resource = new Resource();
        if (null == id) {
            id = 0;
        }
        String primaryKey = resourceMapper.selectByPrimaryKey(id);
        if (null == primaryKey) {
            return false;
        }
        //修改
        BeanUtils.copyProperties(resourceBaseRequestDTO, resource);
        String type = resourceBaseRequestDTO.getType();
        if (type != null) {
            resource.setType(Byte.valueOf(type));
        }
        String enabled = resourceBaseRequestDTO.getEnabled();
        if (one.equals(enabled)) {
            resource.setEnabled(true);
        }
        if (zero.equals(enabled)) {
            resource.setEnabled(false);
        }
        String visible = resourceBaseRequestDTO.getVisible();
        if (one.equals(visible)) {
            resource.setVisible(true);
        }
        if (zero.equals(visible)) {
            resource.setVisible(false);
        }
        resource.setId(id);
        int i = resourceMapper.updateByPrimaryKeySelective(resource);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean add(ResourceBaseRequestDTO requestDTO) throws Exception {
        Resource resource = new Resource();
        String appCode = UniqueCodeGenerator.generateAppCode();//唯一编号
        BeanUtils.copyProperties(requestDTO, resource);
        resource.setAppCode(appCode);
        String type = requestDTO.getType();
        if (type != null) {
            resource.setType(Byte.valueOf(type));
        }
        resource.setEnabled(true);
        resource.setVisible(true);
        int i = resourceMapper.insert(resource);
        if (i > 0) {
            return true;
        }
        return false;
    }

    @Override
    public UserBaseResponseDTO delteById(String id) throws Exception {
        String[] ids = id.split(",");
        for (int i = 0; i < ids.length; i++) {
            resourceMapper.deleteByPrimaryKey(Integer.valueOf(ids[i]));
        }
        return null;
    }

    @Override
    public List<ResourceOnlyUriResponseDTO> selectOnlyUriByUsername(String username) throws Exception {
        return null;
    }

    @Override
    public List selectTreeByAppCode(String appCode) throws Exception {
        List<Resource> resourceList = resourceMapper.selectTreeByAppCode(appCode);
        if (resourceList.size() > 0) {
            List<Resource> childs = new ArrayList<>();
            for (Resource resource : resourceList) {
                childs = getResourceTree(resource.getCode());
                resource.setListResourceTree(childs);
            }
        }
        return resourceList;
    }

    public List<Resource> getResourceTree(String parentCode) throws Exception {
        //查询当前父节点下的子节点
        List<Resource> children = resourceMapper.selectTreeByParentCode(parentCode);
        if (children.size() > 0) {
            List<Resource> childs = new ArrayList<>();
            for (Resource resour : children) {
                childs = getResourceTree(resour.getCode());
                resour.setListResourceTree(childs);
            }
        }
        return children;
    }
}
