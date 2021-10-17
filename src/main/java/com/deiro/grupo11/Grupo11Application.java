package com.deiro.grupo11;

import com.deiro.grupo11.service.MotorbikeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@EntityScan(basePackages = {"com.jalinet.grupo11.com.jalinet.grupo11.entities"})
@SpringBootApplication

//@ComponentScan(basePackageClasses = MotorbikeController.class)
public class Grupo11Application {

	public static void main(String[] args) {
		SpringApplication.run(Grupo11Application.class, args);
	}

}
