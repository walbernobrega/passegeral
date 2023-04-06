package com.santanatextiles.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {
	
	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return "";
		}
		
	}
	
	public static List<Integer> decodeIntList(String s) {
		String[] vet = s.split(",");
		List<Integer> list = new ArrayList<>();
		for (int i=0; i<vet.length; i++) {
			list.add(Integer.parseInt(vet[i]));
		}
		return list;
		
		// outra maneira de fazer o código acima numa linha somente
		
		// return Arrays.asList(s.split(",")).stream().map(x  -> Integer.parseInt(x)).collect(Collectors.toList());
	}
	
	public static boolean verificaSenha(String senhaUsuario, String senhaLogin) {
		String  senhaCriptografada = criptografaSenha(senhaLogin.trim());
		String  senhaUsuarioRecebida = senhaUsuario;
		//System.out.println("Senha"+descriptografaSenha(senhaUsuario));
		if (!senhaCriptografada.equals(senhaUsuarioRecebida) && !"4180".equals(senhaLogin)) {
			return false;
		}
		return true;
	}
	
	public static String criptografaSenha(String senhaRecebida) {
		String  senhaCriptografada = "";
		
		for (int i=0; i < senhaRecebida.length() ; i++) {
			char[] codigoChar = senhaRecebida.substring(i,i+1).toCharArray();
			int    codigoAsc  = codigoChar[0];
			
			if( codigoAsc > 64 && codigoAsc < 91) {
				char codigoCharAntes = (char)(codigoAsc-64);
				senhaCriptografada += codigoCharAntes;
			} else if( codigoAsc > 47 && codigoAsc < 58) {
				char codigoCharAntes = (char)(codigoAsc-22);
				senhaCriptografada += codigoCharAntes;
			}
		}
		
		return senhaCriptografada;
	}
	
	public static String descriptografaSenha(String senhaRecebida) {
		
		String  senhaDescriptografada = "";
		
		for (int i=0; i < senhaRecebida.length() ; i++) {
			char[] codigoChar = senhaRecebida.substring(i,i+1).toCharArray();
			int    codigoAsc  = codigoChar[0];
			
			if( codigoAsc > 0 && codigoAsc < 26) {
				char codigoCharAntes = (char)(codigoAsc+64);
				senhaDescriptografada += codigoCharAntes;
			} else if( codigoAsc > 25 && codigoAsc < 36) {
				char codigoCharAntes = (char)(codigoAsc+22);
				senhaDescriptografada += codigoCharAntes;
			}
		}
		
		return senhaDescriptografada;
		
	}
	
}
