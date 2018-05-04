package Details.utils;

import Details.controller.request.QconRequestVo;
import Details.model.AccessTokenVo;
import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.http.HttpStatus;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Map;

import static Details.utils.FileUtil.saveImageToByInputStream;

/**
 * Created with IntelliJ IDEA.
 * User: XYY78
 * Date: 2018/4/16
 * Time: 13:15
 * Desc:
 * To change this template use File | Settings | File Templates.
 */

public class HttpUtil {

    private static CloseableHttpClient client = createSSLClientDefault();

    public static CloseableHttpClient createSSLClientDefault() {
        try {
            SSLContext sslContext = new SSLContextBuilder().loadTrustMaterial(null, new TrustStrategy() {
                // 信任所有
                public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
                    return true;
                }
            }).build();
            HostnameVerifier hostnameVerifier = NoopHostnameVerifier.INSTANCE;
            SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslContext, hostnameVerifier);
            return HttpClients.custom().setSSLSocketFactory(sslsf).build();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
        return HttpClients.createDefault();

    }
    /**
     * get请求返回jsonObject(引入了json jar依赖，可以放开给调用方做转换)
     * @param baseUrl
     * @param params
     * @return
     */
    public static String get(String baseUrl, Map<String, String> params){
        String paramStr = getRequestParam(params);
        String reqUrl = baseUrl + paramStr;
        HttpGet httpGet = new HttpGet(reqUrl);
        StringBuilder entityStringBuilder=new StringBuilder();;
        try {
            CloseableHttpResponse httpResponse =  client.execute(httpGet);
            if(httpResponse.getStatusLine() != null
                    && httpResponse.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
               HttpEntity entity = httpResponse.getEntity();
               if(entity != null){
                   BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(),"UTF-8"),4*1024);
                   String line;
                   while ( (line =reader.readLine()) != null){
                       entityStringBuilder.append(line);
                   }
                   return entityStringBuilder.toString();
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String post(String baseUrl, String jsonStr, String targetLocation){
        HttpPost httpPost = new HttpPost(baseUrl);
        httpPost.addHeader("Connection", "keep-alive");
        httpPost.addHeader("Accept", "*/*");
        httpPost.addHeader(HTTP.CONTENT_TYPE, "application/json; charset=UTF-8");

        StringEntity  stringEntity = null;
        try {
            stringEntity = new StringEntity(jsonStr);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        stringEntity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE, "UTF-8"));
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);
        try {
            CloseableHttpResponse response = client.execute(httpPost);
            if(response != null
                    && response.getStatusLine() != null
                    && response.getStatusLine().getStatusCode() == HttpStatus.OK.value()){
                HttpEntity resEntity = response.getEntity();
                if(resEntity != null){
                    InputStream inputStream = resEntity.getContent();
                    try {
                     return saveImageToByInputStream(inputStream,targetLocation);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    private static String getRequestParam(Map<String, String> params) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("?");
        int paramsSize = params.size();
        int i = 0 ;
        for (Map.Entry param: params.entrySet()
             ) {
            stringBuilder.append(param.getKey() + "=" + param.getValue());
            i++;
            if(i < paramsSize){
                stringBuilder.append("&");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args){
        String appId= "wxf40a810deaa95da8";
        String secret= "7fc84d2b6f098b2afe64e4fbd8de1750";

        String url="https://api.weixin.qq.com/cgi-bin/token";
//        wx.qcode.request.url="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="

        Map<String,String> pa
                = new HashMap<>();
        pa.put("grant_type", "client_credential");
        pa.put("appid", appId);
        pa.put("secret", secret);
        String jsonStr = get(url, pa);
        AccessTokenVo tokenVo =JSON.parseObject(jsonStr, AccessTokenVo.class);

        QconRequestVo qconRequestVo = new QconRequestVo();
        qconRequestVo.setPath("pages/index/index");
        qconRequestVo.setWidth("430");
        String requestPara = JSON.toJSONString(qconRequestVo);
        String target = "D:/dev/PicDemo/qCon/";
        String token = tokenVo.getAccess_token();
        post("https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token="+token,requestPara,target);
    }
}
