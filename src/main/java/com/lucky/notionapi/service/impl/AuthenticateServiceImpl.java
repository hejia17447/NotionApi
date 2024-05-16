package com.lucky.notionapi.service.impl;

import com.lucky.notionapi.dao.BlockRequestDao;
import com.lucky.notionapi.dao.BlockResponseDao;
import com.lucky.notionapi.service.BlockService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Objects;

/**
 * 认证服务
 * @author jiahe
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticateServiceImpl {

    private final HttpServiceProxyFactory factory;

    /**
     * 追加块子项<br>
     * 将一个块对象数组附加到容器块的子内容。<br>
     * 如果块已经有子内容，则新的子内容将被添加到现有子内容之后。<br>
     * 例子：<a href="https://developers.notion.com/reference/patch-block-children" target="_blank">追加子块</a>
     *
     * @param requestDao 作为块对象数组附加到容器块的子内容
     * @param blockId    块的标识符。还接受页面 ID。
     * @return 一级子块对象的分页列表
     */
    public BlockResponseDao appendBlockChildren(BlockRequestDao requestDao, String blockId) {
        log.info("追加块子项-->块id：{}，块信息：{}", blockId, requestDao.toString());
        BlockService service = factory.createClient(BlockService.class);
        ResponseEntity<BlockResponseDao> response = service.appendBlockChildren(requestDao, blockId);
        BlockResponseDao result = Objects.requireNonNull(response.getBody());
        log.info("追加块子项成功：{}", result);
        return result;
    }

}