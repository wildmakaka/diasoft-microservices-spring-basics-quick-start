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
public class SmsDeliveredMessage {

    @JsonProperty("guid")
    private String guid;

}
