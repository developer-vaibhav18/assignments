package com.example.dream11.configuration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.TransportUtils;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import org.apache.http.HttpHost;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.elasticsearch.client.RestClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.File;

@Configuration
public class ElasticsearchClientConfig {
    @Bean
    public ElasticsearchClient elasticsearchClient() throws Exception {
        File certFile = new File("/Users/vssinha/Downloads/elasticsearch-8.6.2/config/certs/http_ca.crt");
        SSLContext sslContext = TransportUtils.sslContextFromHttpCaCrt(certFile);
        String login = "elastic";
        String password = "81=tzyHZ4NJvwgqJ0GDA";
        BasicCredentialsProvider credsProv = new BasicCredentialsProvider();
        credsProv.setCredentials(AuthScope.ANY, new UsernamePasswordCredentials(login, password));

        RestClient restClient = RestClient.builder(new HttpHost("localhost", 9200, "https"))
                                          .setHttpClientConfigCallback(hc -> hc.setSSLContext(sslContext)
                                                                               .setDefaultCredentialsProvider(
                                                                                       credsProv)).build();
        ElasticsearchTransport transport = new RestClientTransport(restClient, new JacksonJsonpMapper());
        ElasticsearchClient client = new ElasticsearchClient(transport);
        return client;
    }
}
