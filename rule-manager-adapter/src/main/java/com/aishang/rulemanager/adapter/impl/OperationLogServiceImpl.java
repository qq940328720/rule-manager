package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.dal.mapper.OperationLogMapper;
import com.aishang.rulemanager.dal.model.OperationLog;
import com.aishang.rulemanager.dal.model.OperationLogExample;
import com.aishang.rulemanager.facade.dto.info.Log.OperationLogInfoDTO;
import com.aishang.rulemanager.facade.dto.request.Log.OperationLogPaginationRequestDTO;
import com.aishang.rulemanager.facade.dto.request.Log.OperationLogRequestDTO;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.response.Log.OperationLogResponseDTO;
import com.aishang.rulemanager.facade.service.IOperationLogService;
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
public class OperationLogServiceImpl extends BaseServiceImpl<OperationLogRequestDTO, OperationLogInfoDTO, Integer> implements IOperationLogService {
    private static final Logger logger = LoggerFactory.getLogger(OperationLogServiceImpl.class);
    @Autowired
    OperationLogMapper operationLogMapper;

    @Override
    public OperationLogResponseDTO operationLogIntsert(OperationLogRequestDTO request) throws Exception {
        logger.info("保存操作日志开始{}", request);
        OperationLog operationLog = new OperationLog();
        BeanUtils.copyProperties(request, operationLog);
        operationLogMapper.insert(operationLog);
        logger.info("保存操作日志结束{}", request);
        return new OperationLogResponseDTO();
    }


    @Override
    public List<? extends OperationLogInfoDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        OperationLogPaginationRequestDTO request = (OperationLogPaginationRequestDTO) baseRequestParameters;
        OperationLogExample operationLogExample = new OperationLogExample();
        request.setOffset(request.getOffset() <= 0 ? 1 : request.getOffset());
        request.setOffset((request.getOffset() - 1) * request.getLimit());
        OperationLogExample.Criteria criteria = operationLogExample.createCriteria();
        if (null != request.getName() && !request.getName().isEmpty()) {
            criteria.andMethodLike("%" + request.getName() + "%");
        }
        if (null != request.getOperator() && !request.getOperator().isEmpty()) {
            criteria.andOperatorEqualTo(request.getOperator());
        }
        if (null != request.getStart() && null != request.getEnd()) {
            criteria.andOperatedAtBetween(request.getStart(), request.getEnd());
        }
        operationLogExample.setOffset(request.getOffset());
        operationLogExample.setLimit(request.getLimit());
        List<OperationLog> operationLogs = operationLogMapper.selectByExample(operationLogExample);
        List<OperationLogInfoDTO> operationLogInfos = new ArrayList<>();
        for (OperationLog operationLog : operationLogs) {
            OperationLogInfoDTO r = new OperationLogInfoDTO();
            BeanUtils.copyProperties(operationLog, r);
            operationLogInfos.add(r);
        }

        return operationLogInfos;
    }


    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        OperationLogPaginationRequestDTO request = (OperationLogPaginationRequestDTO) baseRequestParameters;
        OperationLogExample operationLogExample = new OperationLogExample();
        OperationLogExample.Criteria criteria = operationLogExample.createCriteria();
        if (null != request.getName() && !request.getName().isEmpty()) {
            criteria.andMethodLike("%" + request.getName() + "%");
        }
        if (null != request.getOperator() && !request.getOperator().isEmpty()) {
            criteria.andOperatorEqualTo(request.getOperator());
        }
        if (null != request.getStart() && null != request.getEnd()) {
            criteria.andOperatedAtBetween(request.getStart(), request.getEnd());
        }
        operationLogExample.setOffset(request.getOffset());
        operationLogExample.setLimit(request.getLimit());
        return operationLogMapper.countByExample(operationLogExample);
    }

    @Override
    public OperationLogInfoDTO selectById(Integer id) throws Exception {
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
    public OperationLogInfoDTO create(OperationLogRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public OperationLogInfoDTO update(OperationLogRequestDTO requestDTO) throws Exception {
        return null;
    }
}
