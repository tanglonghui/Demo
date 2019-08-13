package com.example.administrator.demo.rxjava;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

public class RxJavaActivity extends AppCompatActivity {
    public static final String TAG =" RxJava";

    @BindView(R.id.tv_easy)
    TextView tvEasy;
    @BindView(R.id.tv_easy2)
    TextView tvEasy2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.tv_easy, R.id.tv_easy2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_easy:
                //两个一拆开就好理解了
                //被观察者
                ObservableOnSubscribe<Integer> s = new ObservableOnSubscribe<Integer>() {
                    @Override
                    public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                        e.onNext(1);
                        e.onNext(2);
                        e.onNext(3);
                        e.onComplete(); //结束
                        e.onNext(4);
                    }
                };

                //观察者
                Observer<Integer> b = new Observer<Integer>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {
                        Log.e(TAG, "onSubscribe: " + d.isDisposed());
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.e(TAG, "onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e(TAG, "onComplete: ");
                    }
                };
                Observable.create(s).subscribe(b);
                break;
            case R.id.tv_easy2:
                Observable.create(new ObservableOnSubscribe<Boolean>() {
                    @Override
                    public void subscribe(@io.reactivex.annotations.NonNull ObservableEmitter<Boolean> e) throws Exception {

                    }
                }).map(new Function<Boolean, Boolean>() {
                    @Override
                    public Boolean apply(@io.reactivex.annotations.NonNull Boolean aBoolean) throws Exception {
                        return aBoolean;
                    }
                })
                        .subscribe(new Observer<Boolean>() {
                            @Override
                            public void onSubscribe(@io.reactivex.annotations.NonNull Disposable d) {

                            }

                            @Override
                            public void onNext(@io.reactivex.annotations.NonNull Boolean aBoolean) {

                            }

                            @Override
                            public void onError(@io.reactivex.annotations.NonNull Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
                break;
        }
    }
}
