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
 * 任务
 *
 * @author 贺佳
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ToDoBlock extends AbstractBlock {

    @JsonProperty("to_do")
    private ToDo toDo;

    public ToDoBlock() {
        type = TO_DO;
    }

    @Data
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ToDo {

        /**
         * 待办事项块中显示的富文本。
         *
         * @see RichTextType
         */
        @JsonProperty("rich_text")
        private RichTextType[] richText;

        /**
         * 是否勾选待办事项。
         */
        private Boolean checked;

        /**
         * 块的颜色
         *
         * @see ColorEnum
         */
        private String color;

        /**
         * To do 块的嵌套子块（如果有）。
         */
        private BlockType[] children;

    }

}
