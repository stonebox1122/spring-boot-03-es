package com.stone.springboot;

import com.stone.springboot.bean.Article;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBoot03EsApplicationTests {

    @Autowired
    JestClient jestClient;

    @Test
    public void contextLoads() {
        // 保存数据到ES
        Article article = new Article(1,"好消息","zhangsan","Hello World");
        Index index = new Index.Builder(article).index("stone").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search(){
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        Search search = new Search.Builder(json).addIndex("stone").addType("news").build();
        try {
            SearchResult result = jestClient.execute(search);
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
