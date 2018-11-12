package etg.lan.demo.frontendcontroller;

import etg.lan.demo.core.BaseController;
import etg.result.Result;
import etg.result.ResultGenerator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/test")
@Api(tags = "Main入口")
public class TestController extends BaseController {

    @ApiOperation("启动时自动跳转至swaggerUI页面")
    @RequestMapping(value = "", method = RequestMethod.GET)
    public Object index() {
//        return "Hello, This is mutiple language demo.";
        return "redirect:doc.html";
    }

    @ApiOperation(value = "Service层的多语言",notes = "根据语言种类来获取指定编码的信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "lan", value = "语种标志", defaultValue = "en-US", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "信息编码", defaultValue = "welcome", required = true, dataType = "string", paramType = "query")
    })
    @RequestMapping(value = "/test_i18n", method = RequestMethod.GET)
    @ResponseBody
    public Result<String> test(String lan, String code) {
        return ResultGenerator.genSuccessResult(getMessage(lan, code));
    }

}
