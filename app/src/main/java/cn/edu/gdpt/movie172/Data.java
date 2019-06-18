package cn.edu.gdpt.movie172;

import java.util.List;

public class Data {
    private String msg;
    private String retCode;
    private List<MovieBean> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public List<MovieBean> getResult() {
        return result;
    }

    public void setResult(List<MovieBean> result) {
        this.result = result;
    }
    public static class MovieBean{
        /*{
            "cur": 3035.21,
                "days": 1,
                "name": "黑衣人：全球追缉",
                "sum": 3396.07
        }*/
        private String name;
        private String days;
        private String cur;
        private String sum;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDays() {
            return days;
        }

        public void setDays(String days) {
            this.days = days;
        }

        public String getCur() {
            return cur;
        }

        public void setCur(String cur) {
            this.cur = cur;
        }

        public String getSum() {
            return sum;
        }

        public void setSum(String sum) {
            this.sum = sum;
        }
    }
}
