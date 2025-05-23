package com.campus.boardproject.controller;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled("Spring data REST 통합테스트는 불필요하므로 제외")
@DisplayName("Data REST- API테스트")
@Transactional
@AutoConfigureMockMvc
//@WebMvcTest
@SpringBootTest()
public class DataRestTest {
    private MockMvc mvc;

    public DataRestTest(@Autowired MockMvc mvc) {
        this.mvc = mvc;
    }

    @DisplayName("[api]게시글 리스트 조회")
    @Test
    void whenRequestingArticles_thenReturnArticleJsonResponse() throws Exception {
        //given


        //when
        mvc.perform(get("/api/articles"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api]게시글 단건 조회")
    @Test
    void whenRequestingArticle_thenReturnArticleJsonResponse() throws Exception {
        //given


        //when
        mvc.perform(get("/api/articles/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api]게시글 -> 댓글리스트 조회")
    @Test
    void whenRequestingArticleCommentsFromArticle_thenReturnArticleCommentsJsonResponse() throws Exception {
        //given


        //when
        mvc.perform(get("/api/articles/1/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api]댓글리스트 조회")
    @Test
    void whenRequestingArticleComments_thenReturnArticleCommentsJsonResponse() throws Exception {
        //given


        //when
        mvc.perform(get("/api/articleComments"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }

    @DisplayName("[api]댓글 단건 조회")
    @Test
    void whenRequestingArticleComment_thenReturnArticleCommentJsonResponse() throws Exception {
        //given


        //when
        mvc.perform(get("/api/articleComments/1"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.valueOf("application/hal+json")));
    }
}
