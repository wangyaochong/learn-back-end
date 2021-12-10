package util;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.NoConnectionReuseStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
public class HttpUtil {
    CloseableHttpClient httpClient = HttpClientBuilder.create()
            .setConnectionReuseStrategy(new NoConnectionReuseStrategy())//立刻关闭连接
            .build();
    public Object post(Object obj) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder("requestUrl");
        URI uri = uriBuilder.setScheme("http").setHost("host").setPort(8080).build();
        HttpPost httpPost = new HttpPost(uri);
        StringEntity entity = new StringEntity(JsonUtil.toJson(obj));
        entity.setContentType(ContentType.APPLICATION_JSON.toString());
        entity.setContentEncoding("utf-8");
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        return JsonUtil.fromJson(EntityUtils.toString(response.getEntity()), Object.class);
    }
    public Object get(String param) throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder("requestUrl");
        uriBuilder.setParameter("param", param);
        URI uri = uriBuilder.setScheme("http").setHost("host").setPort(8080).build();
        HttpGet get = new HttpGet(uri);
        CloseableHttpResponse response = httpClient.execute(get);
        return JsonUtil.fromJson(EntityUtils.toString(response.getEntity()), Object.class);
    }
}
