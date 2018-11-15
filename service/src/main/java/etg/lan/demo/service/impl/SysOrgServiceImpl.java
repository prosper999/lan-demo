package etg.lan.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import etg.lan.demo.annotation.MutipleLanguage;
import etg.lan.demo.entity.SysOrg;
import etg.lan.demo.mapper.SysOrgMapper;
import etg.lan.demo.service.SysOrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper,SysOrg> implements SysOrgService {

    @Autowired
    SysOrgMapper sysOrgMapper;

    @MutipleLanguage(lanParameterName = "lan1")
    public List<SysOrg> getList(String lan1) {
        return sysOrgMapper.selectList(null);
    }

    @Override
    @MutipleLanguage(lanParameterName = "lan")
    public SysOrg getObject(String lan) {
        List<SysOrg> list = sysOrgMapper.selectList(null);
        if(list != null && list.size() > 0)
            return list.get(0);
        return null;
    }
}
