package pl.umcs;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RestController;


/**
 * Hello world!
 *
 */

@SpringBootApplication
@RestController
//@ComponentScan(basePackages = {"pl.umcs.repositories","pl.umcs.apiREST"})
public class EurekaClientApp
{

   /* @Autowired
    @Lazy
    private EurekaClient eurekaClient;

    @Value("${spring.application.name}")
    private String appName;
*/

    public static void main( String[] args )
    {

        SpringApplication.run(EurekaClientApp.class, args);
    }



    /*@Override
    public String greeting() {
        return String.format("Hello from '%s'!",
                eurekaClient.getApplication(appName).getName());
    }*/


}
