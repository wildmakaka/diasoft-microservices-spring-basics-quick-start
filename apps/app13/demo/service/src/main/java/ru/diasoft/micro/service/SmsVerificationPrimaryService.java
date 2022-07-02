package ru.diasoft.micro.service;

import java.util.Random;
import java.util.UUID;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.micro.domain.SmsVerificationEntity;
import ru.diasoft.micro.repository.SmsVerificationRepository;

@RequiredArgsConstructor
@Service
@Primary
public class SmsVerificationPrimaryService implements SmsVerificationService{

    private final SmsVerificationRepository repository;

    @Override
    public SmsVerificationCheckResponse dsSmsVerificationCheck(
            SmsVerificationCheckRequest smsVerificationCheckRequest) {
        Optional<SmsVerificationEntity> smsVerificationEntity = repository.findBySecretCodeAndProcessGuid(
                smsVerificationCheckRequest.getCode(),
                smsVerificationCheckRequest.getProcessGUID()
        );
        return new SmsVerificationCheckResponse(smsVerificationEntity.isPresent());
    }

    @Override
    public SmsVerificationPostResponse dsSmsVerificationCreate(SmsVerificationPostRequest smsVerificationPostRequest) {

        String guid = UUID.randomUUID().toString();
        String secretCode = String.format("%04d", new Random().nextInt(10000));
        String status = "WAITING";

        SmsVerificationEntity smsVerification = SmsVerificationEntity.builder()
                .phoneNumber(smsVerificationPostRequest.getPhoneNumber())
                .processGuid(guid)
                .secretCode(secretCode)
                .status(status)
                .build();

        repository.save(smsVerification);
        return new SmsVerificationPostResponse(guid);
    }

} // The End of Class;