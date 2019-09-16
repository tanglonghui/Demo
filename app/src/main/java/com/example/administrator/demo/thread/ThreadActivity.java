package com.example.administrator.demo.thread;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author TangLongHui
 * @data created on 2019/8/1
 * @describe TODO ~~
 */

public class ThreadActivity extends AppCompatActivity {

    @BindView(R.id.tv_easy)
    TextView tvEasy;
    @BindView(R.id.tv_easy2)
    TextView tvEasy2;
    @BindView(R.id.tv_easy3)
    TextView tvEasy3;
    @BindView(R.id.tv_easy4)
    TextView tvEasy4;
    ExecutorService executorService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);
        ButterKnife.bind(this);
//        newCachedThreadPool创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收，则新建线程。
//        newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。
//        newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。
//        newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。
        executorService = Executors.newCachedThreadPool();
    }

    //    ExecutorService executorService = Executors.newFixedThreadPool(4);
    @OnClick({R.id.tv_easy, R.id.tv_easy2, R.id.tv_easy3, R.id.tv_easy4})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_easy:
                ThreadA threadA = new ThreadA("线程 甲");
                ThreadA threadA2 = new ThreadA("线程 乙");
                threadA.setPriority(10);
                threadA2.setPriority(1);
                threadA.start();
                threadA2.start();
                break;
            case R.id.tv_easy2:
                Thread thread1 = new Thread(new RunnableA());
                thread1.setName("线程 1");
                thread1.start();
                break;
            case R.id.tv_easy3:
                FutureTask<String> futureTask = new FutureTask(new CallableA());
                Thread thread2 = new Thread(futureTask, "线程 CallableA");
                thread2.start();
                try {
                    Log.e("Callable 返回值：", futureTask.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.tv_easy4:
                FutureTask<String> futureTask1 = new FutureTask(new CallableA());
                executorService.submit(futureTask1);
                executorService.submit(new RunnableA());
                executorService.submit(new RunnableA());
                try {
                    Log.e("Callable 返回值：", futureTask1.get());
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
