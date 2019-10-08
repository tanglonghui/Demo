package com.example.administrator.demo.testPaper.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2019/6/24.
 * @describe TODO
 */
public class StudentQuestionBean implements Serializable {

    /**
     * answer : A,B,C
     * keywords :
     * options : ["选项A","选项B","选项C","选项D","选项E"]
     * title : 标题11
     * type : m-choice
     * content : 选A还是B还是CDEF
     */
    private String answer;
    private String keywords;
    private List<String> options;
    private String title;
    private String type;
    private String content;
    private String votes;

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAnswer() {
        return answer;
    }

    public String getKeywords() {
        return keywords;
    }

    public List<String> getOptions() {
        return options;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public String getContent() {
        return content;
    }

    public String getVotes() {
        return votes;
    }

    public void setVotes(String votes) {
        this.votes = votes;
    }
}
