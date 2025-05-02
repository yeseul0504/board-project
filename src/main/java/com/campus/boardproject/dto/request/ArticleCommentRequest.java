package com.campus.boardproject.dto.request;

import com.campus.boardproject.dto.ArticleCommentDto;
import com.campus.boardproject.dto.UserAccountDto;

public record ArticleCommentRequest(Long articleId, String content) {

    public static ArticleCommentRequest of(Long articleId, String content) {
        return new ArticleCommentRequest(articleId, content);
    }

    public ArticleCommentDto toDto(UserAccountDto userAccountDto) {
        return ArticleCommentDto.of(
                1L,
                articleId,
                userAccountDto,
                content,
                null,
                null,
                null,
                null
        );
    }

}