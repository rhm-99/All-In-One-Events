/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.json.allinoneeventsfinal;

/**
 *
 * @author rhiya
 */
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.json.Json;
import javax.json.JsonValue;
import javax.persistence.PersistenceContext; //line 8 to 21 imports all the necessary dependencies that I need

/**
 *
 * @author rhiya
 */
public class TicketMaster implements TicketMasterInterface {

    @PersistenceContext
    private TicketMaster tm;

    private static java.net.HttpURLConnection connection;
    //default request method

    public String apiKey = "h28XVg0n5l5feS8g8VsX9tGrCPR8dYdI"; // makes the api key a permanant part of the backend so whenever you call it, its easier to do so. 
    private String name;
    private String id;
    private String url;
    private String localTime;
    private String localDate;
    private String code;
    private String genreName;
    private String note;
    private String type;
    private String min;
    private String max;
    private String venName;
    private String venPostcode;
    private String city;

    public void getEvents(String city) {
        //URL url = new URL("https://app.ticketmaster.com/discovery/v2/events?apikey=" + apiKey + "&city=" + city); //makes the website that you are calling from known
        getEventsList(getJsonObject("events", "&city=" + city));
    }

    public JsonObject getJsonObject(String call, String args) {

        BufferedReader reader;
        String line;
        StringBuffer responseContent = new StringBuffer();

        try {
            URL url = new URL("https://app.ticketmaster.com/discovery/v2/" + call + "?apikey=" + apiKey + args); //makes the website that you are calling from known
            connection = (java.net.HttpURLConnection) url.openConnection(); //cof

            connection.setRequestMethod("GET"); //sets request method which is sent to remote HTTP remote server, can only be called before connection is made
            connection.setRequestProperty("Content-Type", "application/json"); //sets general request property to json
/*
            int status = connection.getResponseCode();
            
            if (status > 299) {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                while ((line = reader.readLine()) != null) {
                    responseContent.append(line);
                }
                reader.close();
            }
            System.out.println(responseContent.toString());
             */
            reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            JsonReader jsonReader = Json.createReader(reader);
            JsonObject object = jsonReader.readObject();
            jsonReader.close();

            //allows Json objects to be read
            // JsonObject object = new JsonObject(responseContent.toString());
            return object;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> getEventsList(JsonObject object) {
        List<Event> eventsList = new ArrayList<>();
        JsonObject embedded = object.getJsonObject("_embedded");
        JsonArray events = embedded.getJsonArray("events");
        for (JsonObject element : events.getValuesAs(JsonObject.class)) {//getting a list of JsonObjects does this for each event 
            String name = element.getString("name");
            String id = element.getString("id");
            String url = element.getString("url");
            /*        JsonArray imageArr = element.getJsonArray("images");
        JsonObject imageEle = imageArr.getJsonObject(0);
        String imgUrl = imageEle.getString("url");
             */
            JsonObject dates = element.getJsonObject("dates");
            JsonObject start = dates.getJsonObject("start");
            String localDate = start.getString("localDate");
            String localTime = start.getString("localTime");
            JsonObject status = dates.getJsonObject("status");
            String code = status.getString("code");
            JsonArray classifications = element.getJsonArray("classifications");
            JsonObject classEle = classifications.getJsonObject(0);
            JsonObject genre = classEle.getJsonObject("genre");
            String genreName = genre.getString("name");
            String note = element.getString("pleaseNote");
            JsonArray priceRanges = element.getJsonArray("priceRanges");
            for (JsonObject priceEle : priceRanges.getValuesAs(JsonObject.class)) {
                String type = priceEle.getString("type");
                String min = priceEle.getString("min");
                String max = priceEle.getString("max");
            }
            //looping through and getting the price range (do the same for genres and venues) this is within the other if statement and checks through the price elements
            JsonObject _embedded = element.getJsonObject("_embedded");
            JsonArray venues = _embedded.getJsonArray("venues");
            for (JsonObject venuesEle : venues.getValuesAs(JsonObject.class)) {
                JsonObject venueEle = venues.getJsonObject(0);
                String venName = venueEle.getString("name");
                String venPostcode = venueEle.getString("postalCode");
                String city = venueEle.getString("city");
            }
        }
        for (JsonValue event : events) {
            eventsList.add(new Event(name, id, url, localTime, localDate, code, genreName, note, type, min, max, venName, venPostcode, city));
        }
        System.out.println(" ");
        System.out.println("name- " + name);
        System.out.println("id- " + id);
        System.out.println("url- " + url);
//        System.out.println("Image url: " + imgUrl);
        System.out.println("localTime- " + localTime);
        System.out.println("localDate- " + localDate);
        System.out.println("code- " + code);
        System.out.println("genre name- " + genreName);
        System.out.println("note- " + note);
        System.out.println("type- " + type);
        System.out.println("min- " + min);
        System.out.println("max- " + max);
        System.out.println("venName- " + venName);
        System.out.println("Postcode- " + venPostcode);
        System.out.println("city- " + city);
        return eventsList;

        /*the role of System.out.println is to print a part of the code, for example, 
        "System.out.println("genre name- " + genreName);" will print out 'genre name- ' 
        and then the genre name of the event*/
    }

//    public TicketMaster() {
//        TicketMaster ticketMaster = new TicketMaster();
//
//        JsonObject object = ticketMaster.getJsonObject("events", "&city=" + "london");
//
//        List<Event> eventsList = ticketMaster.getEventsList(object);
//        for (int i = 0; i < eventsList.size(); i++) {
//            eventsList.get(i).getName();
//            eventsList.get(i).getId();
//            eventsList.get(i).getUrl();
//            eventsList.get(i).getLocalTime();
//            eventsList.get(i).getLocalDate();
//            eventsList.get(i).getCode();
//            eventsList.get(i).getGenreName();
//            eventsList.get(i).getNote();
//            eventsList.get(i).getType();
//            eventsList.get(i).getMin();
//            eventsList.get(i).getMax();
//            eventsList.get(i).getVenName();
//            eventsList.get(i).getVenPostcode();
//            eventsList.get(i).getCity();
//
//        }

    @Override
    public List<Event> findAllEvents() {
        TicketMaster ticketMaster = new TicketMaster();

        JsonObject object = ticketMaster.getJsonObject("events", "&city=" + "london");

        List<Event> eventsList = ticketMaster.getEventsList(object);
        for (int i = 0; i < eventsList.size(); i++) {
            eventsList.get(i).getName();
            eventsList.get(i).getId();
            eventsList.get(i).getUrl();
            eventsList.get(i).getLocalTime();
            eventsList.get(i).getLocalDate();
            eventsList.get(i).getCode();
            eventsList.get(i).getGenreName();
            eventsList.get(i).getNote();
            eventsList.get(i).getType();
            eventsList.get(i).getMin();
            eventsList.get(i).getMax();
            eventsList.get(i).getVenName();
            eventsList.get(i).getVenPostcode();
            eventsList.get(i).getCity();

        }
        return eventsList;
    }
    }
   


