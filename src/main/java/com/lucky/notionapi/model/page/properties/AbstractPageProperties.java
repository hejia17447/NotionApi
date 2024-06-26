package com.lucky.notionapi.model.page.properties;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 页属性抽象
 * 每个页面都有的属性值
 *
 * @author 贺佳
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class AbstractPageProperties implements PageProperties {

    /**
     * 属性的基础标识符。
     * 创建或更新页面时，可以使用 id 代替名称。
     * 当属性名称更改时， id 保持不变。
     */
    protected String id;

    /**
     * 页面对象中属性的类型。可能的类型值为：
     */
    protected String type;

    /**
     * 属性的自定义名称。
     * 如果未设置，则为空。
     * 如果设置了，则为自定义名称。
     * 不进行序列化和反序列化。
     */
    @JsonIgnore
    protected String customizeName;

}
