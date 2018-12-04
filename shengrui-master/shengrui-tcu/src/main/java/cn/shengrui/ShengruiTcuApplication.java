package cn.shengrui;

import com.github.tobato.fastdfs.FdfsClientConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jmx.support.RegistrationPolicy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
@MapperScan("cn.shengrui.*.mapper")
@ComponentScan("cn.shengrui.*")
@EnableAutoConfiguration
@ImportResource(locations = {"classpath:mykaptcha.xml"})
@ServletComponentScan
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)// 解决jmx重复注册bean的问题
@Import(FdfsClientConfig.class)
@EnableSwagger2
@SpringBootApplication
public class ShengruiTcuApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShengruiTcuApplication.class, args);
	}
}
