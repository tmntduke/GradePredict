package Model;

import java.util.List;

public class QAInfo {

    /**
     * id : 0001
     * count : 3
     * comments : [{"c_id":"0010","comment":"shidfldslh"},{"c_id":"0011","comment":"shidfldslh"}]
     */

    private String id;
    private int count;
    private List<CommentsBean> comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        /**
         * c_id : 0010
         * comment : shidfldslh
         */

        private String c_id;
        private String comment;

        public String getC_id() {
            return c_id;
        }

        public void setC_id(String c_id) {
            this.c_id = c_id;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
