package ru.diasoft.digitalq.service.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

import org.aspectj.lang.annotation.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.digitalq.service.SmsVerificationService;
import ru.diasoft.digitalq.service.domain.SmsVerification;
import ru.diasoft.digitalq.service.repositiory.SmsVerificationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVerificationServiceTest {
	
	@Mock
	private SmsVerificationRepository repository;
	
	private SmsVerificationService service;
	
	private final String PHONE_NUMBER = "+495123456789";
	private final String VALID_SECRET_CODE = "0007";
	private final String INVALID_SECRET_CODE = "0008";
	private final String GUID = UUID.randomUUID().toString();
	private final String STATUS = "OK";
	
	@Before(value = "")
	public void init() {
		service =  new SmsVerificationPrimaryService(repository);
		
		SmsVerification smsVerification = SmsVerification.builder()
				.processGuid(GUID)
				.phoneNumber(PHONE_NUMBER)
				.secretCode(INVALID_SECRET_CODE)
				.status(STATUS)
				.build();
		
		when(repository.findBySecretCodeAndProcessGuidAndStatus(VALID_SECRET_CODE, GUID, STATUS)).thenReturn(Optional.of(smsVerification));
		when(repository.findBySecretCodeAndProcessGuidAndStatus(INVALID_SECRET_CODE, GUID, STATUS)).thenReturn(Optional.empty());
	}

	@Test
	public void testDsSmsVerificationCheck() {
		
		SmsVerificationCheckRequest smsVerificationCheckRequest = new SmsVerificationCheckRequest(GUID, VALID_SECRET_CODE);
		SmsVerificationCheckResponse response =  service.dsSmsVerificationCheck(smsVerificationCheckRequest);
		// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getCheckResult()).isEqualTo(true);
	}
	
	@Test
	public void testDsSmsVerificationCheckInvalidCode() {
		
		SmsVerificationCheckRequest smsVerificationCheckRequest = new SmsVerificationCheckRequest(GUID, INVALID_SECRET_CODE);
		SmsVerificationCheckResponse response =  service.dsSmsVerificationCheck(smsVerificationCheckRequest);
		// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getCheckResult()).isEqualTo(false);
	}

	@Test
	public void testDsSmsVerificationCreate() {
		SmsVerificationPostRequest smsVerificationPostRequest = new SmsVerificationPostRequest(PHONE_NUMBER);
		SmsVerificationPostResponse response = service.dsSmsVerificationCreate(smsVerificationPostRequest);
		
		// assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		assertThat(response.getProcessGUID()).isNotEmpty();
		
	}

}
