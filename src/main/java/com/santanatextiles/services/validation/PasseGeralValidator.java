package com.santanatextiles.services.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.santanatextiles.dto.PasseGeralDTO;
import com.santanatextiles.repositories.PasseGeralRepository;
import com.santanatextiles.resources.exception.FieldMessage;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasseGeralValidator implements ConstraintValidator<PasseGeralValidation, PasseGeralDTO> {
	
	@Autowired
	private PasseGeralRepository repo;
	
	@Override
	public void initialize(PasseGeralValidation ann) {

	}

	@Override
	public boolean isValid(PasseGeralDTO objDTO, ConstraintValidatorContext context) {

		List<FieldMessage> list = new ArrayList<>();
		
		if (objDTO.getItensPasseDTO().isEmpty()) {
			list.add(new FieldMessage("itensPasseDTO","Informe os Itens do Passe Geral"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();

	}

}
