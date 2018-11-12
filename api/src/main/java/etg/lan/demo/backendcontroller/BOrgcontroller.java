package etg.lan.demo.backendcontroller;

import etg.lan.demo.entity.SysOrg;
import etg.lan.demo.service.LanDecorator;
import etg.lan.demo.service.SysOrgService;
import etg.result.Result;
import etg.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "组织架构接口")
@RequestMapping("/backend/v1/org")
public class BOrgcontroller {

    @Autowired
    SysOrgService sysOrgService;

    @ApiOperation(value = "获取组织架构列表")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Result<List<SysOrg>> query(){
        List<SysOrg> sysOrgList = sysOrgService.selectList(null);
        return ResultGenerator.genSuccessResult(sysOrgList);
    }

}
