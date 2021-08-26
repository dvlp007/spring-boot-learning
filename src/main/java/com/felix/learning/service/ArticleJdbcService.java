package com.felix.learning.service;

import com.felix.learning.dao.ArticleJdbcDao;
import com.felix.learning.model.Article;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ArticleJdbcService {
    @Resource
    private ArticleJdbcDao articleJdbcDao;
    @Resource
    private JdbcTemplate primaryJdbcTemplate;
    @Resource
    private JdbcTemplate secondaryJdbcTemplate;

    @Transactional
    public void saveArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        articleJdbcDao.save(article, primaryJdbcTemplate);
        articleJdbcDao.save(article, secondaryJdbcTemplate);
        int a = 10 / 0;
    }

    @Transactional
    public void updateArticle(Article article) {
        article.setCreateTime(LocalDateTime.now());
        articleJdbcDao.updateById(article, primaryJdbcTemplate);
        articleJdbcDao.updateById(article, secondaryJdbcTemplate);
    }

    public void deleteArticle(Long id) {
        articleJdbcDao.deleteById(id, primaryJdbcTemplate);
    }

    public Article getArticle(Long id) {
        return articleJdbcDao.findById(id, primaryJdbcTemplate);
    }

    public List<Article> getAllArticle() {
        return articleJdbcDao.findAll(primaryJdbcTemplate);
    }

    public Long countOfArticle() {
        return articleJdbcDao.count(primaryJdbcTemplate);
    }
}
