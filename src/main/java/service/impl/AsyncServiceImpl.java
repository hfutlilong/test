package service.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import service.AsyncService;

/**
 * @Description 异步任务
 * @Author lilong
 * @Date 2018-11-16 15:51
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    @Async
    @Override
    public void doAsyncTask() throws InterruptedException {
        System.out.println("开始执行异步任务");
        Thread.sleep(5000);
        System.out.println("异步任务执行完毕");
    }
}
