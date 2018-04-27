package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.common.enums.LoginTypeEnum;
import com.aishang.rulemanager.dal.mapper.LoginLogMapper;
import com.aishang.rulemanager.dal.model.LoginLog;
import com.aishang.rulemanager.dal.model.LoginLogExample;
import com.aishang.rulemanager.facade.dto.request.Log.LoginLogPaginationRequestDTO;
import com.aishang.rulemanager.facade.dto.request.Log.LoginLogRequestDTO;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.response.Log.LoginLogResponseDTO;
import com.aishang.rulemanager.facade.service.ILoginLogService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class LoginLogServiceImpl extends BaseServiceImpl<LoginLogRequestDTO, LoginLogResponseDTO, Integer> implements ILoginLogService {
    private static final Logger logger = LoggerFactory.getLogger(LoginLogServiceImpl.class);
    @Autowired
    LoginLogMapper loginLogMapper;

    @Override
    public LoginLogResponseDTO loginInsert(LoginLogRequestDTO request) {
        logger.info("保存登录日志开始:{}", request);
        LoginLog loginLog = new LoginLog();
        BeanUtils.copyProperties(request, loginLog);
        loginLogMapper.insert(loginLog);
        logger.info("保存登录日志结束:{}", request);
        return new LoginLogResponseDTO();
    }

    @Override
    public List<? extends LoginLogResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        LoginLogPaginationRequestDTO request = (LoginLogPaginationRequestDTO) baseRequestParameters;
        LoginLogExample loginLogExample = new LoginLogExample();
        request.setOffset(request.getOffset() <= 0 ? 1 : request.getOffset());
        request.setOffset((request.getOffset() - 1) * request.getLimit());
        LoginLogExample.Criteria criteria = loginLogExample.createCriteria();
        if (null != request.getUserName() && !request.getUserName().isEmpty()) {
            criteria.andUsernameLike("%" + request.getUserName() + "%");
        }
        if (null != request.getRealName() && !request.getRealName().isEmpty()) {
            criteria.andRealNameLike("%" + request.getRealName() + "%");
        }
        if (null != request.getLogenum()) {
            criteria.andTypeEqualTo(request.getLogenum().getCode());
        }
        if (null != request.getStart() && null != request.getEnd()) {
            criteria.andLoginAtBetween(request.getStart(), request.getEnd());
        }
        loginLogExample.setOffset(request.getOffset());
        loginLogExample.setLimit(request.getLimit());
        List<LoginLog> loginLogs = loginLogMapper.selectByExample(loginLogExample);
        List<LoginLogResponseDTO> responses = new ArrayList<>();
        for (LoginLog login : loginLogs) {
            LoginLogResponseDTO response = new LoginLogResponseDTO();
            response.setId(login.getId());
            response.setIpaddr(login.getIpaddr());
            response.setLoginAt(login.getLoginAt());
            response.setRealName(login.getRealName());
            response.setUsername(login.getUsername());
            response.setType(LoginTypeEnum.getLogenum(login.getType()));
            responses.add(response);
        }
        return responses;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        LoginLogPaginationRequestDTO request = (LoginLogPaginationRequestDTO) baseRequestParameters;
        LoginLogExample loginLogExample = new LoginLogExample();
        LoginLogExample.Criteria criteria = loginLogExample.createCriteria();
        if (null != request.getUserName() && !request.getUserName().isEmpty()) {
            criteria.andUsernameLike("%" + request.getUserName() + "%");
        }
        if (null != request.getRealName() && !request.getRealName().isEmpty()) {
            criteria.andRealNameLike("%" + request.getRealName() + "%");
        }
        if (null != request.getLogenum()) {
            criteria.andTypeEqualTo(request.getLogenum().getCode());
        }
        if (null != request.getStart() && null != request.getEnd()) {
            criteria.andLoginAtBetween(request.getStart(), request.getEnd());
        }
        long count = loginLogMapper.countByExample(loginLogExample);
        return count;
    }

    @Override
    public LoginLogResponseDTO selectById(Integer id) throws Exception {
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
    public LoginLogResponseDTO create(LoginLogRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public LoginLogResponseDTO update(LoginLogRequestDTO requestDTO) throws Exception {
        return null;
    }
}
