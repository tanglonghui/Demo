package com.example.administrator.demo.android_base.recycleview.ViewRecycle;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.administrator.demo.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ViewActivity extends AppCompatActivity {

    @BindView(R.id.rv_recycler1)
    RecyclerView rvRecycler1;
    @BindView(R.id.rv_recycler2)
    RecyclerView rvRecycler2;
    ViewAdapter adapter;
    ViewAdapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);
        List<String> list = new ArrayList();
        for (int i = 0; i < 3; i++) {
            list.add("" + i);
        }
        adapter = new ViewAdapter();
        adapter2 = new ViewAdapter2();
        adapter.setMyList(list);
        adapter2.setMyList(list);
        rvRecycler1.setLayoutManager(new LinearLayoutManager(ViewActivity.this, LinearLayoutManager.HORIZONTAL, false));
        rvRecycler2.setLayoutManager(new LinearLayoutManager(ViewActivity.this, LinearLayoutManager.HORIZONTAL, false));
        rvRecycler1.setAdapter(adapter);
        rvRecycler2.setAdapter(adapter2);
    }

    @OnClick({R.id.rv_recycler1, R.id.rv_recycler2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rv_recycler1:
                break;
            case R.id.rv_recycler2:
                break;
        }
    }
}
