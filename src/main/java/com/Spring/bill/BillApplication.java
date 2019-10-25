package com.Spring.bill;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BillApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(BillApplication.class);
        springApplication.setBannerMode(Banner.Mode.CONSOLE);
		SpringApplication.run(BillApplication.class, args);
	}

}
