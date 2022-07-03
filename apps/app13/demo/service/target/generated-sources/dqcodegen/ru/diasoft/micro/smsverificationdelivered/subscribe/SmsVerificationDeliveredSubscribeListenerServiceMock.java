/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.smsverificationdelivered.subscribe;

import lombok.Generated;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;
import ru.diasoft.micro.model.SmsDeliveredMessage;
@Service
@Generated
public class SmsVerificationDeliveredSubscribeListenerServiceMock implements SmsVerificationDeliveredSubscribeListenerService {

    Logger logger = LogManager.getLogger(SmsVerificationDeliveredSubscribeListenerServiceMock.class);

    @Override
    public void smsVerificationDelivered(SmsDeliveredMessage msg) {
        if (logger.isInfoEnabled()) {
            logger.info("SmsVerificationDeliveredSubscribeListenerServiceMock.smsVerificationDelivered: {}", msg);
        }
    }
    
}