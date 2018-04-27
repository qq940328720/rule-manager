package com.aishang.rulemanager.facade.service;

import com.aishang.rulemanager.facade.dto.request.admin.AdminBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.response.admin.AdminBaseResponseDTO;
import com.aishang.rulemanager.facade.service.base.IBaseService;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IAdminService extends IBaseService<AdminBaseRequestDTO, AdminBaseResponseDTO, Integer>, UserDetailsService {

}
