package com.zhijing.shoppingcenter.IdCode.company.resultBean;

import java.util.List;

public class CompanyData {
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


        private BrandInfoBean brand_info;
        private CompanyInfoBean company_info;
        private StaffInfoBean staff_info;
        private ConsultationInfoBean consultation_info;

        public BrandInfoBean getBrand_info() {
            return brand_info;
        }

        public void setBrand_info(BrandInfoBean brand_info) {
            this.brand_info = brand_info;
        }

        public CompanyInfoBean getCompany_info() {
            return company_info;
        }

        public void setCompany_info(CompanyInfoBean company_info) {
            this.company_info = company_info;
        }

        public StaffInfoBean getStaff_info() {
            return staff_info;
        }

        public void setStaff_info(StaffInfoBean staff_info) {
            this.staff_info = staff_info;
        }

        public ConsultationInfoBean getConsultation_info() {
            return consultation_info;
        }

        public void setConsultation_info(ConsultationInfoBean consultation_info) {
            this.consultation_info = consultation_info;
        }

        public static class BrandInfoBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {


                private String figure;
                private String name;

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }
            }
        }

        public static class CompanyInfoBean {
            private List<ListBeanX> list;

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {


                private String figure;
                private String name;
                private String article;

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getArticle() {
                    return article;
                }

                public void setArticle(String article) {
                    this.article = article;
                }
            }
        }

        public static class StaffInfoBean {
            private List<ListBeanXX> list;

            public List<ListBeanXX> getList() {
                return list;
            }

            public void setList(List<ListBeanXX> list) {
                this.list = list;
            }

            public static class ListBeanXX {


                private String figure;
                private String name;
                private String position;
                private String Telephone;
                private String Hometown;
                private String Location;
                private String Personal;
                private String Email;
                private String QQ;

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getPosition() {
                    return position;
                }

                public void setPosition(String position) {
                    this.position = position;
                }

                public String getTelephone() {
                    return Telephone;
                }

                public void setTelephone(String Telephone) {
                    this.Telephone = Telephone;
                }

                public String getHometown() {
                    return Hometown;
                }

                public void setHometown(String Hometown) {
                    this.Hometown = Hometown;
                }

                public String getLocation() {
                    return Location;
                }

                public void setLocation(String Location) {
                    this.Location = Location;
                }

                public String getPersonal() {
                    return Personal;
                }

                public void setPersonal(String Personal) {
                    this.Personal = Personal;
                }

                public String getEmail() {
                    return Email;
                }

                public void setEmail(String Email) {
                    this.Email = Email;
                }

                public String getQQ() {
                    return QQ;
                }

                public void setQQ(String QQ) {
                    this.QQ = QQ;
                }
            }
        }

        public static class ConsultationInfoBean {
            private List<ListBeanXXX> list;

            public List<ListBeanXXX> getList() {
                return list;
            }

            public void setList(List<ListBeanXXX> list) {
                this.list = list;
            }

            public static class ListBeanXXX {
                private String title;
                private String article;

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getArticle() {
                    return article;
                }

                public void setArticle(String article) {
                    this.article = article;
                }
            }
        }
    }
}
