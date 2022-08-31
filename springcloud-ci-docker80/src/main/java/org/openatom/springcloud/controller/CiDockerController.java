package org.openatom.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.openatom.springcloud.entities.CommonResult;
import org.openatom.springcloud.entities.Payment;


/**
 * 用于测试8003这个节点中的服务熔断、服务降级功能
 */
@RestController
public class CiDockerController {


    @GetMapping("/ci/docker")
    public CommonResult<String> create(Payment payment) {
        return new CommonResult(200,"持续集成","测试持续集成到Docker");
    }

}
