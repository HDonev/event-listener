package bg.mvr.dcis.eventlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class Controller {

    private ApplicationEventPublisher publisher;
    private List<Long> sids = new ArrayList<>(100000);

    @Autowired
    public Controller(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/")
    public String delSids() {
        publisher.publishEvent(sids);
        return "Вашата заявка за заличаване е приета и ще бъде обработена скоро.";
    }

    @PostConstruct
    public void initArray() {
        for (int i = 0; i < 10000; i++) {
            sids.add(new Random().nextLong());
        }
    }
}
