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

public class RxJavaActivity extends AppCompatActivity {

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
                        Log.e("zhao", "onSubscribe: " + d.isDisposed());
                    }

                    @Override
                    public void onNext(@NonNull Integer integer) {
                        Log.e("zhao", "onNext: " + integer);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e("zhao", "onError: ");
                    }

                    @Override
                    public void onComplete() {
                        Log.e("zhao", "onComplete: ");
                    }
                };
                Observable.create(s).subscribe(b);
                break;
            case R.id.tv_easy2:
                break;
        }
    }
}
