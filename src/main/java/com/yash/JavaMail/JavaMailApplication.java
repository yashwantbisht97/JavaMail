package com.yash.JavaMail;

import com.yash.JavaMail.service.IJavaMailService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JavaMailApplication {

	public static void main(String[] args) {



		ConfigurableApplicationContext ctx =SpringApplication.run(JavaMailApplication.class, args);
// get Service class object ref
		IJavaMailService mail= ctx.getBean("mailService", IJavaMailService.class);
//invoke method
		try {
			String msg = mail.javaMail (new String[]{"geeks79062@gmail.com"});
			System.out.println(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}

//close container
		ctx.close();

	}

}
