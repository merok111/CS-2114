package io.github.crickon.proj5;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class APITest {
    public static void main(String... args) {
        try {
            HttpResponse<String> response = Unirest.get(
                "https://covid-19-coronavirus-statistics.p.rapidapi.com/v1/stats")
                .header("x-rapidapi-host",
                    "covid-19-coronavirus-statistics.p.rapidapi.com").header(
                        "x-rapidapi-key",
                        "9a921f0b11mshca9887a122a21f8p1d2049jsn6147d18dbbb5")
                .asString();

            Object obj = new JSONParser().parse(response.getBody());
            JSONObject jo = (JSONObject)obj;

            PrintWriter pw = new PrintWriter("jsonstats.json");
            pw.write(jo.toJSONString());

            pw.flush();
            pw.close();
        }
        catch (Exception e) {
            System.out.println("Data Set update failed, using backup");
        }
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("jsonstats.json"));
        }
        catch (IOException | ParseException e) {
            System.out.print("oops we made a fucky wucky");
            System.exit(-1);
        }
        JSONObject jo = (JSONObject)obj;

        JSONObject data = (JSONObject)jo.get("data");

        JSONArray covidArray = (JSONArray)data.get("covid19Stats");

        HashMap<String, Integer> countryCount = new HashMap<String, Integer>();

        Iterator<JSONObject> iterator = covidArray.iterator();
        int count = 0;
        while (iterator.hasNext()) {
            @SuppressWarnings("unchecked")
            HashMap<String, String> entry = (HashMap<String, String>)iterator
                .next();
            String key = entry.get("country");

            if (countryCount.get(key) == null)
                countryCount.put(key, 1);
            else
                countryCount.put(key, countryCount.get(key) + 1);
            count++;
        }
        System.out.println(count);
        System.out.println(countryCount.get("US"));
        System.out.println(countryCount.get("United Kingdom"));
        System.out.println(countryCount.get("Australia"));
        System.out.println(countryCount.get("China"));

    }
}
