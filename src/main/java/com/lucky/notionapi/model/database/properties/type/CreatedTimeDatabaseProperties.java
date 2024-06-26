package com.lucky.notionapi.model.database.properties.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.model.communal.CreatedTime;
import com.lucky.notionapi.model.database.properties.AbstractDatabaseProperties;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 创建的时间数据库属性在 Notion UI 中呈现为一列，其中包含每行创建时的时间戳作为值。created_time 类型对象为空。没有额外的属性配置。
 *
 * @author jiahe
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatedTimeDatabaseProperties extends AbstractDatabaseProperties {

    @JsonProperty("created_time")
    private CreatedTime createdTime;

    /**
     * 根据{@code initType}情况是否初始化{@code type}
     *
     * @param initType 是否初始化{@code type}
     */
    public CreatedTimeDatabaseProperties(Boolean initType) {
        if (initType) {
            type = CREATED_TIME;
        }
    }

}
