import DTO.Measurement;
import DTO.Measurements;
import DTO.Sensor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class WeatherApp {

    public static void main(String[] args) {
        registration("Russia[URAL]");
//        getAllMeasurements();
//            getRainDays();
        registrationNewMeasurement(new Measurement(10.7,false,new Sensor("Russia[URAL]")));
    }
    private static void registration(Object sensorName){
        String URL = "http://localhost:8080/sensor/registration";

        HashMap<String,Object> map = new HashMap<>();
        map.put("name",sensorName);
        postRequest(URL,map);

    }
    private static void registrationNewMeasurement(Measurement measurement){
        String URL = "http://localhost:8080/measurement/add";
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        System.out.println(measurement.toString());
        HttpEntity<Object> httpEntity = new HttpEntity<>(measurement,headers);
        try {
            restTemplate.postForObject(URL,httpEntity,String.class);
            System.out.println("Good");
        }catch (RestClientException e){
            System.out.println("Error");
        }

    }

    private static void getAllMeasurements(){
        String URL = "http://localhost:8080/measurement";
        RestTemplate restTemplate = new RestTemplate();
        Measurements measurement = restTemplate.getForObject(URL, Measurements.class);
        if (measurement != null) {
            measurement.getList().forEach(System.out::println);
        }
    }

    private static void getRainDays(){
        String URL = "http://localhost:8080/measurement/rainDays";
        RestTemplate restTemplate = new RestTemplate();
        System.out.println(restTemplate.getForObject(URL,Long.class));
    }
    private static void postRequest(String URL, HashMap<String,Object> map){
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> httpEntity = new HttpEntity<>(map,headers);

        try{
            restTemplate.postForObject(URL,httpEntity,String.class);
            System.out.println("Good");
        }catch (RestClientException e){
            System.out.println("Error!!");

        }

    }
}
