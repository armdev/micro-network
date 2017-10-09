package io.project.core.resources;

import io.project.core.dao.GreetingClient;
import javax.ws.rs.Produces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/core")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class CoreResource {

   // @Autowired
  //  private GreetingClient greetingClient;

//    @RequestMapping("/get-greeting")
//    public String greeting(Model model) {
//        model.addAttribute("healthcheck", greetingClient.greeting());
//        return "greeting-view";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public String healthcheck() {
        return "I am ok";
    }

}
