package com.lucky.notionapi.dao;

import com.lucky.notionapi.model.block.BlockType;
import lombok.Data;

/**
 * 块请求数据
 *
 * @author jiahe
 */
@Data
public class BlockRequestDao {

    /**
     * 作为块对象数组附加到容器块的子内容
     */
    private BlockType[] children;

    /**
     * 应在其后附加新块的现有块的 ID。
     */
    private String after;

}