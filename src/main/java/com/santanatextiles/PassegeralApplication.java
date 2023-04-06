package com.santanatextiles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.santanatextiles.domain.Usuario;

@SpringBootApplication
public class PassegeralApplication {

	public final static String _EMPRESA="01";
	public final static Long _LOCALIZACAO=Long.valueOf(1);
	public final static Usuario _USUARIO= new Usuario();
	
	public static void main(String[] args) {
		SpringApplication.run(PassegeralApplication.class, args);
	}
	
}
