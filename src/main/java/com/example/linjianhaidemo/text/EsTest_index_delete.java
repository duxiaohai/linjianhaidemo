package com.example.linjianhaidemo.text;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;

public class EsTest_index_delete {

    public static void main(String[] args)  throws Exception{
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
        //获取索引
        DeleteIndexRequest request = new DeleteIndexRequest("kkk");
        AcknowledgedResponse deleteIndexRequest = esClient.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println(deleteIndexRequest.isAcknowledged());

        //关闭ES客户端
        esClient.close();
    }
}
