package service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.AsyncService;
import service.TestService;

/**
 * @Description TODO
 * @Author lilong
 * @Date 2018-11-16 15:34
 */
@Service
public class TestServiceImpl implements TestService {
    @Autowired
    private AsyncService asyncService;

    @Override
    public void testAsync() {
        System.out.println("开始执行");
        try {
            asyncService.doAsyncTask();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行完毕");
    }


//    @Async
//    public void inTask() throws InterruptedException {
//        System.out.println("开始执行异步任务");
//        Thread.sleep(5000);
//        System.out.println("异步任务执行完了");
//    }

    @Override
    public void test() {
        System.out.println("oh, yeah");
    }
}
