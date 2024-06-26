package com.lucky.notionapi.model.block.type;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.lucky.notionapi.model.block.AbstractBlock;
import com.lucky.notionapi.model.file.FileType;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 图像块对象包含一个文件对象
 *
 * @author 贺佳
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageBlock extends AbstractBlock {

    /**
     * 文件对象即icon对象
     */
    @Valid
    private FileType image;

    public ImageBlock() {
        type = IMAGE;
    }

}
