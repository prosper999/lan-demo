package etg.lan.demo.service;

import com.baomidou.mybatisplus.service.IService;
import etg.lan.demo.entity.SysOrg;

import java.util.List;

public interface SysOrgService extends IService<SysOrg> {
    List<SysOrg> getList(String lan);
    SysOrg getObject(String lan);
}
