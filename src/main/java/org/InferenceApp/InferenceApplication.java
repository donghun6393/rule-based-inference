//package org.InferenceApp;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.util.HashMap;
//import java.util.Map;
//
//import org.DroolsEngine.DroolsApp;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//public class InferenceApplication {
//	
//    public static void main( String[] args ) throws Exception {
//    	
//    	String SERVER_URL = "http://localhost:1337/";
//    	
//    	String posture = "WALKING";
//    	
//    	DroolsApp.executeInferenceEngine(SERVER_URL, posture);
//    	
//    	
////        String SERVER_SEND_URL = "https://webhook.site/155dc023-a2a6-4b9d-8c29-da229dce82b9";
////        String SERVER_GET_URL = "http://localhost:1337/";
////
////        JSONObject obj = getData(SERVER_GET_URL);
////
////        Number positionXnum = (Number) obj.get("positionX");
////        Double positionX = positionXnum.doubleValue();
////        Number positionYnum = (Number) obj.get("positionY");
////        Double positionY = positionYnum.doubleValue();
////        
////        // output of posture detection module
////        String poseName = (String) obj.get("poseName");
////        
////        if (positionX != null && positionY != null && poseName != null) {
////            System.out.println(obj.toString());
////            System.out.println(positionX);
////            System.out.println(positionY);
////            System.out.println(poseName);
////            
////            // rule engine
////            DroolsEngineInput droolsEngineInput = new DroolsEngineInput();
////            
////            droolsEngineInput.positionX = positionX;
////            droolsEngineInput.positionY = positionY;
////            droolsEngineInput.poseName = poseName;
////            
////            DroolsEngineOutput droolsEngineOutput = new DroolsEngineOutput();
////            
////            droolsEngineOutput = DroolsController.inputForDrools(droolsEngineInput);
////            
////         // rule engine output
////            System.out.println("---------------------------------------------------------------------");
////    		System.out.println();
////    		System.out.println("INPUT FOR INFERENCE ENGINE: ");
////    		System.out.println("The coordinate (X,Y,Z) of worker is [(" + droolsEngineInput.getPositionX() + ", " + droolsEngineInput.getPositionY() + ", 0.0" + ")].");
////    		System.out.println("The name of worker posture is [" + droolsEngineInput.getPoseName() + "].");
////
////    		System.out.println();
////    		System.out.println("THE OUTPUT OF INFERENCE ENGINE: ");
////    		System.out.println("The name of location is [" + droolsEngineOutput.getLocationName() + "].");
////    		System.out.println("The name of workspace is [" + droolsEngineOutput.getTaskName() + "].");
////    		System.out.println("The name of posture is [" + droolsEngineOutput.getPoseName() + "].");
////    		System.out.println("The weight for the location and workspace is [" + droolsEngineOutput.getLocationNtaskWeight() + "].");
////    		System.out.println("The weight for the posture is ["+ droolsEngineOutput.getPoseWeight() + "].");
////    		System.out.println("The risk level is [" + droolsEngineOutput.getRiskLevel() + "].");
////    		System.out.println();
////    		System.out.println("---------------------------------------------------------------------");
////
////            
////            // send rule engine output as a JSON 
////            HashMap<String, String> jsonData = new HashMap<String, String>();
////            jsonData.put("Location", droolsEngineOutput.getLocationName());
////            jsonData.put("Workspace", droolsEngineOutput.getTaskName());
////            jsonData.put("Posture", droolsEngineOutput.getPoseName());
////            jsonData.put("Risklevel", droolsEngineOutput.getRiskLevel());
////            
////            sendData(SERVER_GET_URL, jsonData);
////       }
//
//    }
//
//
//    private static JSONObject makeJsonObject(Map<String, String> values){
//        JSONObject json = new JSONObject();
//        values.forEach((key, value) -> {
//            json.put(key, value);
//        });
//        return json;
//    }
//    
//    public static JSONObject getData(String targetUrl) throws Exception {
//        URL url = new URL(targetUrl);
//        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        JSONParser parser = new JSONParser();
//        JSONObject responseJson = null;
//        try (AutoCloseable a = () -> conn.disconnect()){
//            conn.setRequestMethod("GET");
//            conn.setDoOutput(true); //false
//            
//            int responseCode = conn.getResponseCode();
//            if (responseCode != 200) {
//                System.out.println("Error");
//            }
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
//            StringBuilder sb = new StringBuilder();
//            String line = "";
//            while ((line = br.readLine()) != null) {
//                sb.append(line);
//            }
//
//            responseJson = (JSONObject)parser.parse(sb.toString());
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return responseJson;
//    }
//
//    public static Map<String, Object> sendData(String targetUrl, Map<String, String> values) throws Exception {
//        Map<String, Object> response = new HashMap<>();
//
////        URL url = new URL("http://demo.jiniworld.me/users");
//        URL url = new URL(targetUrl);
//        final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//        try (AutoCloseable a = () -> conn.disconnect()) {
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setDoOutput(true);
//
//            try (final OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(), "UTF-8")) {
//                JSONObject json = makeJsonObject(values);
//                osw.write(json.toString());
//                osw.flush();
//            }
//
//            //response.put("status", conn.getResponseCode());
//            if (conn.getResponseCode() != 200){
//                System.out.println("Fail to send data");
//                return response;
//            }
//            return response;
//        }
//    }
//
//}