package com.lucky.notionapi.model.page.properties.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.model.communal.PhoneNumber;
import com.lucky.notionapi.model.page.properties.AbstractPageProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 电话号码
 *
 * @author jiahe
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PhoneNumberPageProperties extends AbstractPageProperties {

    @JsonProperty(value = "phone_number", access = JsonProperty.Access.READ_ONLY)
    private String phoneNumber;

    @JsonProperty(value = "phone_number", access = JsonProperty.Access.WRITE_ONLY)
    private PhoneNumber phoneNumberObject;

    public PhoneNumberPageProperties() {
        type = PEOPLE;
    }

}
