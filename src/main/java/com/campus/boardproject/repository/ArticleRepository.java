package com.campus.boardproject.repository;

import com.campus.boardproject.domain.Article;
import com.campus.boardproject.domain.QArticle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ArticleRepository extends
        QuerydslPredicateExecutor<Article>,
        QuerydslBinderCustomizer<QArticle> {

    Page<Article> findByTitle(String title, Pageable pageable);

    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true);
    }

    Optional<Object> findById(long Id);

    void deleteById(Long articleId);

    void delete(Article article);

    Article saveAndFlush(Article article);

    void save(Article article);

    void getReferenceById(Long id);
}
