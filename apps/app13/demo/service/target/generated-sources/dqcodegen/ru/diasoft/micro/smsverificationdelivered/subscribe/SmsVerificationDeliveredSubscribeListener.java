/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.smsverificationdelivered.subscribe;

import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Configuration;
import ru.diasoft.micro.model.SmsDeliveredMessage;
@Configuration
@Generated
public class SmsVerificationDeliveredSubscribeListener {

    @Autowired
    private SmsVerificationDeliveredSubscribeListenerService listenerService;

    @StreamListener(SmsVerificationDeliveredSubscribeChannelConstants.SMS_VERIFICATION_DELIVERED)
    void smsVerificationDelivered(SmsDeliveredMessage msg) {
        listenerService.smsVerificationDelivered(msg);
    }
    
}