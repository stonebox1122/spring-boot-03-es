package com.stone.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot默认支持两张技术来和ES交互
 * 1.Jest（默认不生效，需要导入jest工具包io.searchbox.client.JestClient）
 * 2.SpringData ElasticSearch[ES版本有可能不合适]
 *      1.版本适配说明：如果版本不适配，升级SpringBoot版本或者安装对应版本的ES
 */
@SpringBootApplication
public class SpringBoot03EsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot03EsApplication.class, args);
    }

}
