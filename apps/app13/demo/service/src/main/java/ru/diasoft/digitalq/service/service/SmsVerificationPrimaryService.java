package ru.diasoft.digitalq.service.service;

import java.util.Random;
import java.util.UUID;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.digitalq.service.SmsVerificationService;
import ru.diasoft.digitalq.service.domain.SmsVerification;
import ru.diasoft.digitalq.service.repositiory.SmsVerificationRepository;

@RequiredArgsConstructor
@Service
@Primary
public class SmsVerificationPrimaryService implements SmsVerificationService{
	
	private final SmsVerificationRepository repository;

	@Override
	public SmsVerificationCheckResponse dsSmsVerificationCheck(
			SmsVerificationCheckRequest smsVerificationCheckRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SmsVerificationPostResponse dsSmsVerificationCreate(SmsVerificationPostRequest smsVerificationPostRequest) {
		
		String guid = UUID.randomUUID().toString();
		String secretCode = String.format("%04d", new Random().nextInt(10000));
		
		SmsVerification smsVerification = SmsVerification.builder()
				.phoneNumber(smsVerificationPostRequest.getPhoneNumber())
				.processGuid(guid)
				.secretCode(secretCode)
				.status("WAITING")
				.build();
				
		repository.save(smsVerification);
		return new SmsVerificationPostResponse(guid);
	}

}
