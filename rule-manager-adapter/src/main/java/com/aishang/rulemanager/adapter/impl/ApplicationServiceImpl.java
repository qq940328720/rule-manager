package com.aishang.rulemanager.adapter.impl;

import com.aishang.rulemanager.common.UniqueCodeGenerator;
import com.aishang.rulemanager.common.inrerface.Logs;
import com.aishang.rulemanager.dal.mapper.ApplicationMapper;
import com.aishang.rulemanager.dal.model.Application;
import com.aishang.rulemanager.facade.dto.request.app.AppEnableRequestDTO;
import com.aishang.rulemanager.facade.dto.request.app.ApplicationRequestDTO;
import com.aishang.rulemanager.facade.dto.request.base.BaseRequestParameters;
import com.aishang.rulemanager.facade.dto.response.app.ApplicationResponseDTO;
import com.aishang.rulemanager.facade.dto.response.app.GetAppResponseDTO;
import com.aishang.rulemanager.facade.dto.info.app.ApplicationInfo;
import com.aishang.rulemanager.facade.service.IApplicationService;
import com.aishang.rulemanager.facade.service.base.impl.BaseServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

////////////////////////////////////////////////////////////////////
//                          _ooOoo_                               //
//                         o8888888o                              //
//                         88" . "88                              //
//                         (| ^_^ |)                              //
//                         O\  =  /O                              //
//                      ____/`---'\____                           //
//                    .'  \\|     |//  `.                         //
//                   /  \\|||  :  |||//  \                        //
//                  /  _||||| -:- |||||-  \                       //
//                  |   | \\\  -  /// |   |                       //
//                  | \_|  ''\---/''  |   |                       //
//                  \  .-\__  `-`  ___/-. /                       //
//                ___`. .'  /--.--\  `. . ___                     //
//              ."" '<  `.___\_<|>_/___.'  >'"".                  //
//            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
//            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
//      ========`-.____`-.___\_____/___.-`____.-'========         //
//                           `=---='                              //
//      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
//         佛祖保佑       永无BUG     永不修改                       //
////////////////////////////////////////////////////////////////////

@Service
@Transactional(rollbackFor = Exception.class)
public class ApplicationServiceImpl extends BaseServiceImpl<ApplicationRequestDTO, ApplicationResponseDTO, Integer> implements IApplicationService {

    @Autowired
    private ApplicationMapper applicationMapper;

    /**
     * 一次性查询出所有子系统，按照最后一次更新时间倒序
     *
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public ApplicationResponseDTO queryAll() throws Exception {
        ApplicationResponseDTO response = new ApplicationResponseDTO();
        List<Application> list = applicationMapper.queryAll();
        if (list.size() > 0) {
            List<ApplicationInfo> ApplicationInfolist = new ArrayList<ApplicationInfo>();
            for (Application app : list) {
                ApplicationInfo appInfo = new ApplicationInfo();
                BeanUtils.copyProperties(app, appInfo);
                ApplicationInfolist.add(appInfo);
            }
            response.setList(ApplicationInfolist);
            return response;

            /*Application application = list.get(0);
            return new ApplicationResponseDTO(application.getCode(),application.getName(),application.getUrl(),application.getCreatedAt(),application.getUpdatedAt(),application.getEnabled());*/
        }
        return null;
    }

    /**
     * 点击【新增】按钮，弹出新增页面。填写【系统名称（string类型）】和【URL链接（string类型）】字段，并点击【确定】按钮保存。
     * 子系统对象还包括下列字段：【子系统唯一编号（系统自动生成）】，【创建时间（系统自动生成）】，【最近一次更新时间（系统自动生成）】，
     * 【状态（默认为正常）】，【是否删除（默认为否）】。如果数据库中存在相同（各字段的值均一致）记录则更新，否则新增，并返回保存结果。
     * 如果新增成功则关闭新增页面，否则在新增页面给用户提示。
     *
     * @param requestDTO
     * @return
     * @throws Exception
     */
    @Logs
    @Override
    public Boolean insertApplication(ApplicationRequestDTO requestDTO) throws Exception {
        Application application = new Application();
//        Application primaryKey = applicationMapper.selectByPrimaryKey(code);
        //新增
        String appCode = UniqueCodeGenerator.generateAppCode();//唯一编号
        application.setCode(appCode);
        application.setName(requestDTO.getName());
        application.setUrl(requestDTO.getUrl());
        application.setCreatedAt(System.currentTimeMillis());
        application.setUpdatedAt(System.currentTimeMillis());
        application.setEnabled(true);
        int i = applicationMapper.insertSelective(application);
        if(i>0){
            return true;
        }
        return false;
    }

    /**
     * 根据code查询
     * @param code
     * @return
     * @throws Exception
     */
    @Override
    @Transactional(readOnly = true,rollbackFor = Exception.class)
    public GetAppResponseDTO getApplicationById(String code) throws Exception {
        GetAppResponseDTO responseDTO = new GetAppResponseDTO();
        ApplicationInfo info = new ApplicationInfo();
        Application applicationPrimaryKey = applicationMapper.selectByPrimaryKey(code);
        if(null == applicationPrimaryKey){
            return null;
        }
        BeanUtils.copyProperties(applicationPrimaryKey, info);
        responseDTO.setAppInfo(info);
        return responseDTO;
    }

    /**
     * 修改
     * @param requestDTO
     * @return
     * @throws Exception
     */
    @Logs
    @Override
    public Boolean updApplication(ApplicationRequestDTO requestDTO,String code) throws Exception {
        Application application = new Application();
        Application primaryKey = applicationMapper.selectByPrimaryKey(code);
        if(null == primaryKey){
            return false;
        }
        application.setCode(code);
        application.setName(requestDTO.getName());
        application.setUrl(requestDTO.getUrl());
        application.setUpdatedAt(System.currentTimeMillis());
        applicationMapper.updateByPrimaryKeySelective(application);
        return true;
    }

    /**
     * 1启用/0禁用
     * @param requestDTO
     * @return
     * @throws Exception
     */
    @Logs
    @Override
    public Boolean uptAvailable(String code,AppEnableRequestDTO requestDTO) throws Exception {
        Application application = new Application();
        application.setCode(code);
        application.setUpdatedAt(System.currentTimeMillis());
        application.setEnabled(requestDTO.getEnabled());
        applicationMapper.updateByPrimaryKeySelective(application);
        return true;
    }

    /**
     * 删除(批量删除)
     * @param code
     * @return
     * @throws Exception
     */
    @Logs
    @Override
    public void deleteApp(String code) throws Exception {
        String[] codes = code.split(",");
        for(int i = 0; i < codes.length; i++){
            applicationMapper.deleteByPrimaryKey(codes[i]);
        }
    }

    @Override
    public List<? extends ApplicationResponseDTO> selectAll(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public Long selectCount(BaseRequestParameters baseRequestParameters) throws Exception {
        return null;
    }

    @Override
    public ApplicationResponseDTO selectById(Integer id) throws Exception {
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
    public ApplicationResponseDTO create(ApplicationRequestDTO requestDTO) throws Exception {
        return null;
    }

    @Override
    public ApplicationResponseDTO update(ApplicationRequestDTO requestDTO) throws Exception {
        return null;
    }

}

