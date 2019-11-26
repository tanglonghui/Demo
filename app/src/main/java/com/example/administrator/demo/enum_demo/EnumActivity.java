package com.example.administrator.demo.enum_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.log.MKLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EnumActivity extends AppCompatActivity {

    @BindView(R.id.tv_1)
    TextView tv1;
    @BindView(R.id.tv_2)
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enum);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_1, R.id.tv_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_1:
                MKLog.d(Enum1.A.toString());
                MKLog.d(Enum2.A.toString());
                MKLog.d(Enum3.A.getCode()+"");
                MKLog.d(Enum4.A.getDescription());
                break;
            case R.id.tv_2:
                for (ErrorCode s : ErrorCode.values()) {
                    MKLog.d("code: " + s.getCode() + ", description: " + s.getDescription());
                }
                for (ErrorCodeEn s : ErrorCodeEn.values()) {
                    MKLog.d("code: " + s.getCode() + ", description: " + s.getDescription());
                }
                break;
        }
    }

    public enum Enum1 {
        A,B,C,D;
    }
    public enum Enum2 {
        A(1),B(2),C(3),D(4);

        Enum2(int i) {
        }
    }
    public enum Enum3 {
        A(1),B(2),C(3),D(4);
        private int code;
         Enum3(int i) {
             code=i;
        }
        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
    public enum Enum4 {
        A(1,"11"),B(2,"22"),C(3,"33"),D(4,"44");
        private int code;
        private String description;
        Enum4(int i,String str) {
            code=i;
            description=str;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }
    }
    public enum ErrorCode {
        OK(0) {
            public String getDescription() {
                return "成功";
            }
        },
        ERROR_A(100) {
            public String getDescription() {
                return "错误A";
            }
        },
        ERROR_B(200) {
            public String getDescription() {
                return "错误B";
            }
        };

        private int code;

        // 构造方法：enum的构造方法只能被声明为private权限或不声明权限
        private ErrorCode(int number) { // 构造方法
            this.code = number;
        }
        public int getCode() { // 普通方法
            return code;
        } // 普通方法
        public abstract String getDescription(); // 抽象方法
    }
    public enum ErrorCodeEn {
        OK(0, "成功"),
        ERROR_A(100, "错误A"),
        ERROR_B(200, "错误B");

        ErrorCodeEn(int number, String description) {
            this.code = number;
            this.description = description;
        }
        private int code;
        private String description;
        public int getCode() {
            return code;
        }
        public String getDescription() {
            return description;
        }
    }
}
