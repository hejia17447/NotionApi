package com.lucky.notionapi.service.impl;

import com.lucky.notionapi.annotation.NotionException;
import com.lucky.notionapi.dao.PropertyItemDao;
import com.lucky.notionapi.dao.UpdatePagePropertyRequestDao;
import com.lucky.notionapi.model.page.Page;
import com.lucky.notionapi.service.PageService;
import com.lucky.notionapi.utils.ObjectMapperUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import java.util.Map;
import java.util.Objects;

/**
 * 页服务
 *
 * @author jiahe
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class PageServiceImpl {

    private final HttpServiceProxyFactory factory;


    /**
     * 创建页面
     *
     * @param page 页面数据
     * @return 页面数据
     */
    @NotionException("创建页面")
    public Page createPage(Page page) {
        PageService service = factory.createClient(PageService.class);
        ResponseEntity<Page> response = service.createPage(ObjectMapperUtil.toJson(page));
        return Objects.requireNonNull(response.getBody());
    }

    /**
     * 检索页面
     *
     * @param pageId  页面id
     * @param filters 过滤条件
     * @return 页面数据
     */
    @NotionException("检索页面")
    public Page queryPage(String pageId, String[] filters) {
        PageService service = factory.createClient(PageService.class);
        ResponseEntity<Page> response = service.retrievePage(pageId, filters);
        return Objects.requireNonNull(response.getBody());
    }

    /**
     * 获取页面属性项
     *
     * @param pageId     页面id
     * @param propertyId 属性id
     * @param params     分页参数
     * @return 属性项数据
     */
    @NotionException("获取页面属性项")
    public PropertyItemDao retrievePagePropertyItem(String pageId, String propertyId, Map<String, String> params) {
        if (params == null) {
            params = Map.of();
        }
        PageService service = factory.createClient(PageService.class);
        ResponseEntity<PropertyItemDao> response = service.retrievePagePropertyItem(pageId, propertyId, params);
        return Objects.requireNonNull(response.getBody());
    }

    /**
     * 更新页面属性
     *
     * @param pageId     页面id
     * @param requestDao 修改数据
     * @return 页面数据
     */
    @NotionException("更新页面属性")
    public Page updatePageProperty(String pageId, UpdatePagePropertyRequestDao requestDao) {
        String body = ObjectMapperUtil.toJson(requestDao);
        PageService service = factory.createClient(PageService.class);
        ResponseEntity<Page> response = service.updatePageProperties(pageId, body);
        return Objects.requireNonNull(response.getBody());
    }

}
