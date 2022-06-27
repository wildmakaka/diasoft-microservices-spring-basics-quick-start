/*
 * Created by DQCodegen
 */
package ru.diasoft.digitalq.controller.dto;

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
@ApiModel(value = "SmsVerificationPostResponse", description = "")
@JsonFilter("DynamicExclude")
@Generated
public class SmsVerificationPostResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(name = "ProcessGUID", value = "GUID процесса", required = false, position = 1)
    @JsonProperty("ProcessGUID")
    private String processGUID;

    SmsVerificationPostResponse(String processGUID){
        this.processGUID = processGUID;
    }

}
