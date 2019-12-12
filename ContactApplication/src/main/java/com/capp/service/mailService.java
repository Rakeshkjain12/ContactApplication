package com.capp.service;

public interface mailService {
	public void sendMail(final String senderEmailId, final String receiverEmailId, final String subject, final String msg);
}
