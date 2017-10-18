package com.project.web.handlers;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IList;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@Named
@RequestScoped
public class FlightClient implements Serializable {

    private static final long serialVersionUID = 1L;
    private final String SERVICE_PATH = "http://192.168.99.100:9090/api/";
    private static final Logger log = LoggerFactory.getLogger(FlightClient.class);
    @Autowired
    private HazelcastInstance hazelcastInstance;
    private List<FlightModel> finalList = new ArrayList<>();

    @PostConstruct
    public void init() {
        log.info("Post Construct started");
      //  List<FlightModel> fetchList = this.getAllList();
      //  this.addAll(fetchList);
       // finalList = this.getListOfFlights();
    }

    public List<FlightModel> getFinalDataList() {
//        if (!FacesContext.getCurrentInstance().getRenderResponse()) {
//            return null;
//        }

           log.info("Get final list");
        finalList = this.getListOfFlights();
        return finalList;
    }

    public List<FlightModel> getListOfFlights() {
        log.info("Get all flights from cache");
        IList<FlightModel> dataStore = hazelcastInstance.getList("flightList");
        if (dataStore == null || dataStore.isEmpty()) {
            log.info("Cache is emty: fill cache");
            List<FlightModel> fetchList = this.getAllList();
            this.addAll(fetchList);
            dataStore = hazelcastInstance.getList("flightList");
        }
        return dataStore;
    }

    public void addAll(List<FlightModel> list) {
        log.info("Add all flights to cache");
        IList<FlightModel> dataStore = hazelcastInstance.getList("flightList");
        dataStore.addAll(list);
    }

    public void removeAll() {
        log.info("clear cache ");
        IList<FlightModel> dataStore = hazelcastInstance.getList("flightList");
        dataStore.clear();
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

            ObjectMapper mapper = new ObjectMapper();
            log.info("get all data from backend");
            model = mapper.readValue((EntityUtils.toString(entity)), new TypeReference<List<FlightModel>>() {
            });

        } catch (IOException | ParseException ex) {
            ex.printStackTrace();
        }
        return model;

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

}
