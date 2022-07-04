package ru.diasoft.micro.service;

import org.junit.Before;

import static org.junit.Assert.*;

import java.util.UUID;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.micro.domain.SmsVerificationEntity;
import ru.diasoft.micro.repository.SmsVerificationRepository;
import ru.diasoft.micro.service.SmsVerificationPrimaryService;
import ru.diasoft.micro.service.SmsVerificationService;
import ru.diasoft.micro.smsverificationcreated.publish.SmsVerificationCreatedPublishGateway;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsVerificationServiceTest {

    @Mock
    private SmsVerificationRepository repository;

    @Mock
    private SmsVerificationCreatedPublishGateway messagingGateway;

    private SmsVerificationService service;

    private final String GUID = UUID.randomUUID().toString();
    private final String PHONE_NUMBER = "+495123456789";
    private final String VALID_SECRET_CODE = "0007";
    private final String INVALID_SECRET_CODE = "0008";
    private final String STATUS = "OK";

    //@Before(value = "")
    @Before
    public void init() {

        service =  new SmsVerificationPrimaryService(repository, messagingGateway);

        SmsVerificationEntity smsVerificationEntity = SmsVerificationEntity.builder()
                .processGuid(GUID)
                .phoneNumber(PHONE_NUMBER)
                .secretCode(VALID_SECRET_CODE)
                .status(STATUS)
                .build();

        when(repository.findBySecretCodeAndProcessGuid(VALID_SECRET_CODE, GUID))
                .thenReturn(Optional.of(smsVerificationEntity));
        when(repository.findBySecretCodeAndProcessGuid(INVALID_SECRET_CODE, GUID))
                .thenReturn(Optional.empty());
        when(repository.save(any())).thenReturn(smsVerificationEntity);
    }

    @Test
    public void testDsSmsVerificationCheck() {
        SmsVerificationCheckRequest smsVerificationCheckRequest = new SmsVerificationCheckRequest(GUID, VALID_SECRET_CODE);
        SmsVerificationCheckResponse response =  service.dsSmsVerificationCheck(smsVerificationCheckRequest);
        assertThat(response.getCheckResult()).isTrue();
    }

    @Test
    public void testDsSmsVerificationCheckInvalidCode() {
        SmsVerificationCheckRequest smsVerificationCheckRequest = new SmsVerificationCheckRequest(GUID, INVALID_SECRET_CODE);
        SmsVerificationCheckResponse response =  service.dsSmsVerificationCheck(smsVerificationCheckRequest);
        assertThat(response.getCheckResult()).isFalse();
    }

    @Test
    public void testDsSmsVerificationCreate() {
        SmsVerificationPostRequest smsVerificationPostRequest = new SmsVerificationPostRequest(PHONE_NUMBER);
        SmsVerificationPostResponse response = service.dsSmsVerificationCreate(smsVerificationPostRequest);
        assertThat(response.getProcessGUID()).isNotEmpty();
    }

} // The End of Class;