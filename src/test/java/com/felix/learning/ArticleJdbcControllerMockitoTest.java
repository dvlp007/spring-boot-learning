package com.felix.learning;

import com.felix.learning.model.Article;
import com.felix.learning.service.ArticleJdbcService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import javax.annotation.Resource;
import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
public class ArticleJdbcControllerMockitoTest {

    @Resource
    private MockMvc mockMvc;

    @MockBean
    private ArticleJdbcService articleJdbcService;

    @Test
    @SneakyThrows
    public void getArticleTest() {
        // 打桩：使用Mockito模拟对象的行为
        Article article = new Article();
        article.setTitle("mockito");
        Mockito.when(articleJdbcService.getArticle(1L)).thenReturn(article);

        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.request(HttpMethod.GET, "/jdbc/article/1")
        )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        mvcResult.getResponse().setCharacterEncoding(StandardCharsets.UTF_8.name());
        log.info(mvcResult.getResponse().getContentAsString());
    }

}
