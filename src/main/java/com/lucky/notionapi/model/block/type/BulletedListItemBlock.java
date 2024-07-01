package com.lucky.notionapi.model.block.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.config.NotionConfig;
import com.lucky.notionapi.model.block.AbstractBlock;
import com.lucky.notionapi.model.block.BlockType;
import com.lucky.notionapi.model.communal.Color;
import com.lucky.notionapi.model.communal.richtext.RichTextType;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 项目符号列表项
 *
 * @author 贺佳
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BulletedListItemBlock extends AbstractBlock {

    @Valid
    @JsonProperty("bulleted_list_item")
    private BulletedListItem bulletedListItem;

    /**
     * 构造函数，创建给{@link #type}赋值的对象
     */
    public BulletedListItemBlock() {
        type = BULLETED_LIST_ITEM;
    }

    /**
     * 项目符号列表项
     */
    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class BulletedListItem {

        /**
         * 富文本数组
         *
         * @see RichTextType
         */
        @JsonProperty("rich_text")
        @Size(max = NotionConfig.BLOCK_ARRAY_SIZE, message = NotionConfig.BLOCK_ARRAY_MESSAGE)
        private RichTextType[] richText;

        /**
         * 颜色
         *
         * @see Color
         */
        private String color;

        /**
         * 块的嵌套子块（如果有）。
         *
         * @see BlockType
         */
        @Size(max = NotionConfig.BLOCK_ARRAY_SIZE, message = NotionConfig.BLOCK_ARRAY_MESSAGE)
        private BlockType[] children;
    }

}
