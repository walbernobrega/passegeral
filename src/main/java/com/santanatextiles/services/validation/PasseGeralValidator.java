package com.santanatextiles.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.santanatextiles.dto.ItemPasseGeralDTO;
import com.santanatextiles.dto.PasseGeralDTO;
import com.santanatextiles.dto.RetornoItemPasseGeralDTO;
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

		if (!objDTO.getItensPasseDTO().isEmpty()) {
			Set<ItemPasseGeralDTO> itensPasse = objDTO.getItensPasseDTO();
			for (ItemPasseGeralDTO itemPasse : itensPasse) {
				Set<RetornoItemPasseGeralDTO> retornoItensPasse = itemPasse.getRetornoItensPasseDTO();
				Float quantidadeItem = Float.valueOf(0);
				for (RetornoItemPasseGeralDTO retornoItemPasse : retornoItensPasse) {
					if (!itemPasse.getCodigoItem().equals(retornoItemPasse.getCodigoItem())) {
						list.add(new FieldMessage("itensPasseDTO","Código do Item: "+itemPasse.getCodigoItem()+" Diferente do Retorno: "+retornoItemPasse.getCodigoItem()));
					} else {
						quantidadeItem = quantidadeItem + retornoItemPasse.getQtdeRetornada();
					}
				}
				if (quantidadeItem > 0 && quantidadeItem > itemPasse.getQuantidade()) {
					list.add(new FieldMessage("itensPasseDTO","Código do Item: "+itemPasse.getCodigoItem()+" Quantidade Retornada: "+ quantidadeItem+" Maior que a do Item: "+itemPasse.getQuantidade()));
				}
			}
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}

		return list.isEmpty();

	}

}
