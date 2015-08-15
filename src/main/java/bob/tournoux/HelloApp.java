package bob.tournoux;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.time.LocalDateTime;

public class HelloApp {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        HelloService helloService = context.getBean(HelloService.class);
        System.out.println(helloService.sayHello());
        GpioTest test = new GpioTest();

        try{
            test.test();
        }
        catch(Exception e){
            System.out.println("Problem with the GPIO.");
        }

        while (true){
            String msg = String.format("Current Time is: %s", LocalDateTime.now().toString());
            System.out.println(msg);
            try{
                Thread.sleep(5000L);
            }catch(Exception e){
                System.out.println("could not sleep so will exit now.");
                break;
            }
        }
    }
}
