/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.service;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckRequestMock;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.digitalq.controller.dto.SmsVerificationCheckResponseMock;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostRequestMock;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.digitalq.controller.dto.SmsVerificationPostResponseMock;

@Service
@Generated
public class SmsVerificationServiceBase implements SmsVerificationService {


    public SmsVerificationServiceBase(
    ){
    }

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

