package com.aishang.rulemanager.facade.service.base.impl;


import com.aishang.rulemanager.facade.service.base.IBaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by neeke on 17-9-9.
 */
public abstract class BaseServiceImpl<DTO4REQ, DTO4REP, KEY> implements IBaseService<DTO4REQ, DTO4REP, KEY> {

    protected final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
}
