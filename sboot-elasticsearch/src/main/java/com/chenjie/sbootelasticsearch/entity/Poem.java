package com.chenjie.sbootelasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;



/**
 * @author chenjie
 * @date 2018/10/11
 * @description: 定义索引名字及类型
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "poem",type = "poem",shards = 1, replicas = 0)
public class Poem {

    @Id
    private long id;
    private String title;
    private String content;

    public Poem(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.JSON_STYLE);
    }

}
