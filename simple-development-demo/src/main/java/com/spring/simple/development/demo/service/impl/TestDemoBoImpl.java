package com.spring.simple.development.demo.service.impl;

import com.alibaba.lava.base.AbstractLavaBoImpl;
import com.alibaba.lava.privilege.PrivilegeInfo;
import com.spring.simple.development.core.annotation.base.HasPermissions;
import com.spring.simple.development.core.annotation.base.IsApiService;
import com.spring.simple.development.core.annotation.base.NoApiMethod;
import com.spring.simple.development.core.annotation.base.ValidHandler;
import com.spring.simple.development.core.annotation.base.swagger.Api;
import com.spring.simple.development.core.annotation.base.swagger.ApiImplicitParam;
import com.spring.simple.development.core.annotation.base.swagger.ApiOperation;
import com.spring.simple.development.core.component.alertsdk.SimpleAlertExecutor;
import com.spring.simple.development.core.component.mvc.BaseSupport;
import com.spring.simple.development.demo.mapper.DemoDoMapperExt;
import com.spring.simple.development.demo.model.DemoDo;
import com.spring.simple.development.demo.model.DemoDoExample;
import com.spring.simple.development.demo.service.TestDemoBo;
import com.spring.simple.development.demo.vo.DemoVo;
import com.spring.simple.development.support.exception.GlobalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import static com.spring.simple.development.support.exception.ResponseCode.RES_PARAM_IS_EMPTY;

@Service
@IsApiService(isLogin = false)
@Api(tags = "用户相关11111")
public class TestDemoBoImpl extends AbstractLavaBoImpl<DemoDo, DemoDoMapperExt, DemoDoExample> implements TestDemoBo {

    @Autowired
    private BaseSupport baseSupport;
    @Autowired
    PrivilegeInfo privilegeInfo;

    @Autowired
    @NoApiMethod
    public void setBaseMapper(DemoDoMapperExt mapper) {
        setMapper(mapper);
    }

    @Override
    @CacheEvict(value = "test", key = "#demoVo.id", condition = "#demoVo != null")
    @ApiOperation(value = "插入", notes = "插入一亿个订单")
    @ApiImplicitParam(name = "demoVo", description = "用户vo")
    public int insertData(DemoVo demoVo) {
        DemoDo demoDo = baseSupport.objectCopy(demoVo, DemoDo.class);
        return insert(demoDo);
    }

    @Override
    @CacheEvict(value = "test", key = "#id", condition = "#id != null")
    @ApiOperation(value = "删除", notes = "删除一亿个订单")
    @ValidHandler(key = "demoVo", value = DemoVo.class, isReqBody = false)
    public int deleteData(String id) {
        return delete(Long.valueOf(id));
    }

    @Override
    @Cacheable(value = "test", key = "#id", condition = "#id != null",unless="#result == null")
    @ApiOperation(value = "查询", notes = "查询一亿个订单")
    @ApiImplicitParam(name = "demoVo", description = "用户vo", resultDataType = DemoVo.class)
    public DemoVo getData(String id) {
        System.out.println(privilegeInfo);
        DemoDo demoDo = selectByPrimaryKey(Long.valueOf(id));
        return baseSupport.objectCopy(demoDo, DemoVo.class);
    }
}