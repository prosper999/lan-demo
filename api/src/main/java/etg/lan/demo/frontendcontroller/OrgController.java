package etg.lan.demo.frontendcontroller;

import etg.lan.demo.core.BaseController;
import etg.lan.demo.entity.SysOrg;
import etg.lan.demo.service.LanDecorator;
import etg.lan.demo.service.SysOrgService;
import etg.result.Result;
import etg.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(tags = "组织架构")
@RequestMapping("/frontend/v1/org")
public class OrgController extends BaseController {

    @Autowired
    SysOrgService sysOrgService;
    @Autowired
    LanDecorator lanDecorator;

//    @ApiOperation(value = "获取组织架构列表")
    @RequestMapping(value = "/query",method = RequestMethod.GET)
    public Result<List<SysOrg>> query(String lan){
        List<SysOrg> sysOrgList = sysOrgService.selectList(null);
        lanDecorator.filter(sysOrgList,lan);
        return ResultGenerator.genSuccessResult(sysOrgList);
    }

}
