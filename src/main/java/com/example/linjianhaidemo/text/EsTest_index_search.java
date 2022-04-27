package com.example.linjianhaidemo.text;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class EsTest_index_search {

    public static void main(String[] args)  throws Exception{
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
        //获取索引
        GetIndexRequest request = new GetIndexRequest("kkk");
        GetIndexResponse getIndexResponse = esClient.indices().get(request,RequestOptions.DEFAULT);
        System.out.println(getIndexResponse.getAliases());

        //关闭ES客户端
        esClient.close();
    }
}
