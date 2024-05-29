package com.lucky.notionapi.model.block.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.enumerate.ColorEnum;
import com.lucky.notionapi.model.block.AbstractBlock;
import com.lucky.notionapi.model.block.BlockType;
import com.lucky.notionapi.model.block.richtext.RichTextType;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 编号列表项
 *
 * @author 贺佳
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NumberedListItemBlock extends AbstractBlock {

    @JsonProperty("numbered_list_item")
    private NumberedListItem numberedListItem;

    public NumberedListItemBlock() {
        type = NUMBERED_LIST_ITEM;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class NumberedListItem {

        /**
         * numbered_list_item 块中显示的富文本。
         *
         * @see RichTextType
         */
        @JsonProperty("rich_text")
        private RichTextType[] richText;

        /**
         * 块的颜色
         *
         * @see ColorEnum
         */
        private String color;

        /**
         * numbered_list_item 块的嵌套子块（如果有）。
         *
         * @see BlockType
         */
        private BlockType[] children;

    }

}
