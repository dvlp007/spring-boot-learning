package com.felix.learning.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel("文章")
public class Article {
    /**
     * 主键
     */
    @ApiModelProperty("ID")
    private Long id;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String title;
    /**
     * 作者
     */
    @ApiModelProperty("作者")
    private String author;
    /**
     * 内容
     */
    @ApiModelProperty("内容")
    private String content;
    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
}
