package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.dal.mapper.AdminMapper;
import com.aishang.rulemanager.dal.model.Admin;
import com.aishang.rulemanager.dal.model.AdminExample;
import com.aishang.rulemanager.facade.dto.request.admin.AdminBaseRequestDTO;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.response.admin.AdminBaseResponseDTO;
import com.aishang.rulemanager.facade.service.IAdminService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Collection;
import java.util.List;


@Service
@Transactional(rollbackFor = Exception.class)
public class AdminServiceImpl extends BaseServiceImpl<AdminBaseRequestDTO, AdminBaseResponseDTO, Integer> implements IAdminService  {

    @Autowired
    private AdminMapper adminMapper;


    @Override
    public List<? extends AdminBaseResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public AdminBaseResponseDTO selectById(Integer id) throws Exception {
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
    public AdminBaseResponseDTO create(AdminBaseRequestDTO adminBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public AdminBaseResponseDTO update(AdminBaseRequestDTO adminBaseRequestDTO) throws Exception {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        AdminExample adminExample = new AdminExample();
        adminExample.createCriteria().andUsernameEqualTo(s);
        List<Admin> adminList = adminMapper.selectByExample(adminExample);

        if (adminList.size() > 0){
            Admin admin = adminList.get(0);
            return new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return null;
                }

                @Override
                public String getPassword() {
                    return admin.getPassword();
                }

                @Override
                public String getUsername() {
                    return admin.getUsername();
                }

                @Override
                public boolean isAccountNonExpired() {
                    return admin.getAccountNonExpired();
                }

                @Override
                public boolean isAccountNonLocked() {
                    return admin.getAccountNonLocked();
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return admin.getCredentialsNonExpired();
                }

                @Override
                public boolean isEnabled() {
                    return admin.getEnabled();
                }
            };
        }
        return null;
    }
}
