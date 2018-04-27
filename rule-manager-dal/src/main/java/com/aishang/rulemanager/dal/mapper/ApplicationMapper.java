package com.aishang.rulemanager.dal.mapper;

import com.aishang.rulemanager.dal.model.Application;
import com.aishang.rulemanager.dal.model.ApplicationExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ApplicationMapper {

    List<Application> queryAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    long countByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int deleteByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int insert(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int insertSelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    List<Application> selectByExample(ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    Application selectByPrimaryKey(String code);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Application record, @Param("example") ApplicationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Application record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Application record);
}