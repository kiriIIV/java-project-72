package hexlet.code.util;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlUtils {

    public static String normalizeUrl(String urlString) throws MalformedURLException {
        URL url = new URL(urlString);
        String protocol = url.getProtocol();
        String host = url.getHost();
        int port = url.getPort();

        if (port == -1) {
            return protocol + "://" + host;
        } else {
            return protocol + "://" + host + ":" + port;
        }
    }

    public static boolean isValidUrl(String urlString) {
        try {
            new URL(urlString);
            return true;
        } catch (MalformedURLException e) {
            return false;
        }
    }
}