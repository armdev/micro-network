package com.project.web.handlers;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

@Named
@ApplicationScoped
public class FlightClient implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String SERVICE_PATH = "http://192.168.99.100:9090/api/";

    @PostConstruct
    public void init() {

    }

    public static void main(String args[]) {
        FlightClient obj = new FlightClient();
        FlightModel model = obj.getById(1L);
        //System.out.println(model.toString());

    }

    public FlightModel getById(Long id) {
        FlightModel model = null;
        CloseableHttpClient CLIENT = HttpClients.createDefault();
        try {
            System.out.println("start");
            HttpGet request = new HttpGet("http://192.168.99.100:9090/api/flight/" + id);
            request.addHeader("charset", "UTF-8");
            HttpResponse response = CLIENT.execute(request);
            System.out.println("start1");
            response.addHeader("content-type", "application/json;charset=UTF-8");
            HttpEntity entity = response.getEntity();
            //System.out.println("start2 " +EntityUtils.toString(entity));
            ObjectMapper mapper = new ObjectMapper();

            model = mapper.readValue((EntityUtils.toString(entity)), new TypeReference<FlightModel>() {
            });
            //     model = mapper.readValue((EntityUtils.toString(entity)), FlightModel.class);
            System.out.println("start4");
            System.out.println(model.toString());
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return model;

    }

    public List<FlightModel> getAllList() {
        List<FlightModel> model = null;
        CloseableHttpClient CLIENT = HttpClients.createDefault();
        try {
            System.out.println("start");
            HttpGet request = new HttpGet("http://192.168.99.100:9090/api/flights");
            request.addHeader("charset", "UTF-8");
            HttpResponse response = CLIENT.execute(request);
            System.out.println("start1");
            response.addHeader("content-type", "application/json;charset=UTF-8");
            HttpEntity entity = response.getEntity();
            //System.out.println("start2 " +EntityUtils.toString(entity));
            ObjectMapper mapper = new ObjectMapper();

            model = mapper.readValue((EntityUtils.toString(entity)), new TypeReference<List<FlightModel>>() {
            });
            //     model = mapper.readValue((EntityUtils.toString(entity)), FlightModel.class);
            System.out.println("start4");
            System.out.println(model.toString());
        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return model;

    }

}
