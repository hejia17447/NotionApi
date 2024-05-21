package com.lucky.notionapi.service.impl;

import com.lucky.notionapi.NotionClient;
import com.lucky.notionapi.dao.BlockAddRequestDao;
import com.lucky.notionapi.dao.BlockAddResponseDao;
import com.lucky.notionapi.model.block.BlockType;
import com.lucky.notionapi.model.block.richtext.RichTextType;
import com.lucky.notionapi.model.block.richtext.type.TextRichText;
import com.lucky.notionapi.model.block.type.BookmarkBlock;
import com.lucky.notionapi.model.block.type.BreadcrumbBlock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BlockServiceImplTest {

    @Autowired
    private NotionClient client;

    @Test
    void appendBlockChildrenBookmarkBlock() {
        BlockAddRequestDao requestDao = new BlockAddRequestDao();
        BlockType[] children = new BlockType[1];
        // 书签块
        BookmarkBlock bookmarkBlock = new BookmarkBlock();
        bookmarkBlock.setBookmark(new BookmarkBlock.Bookmark());
        TextRichText caption = new TextRichText();
        caption.setText(new TextRichText.Text());
        caption.getText().setContent("notion追加测试");
        bookmarkBlock.getBookmark().setCaption(new RichTextType[]{caption});
        bookmarkBlock.getBookmark().setUrl("https://notionchina.co/guide/images-videos-files-embeds/web-bookmarks.html");
        children[0] = bookmarkBlock;
        requestDao.setChildren(children);
        BlockAddResponseDao blockAddResponseDao = client.blockService().appendBlockChildren(requestDao, "89529312369f46cca58b3d98a4c15114");
        System.out.println(blockAddResponseDao);
    }

    @Test
    void appendBlockChildrenBreadcrumbBlock() {
        BlockAddRequestDao requestDao = new BlockAddRequestDao();
        BlockType[] children = new BlockType[1];
        BreadcrumbBlock breadcrumbBlock = new BreadcrumbBlock();
        children[0] = breadcrumbBlock;
        breadcrumbBlock.setBreadcrumb(new BreadcrumbBlock.Breadcrumb());
        requestDao.setChildren(children);
        BlockAddResponseDao blockAddResponseDao = client.blockService().appendBlockChildren(requestDao, "89529312369f46cca58b3d98a4c15114");
        System.out.println(blockAddResponseDao);
    }


    @Test
    void retrieveBlock() {
    }
}