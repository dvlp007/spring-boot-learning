package com.felix.learning.service;

import com.felix.learning.dao.ArticleJdbcDao;
import com.felix.learning.model.Article;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleJdbcService {
    @Resource
    private ArticleJdbcDao articleJdbcDao;

    public void saveArticle(Article article) {
        articleJdbcDao.save(article);
    }

    @Transactional
    public void updateArticle(Article article) {
        articleJdbcDao.updateById(article);
        int a = 10 / 0;
    }

    public void deleteArticle(Long id) {
        articleJdbcDao.deleteById(id);
    }

    public Article getArticle(Long id) {
        return articleJdbcDao.findById(id);
    }

    public List<Article> getAllArticle() {
        return articleJdbcDao.findAll();
    }

    public Long countOfArticle() {
        return articleJdbcDao.count();
    }
}
