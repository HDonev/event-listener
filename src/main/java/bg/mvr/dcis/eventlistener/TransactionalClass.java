package bg.mvr.dcis.eventlistener;

import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class TransactionalClass {
    @Transactional
    public void checkTransaction(){
        TransactionStatus status = TransactionAspectSupport.currentTransactionStatus();
        System.out.println(status.toString());
    }
}
