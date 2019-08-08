package com.example.administrator.demo.echarts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.administrator.demo.R;

public class EchartsActivity extends AppCompatActivity {
    private EchartView lineChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_echarts);
        lineChart = (EchartView) findViewById(R.id.lineChart);
        refreshLineChart();
        lineChart.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                //最好在h5页面加载完毕后再加载数据，防止html的标签还未加载完成，不能正常显示
                refreshLineChart();
            }
        });
    }

    private void refreshLineChart(){
        Object[] x = new Object[]{
                "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
        };
        Object[] y = new Object[]{
                820, 932, 901, 934, 1290, 1330, 1320
        };
        lineChart.refreshEchartsWithOption(EchartOptionUtil.getLineChartOptions(x, y));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ViewParent parent = lineChart.getParent();
        if (parent != null) {
            ((ViewGroup) parent).removeView(lineChart);
        }
        lineChart.stopLoading();
        lineChart.getSettings().setJavaScriptEnabled(false);
        lineChart.clearHistory();
        lineChart.clearView();
        lineChart.removeAllViews();
//         ..........................
        lineChart.destroy();
        lineChart=null;
//        lineChart.loadUrl(null);
//        lineChart.destroy();
    }
}
