package com.example.administrator.demo.test_box.testPaper.questions;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.demo.R;
import com.example.administrator.demo.test_box.testPaper.bean.FlippedClassroomTestPaperInfo;

/**
 * @author TangLongHui
 * @data created on 2019/10/8.
 * @describe   简答题
 */
public class ShortAnswerQuestionFragment extends BaseQuestionFragment {
    private TextView tvQuestion;
    private EditText etAnswer;

    public static ShortAnswerQuestionFragment newInstance(FlippedClassroomTestPaperInfo.ListEntity listEntity) {
        ShortAnswerQuestionFragment fragment = new ShortAnswerQuestionFragment();
        Bundle args = new Bundle();
        args.putSerializable("listEntity", listEntity);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_short_answer_question;
    }

    @Override
    protected void initViews() {
        tvQuestion = (TextView) findView(R.id.tv_question);
        etAnswer = (EditText) findView(R.id.et_answer);
    }

    @Override
    protected void init() {
        if (getArguments()!=null){
            listEntity = (FlippedClassroomTestPaperInfo.ListEntity) getArguments().getSerializable("listEntity");
        }
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void registerEvents() {

    }

    @Override
    public String getAnswer() {
        answer = etAnswer.getText().toString();
        return answer;
    }

    @Override
    protected String getType() {
        return null;
    }

    @Override
    protected String getTrContentId() {
        return null;
    }
}
