package com.bl.station.utils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName FileUploadUtil
 * @Description TODO
 * @Date 2018/8/20 15:27
 * @Author itastro
 * @Version 1.0
 **/
public class FileUploadUtil {

    public static String upload(String httpurl, String fileName, InputStream inputStream) throws Exception {
        String result = "";

        /**
         * 定义数据分割线
         */
        String BOUNDARY = "---------7d4a6d158c9";
        URL url = new URL(httpurl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        //发送post请求必须设置
        conn.setDoOutput(true);
        conn.setDoInput(true);
        conn.setUseCaches(false);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("connection", "Keep-Alive");


        conn.setRequestProperty("User-Agent", "Mozilla/5.0");
        conn.setRequestProperty("Charsert", "UTF-8");
        conn.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + BOUNDARY);
        OutputStream out = new DataOutputStream(conn.getOutputStream());
        /**
         *  定义最后数据分隔线
         */
        byte[] end_data = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();
        StringBuilder sb = new StringBuilder();
        sb.append("--");
        sb.append(BOUNDARY);
        sb.append("\r\n");
        sb.append("Content-Disposition: form-data;name=\"file" + 1
                + "\";filename=\"" + fileName + "\"\r\n");
        sb.append("Content-Type:application/octet-stream\r\n\r\n");

        byte[] data = sb.toString().getBytes();
        out.write(data);
        DataInputStream in = new DataInputStream(inputStream);
        int bytes = 0;
        byte[] bufferOut = new byte[1024];
        while ((bytes = in.read(bufferOut)) != -1) {
            out.write(bufferOut, 0, bytes);
        }
        /**
         *  多个文件时，二个文件之间加入这个
         */
        out.write("\r\n".getBytes());
        in.close();
        out.write(end_data);
        out.flush();
        out.close();
        // 定义BufferedReader输入流来读取URL的响应
        BufferedReader reader = new BufferedReader(new InputStreamReader(
                conn.getInputStream()));
        String line = null;
        while ((line = reader.readLine()) != null) {
            result += line;
        }


        return result;
    }
    //Connection timed out: connect

    public static void main(String[] args) throws Exception {
        String content = "hellow 中国";
        InputStream ips = new ByteArrayInputStream(content.getBytes("UTF-8"));
        String result = upload("http://192.168.153.128", "text.txt", ips);

        System.out.println(result);

    }

}
