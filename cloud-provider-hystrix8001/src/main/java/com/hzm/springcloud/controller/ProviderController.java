package com.hzm.springcloud.controller;

import com.hzm.springcloud.entity.CommonResult;
import com.hzm.springcloud.service.ProviderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hzm
 * @version 1.0
 * @date 2020/7/14 9:38
 */
@RestController
@Slf4j
@RequestMapping("provider")
public class ProviderController {
    @Resource
    private ProviderService providerService;

    @GetMapping("ok")
    public CommonResult ok(){
        String ok = providerService.ok();
        return new CommonResult(200,"ok成功",ok);
    }

    @GetMapping("timeout")
    public CommonResult timeout(){
        String timeout = providerService.timeout();
        return new CommonResult(200,"timeout成功",timeout);
    }

}
