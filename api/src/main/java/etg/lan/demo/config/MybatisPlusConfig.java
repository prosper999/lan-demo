package etg.lan.demo.config;

import com.baomidou.mybatisplus.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version: V1.0
 * @author: fendo
 * @className: MybatisPlusConfig
 * @packageName: com.fendo.mybatis.plus.config
 * @description: Mybatis-plus配置类
 * @data: 2018-01-12 23:13
 **/
@Configuration
@MapperScan("etg.estate.mapper*")
public class MybatisPlusConfig {
//    /**
//     * mybatis-plus SQL执行效率插件【生产环境可以关闭】
//     */
//    @Bean
//    public PerformanceInterceptor performanceInterceptor() {
//        return new PerformanceInterceptor();
//    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
