package com.example.administrator.demo.testPaper.bean;


import java.io.Serializable;
import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2019/10/8.
 * @describe   翻转课堂-试卷
 */
public class FlippedClassroomTestPaperInfo  {

    /**
     * totalSize : null
     * data : null
     * success : true
     * totalPage : null
     * page : null
     * message : null
     * list : [{"trContentListAnswer":null,"trContentId":"08759acb7be242a7b1fafb6ab2f1dd68","accuracyRate":null,"tqContent":"德,\",\"title\":\"\",\"type\":\"message\"}]","id":"1","right":null,"type":"3","order":null}]
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
        /**
         * trContentListAnswer : null
         * trContentId : 08759acb7be242a7b1fafb6ab2f1dd68
         * accuracyRate : null
         * tqContent : 德,","title":"","type":"message"}]
         * id : 1
         * right : null
         * type : 3
         * order : null
         */
        private String trContentListAnswer;
        private String trContentId;
        private String accuracyRate;
        private String tqContent;
        private String id;
        private String right;
        private String type;
        private String order;

        public void setTrContentListAnswer(String trContentListAnswer) {
            this.trContentListAnswer = trContentListAnswer;
        }

        public void setTrContentId(String trContentId) {
            this.trContentId = trContentId;
        }

        public void setAccuracyRate(String accuracyRate) {
            this.accuracyRate = accuracyRate;
        }

        public void setTqContent(String tqContent) {
            this.tqContent = tqContent;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setRight(String right) {
            this.right = right;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getTrContentListAnswer() {
            return trContentListAnswer;
        }

        public String getTrContentId() {
            return trContentId;
        }

        public String getAccuracyRate() {
            return accuracyRate;
        }

        public String getTqContent() {
            return tqContent;
        }

        public String getId() {
            return id;
        }

        public String getRight() {
            return right;
        }

        public String getType() {
            return type;
        }

        public String getOrder() {
            return order;
        }
    }
}
