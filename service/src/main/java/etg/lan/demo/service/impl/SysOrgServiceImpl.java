package etg.lan.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import etg.lan.demo.entity.SysOrg;
import etg.lan.demo.mapper.SysOrgMapper;
import etg.lan.demo.service.SysOrgService;
import org.springframework.stereotype.Service;

@Service
public class SysOrgServiceImpl extends ServiceImpl<SysOrgMapper,SysOrg> implements SysOrgService {
}
