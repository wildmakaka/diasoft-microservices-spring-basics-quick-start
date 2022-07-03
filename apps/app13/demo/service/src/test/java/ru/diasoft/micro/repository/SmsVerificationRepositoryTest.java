package ru.diasoft.micro.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.diasoft.micro.domain.SmsVerificationEntity;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVerificationRepositoryTest {
	
	@Autowired
	private SmsVerificationRepository repository;

	private final String GUID = UUID.randomUUID().toString();
	private final String PHONE_NUMBER = "5555555";
	private final String SECRET_CODE = "0007";
	private final String WRONG_SECRET_CODE = "0006";
	private final String STATUS_WAITING = "WAITING";
	private final String STATUS_OK = "OK";
	
	@Test
	public void smsVerificationCreateTest() {

		SmsVerificationEntity smsVerification = SmsVerificationEntity.builder()
			.processGuid(GUID)
			.phoneNumber(PHONE_NUMBER)
			.secretCode(SECRET_CODE)
			.status(STATUS_WAITING)
			.build();

		SmsVerificationEntity createdEntity = repository.save(smsVerification);
		assertThat(smsVerification).isEqualTo(createdEntity);
		assertThat(createdEntity.getVerificationId()).isNotNull();
	}
	
	@Test
	public void findBySecretCodeAndProcessGuidAndStatusTest() {

		SmsVerificationEntity smsVerification = SmsVerificationEntity.builder()
			.processGuid(GUID)
			.phoneNumber(PHONE_NUMBER)
			.secretCode(SECRET_CODE)
			.status(STATUS_WAITING)
			.build();

		 SmsVerificationEntity createdEntity = repository.save(smsVerification);

		 assertThat(repository.findBySecretCodeAndProcessGuid(SECRET_CODE, GUID).orElse(SmsVerificationEntity.builder().build())).isEqualTo(createdEntity);
		 assertThat(repository.findBySecretCodeAndProcessGuid(WRONG_SECRET_CODE, GUID)).isEmpty();
	}

	@Test
	public void updateStatusByProcessGuidTest() {
		SmsVerificationEntity smsVerification =
				SmsVerificationEntity.builder()
						.processGuid(GUID)
						.phoneNumber(PHONE_NUMBER)
						.secretCode(SECRET_CODE)
						.status(STATUS_WAITING)
						.build();

		SmsVerificationEntity createdEntity = repository.save(smsVerification);
		repository.updateStatusByProcessGuid(STATUS_OK, GUID);

		assertThat(repository.findById(createdEntity.getVerificationId())
				.orElse(SmsVerificationEntity.builder().build()).getStatus()).isEqualTo(STATUS_OK);
	}


} // The End of Class;
