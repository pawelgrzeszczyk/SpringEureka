package pl.umcs;

import com.google.common.base.Optional;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import pl.umcs.model.Employee;
import pl.umcs.services.EmployeeService;

import java.util.List;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class EurekaConsumer
{
    @Autowired
    private EurekaClient eurekaClient;
    private EmployeeService employeeService;

    @Autowired
    private RestTemplate restTemplate;

    public static void main( String[] args )
    {
        SpringApplication.run(EurekaConsumer.class, args);
    }

    @Autowired
    public EurekaConsumer(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{id}")
    public Employee find(@PathVariable Long id) {
        return employeeService.find(id);
    }

    @GetMapping("/holidays/{id}/{days}")
    public String takeHolidays(@PathVariable Long id,@PathVariable int days)
    {
       return employeeService.takeHolidays(id, days);
    }

    @GetMapping("/dajGlos")
    public String dajGlos() {
        Application application
                = eurekaClient.getApplication("client");
        List<InstanceInfo> instances = application.getInstances();
        InstanceInfo instanceInfo = instances.iterator().next();
        String hostname = instanceInfo.getHostName();
        int port = instanceInfo.getPort();
        return restTemplate.getForObject(
                "http://"+hostname+":"+port+"/greeting", String.class) + " Roxx!";
    }


}
