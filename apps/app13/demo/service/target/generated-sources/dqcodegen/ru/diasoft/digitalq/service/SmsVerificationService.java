/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.service;

import lombok.Generated;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostResponse;

@Generated
public interface SmsVerificationService {

    SmsVerificationCheckResponse dsSmsVerificationCheck(
        SmsVerificationCheckRequest smsVerificationCheckRequest);
    
    SmsVerificationPostResponse dsSmsVerificationCreate(
        SmsVerificationPostRequest smsVerificationPostRequest);
    
}
