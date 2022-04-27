package com.example.linjianhaidemo.text;

import org.apache.http.HttpHost;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.*;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.elasticsearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import org.elasticsearch.search.aggregations.metrics.MaxAggregationBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.sort.SortOrder;

public class EsTest_document_query {

    public static void main(String[] args)  throws Exception{
        //创建ES客户端
        RestHighLevelClient esClient = new RestHighLevelClient(
                RestClient.builder(new HttpHost("127.0.0.1",9200,"http"))
        );
        //1、全量查询数据
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.matchAllQuery()));
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //2、条件查询：termQuery:单条件
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        searchRequest.source(new SearchSourceBuilder().query(QueryBuilders.termQuery("age","25")));
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //3、分页查询：from起始条数， size页大小
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.from(2);
//        builder.size(3);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //4、排序 : sort
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        builder.sort("age", SortOrder.DESC);
//        builder.from(0);
//        builder.size(2);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //5、排除 : fetchSource : includes 包含  excludes 排除
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        String[] includes = {};
//        String[] excludes = {"age"};
//        builder.fetchSource(includes, excludes);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //6、组合查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("age","25"));
//        //boolQueryBuilder.must(QueryBuilders.matchQuery("name","张三5"));
//        //boolQueryBuilder.mustNot(QueryBuilders.matchQuery("name","张三5"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","25"));
//        boolQueryBuilder.should(QueryBuilders.matchQuery("age","26"));
//        builder.query(boolQueryBuilder);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }


        //7、范围查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        RangeQueryBuilder rangeQuery = QueryBuilders.rangeQuery("age");
//        rangeQuery.gte(22);
//        rangeQuery.lte(25);
//        builder.query(rangeQuery);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //8、模糊查询
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder().query(QueryBuilders.matchAllQuery());
//        FuzzyQueryBuilder fuzzyQueryBuilder = QueryBuilders.fuzzyQuery("name", "张").fuzziness(Fuzziness.ZERO);
//        builder.query(fuzzyQueryBuilder);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }

        //9、高亮显示
//        SearchRequest searchRequest = new SearchRequest();
//        searchRequest.indices("user");
//        SearchSourceBuilder builder = new SearchSourceBuilder();
//        TermsQueryBuilder termsQueryBuilder = QueryBuilders.termsQuery("name", "张三");
//        HighlightBuilder highlightBuilder = new HighlightBuilder();
//        highlightBuilder.preTags("<font color='red'>");
//        highlightBuilder.postTags("</font>");
//        highlightBuilder.field("name");
//        builder.highlighter(highlightBuilder);
//        builder.query(termsQueryBuilder);
//        searchRequest.source(builder);
//        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
//        SearchHits hits = response.getHits();
//        System.out.println("总条数:" + hits.getTotalHits());
//        System.out.println(response.getTook());
//        for (SearchHit searchHit: hits) {
//            System.out.println(searchHit.getSourceAsString());
//        }


        //9、聚合查询
        SearchRequest searchRequest = new SearchRequest();
        searchRequest.indices("user");
        SearchSourceBuilder builder = new SearchSourceBuilder();

        //分组
        AggregationBuilder termsAggregationBuilder = AggregationBuilders.terms("age_group").field("age");

        //聚合
        AggregationBuilder aggregationBuilder = AggregationBuilders.max("maxAge").field("age");

        builder.aggregation(aggregationBuilder);

        searchRequest.source(builder);
        SearchResponse response = esClient.search(searchRequest, RequestOptions.DEFAULT);
        SearchHits hits = response.getHits();
        System.out.println("总条数:" + hits.getTotalHits());
        System.out.println(response.getTook());
        for (SearchHit searchHit: hits) {
            System.out.println(searchHit.getSourceAsString());
        }


        //关闭ES客户端
        esClient.close();
    }
}
