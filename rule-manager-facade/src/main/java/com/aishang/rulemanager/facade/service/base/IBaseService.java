package com.aishang.rulemanager.facade.service.base;



import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;

import java.util.List;

/**
 * Created by neeke on 17-9-8.
 * 定义通用接口方法，所有异常向外抛出。
 */
public interface IBaseService<DTO4REQ, DTO4REP, KEY> {

    /**
     * 根据条件查询
     *
     * @param baseRequestParameters 查询条件
     * @return 结果集
     * @throws Exception
     */
    List<? extends DTO4REP> selectAll(BaseRequestParameters baseRequestParameters) throws Exception;

    /**
     * 根据条件查询总记录数
     *
     * @param baseRequestParameters
     * @return 记录数
     * @throws Exception
     */
    Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception;

    /**
     * 根据主键查询
     *
     * @param id 数据库主键
     * @return 对象
     * @throws Exception
     */
    DTO4REP selectById(KEY id) throws Exception;

    /**
     * 根据主键删除
     *
     * @param id 主键
     * @throws Exception
     */
    void deleteById(KEY id) throws Exception;

    /**
     * 根据主键批量删除
     *
     * @param id 主键列表
     * @throws Exception
     */
    void deleteById(KEY... id) throws Exception;

    /**
     * 根据主键批量删除
     *
     * @param idList 主键列表
     * @throws Exception
     */
    void deleteById(List<KEY> idList) throws Exception;

    /**
     * 创建新纪录
     *
     * @param dto4REQ 请求参数
     * @return 创建结果
     * @throws Exception
     */
    DTO4REP create(DTO4REQ dto4REQ) throws Exception;

    /**
     * 更新记录
     *
     * @param dto4REQ 请求参数
     * @return 更新结果
     * @throws Exception
     */
    DTO4REP update(DTO4REQ dto4REQ) throws Exception;
}
