package demo.netty.demo4;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTTPUtils {
    public static String httpReq(String serviceUrl, String parameter, String restMethod,String sessionid) {
        try {
            // 如果请求方法为PUT,POST和DELETE设置DoOutput为真
            if (!"GET".equals(restMethod)) {
                URL url = new URL(serviceUrl);
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                con.setRequestProperty("Cookie", "JSESSIONID="+sessionid);
                con.setRequestMethod(restMethod);
                con.setDoOutput(true);
                if (!"DELETE".equals(restMethod)) { // 请求方法为PUT或POST时执行
                    OutputStream os = con.getOutputStream();
                    os.write(parameter.getBytes("UTF-8"));
                    os.close();
                }
                // 获取返回结果
                String encoding = con.getContentEncoding();
                InputStream is = con.getInputStream();
                int read = -1;
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                while ((read = is.read()) != -1) {
                    baos.write(read);
                }
                byte[] data = baos.toByteArray();
                baos.close();
                String content = null;
                if (encoding != null) {
                    content = new String(data, encoding);
                } else {
                    content = new String(data);
                }
                //logger.info("响应内容:" + content);
                con.disconnect();
                return content;
            } else { // 请求方法为GET时执行
                URL url = new URL((serviceUrl).trim());
                java.net.URLEncoder.encode(url.toString(), "UTF-8");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.setRequestMethod("GET");
                connection.setConnectTimeout(3000);
                connection.setReadTimeout(3000);
                connection.connect();
                // 接收返回请求
                BufferedReader reader = new BufferedReader(new InputStreamReader(
                        connection.getInputStream(), "UTF-8"));
                String line = "";
                StringBuffer buffer = new StringBuffer();
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                String responseData = buffer.toString();
                //logger.info("响应内容:" + responseData);
                connection.disconnect();
                return responseData;
            }
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }
        return "";
    }


    public static void main(String args[]){
//        String requestUrl = "http://luna-passport.mobike.com/internal/client?client_id=gov_portal";
//        String requestUrl = "http://luna-passport.mobike.com/internal/client?client_id=gov_portal";
        String requestUrl = "http://47.100.124.51:8000/trackings/?coordinate_type=gps";
        String str = HTTPUtils.httpReq(requestUrl,"","GET","");
        System.out.println(str);
    }

}