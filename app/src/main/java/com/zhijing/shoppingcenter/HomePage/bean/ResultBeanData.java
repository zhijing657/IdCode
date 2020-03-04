package com.zhijing.shoppingcenter.HomePage.bean;


import java.util.List;

public class ResultBeanData {

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


        private DrinksInfoBean drinks_info;
        private DeriveInfoBean derive_info;
        private List<BannerInfoBean> banner_info;
        private List<ChannelInfoBean> channel_info;
        private List<RecommendInfoBean> recommend_info;

        public DrinksInfoBean getDrinks_info() {
            return drinks_info;
        }

        public void setDrinks_info(DrinksInfoBean drinks_info) {
            this.drinks_info = drinks_info;
        }

        public DeriveInfoBean getDerive_info() {
            return derive_info;
        }

        public void setDerive_info(DeriveInfoBean derive_info) {
            this.derive_info = derive_info;
        }

        public List<BannerInfoBean> getBanner_info() {
            return banner_info;
        }

        public void setBanner_info(List<BannerInfoBean> banner_info) {
            this.banner_info = banner_info;
        }

        public List<ChannelInfoBean> getChannel_info() {
            return channel_info;
        }

        public void setChannel_info(List<ChannelInfoBean> channel_info) {
            this.channel_info = channel_info;
        }

        public List<RecommendInfoBean> getRecommend_info() {
            return recommend_info;
        }

        public void setRecommend_info(List<RecommendInfoBean> recommend_info) {
            this.recommend_info = recommend_info;
        }

        public static class DrinksInfoBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {


                private String cover_price;
                private String figure;
                private String type;
                private String name;
                private String product_id;
                private String call_to_buy;
                private String specs;
                private String taste;
                private String date_of_bad;
                private String logo;
                private String product;
                private String company_name;
                private String company_logo;
                private String company_people;
                private String company_phone;
                private String company_location;
                private String company_info;

                public String getCover_price() {
                    return cover_price;
                }

                public void setCover_price(String cover_price) {
                    this.cover_price = cover_price;
                }

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(String product_id) {
                    this.product_id = product_id;
                }

                public String getCall_to_buy() {
                    return call_to_buy;
                }

                public void setCall_to_buy(String call_to_buy) {
                    this.call_to_buy = call_to_buy;
                }

                public String getSpecs() {
                    return specs;
                }

                public void setSpecs(String specs) {
                    this.specs = specs;
                }

                public String getTaste() {
                    return taste;
                }

                public void setTaste(String taste) {
                    this.taste = taste;
                }

                public String getDate_of_bad() {
                    return date_of_bad;
                }

                public void setDate_of_bad(String date_of_bad) {
                    this.date_of_bad = date_of_bad;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getProduct() {
                    return product;
                }

                public void setProduct(String product) {
                    this.product = product;
                }

                public String getCompany_name() {
                    return company_name;
                }

                public void setCompany_name(String company_name) {
                    this.company_name = company_name;
                }

                public String getCompany_logo() {
                    return company_logo;
                }

                public void setCompany_logo(String company_logo) {
                    this.company_logo = company_logo;
                }

                public String getCompany_people() {
                    return company_people;
                }

                public void setCompany_people(String company_people) {
                    this.company_people = company_people;
                }

                public String getCompany_phone() {
                    return company_phone;
                }

                public void setCompany_phone(String company_phone) {
                    this.company_phone = company_phone;
                }

                public String getCompany_location() {
                    return company_location;
                }

                public void setCompany_location(String company_location) {
                    this.company_location = company_location;
                }

                public String getCompany_info() {
                    return company_info;
                }

                public void setCompany_info(String company_info) {
                    this.company_info = company_info;
                }
            }
        }

        public static class DeriveInfoBean {
            private List<ListBeanX> list;

            public List<ListBeanX> getList() {
                return list;
            }

            public void setList(List<ListBeanX> list) {
                this.list = list;
            }

            public static class ListBeanX {


                private String cover_price;
                private String figure;
                private String type;
                private String name;
                private String product_id;
                private String company_logo;
                private String call_to_buy;
                private String specs;
                private String date_of_bad;
                private String logo;
                private String taste;
                private String product;
                private String company_name;
                private String company_people;
                private String company_phone;
                private String company_location;
                private String company_info;

                public String getCover_price() {
                    return cover_price;
                }

                public void setCover_price(String cover_price) {
                    this.cover_price = cover_price;
                }

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(String product_id) {
                    this.product_id = product_id;
                }

                public String getCompany_logo() {
                    return company_logo;
                }

                public void setCompany_logo(String company_logo) {
                    this.company_logo = company_logo;
                }

                public String getCall_to_buy() {
                    return call_to_buy;
                }

                public void setCall_to_buy(String call_to_buy) {
                    this.call_to_buy = call_to_buy;
                }

                public String getSpecs() {
                    return specs;
                }

                public void setSpecs(String specs) {
                    this.specs = specs;
                }

                public String getDate_of_bad() {
                    return date_of_bad;
                }

                public void setDate_of_bad(String date_of_bad) {
                    this.date_of_bad = date_of_bad;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getTaste() {
                    return taste;
                }

                public void setTaste(String taste) {
                    this.taste = taste;
                }

                public String getProduct() {
                    return product;
                }

                public void setProduct(String product) {
                    this.product = product;
                }

                public String getCompany_name() {
                    return company_name;
                }

                public void setCompany_name(String company_name) {
                    this.company_name = company_name;
                }

                public String getCompany_people() {
                    return company_people;
                }

                public void setCompany_people(String company_people) {
                    this.company_people = company_people;
                }

                public String getCompany_phone() {
                    return company_phone;
                }

                public void setCompany_phone(String company_phone) {
                    this.company_phone = company_phone;
                }

                public String getCompany_location() {
                    return company_location;
                }

                public void setCompany_location(String company_location) {
                    this.company_location = company_location;
                }

                public String getCompany_info() {
                    return company_info;
                }

                public void setCompany_info(String company_info) {
                    this.company_info = company_info;
                }
            }
        }

        public static class BannerInfoBean {


            private String image;
            private int option;
            private int type;
            private String title;
            private ValueBean value;

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public ValueBean getValue() {
                return value;
            }

            public void setValue(ValueBean value) {
                this.value = value;
            }

            public static class ValueBean {

                private String url;

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class ChannelInfoBean {

            private String channel_name;
            private String image;
            private int option;
            private int type;
            private ValueBeanX value;

            public String getChannel_name() {
                return channel_name;
            }

            public void setChannel_name(String channel_name) {
                this.channel_name = channel_name;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getOption() {
                return option;
            }

            public void setOption(int option) {
                this.option = option;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public ValueBeanX getValue() {
                return value;
            }

            public void setValue(ValueBeanX value) {
                this.value = value;
            }

            public static class ValueBeanX {


                private String channel_id;

                public String getChannel_id() {
                    return channel_id;
                }

                public void setChannel_id(String channel_id) {
                    this.channel_id = channel_id;
                }
            }
        }

        public static class RecommendInfoBean {


            private InfoBean info;

            public InfoBean getInfo() {
                return info;
            }

            public void setInfo(InfoBean info) {
                this.info = info;
            }

            public static class InfoBean {


                private String cover_price;
                private String figure;
                private String type;
                private String name;
                private String product_id;
                private String call_to_buy;
                private String specs;
                private String taste;
                private String date_of_bad;
                private String logo;
                private String product;
                private String company_name;
                private String company_logo;
                private String company_people;
                private String company_phone;
                private String company_location;
                private String company_info;

                public String getCover_price() {
                    return cover_price;
                }

                public void setCover_price(String cover_price) {
                    this.cover_price = cover_price;
                }

                public String getFigure() {
                    return figure;
                }

                public void setFigure(String figure) {
                    this.figure = figure;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getProduct_id() {
                    return product_id;
                }

                public void setProduct_id(String product_id) {
                    this.product_id = product_id;
                }

                public String getCall_to_buy() {
                    return call_to_buy;
                }

                public void setCall_to_buy(String call_to_buy) {
                    this.call_to_buy = call_to_buy;
                }

                public String getSpecs() {
                    return specs;
                }

                public void setSpecs(String specs) {
                    this.specs = specs;
                }

                public String getTaste() {
                    return taste;
                }

                public void setTaste(String taste) {
                    this.taste = taste;
                }

                public String getDate_of_bad() {
                    return date_of_bad;
                }

                public void setDate_of_bad(String date_of_bad) {
                    this.date_of_bad = date_of_bad;
                }

                public String getLogo() {
                    return logo;
                }

                public void setLogo(String logo) {
                    this.logo = logo;
                }

                public String getProduct() {
                    return product;
                }

                public void setProduct(String product) {
                    this.product = product;
                }

                public String getCompany_name() {
                    return company_name;
                }

                public void setCompany_name(String company_name) {
                    this.company_name = company_name;
                }

                public String getCompany_logo() {
                    return company_logo;
                }

                public void setCompany_logo(String company_logo) {
                    this.company_logo = company_logo;
                }

                public String getCompany_people() {
                    return company_people;
                }

                public void setCompany_people(String company_people) {
                    this.company_people = company_people;
                }

                public String getCompany_phone() {
                    return company_phone;
                }

                public void setCompany_phone(String company_phone) {
                    this.company_phone = company_phone;
                }

                public String getCompany_location() {
                    return company_location;
                }

                public void setCompany_location(String company_location) {
                    this.company_location = company_location;
                }

                public String getCompany_info() {
                    return company_info;
                }

                public void setCompany_info(String company_info) {
                    this.company_info = company_info;
                }
            }
        }
    }
}
