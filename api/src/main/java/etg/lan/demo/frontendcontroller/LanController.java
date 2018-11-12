package etg.lan.demo.frontendcontroller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import etg.lan.demo.core.BaseController;
import etg.lan.demo.entity.SysLanDefine;
import etg.lan.demo.service.SysLanDefineService;
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
@Api(tags = "多语言接口")
@RequestMapping("/frontend/v1/lan")
public class LanController extends BaseController {

    @Autowired
    SysLanDefineService sysLanDefineService;

    @ApiOperation("所有的语种列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public Result<List<SysLanDefine>> getLanList(Boolean isUser){
        EntityWrapper<SysLanDefine> wrapper = new EntityWrapper<>();
        if(isUser != null)
            if(isUser)
            wrapper.eq("used",true);
        else
            wrapper.ne("used",true);

        List<SysLanDefine> sysLanDefineList = sysLanDefineService.selectList(wrapper);
        return ResultGenerator.genSuccessResult(sysLanDefineList);
    }

//     哪些列可以配置
//3.配置了哪些列





}
