package org.example;



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UBAJson {

    public void jsonprepare(String Request,String Response) throws JSONException {
//	   	System.out.println(Response);
        JSONArray finalJson=new JSONArray();
        JSONObject req = new JSONObject(Request);
        JSONArray totalevents=req.getJSONArray("events");
        JSONArray resarr=new JSONArray(Response);
        for(int i=0;i<totalevents.length();i++) {
            JSONObject singleEventRequest = totalevents.getJSONObject(i);
            Object RequestTimeStamp=singleEventRequest.get("eventId");
            for(int j=0;j<resarr.length();j++) {
                JSONObject singleEventResponse = resarr.getJSONObject(i);
                String input=singleEventResponse.get("inputData").toString();
                JSONObject inputDataJson=new JSONObject(input);
                Object responseTimeStamp=inputDataJson.get("eventId");
                if(RequestTimeStamp.equals(responseTimeStamp)) {
                    singleEventRequest.put("responseCode", "204");
                    singleEventRequest.put("responseMessage",singleEventResponse);
                    finalJson.put(singleEventRequest);
                    break;
                }

            }
        }
        System.out.println("----------------------------Final Json-----------------------------");
        System.out.println(finalJson.toString());
//        System.out.println(finalJson.length());
        JSONObject DesiredJson=new JSONObject();
        for(int i=0;i<finalJson.length();i++) {
            JSONObject eventArr= finalJson.getJSONObject(i);
            String eventNameArray=eventArr.getString("eventName");
            try{
                DesiredJson.append(eventNameArray, eventArr);
            }catch(Exception e) {
                JSONObject eventArrayTemp=finalJson.getJSONObject(i);
                JSONArray aaa=new JSONArray();
                aaa.put(eventArrayTemp);
                DesiredJson.put(eventArr.getString("eventName"), aaa);
            }
        }
        DesiredJson.put("totalcount", finalJson.length());
        System.out.println("-------------------------------------Desired JSon-------------------------------");
        System.out.println(DesiredJson);
    }





}
