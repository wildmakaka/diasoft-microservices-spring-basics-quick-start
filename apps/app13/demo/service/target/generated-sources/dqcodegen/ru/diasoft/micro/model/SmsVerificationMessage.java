/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Generated
public class SmsVerificationMessage {

    @JsonProperty("guid")
    private String guid;

    @JsonProperty("phoneNumber")
    private String phoneNumber;

    @JsonProperty("code")
    private String code;

}
