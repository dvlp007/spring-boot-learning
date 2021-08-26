package com.felix.learning.controller;

import com.felix.learning.common.AjaxResponse;
import com.felix.learning.model.Article;
import com.felix.learning.service.ArticleJdbcService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Api(value = "文章模块", tags = "文章相关接口")
@RestController
@RequestMapping("/v1/jdbc")
public class ArticleJdbcController {
    @Resource
    private ArticleJdbcService articleJdbcService;

    @ApiOperation(value = "新增文章")
    @PostMapping("/article")
    public AjaxResponse saveArticle(@RequestBody Article article) {
        articleJdbcService.saveArticle(article);
        return AjaxResponse.success();
    }

    @ApiOperation(value = "修改文章")
    @PutMapping("/article")
    public AjaxResponse updateArticle(@RequestBody Article article) {
        articleJdbcService.updateArticle(article);
        return AjaxResponse.success();
    }

    @ApiOperation(value = "删除文章")
    @DeleteMapping("/article/{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id) {
        articleJdbcService.deleteArticle(id);
        return AjaxResponse.success();
    }

    @ApiOperation(value = "查询单一文章")
    @GetMapping("/article/{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id) {
        Article article = articleJdbcService.getArticle(id);
        return AjaxResponse.success(article);
    }

    @ApiOperation(value = "获取文章列表")
    @GetMapping("/articles")
    public AjaxResponse getArticles() {
        List<Article> articles = articleJdbcService.getAllArticle();
        return AjaxResponse.success(articles);
    }

    @ApiOperation(value = "获取文章数量")
    @GetMapping("/article/count")
    public AjaxResponse countOfArticle() {
        Long count = articleJdbcService.countOfArticle();
        return AjaxResponse.success(count);
    }
}
