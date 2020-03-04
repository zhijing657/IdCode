package com.zhijing.shoppingcenter.IdCode.Product.getExcel.bean;

import java.util.List;

public class Programme {

    /**
     * code : 200
     * msg : 请求成功
     * result : {"programme_info":{"list":[{"name":"零件1","price":"12497"},{"name":"零件2","price":"12456"},{"name":"零件3","price":"132568"},{"name":"零件4","price":"15378"},{"name":"零件5","price":"10597"},{"name":"零件6","price":"19567"},{"name":"零件7","price":"18945"},{"name":"零件8","price":"125347"},{"name":"零件9","price":"124568"},{"name":"零件10","price":"13456"},{"name":"零件11","price":"12675"},{"name":"零件12","price":"1563"},{"name":"零件13","price":"1003"}]}}
     */

    private int code;
    private String msg;
    private ResultBean result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * programme_info : {"list":[{"name":"零件1","price":"12497"},{"name":"零件2","price":"12456"},{"name":"零件3","price":"132568"},{"name":"零件4","price":"15378"},{"name":"零件5","price":"10597"},{"name":"零件6","price":"19567"},{"name":"零件7","price":"18945"},{"name":"零件8","price":"125347"},{"name":"零件9","price":"124568"},{"name":"零件10","price":"13456"},{"name":"零件11","price":"12675"},{"name":"零件12","price":"1563"},{"name":"零件13","price":"1003"}]}
         */

        private ProgrammeInfoBean programme_info;

        public ProgrammeInfoBean getProgramme_info() {
            return programme_info;
        }

        public void setProgramme_info(ProgrammeInfoBean programme_info) {
            this.programme_info = programme_info;
        }

        public static class ProgrammeInfoBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                /**
                 * name : 零件1
                 * price : 12497
                 */

                private String name;
                private String price;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }
            }
        }
    }
}
