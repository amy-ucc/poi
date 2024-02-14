package com.u3.frontend;

/**
 * The purpose of this class make a call to OpenWeather API to obtain current weather
 * data and retrieve key weather information from the JSON API response 
 * 
 * @author Sadiyah Sajjad
 */

 import org.json.simple.JSONObject;
 import org.json.simple.parser.JSONParser;
 import org.json.simple.JSONArray;
 import java.net.HttpURLConnection;
 import java.net.URL;
 import java.util.Scanner;
 
 public class Weather_API {
     
     // global variable to store the JSON API response in string format 
     private static String API_response; 
     
     /**
      * String array will be used to store key weather information including Current Temperature, 
      * Feels Like Temperature, Weather Description, Maximum Temperature, Minimum Temperature, 
      * Pressure, Humidity, and Weather Icon
      */
     private static String [] weather_info = new String[8];

     private static int responseCode;
   
 
     /**
      * This method returns the current temperature value
      * @return current temperature 
      */
     public String get_currentTemp() {
 
         String result = weather_info[0];
         //String result = "13";
        
         return result; 
     }
     
     /**
      * This method returns the feels like temperature value
      * @return feels like temperature 
      */
     public String get_feelsLike(){
         
         String result = weather_info[1];
         
         return result;
         
     }
     
     /**
      * This method returns the weather description
      * @return weather description
      */
     public String get_description(){
         
         String result = weather_info[2];
         
         return result;
         
     }
     
     /**
      * This method returns the minimum temperature value
      * @return minimum temperature
      */
     public String get_minTemp(){
         
         String result = weather_info[3];
         
         return result;
         
     }
     
     /**
      * This method returns the maximum temperature value
      * @return maximum temperature
      */
     public String get_maxTemp(){
         
         String result = weather_info[4];
         
         return result;
         
     }
     
      /**
      * This method returns the pressure value
      * @return pressure
      */
     public String get_Pressure(){
         
         String result = weather_info[5];
         
         return result;
         
     }
     
      /**
      * This method returns the humidity value
      * @return humidity
      */
     public String get_Humidity(){
         
         String result = weather_info[6];
         
         return result;
         
     }
     
      /**
      * This method returns the weather icon from the API response
      * @return weather icon - string
      */
     public String get_Icon(){
         
         String result = weather_info[7];
         
         return result;
         
     }

     public int get_ResponseCode(){
        
        return responseCode;
     }
 
     public Weather_API() {
         
         try {
 
         URL url = new URL("https://api.openweathermap.org/data/2.5/weather?lat=42.9834&lon=-81.233&appid=15b349a5263488ec94c1197034d6de74&units=metric");
         
         HttpURLConnection conn = (HttpURLConnection) url.openConnection();
         conn.setRequestMethod("GET");
         conn.connect();
 
         //Check if connect is made
         //int responseCode = conn.getResponseCode();
         responseCode = conn.getResponseCode();
         //System.out.println(responseCode);
 
         // 200 OK
         if (responseCode != 200) {
             throw new RuntimeException("HttpResponseCode: " + responseCode);
         } else {
 
             StringBuilder informationString = new StringBuilder();
             Scanner scanner = new Scanner(url.openStream());
 
             while (scanner.hasNext()) {
                 informationString.append(scanner.nextLine());
             }
             //Close the scanner
             scanner.close();
 
             API_response = informationString.toString();
             
            JSONParser parse = new JSONParser();
            
            // Main JSON Object containing all weather related information 
            JSONObject mainObject1 = (JSONObject) parse.parse(API_response);
            
            // JSON Object within the main JSON object 
            JSONObject mainObject2 = (JSONObject) mainObject1.get("main");
            
            // JSON Array within the main JSON object
            JSONArray weatherArray = (JSONArray)mainObject1.get("weather");
            JSONObject weatherArray_obj = (JSONObject) weatherArray.get(0);
          
          // Retrieving key weather information from API response
          
          double temp1 = (Double) mainObject2.get("temp");
          String current_temp = Double.toString(Math.round(temp1));
 
          double temp2 = (Double) mainObject2.get("feels_like");
          String feels_like = Double.toString(Math.round(temp2));
 
          String description = weatherArray_obj.get("description").toString();
          String icon = weatherArray_obj.get("icon").toString();
          
          double temp3 = (Double) mainObject2.get("temp_min");
          String min_temp = Double.toString(Math.round(temp3));
          
          double temp4 = (Double) mainObject2.get("temp_max");
          String max_temp = Double.toString(Math.round(temp4));
          
          long temp5 = (long) mainObject2.get("pressure");
          String pressure = String.valueOf(temp5);
          
          long temp6 = (long) mainObject2.get("humidity");
          String humidity = String.valueOf(temp6);
          
          // Storing the key weather information into the weather_info string array 
          weather_info[0] = current_temp;
          weather_info[1] = feels_like;
          weather_info[2]  = description;
          weather_info[3]  = min_temp;
          weather_info[4]  = max_temp;
          weather_info[5]  = pressure;
          weather_info[6] = humidity;
          weather_info[7] = icon; 
         
         
         }
     } catch (Exception e) {
         e.printStackTrace();
     }
         
     }
        
 }
 