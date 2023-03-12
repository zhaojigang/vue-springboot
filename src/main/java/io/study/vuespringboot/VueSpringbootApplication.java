package io.study.vuespringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

/**
 * 启动器
 *
 * @author zhaowang
 */
@EnableOpenApi
@SpringBootApplication
public class VueSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(VueSpringbootApplication.class, args);
    }

}
