package com.aishang.rulemanager.facade.dto.response.user;

import com.aishang.rulemanager.facade.dto.info.user.UserInfoDTO;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Created by ylj on 18-3-6.
 */
public class UserInfoListRresponseDTO extends UserBaseResponseDTO {

    @ApiModelProperty(value = "总条数")
    private Integer total;

    @ApiModelProperty(value = "列表")
    private List<UserInfoDTO> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<UserInfoDTO> getList() {
        return list;
    }

    public void setList(List<UserInfoDTO> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "UserInfoListRresponseDTO{" +
                "total=" + total +
                ", list=" + list +
                "} " + super.toString();
    }
}
