package com.example.demo.jk;

import org.elasticsearch.client.ElasticsearchClient;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;

public interface ArticleRepository extends ElasticsearchClient {
    Page<Article> findByAuthorsName(String name, Pageable pageable);

    @Query("{\"bool\": {\"must\": [{\"match\": {\"authors.name\": \"?0\"}}]}}")
    Page<Article> findByAuthorsNameUsingCustomQuery(String name, Pageable pageable);
}
