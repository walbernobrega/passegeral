package com.santanatextiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santanatextiles.domain.Usuario;

@SpringBootApplication
public class PassegeralApplication {

	public static String _EMPRESA="01";
	public static Long _LOCALIZACAO=Long.valueOf(1);
	public static Usuario _USUARIO= new Usuario();
	
	public static void main(String[] args) {
		SpringApplication.run(PassegeralApplication.class, args);
	}
	
}
