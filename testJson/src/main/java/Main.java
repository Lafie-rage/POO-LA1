import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;

public class Main {

    private static String URL = "https://www.kiwime.com/oqdb/files/3228365465/OpenQuizzDB_228/openquizzdb_228.json";

    public static void main(String[] args) {
        JSONArray questions = getJSONObjetcFromUrl(URL).getJSONObject("quizz").getJSONObject("fr").getJSONArray("débutant");

        for(Object question : questions) {
            if(question instanceof JSONObject) {
                System.out.println(question);
            }
        }
    }

    private static JSONObject getJSONObjetcFromUrl(String url) {
        JSONObject json = new JSONObject();
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            StringBuilder builder = new StringBuilder();
            int cp;
            while((cp = buffer.read()) != -1)
                builder.append((char)cp);
            json = new JSONObject(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }
}
