package Core.Entities;

import java.io.BufferedReader;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Json {
    public static JsonObject GetJsonFromRequestBody(HttpServletRequest request) {
        try {
            JsonParser parser = new JsonParser();

            BufferedReader reader = request.getReader();
            StringBuilder json = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                json.append(line);
            }

            return parser.parse(json.toString()).getAsJsonObject();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
