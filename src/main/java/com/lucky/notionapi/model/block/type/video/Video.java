package com.lucky.notionapi.model.block.type.video;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lucky.notionapi.model.block.BlockType;

/**
 * 视频
 *
 * @author 贺佳
 */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", visible = true, include = JsonTypeInfo.As.EXISTING_PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ExternalVideo.class, name = "external"),
        @JsonSubTypes.Type(value = FileVideo.class, name = "file"),
})
public interface Video extends BlockType {

}
