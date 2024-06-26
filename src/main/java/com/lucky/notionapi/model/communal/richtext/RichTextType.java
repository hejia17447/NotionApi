package com.lucky.notionapi.model.communal.richtext;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lucky.notionapi.model.communal.richtext.type.EquationRichText;
import com.lucky.notionapi.model.communal.richtext.type.MentionRichText;
import com.lucky.notionapi.model.communal.richtext.type.TextRichText;
import org.springframework.validation.annotation.Validated;

import static com.lucky.notionapi.model.communal.richtext.RichTextType.*;

/**
 * 富文本类型
 *
 * @author jiahe
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, defaultImpl = TextRichText.class,
        include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @Type(value = TextRichText.class, name = TEXT),
        @Type(value = MentionRichText.class, name = MENTION),
        @Type(value = EquationRichText.class, name = EQUATION),
})
@Validated
public interface RichTextType {

    /**
     * 文本
     */
    String TEXT = "text";
    /**
     * 提到
     */
    String MENTION = "mention";
    /**
     * 方程
     */
    String EQUATION = "equation";

}
