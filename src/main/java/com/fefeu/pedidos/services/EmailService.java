package com.fefeu.pedidos.services;

import org.springframework.mail.SimpleMailMessage;

import com.fefeu.pedidos.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
