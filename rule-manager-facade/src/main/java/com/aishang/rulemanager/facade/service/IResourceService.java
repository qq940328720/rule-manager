package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.request.resource.ResourceBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.resource.ResourceBaseResponseDTO;
import com.aishang.rulemanager.facade.dto.response.resource.ResourceOnlyUriResponseDTO;
import com.aishang.rulemanager.facade.dto.response.user.UserBaseResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;

import java.util.List;

public interface IResourceService extends IBaseService<ResourceBaseRequestDTO, ResourceBaseResponseDTO, Integer> {

    List<ResourceOnlyUriResponseDTO> selectOnlyUriByUsername(String username) throws Exception;

    /**
     * 更新
     * @param requestDTO 请求参数
     * @return
     * @throws Exception
     */
    Boolean update(ResourceBaseRequestDTO requestDTO,Integer id) throws Exception;

    /**
     * 新增
     * @param requestDTO 请求参数
     * @return
     * @throws Exception
     */
    Boolean add(ResourceBaseRequestDTO requestDTO) throws Exception;


     UserBaseResponseDTO delteById(String id) throws Exception;


     List selectTreeByAppCode (String appCode)throws Exception;

     //JSONObject getResourceTree(String appCode)
}
