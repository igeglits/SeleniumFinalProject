package utils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckHttpStatus {

    public static int getHttpStatusCode(String url) throws IOException {
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            throw new MalformedURLException("Invalid URL, missing protocol: " + url);
        }
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
        connection.setRequestMethod("GET");
        connection.connect();
        int statusCode = connection.getResponseCode();
        connection.disconnect();
        return statusCode;
    }
}
