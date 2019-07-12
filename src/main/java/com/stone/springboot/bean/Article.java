package com.stone.springboot.bean;

import io.searchbox.annotations.JestId;
import lombok.*;

/**
 * @author stone
 * @date 2019/7/12 15:23
 * description
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Article {
    @JestId
    private Integer id;
    private String author;
    private String titles;
    private String content;
}
