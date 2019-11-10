package com.example.administrator.demo.model;


import java.io.Serializable;
import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2019/6/4.
 * @describe   学生考勤统计列表信息
 */
public class TestSerModel {

    /**
     * totalSize : null
     * data : null
     * success : true
     * totalPage : null
     * page : null
     * message : null
     * list : [{"checkType":null,"vocationNum":null,"teacherName":"五五","leaveEarlyNum":null,"checkTime2":"2019-05-22 17:25:43","normalNum":null,"checkTime1":"2019-05-22 10:25:26","lessonId":"123123","truancyNum":null,"lessonName":"保密法1","studentId":"3","teacherId":null,"clazzId":null,"studentName":null,"lateNum":null,"imei":null,"id":"123213","time":"09:00-11:00","result2":"2","clazzName":null,"startDate":"2019-06-01","result1":"1","isreplace":null}]
     */
    private String totalSize;
    private String data;
    private boolean success;
    private String totalPage;
    private String page;
    private String message;
    private List<ListEntity> list;

    public void setTotalSize(String totalSize) {
        this.totalSize = totalSize;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setList(List<ListEntity> list) {
        this.list = list;
    }

    public String getTotalSize() {
        return totalSize;
    }

    public String getData() {
        return data;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public String getPage() {
        return page;
    }

    public String getMessage() {
        return message;
    }

    public List<ListEntity> getList() {
        return list;
    }

    public class ListEntity implements Serializable {


        private String id;
        private String time;
        private String clazzName;
        private List<ListBean> list;

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public void setClazzName(String clazzName) {
            this.clazzName = clazzName;
        }

        public String getId() {
            return id;
        }

        public String getTime() {
            return time;
        }

        public String getClazzName() {
            return clazzName;
        }
        public class ListBean implements Serializable {


            private String id2;
            private String time2;
            private String clazzName2;

            public String getId2() {
                return id2;
            }

            public void setId2(String id2) {
                this.id2 = id2;
            }

            public String getTime2() {
                return time2;
            }

            public void setTime2(String time2) {
                this.time2 = time2;
            }

            public String getClazzName2() {
                return clazzName2;
            }

            public void setClazzName2(String clazzName2) {
                this.clazzName2 = clazzName2;
            }
        }

    }
}
