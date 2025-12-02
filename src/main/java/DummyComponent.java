import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
//@Profile({"prod","dev"})
public class DummyComponent {

    @Value("${data}")
    String data;
    @Value("${server.port}")
    String port;
    @Value("${date}")
    String data1;

    public DummyComponent() {

    }
    @PostConstruct
    //this annotations will call init methods
    public void method(){ System.out.println(data);
        System.out.println(port);
        System.out.println(data1);}
}
