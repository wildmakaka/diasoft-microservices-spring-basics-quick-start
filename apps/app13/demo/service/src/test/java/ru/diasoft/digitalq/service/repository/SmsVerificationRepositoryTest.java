package ru.diasoft.digitalq.service.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.diasoft.digitalq.service.domain.SmsVerification;
import ru.diasoft.digitalq.service.repositiory.SmsVerificationRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVerificationRepositoryTest {
	
	@Autowired
	private SmsVerificationRepository repository; 
	
	@Test
	public void smsVerificationCreateTest() {
		SmsVerification smsVerification = SmsVerification.builder()
			.processGuid(UUID.randomUUID().toString())
			.phoneNumber("123456789")
			.secretCode("0007")
			.status("WAITING")
			.build();
		
		SmsVerification createdEntity = repository.save(smsVerification);
		assertThat(smsVerification).isEqualToComparingOnlyGivenFields(createdEntity, "verificationId");
		assertThat(createdEntity.getVirificationId()).isNotNull();
	}
	
	@Test
	public void findBySecretCodeAndProcessGuidAndStatusTest() {
		
		String guid = UUID.randomUUID().toString();
		String status = "WAITING";
		String secretCode = "0007";
		
		SmsVerification smsVerification = SmsVerification.builder()
			.processGuid(guid)
			.phoneNumber("123456789")
			.secretCode(secretCode)
			.status(status)
			.build();
			
		SmsVerification createdEntity = repository.save(smsVerification);
		
		assertThat(repository.findBySecretCodeAndProcessGuidAndStatus(secretCode, guid, status).orElse(SmsVerification.builder().build())).isEqualToIgnoringGivenFields(createdEntity, "verificationId");
		assertThat(repository.findBySecretCodeAndProcessGuidAndStatus("22222", guid, status).orElse(null)).isNotNull();
		
	}

}
