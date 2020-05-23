package com.example.administrator.demo.java_base.thread;

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
 * @describe   ~~
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
    @BindView(R.id.tv_easy5)
    TextView tvEasy5;
    @BindView(R.id.tv_easy6)
    TextView tvEasy6;
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
    @OnClick({R.id.tv_easy, R.id.tv_easy2, R.id.tv_easy3, R.id.tv_easy4, R.id.tv_easy5, R.id.tv_easy6})
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
            case R.id.tv_easy5:
                final StorageB storage = new StorageB();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            storage.write(i);
                            Log.e("当前线程：" + Thread.currentThread().getName() + " 存 ：", "" + i);
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            Log.e("当前线程：" + Thread.currentThread().getName() + " 取 ：", storage.read(i).toString());
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                break;
            case R.id.tv_easy6:
                final Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 20; i++) {
                            Log.e("当前线程：" + Thread.currentThread().getName(), "运行" + i);
                        }
                        Log.e("当前线程：" + Thread.currentThread().getName(), "运行结束");
                    }
                });
                thread3.setName("A");
                Thread thread4 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            Log.e("当前线程：" + Thread.currentThread().getName(), "运行" + i);
                            if (i == 5) {
                                try {
                                    //在此节点之后，thread4 进入阻塞状态，要等待 thread3 执行完毕之后才会继续执行（转为就绪状态）
                                    thread3.join();
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        Log.e("当前线程：" + Thread.currentThread().getName(), "运行结束");
                    }
                });
                thread4.setName("B");
                thread3.start();
                thread4.start();
                break;
        }
    }
}
