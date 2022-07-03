/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.smsverificationcreated.publish;

import lombok.Generated;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

/*
spring:
  cloud:
    stream:
      bindings:
        smsVerificationCreatedPublish:
          destination: sms-verification-created
*/
@Configuration
@EnableBinding(SmsVerificationCreatedPublishChannel.class)
@Generated
public class SmsVerificationCreatedPublishChannelBinding {
}