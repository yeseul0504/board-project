package com.campus.boardproject.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

@DisplayName("view 컨트롤러 - 게시글")
@WebMvcTest(ArticleController.class)
class ArticleControllerTest {

    private final MockMvc mvc;

    public ArticleControllerTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[view][GET] - 게시글 리스트 (게시판)페이지 - 정상 호출")
    @Test
    public void givenNothing_whenRequestArticlesView_thenReturnArticlesView () throws Exception {
        //given

        //when
        mvc.perform(get("/articles"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("articles"));
    }

    @DisplayName("[view][GET] - 게시글 상세페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleView_thenReturnArticleView () throws Exception {
        //given

        //when
        mvc.perform(get("/articles/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML))
                .andExpect(model().attributeExists("article"));
    }

    @DisplayName("[view][GET] - 게시글 검색 전용 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleSearchView_thenReturnArticleSearchView () throws Exception {
        //given

        //when
        mvc.perform(get("/articles/search"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

    @DisplayName("[view][GET] - 게시글 해시태그 검색 페이지 - 정상호출")
    @Test
    public void givenNothing_whenRequestArticleHashtagSearchView_thenReturnArticleHashtagSearchView () throws Exception {
        //given

        //when
        mvc.perform(get("/articles/search-hashtag"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(content().contentType(MediaType.TEXT_HTML));
    }

}
