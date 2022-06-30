/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.service;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequestMock;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponseMock;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequestMock;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponseMock;

@Service
@Generated
@SuppressWarnings({"all"})
public class SmsVerificationServiceBase implements SmsVerificationService {

    @Override
    public SmsVerificationCheckResponse dsSmsVerificationCheck(
            SmsVerificationCheckRequest smsVerificationCheckRequest) {
        return new SmsVerificationCheckResponseMock();  
    } 

    @Override
    public SmsVerificationPostResponse dsSmsVerificationCreate(
            SmsVerificationPostRequest smsVerificationPostRequest) {
        return new SmsVerificationPostResponseMock();  
    } 


}

