/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.service;

import lombok.Generated;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponse;

@Generated
@SuppressWarnings({"all"})
public interface SmsVerificationService {

    SmsVerificationCheckResponse dsSmsVerificationCheck(
        SmsVerificationCheckRequest smsVerificationCheckRequest);
    
    SmsVerificationPostResponse dsSmsVerificationCreate(
        SmsVerificationPostRequest smsVerificationPostRequest);
    
}
