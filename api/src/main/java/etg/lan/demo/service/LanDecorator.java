package etg.lan.demo.service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.entity.TableFieldInfo;
import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.toolkit.TableInfoHelper;
import etg.lan.demo.entity.SysLanBasic;
import etg.lan.demo.entity.SysOrg;
import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.ReflectorFactory;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LanDecorator {

    @Autowired
    SysLanBasicService sysLanBasicService;

    private static final ObjectFactory DEFAULT_OBJECT_FACTORY = new DefaultObjectFactory();
    /**
     * 默认ObjectWrapperFactory
     */
    private static final ObjectWrapperFactory DEFAULT_OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();
    /**
     * 默认ReflectorFactory
     */
    private static final ReflectorFactory DEFAULT_REFLECTOR_FACTORY = new DefaultReflectorFactory();

    public void filter(List<SysOrg> list, String lan) {
        if (list == null || list.size() == 0) return;
        TableInfo tableInfo = TableInfoHelper.getTableInfo(list.get(0).getClass());
        String tableName = tableInfo.getTableName();
        List<TableFieldInfo> tableFieldInfoList = tableInfo.getFieldList();
        //根据表名，查找有哪些列是多语言的
        List<String> columnList = getLanColumnListByTableName(tableName);
        //遍历数据记录
        for (SysOrg org : list) {
            //遍历每一列
            for (TableFieldInfo fieldInfo : tableFieldInfoList) {
                //判断这个列是否是多语言列
                if (columnList.contains(fieldInfo.getProperty())) {
                    //如果是多语言列，取出这个值
                    //取得该对象的值
                    MetaObject metaObject = MetaObject.forObject(org,
                            DEFAULT_OBJECT_FACTORY, DEFAULT_OBJECT_WRAPPER_FACTORY, DEFAULT_REFLECTOR_FACTORY);
                    String value = (String) metaObject.getValue(fieldInfo.getProperty());
//                    String value = org.getName();
                    try {
                        JSONObject jsonObject = JSONObject.parseObject(value);
                        if (jsonObject != null) {
                            String newValue = null;
                            if (jsonObject.containsKey(lan))
                                newValue = (String) jsonObject.get(lan);
                            else
                                newValue = (String) jsonObject.get("Default");
                            metaObject.setValue(fieldInfo.getProperty(),newValue);
//                            org.setName(newValue);
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
    }

    private List<String> getLanColumnListByTableName(String tableName) {
        List<String> columnList = new ArrayList<>();
        EntityWrapper<SysLanBasic> wrapper = new EntityWrapper<SysLanBasic>();
        wrapper.eq("table_name", tableName);
        wrapper.eq("used",true);
        List<SysLanBasic> sysLanBasicList = sysLanBasicService.selectList(wrapper);
        if (sysLanBasicList != null && sysLanBasicList.size() > 0) {
            columnList = sysLanBasicList.stream()
                    .map(SysLanBasic::getColumnName)
                    .collect(Collectors.toList());
        }
        return columnList;
    }

//    private Map<String,List<String>> getLanListByTableName(String tableName){
//        Map<String,List<String>> map = new HashMap<String, List<String>>();
//        EntityWrapper<SysLanBasic> wrapper = new EntityWrapper<SysLanBasic>();
//        wrapper.eq("table_name",tableName);
//        List<SysLanBasic> sysLanBasicList = sysLanBasicService.selectList(wrapper);
//        if(sysLanBasicList != null && sysLanBasicList.size() > 0){
//            for(SysLanBasic sysLanBasic:sysLanBasicList){
//                EntityWrapper<SysLanConfig> wrapper1 = new EntityWrapper<>();
//                wrapper1.eq("id",sysLanBasic.getId());
//                List<SysLanConfig> sysLanConfigList = sysLanConfigService.selectList(wrapper1);
//                if(sysLanConfigList != null && sysLanConfigList.size() > 0){
//                    List<String> list = sysLanConfigList.stream()
//                            .map(SysLanConfig::getLan)
//                            .collect(Collectors.toList());
//                    map.put(sysLanBasic.getColumnName(),list);
//                }
//            }
//        }
//        return  map;
//    }


}
