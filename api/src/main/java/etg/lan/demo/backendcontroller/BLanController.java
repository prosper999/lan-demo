package etg.lan.demo.backendcontroller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import etg.lan.demo.core.BaseController;
import etg.lan.demo.entity.SysLanBasic;
import etg.lan.demo.entity.SysLanDefine;
import etg.lan.demo.service.SysLanBasicService;
import etg.lan.demo.service.SysLanDefineService;
import etg.result.Result;
import etg.result.ResultCode;
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
@RequestMapping("/backend/v1/lan")
public class BLanController extends BaseController {

    @Autowired
    SysLanDefineService sysLanDefineService;
    @Autowired
    SysLanBasicService sysLanBasicService;

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

    @ApiOperation("应用或者取消一种新的语言")
    @RequestMapping(value = "/useLan", method = RequestMethod.POST)
    public Result useLan(String id, Boolean isUsed) {
        if (id == null)
            return ResultGenerator.genFailedResult("id必须填写");
        if (isUsed == null)
            return ResultGenerator.genFailedResult("isUsed必须填写");

        EntityWrapper<SysLanDefine> wrapper = new EntityWrapper<>();
        wrapper.eq("id", id);
        SysLanDefine sysLanDefine = sysLanDefineService.selectOne(wrapper);
        if (sysLanDefine == null)
            return ResultGenerator.genFailedResult("不存在的语言");
        if (isUsed.equals(sysLanDefine.getUsed())) {
            return new Result(ResultCode.SUCCESS, "不需要设置", null);
        }
        sysLanDefine.setUsed(isUsed);
        sysLanDefineService.updateById(sysLanDefine);
        return new Result(ResultCode.SUCCESS, "操作成功", null);
    }

    @ApiOperation("获取所有的多语言的字段列表")
    @RequestMapping(value = "/basicList",method = RequestMethod.GET)
    public Result<List<SysLanBasic>> getBasicList(Boolean isUser){
        EntityWrapper<SysLanBasic> wrapper = new EntityWrapper<SysLanBasic>();
        if(isUser != null)
            if(isUser)
                wrapper.eq("used",true);
            else
                wrapper.ne("used",true);

        List<SysLanBasic> sysLanBasicList = sysLanBasicService.selectList(wrapper);
        return ResultGenerator.genSuccessResult(sysLanBasicList);
    }

    @ApiOperation("应用指定的字段为多语言，或者取消多语言的字段")
    @RequestMapping(value = "/useLanBasic", method = RequestMethod.POST)
    public Result useLanBasic(String id, Boolean isUsed) {
        if (id == null)
            return ResultGenerator.genFailedResult("id必须填写");
        if (isUsed == null)
            return ResultGenerator.genFailedResult("isUsed必须填写");

        EntityWrapper<SysLanBasic> wrapper = new EntityWrapper<SysLanBasic>();
        wrapper.eq("id", id);
        SysLanBasic sysLanBasic = sysLanBasicService.selectOne(wrapper);
        if (sysLanBasic == null)
            return ResultGenerator.genFailedResult("查无数据");
        if (isUsed.equals(sysLanBasic.getUsed())) {
            return new Result(ResultCode.SUCCESS, "不需要设置", null);
        }
        sysLanBasic.setUsed(isUsed);
        sysLanBasicService.updateById(sysLanBasic);
        return new Result(ResultCode.SUCCESS, "操作成功", null);
    }


}
