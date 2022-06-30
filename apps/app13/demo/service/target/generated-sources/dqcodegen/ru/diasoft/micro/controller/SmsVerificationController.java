/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationCheckResponse;
import ru.diasoft.micro.controller.dto.SmsVerificationPostRequest;
import ru.diasoft.micro.controller.dto.SmsVerificationPostResponse;
import ru.diasoft.micro.lib.config.aop.Loggable;
import ru.diasoft.micro.lib.utils.response.RESTStatus;
import ru.diasoft.micro.service.SmsVerificationService;

@RestController("ru.diasoft.micro.controller.SmsVerificationController")
@Api(tags = {"SmsVerification"})
@Generated
@Loggable
@SuppressWarnings({"all"})
public class SmsVerificationController {

    private final SmsVerificationService smsVerificationService;

    @Autowired    
    public SmsVerificationController(SmsVerificationService smsVerificationService) {
        this.smsVerificationService = smsVerificationService;
    }

    @GetMapping("/v1/sms-verification")
    @ApiOperation(value = "Метод проверяет, что введенный код соответствует отправленному.", response = SmsVerificationCheckResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<SmsVerificationCheckResponse> dsSmsVerificationCheck(
                @ApiParam(name = "SmsVerificationCheckRequest", value = "", required = false)
                @RequestBody(required = false)
                SmsVerificationCheckRequest smsVerificationCheckRequest,
                @ApiParam(value = "Field set for return") 
                @RequestParam(name = "fields", required = false)
                String fields) {
        SmsVerificationCheckResponse result = smsVerificationService.dsSmsVerificationCheck(
                smsVerificationCheckRequest);
        if (result instanceof RESTStatus) {
            return ResponseEntity.status(((RESTStatus)result).getHttpStatus()).body(result);    
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result); 
        }
    }

    @PostMapping("/v1/sms-verification")
    @ApiOperation(value = "Отправка проверочного кода на телефон клиента.", response = SmsVerificationPostResponse.class, tags = {"SmsVerification"})
    public ResponseEntity<SmsVerificationPostResponse> dsSmsVerificationCreate(
                @ApiParam(name = "SmsVerificationPostRequest", value = "", required = false)
                @RequestBody(required = false)
                SmsVerificationPostRequest smsVerificationPostRequest) {
        SmsVerificationPostResponse result = smsVerificationService.dsSmsVerificationCreate(
                smsVerificationPostRequest);
        if (result instanceof RESTStatus) {
            return ResponseEntity.status(((RESTStatus)result).getHttpStatus()).body(result);    
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(result); 
        }
    }

}
