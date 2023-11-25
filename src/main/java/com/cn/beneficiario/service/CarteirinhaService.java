package com.cn.beneficiario.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarteirinhaService {

	@Autowired
	private Random proxRandom;
	
    public String GerandoCarteirinha() {
		 String[] caracteres = { "0", "1", "b", "2", "4", "5", "6", "7", "8",
	                "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k",
	                "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w",
	                "x", "y", "z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y"};
		 
		 String carteirinha = "";
		 int index;
		 
		 for(int i=0; i<=10; i++){
			 index = proxRandom.nextInt(caracteres.length); 
			 carteirinha += caracteres[index];
		 }
		 
		 return carteirinha;
	}	
	
}
