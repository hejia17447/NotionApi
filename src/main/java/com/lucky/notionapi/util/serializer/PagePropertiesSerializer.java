package com.lucky.notionapi.util.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.lucky.notionapi.model.page.properties.AbstractPageProperties;
import com.lucky.notionapi.model.page.properties.PageProperties;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

/**
 * 页属性自定义序列化
 *
 * @author jiahe
 */
@Slf4j
public class PagePropertiesSerializer extends JsonSerializer<List<PageProperties>> {

    @Override
    public void serialize(List<PageProperties> properties, JsonGenerator jg, SerializerProvider sp) {
        try {
            jg.writeStartObject();
            properties.forEach(p -> {
                AbstractPageProperties ap = (AbstractPageProperties) p;
                try {
                    jg.writePOJOField(ap.getCustomizeName(), p);
                } catch (IOException e) {
                    log.error("页属性序列化异常：", e);
                }

            });
            jg.writeEndObject();
        } catch (IOException e) {
            log.error("页属性序列化异常：", e);
        }
    }

}
