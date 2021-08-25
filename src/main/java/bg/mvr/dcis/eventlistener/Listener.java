package bg.mvr.dcis.eventlistener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Listener {
    private TransactionalClass transactionalClass;

    @Autowired
    public Listener(TransactionalClass transactionalClass) {
        this.transactionalClass = transactionalClass;
    }

    @Async
    @EventListener(classes = List.class)
    public void deletePerson(List<Long> sids){
        sids.forEach(sid -> {
            try {
                Thread.sleep(1);
                System.out.println(Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            transactionalClass.checkTransaction();
        });
    }
}
