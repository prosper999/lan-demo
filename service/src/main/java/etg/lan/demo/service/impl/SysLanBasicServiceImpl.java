package etg.lan.demo.service.impl;

import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.toolkit.ReflectionKit;
import com.baomidou.mybatisplus.toolkit.StringUtils;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import etg.lan.demo.entity.SysLanBasic;
import etg.lan.demo.mapper.SysLanBasicMapper;
import etg.lan.demo.service.SysLanBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysLanBasicServiceImpl extends ServiceImpl<SysLanBasicMapper,SysLanBasic> implements SysLanBasicService {

    @Autowired
    SysLanBasicMapper sysLanBasicMapper;

//    public void sdfsf(){
//        SysLanBasic entity = new SysLanBasic();
//        Class<?> cls = entity.getClass();
//        TableInfo tableInfo = TableInfoHelper.getTableInfo(cls);
//        tableInfo.getFieldList()
//        if (null != tableInfo && StringUtils.isNotEmpty(tableInfo.getKeyProperty())) {
//            Object idVal = ReflectionKit.getMethodValue(cls, entity, tableInfo.getKeyProperty());
//
//
//    }

}
