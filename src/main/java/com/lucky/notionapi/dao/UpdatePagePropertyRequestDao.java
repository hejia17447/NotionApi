package com.lucky.notionapi.dao;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.lucky.notionapi.model.file.EmojiFile;
import com.lucky.notionapi.model.file.ExternalFile;
import com.lucky.notionapi.model.file.FileType;
import com.lucky.notionapi.model.page.properties.PageProperties;
import lombok.Data;

/**
 * 更新页面属性请求Dao
 *
 * @author jiahe
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdatePagePropertyRequestDao {

    /**
     * 页面要更新的属性值。键是属性的名称或 ID，值是属性值。如果页面属性 ID 未包含在内，则不会更改。
     */
    private PageProperties properties;

    /**
     * 是否删除页面。设为 true 可删除页面。设为 false 则恢复页面。
     */
    @JsonProperty("in_trash")
    private Boolean inTrash;

    /**
     * 页面的页面图标。支持的类型有外部文件对象或表情符号对象. {@link ExternalFile}和{@link EmojiFile}
     */
    private FileType icon;

    /**
     * 页面的封面图像。只支持外部文件对象。
     *
     * @see ExternalFile
     */
    private FileType cover;

}
