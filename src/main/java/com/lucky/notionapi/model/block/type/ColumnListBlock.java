package com.lucky.notionapi.model.block.type;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.model.block.AbstractBlock;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 列列表
 * 列列表是列的父块。它们在 column_list 属性中不包含任何信息。
 * 通过 Append 块子级创建 column_list 块时， column_list 必须至少有两个 column ，
 * 并且每个 column 必须至少有两个 column 。至少一个孩子。
 * 按照以下步骤获取 column_list 中的内容：
 * 1.从查询中获取 column_list ID 以检索父页面的块子级。
 * 2.从查询中获取 column 子项以检索 column_list 的块子项。
 * 3.通过查询获取每个单独 column 中的内容，以检索唯一 column ID 的块子级。
 *
 * @author 贺佳
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ColumnListBlock extends AbstractBlock {

    @JsonProperty("column_list")
    private ColumnList columnList;

    public ColumnListBlock() {
        columnList = new ColumnList();
        type = COLUMN_LIST;
    }

    @Data
    static class ColumnList {

    }

}
