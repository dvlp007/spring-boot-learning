package com.felix.learning;

import cn.hutool.json.JSONUtil;
import com.felix.learning.model.Article;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArticleJdbcControllerTest {

    @Resource
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    public void saveArticleTest() {
        Article article = Article.builder().title("标题").author("作者").content("内容").createTime(LocalDateTime.now()).build();
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.POST, "/jdbc/article")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding(StandardCharsets.UTF_8.name())
                .content(JSONUtil.toJsonStr(article))
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @SneakyThrows
    public void getArticlesTest() {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.GET, "/jdbc/articles")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @SneakyThrows
    public void getArticleTest() {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.GET, "/jdbc/article/1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    @SneakyThrows
    public void countOfArticleTest() {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.GET, "/jdbc/article/count")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        log.info(mvcResult.getResponse().getContentAsString());
    }
}
