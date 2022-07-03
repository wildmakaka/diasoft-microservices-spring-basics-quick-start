/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.smsverificationdelivered.subscribe;

import lombok.Generated;
import ru.diasoft.micro.model.SmsDeliveredMessage;
@Generated
public interface SmsVerificationDeliveredSubscribeListenerService {

    void smsVerificationDelivered(SmsDeliveredMessage msg);
    
}