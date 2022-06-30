/*
 * Created by DQCodegen
 */
package ru.diasoft.micro.controller.dto;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "SmsVerificationCheckResponse", description = "")
@JsonFilter("DynamicExclude")
@Generated
public class SmsVerificationCheckResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "CheckResult", value = "Результат проверки", required = false, position = 1)
    @JsonProperty("CheckResult")
    private Boolean checkResult;

}
