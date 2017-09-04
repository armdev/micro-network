package io.project.resources;

import com.netflix.discovery.EurekaClient;
import io.project.models.WorkLog;
import io.project.services.WorkLogService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/logs")
@Produces(MediaType.APPLICATION_JSON_VALUE + ";charset=utf-8")
public class NodeResource {

    @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private WorkLogService workLogService;

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    @ApiOperation(value = "all logs", nickname = "health")
    public String healthcheck() {
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName() + " I am OK!!!!");
    }

    @CrossOrigin
    @ApiOperation(value = "Create log Node", nickname = "LogNode")
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Success", response = Object.class)
        ,
            @ApiResponse(code = 401, message = "Unauthorized")
        ,
            @ApiResponse(code = 403, message = "Forbidden")
        ,
            @ApiResponse(code = 404, message = "Not Found")
        ,
            @ApiResponse(code = 500, message = "Failure")})
    public Response createWorkLog(@RequestParam(value = "worklog") String worklog) {
        WorkLog entity = new WorkLog();
        entity.setWorklog(worklog);
        workLogService.saveObject(entity);
        return Response.ok(Status.OK).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).build();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/all")
    @ApiOperation(value = "all logs", nickname = "LogNode")
    public Response findAllLogs() {

        List<WorkLog> list = workLogService.getAllObjects();
        return Response.ok().entity(list).type(javax.ws.rs.core.MediaType.APPLICATION_JSON + ";charset=utf-8").build();
    }
}
