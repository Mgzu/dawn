package org.dawn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.dawn.mapper")
public class DawnApplication {

	public static void main(String[] args) {
		SpringApplication.run(DawnApplication.class, args);
	}
}
