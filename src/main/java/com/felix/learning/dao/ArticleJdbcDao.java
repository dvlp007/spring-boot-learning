package com.felix.learning.dao;

import com.felix.learning.model.Article;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ArticleJdbcDao {

    public void save(Article article, JdbcTemplate jdbcTemplate) {
        // 插入操作：使用update方法
        String sql = "insert into article(title, author, content, create_time) values(?, ?, ?, ?)";
        jdbcTemplate.update(sql, article.getTitle(), article.getAuthor(),
                article.getContent(), article.getCreateTime());
    }

    public void updateById(Article article, JdbcTemplate jdbcTemplate) {
        // 更新操作：使用update方法
        String sql = "update article set title = ?, author = ?, content = ?, create_time = ? where id = ?";
        jdbcTemplate.update(sql, article.getTitle(), article.getAuthor(),
                article.getContent(), article.getCreateTime(), article.getId());
    }

    public void deleteById(Long id, JdbcTemplate jdbcTemplate) {
        // 删除操作：使用update方法
        String sql = "delete from article where id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Article findById(Long id, JdbcTemplate jdbcTemplate) {
        // 单行查询：使用queryForObject方法
        String sql = "select * from article where id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Article.class), id);
    }

    public List<Article> findAll(JdbcTemplate jdbcTemplate) {
        // 多行查询：使用query方法
        String sql = "select id, title, author, content, create_time from article";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Article.class));
    }

    public Long count(JdbcTemplate jdbcTemplate) {
        // 单值查询：使用queryForObject方法
        String sql = "select count(1) from article";
        return jdbcTemplate.queryForObject(sql, Long.class);
    }
}
