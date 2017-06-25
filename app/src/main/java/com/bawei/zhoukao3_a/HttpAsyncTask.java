package com.bawei.zhoukao3_a;

import android.os.AsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.CoreConnectionPNames;

import java.io.IOException;
import java.io.InputStream;

public class HttpAsyncTask extends AsyncTask<String, Void, String> {


private HttpResponse httpResponse;
private InputStream inputStream;
private String string;


@Override
protected void onPreExecute() {
super.onPreExecute();
}


@Override
protected String doInBackground(String... params) {

String path = "http://v.juhe.cn/weather/index?cityname=%E5%8C%97%E4%BA%AC&dtype=&format=&key=e32ff0ecc9e5589c86382177a44bd806";

HttpClient httpClient = new DefaultHttpClient();
httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, 20000);
httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, 20000);

HttpGet get = new HttpGet(path);

try {

httpResponse = httpClient.execute(get);

if (httpResponse.getStatusLine().getStatusCode() == 200){

inputStream = httpResponse.getEntity().getContent();
string = ReadFile.readFromFile(inputStream);

System.out.println(string);

return string;

}


} catch (IOException e) {
e.printStackTrace();
}


return null;
}


@Override
protected void onPostExecute(String s) {
super.onPostExecute(s);

}
}