package com.zhijing.shoppingcenter.IdCode.Product.RestuleBean;

import java.util.List;

public class ProductData {
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
        private ProductInfoBean product_info;

        public ProductInfoBean getProduct_info() {
            return product_info;
        }

        public void setProduct_info(ProductInfoBean product_info) {
            this.product_info = product_info;
        }

        public static class ProductInfoBean {
            private List<ListBean> list;

            public List<ListBean> getList() {
                return list;
            }

            public void setList(List<ListBean> list) {
                this.list = list;
            }

            public static class ListBean {
                private String product_name;
                private ActivityBean activity;
                private int times;
                private String code;
                private String figure;
                private String type;
                private String url;
                private String phone_to_buy;
                private String price;
                private String specs;
                private String date_of_make;
                private String date_of_bad;
                private String taste;
                private String company;
                private String product;
                private String company_name;
                private String company_contacts;
                private String phone_to_call;
                private String company_logo;
                private String company_location;
                private String company_info;
                private String code_type;
                private String one_code;
                private AllCODEBean all_CODE;
                private TestPhotoBean Test_photo;
                private TestNameBean Test_name;
                private WorkmanshipPhotoBean workmanship_photo;
                private WorkmanshipNameBean workmanship_name;
                private WorkmanshipFountionBean workmanship_fountion;
                private InspectNameBean Inspect_name;
                private InspectPhotoBean inspect_photo;
                private InspecFountionBean inspec_fountion;
                private ManufacturerBean Manufacturer;
                private String agent_name;
                private String agent_location;
                private String complaint_phone;
                private InspecTypeBean inspec_type;

                public String getProduct_name() {
                    return product_name;
                }

                public void setProduct_name(String product_name) {
                    this.product_name = product_name;
                }

                public ActivityBean getActivity() {
                    return activity;
                }

                public void setActivity(ActivityBean activity) {
                    this.activity = activity;
                }

                public int getTimes() {
                    return times;
                }

                public void setTimes(int times) {
                    this.times = times;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
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

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public String getPhone_to_buy() {
                    return phone_to_buy;
                }

                public void setPhone_to_buy(String phone_to_buy) {
                    this.phone_to_buy = phone_to_buy;
                }

                public String getPrice() {
                    return price;
                }

                public void setPrice(String price) {
                    this.price = price;
                }

                public String getSpecs() {
                    return specs;
                }

                public void setSpecs(String specs) {
                    this.specs = specs;
                }

                public String getDate_of_make() {
                    return date_of_make;
                }

                public void setDate_of_make(String date_of_make) {
                    this.date_of_make = date_of_make;
                }

                public String getDate_of_bad() {
                    return date_of_bad;
                }

                public void setDate_of_bad(String date_of_bad) {
                    this.date_of_bad = date_of_bad;
                }

                public String getTaste() {
                    return taste;
                }

                public void setTaste(String taste) {
                    this.taste = taste;
                }

                public String getCompany() {
                    return company;
                }

                public void setCompany(String company) {
                    this.company = company;
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

                public String getCompany_contacts() {
                    return company_contacts;
                }

                public void setCompany_contacts(String company_contacts) {
                    this.company_contacts = company_contacts;
                }

                public String getPhone_to_call() {
                    return phone_to_call;
                }

                public void setPhone_to_call(String phone_to_call) {
                    this.phone_to_call = phone_to_call;
                }

                public String getCompany_logo() {
                    return company_logo;
                }

                public void setCompany_logo(String company_logo) {
                    this.company_logo = company_logo;
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

                public String getCode_type() {
                    return code_type;
                }

                public void setCode_type(String code_type) {
                    this.code_type = code_type;
                }

                public String getOne_code() {
                    return one_code;
                }

                public void setOne_code(String one_code) {
                    this.one_code = one_code;
                }

                public AllCODEBean getAll_CODE() {
                    return all_CODE;
                }

                public void setAll_CODE(AllCODEBean all_CODE) {
                    this.all_CODE = all_CODE;
                }

                public TestPhotoBean getTest_photo() {
                    return Test_photo;
                }

                public void setTest_photo(TestPhotoBean Test_photo) {
                    this.Test_photo = Test_photo;
                }

                public TestNameBean getTest_name() {
                    return Test_name;
                }

                public void setTest_name(TestNameBean Test_name) {
                    this.Test_name = Test_name;
                }

                public WorkmanshipPhotoBean getWorkmanship_photo() {
                    return workmanship_photo;
                }

                public void setWorkmanship_photo(WorkmanshipPhotoBean workmanship_photo) {
                    this.workmanship_photo = workmanship_photo;
                }

                public WorkmanshipNameBean getWorkmanship_name() {
                    return workmanship_name;
                }

                public void setWorkmanship_name(WorkmanshipNameBean workmanship_name) {
                    this.workmanship_name = workmanship_name;
                }

                public WorkmanshipFountionBean getWorkmanship_fountion() {
                    return workmanship_fountion;
                }

                public void setWorkmanship_fountion(WorkmanshipFountionBean workmanship_fountion) {
                    this.workmanship_fountion = workmanship_fountion;
                }

                public InspectNameBean getInspect_name() {
                    return Inspect_name;
                }

                public void setInspect_name(InspectNameBean Inspect_name) {
                    this.Inspect_name = Inspect_name;
                }

                public InspectPhotoBean getInspect_photo() {
                    return inspect_photo;
                }

                public void setInspect_photo(InspectPhotoBean inspect_photo) {
                    this.inspect_photo = inspect_photo;
                }

                public InspecFountionBean getInspec_fountion() {
                    return inspec_fountion;
                }

                public void setInspec_fountion(InspecFountionBean inspec_fountion) {
                    this.inspec_fountion = inspec_fountion;
                }

                public ManufacturerBean getManufacturer() {
                    return Manufacturer;
                }

                public void setManufacturer(ManufacturerBean Manufacturer) {
                    this.Manufacturer = Manufacturer;
                }

                public String getAgent_name() {
                    return agent_name;
                }

                public void setAgent_name(String agent_name) {
                    this.agent_name = agent_name;
                }

                public String getAgent_location() {
                    return agent_location;
                }

                public void setAgent_location(String agent_location) {
                    this.agent_location = agent_location;
                }

                public String getComplaint_phone() {
                    return complaint_phone;
                }

                public void setComplaint_phone(String complaint_phone) {
                    this.complaint_phone = complaint_phone;
                }

                public InspecTypeBean getInspec_type() {
                    return inspec_type;
                }

                public void setInspec_type(InspecTypeBean inspec_type) {
                    this.inspec_type = inspec_type;
                }

                public static class ActivityBean {
                    private List<ActivityListBean> activityList;

                    public List<ActivityListBean> getActivityList() {
                        return activityList;
                    }

                    public void setActivityList(List<ActivityListBean> activityList) {
                        this.activityList = activityList;
                    }

                    public static class ActivityListBean {
                        private String activity;

                        public String getActivity() {
                            return activity;
                        }

                        public void setActivity(String activity) {
                            this.activity = activity;
                        }
                    }
                }

                public static class AllCODEBean {
                    private List<AllCodeListBean> all_code_list;

                    public List<AllCodeListBean> getAll_code_list() {
                        return all_code_list;
                    }

                    public void setAll_code_list(List<AllCodeListBean> all_code_list) {
                        this.all_code_list = all_code_list;
                    }

                    public static class AllCodeListBean {
                        private String code;

                        public String getCode() {
                            return code;
                        }

                        public void setCode(String code) {
                            this.code = code;
                        }
                    }
                }

                public static class TestPhotoBean {
                    private List<TestPhotoListBean> TestPhotoList;

                    public List<TestPhotoListBean> getTestPhotoList() {
                        return TestPhotoList;
                    }

                    public void setTestPhotoList(List<TestPhotoListBean> TestPhotoList) {
                        this.TestPhotoList = TestPhotoList;
                    }

                    public static class TestPhotoListBean {
                        private String test_photo;

                        public String getTest_photo() {
                            return test_photo;
                        }

                        public void setTest_photo(String test_photo) {
                            this.test_photo = test_photo;
                        }
                    }
                }

                public static class TestNameBean {
                    private List<TestNameListBean> TestNameList;

                    public List<TestNameListBean> getTestNameList() {
                        return TestNameList;
                    }

                    public void setTestNameList(List<TestNameListBean> TestNameList) {
                        this.TestNameList = TestNameList;
                    }

                    public static class TestNameListBean {
                        private String test_name;

                        public String getTest_name() {
                            return test_name;
                        }

                        public void setTest_name(String test_name) {
                            this.test_name = test_name;
                        }
                    }
                }

                public static class WorkmanshipPhotoBean {
                    private List<WorkmanshipListBean> workmanshipList;

                    public List<WorkmanshipListBean> getWorkmanshipList() {
                        return workmanshipList;
                    }

                    public void setWorkmanshipList(List<WorkmanshipListBean> workmanshipList) {
                        this.workmanshipList = workmanshipList;
                    }

                    public static class WorkmanshipListBean {
                        private String workmanship_photo;

                        public String getWorkmanship_photo() {
                            return workmanship_photo;
                        }

                        public void setWorkmanship_photo(String workmanship_photo) {
                            this.workmanship_photo = workmanship_photo;
                        }
                    }
                }

                public static class WorkmanshipNameBean {
                    private List<WorkmanshipNameListBean> workmanship_nameList;

                    public List<WorkmanshipNameListBean> getWorkmanship_nameList() {
                        return workmanship_nameList;
                    }

                    public void setWorkmanship_nameList(List<WorkmanshipNameListBean> workmanship_nameList) {
                        this.workmanship_nameList = workmanship_nameList;
                    }

                    public static class WorkmanshipNameListBean {
                        private String workmanship_name;

                        public String getWorkmanship_name() {
                            return workmanship_name;
                        }

                        public void setWorkmanship_name(String workmanship_name) {
                            this.workmanship_name = workmanship_name;
                        }
                    }
                }

                public static class WorkmanshipFountionBean {
                    private List<WorkmanshipFountionListBean> workmanship_fountionList;

                    public List<WorkmanshipFountionListBean> getWorkmanship_fountionList() {
                        return workmanship_fountionList;
                    }

                    public void setWorkmanship_fountionList(List<WorkmanshipFountionListBean> workmanship_fountionList) {
                        this.workmanship_fountionList = workmanship_fountionList;
                    }

                    public static class WorkmanshipFountionListBean {
                        private String workmanship_fountion;

                        public String getWorkmanship_fountion() {
                            return workmanship_fountion;
                        }

                        public void setWorkmanship_fountion(String workmanship_fountion) {
                            this.workmanship_fountion = workmanship_fountion;
                        }
                    }
                }

                public static class InspectNameBean {
                    private List<InspectNameListBean> InspectNameList;

                    public List<InspectNameListBean> getInspectNameList() {
                        return InspectNameList;
                    }

                    public void setInspectNameList(List<InspectNameListBean> InspectNameList) {
                        this.InspectNameList = InspectNameList;
                    }

                    public static class InspectNameListBean {
                        private String inspect_name;

                        public String getInspect_name() {
                            return inspect_name;
                        }

                        public void setInspect_name(String inspect_name) {
                            this.inspect_name = inspect_name;
                        }
                    }
                }

                public static class InspectPhotoBean {
                    private List<InspectPhotoListBean> InspectPhotoList;

                    public List<InspectPhotoListBean> getInspectPhotoList() {
                        return InspectPhotoList;
                    }

                    public void setInspectPhotoList(List<InspectPhotoListBean> InspectPhotoList) {
                        this.InspectPhotoList = InspectPhotoList;
                    }

                    public static class InspectPhotoListBean {
                        private String inspect_photo;

                        public String getInspect_photo() {
                            return inspect_photo;
                        }

                        public void setInspect_photo(String inspect_photo) {
                            this.inspect_photo = inspect_photo;
                        }
                    }
                }

                public static class InspecFountionBean {
                    private List<InspecFountionListBean> inspec_fountionList;

                    public List<InspecFountionListBean> getInspec_fountionList() {
                        return inspec_fountionList;
                    }

                    public void setInspec_fountionList(List<InspecFountionListBean> inspec_fountionList) {
                        this.inspec_fountionList = inspec_fountionList;
                    }

                    public static class InspecFountionListBean {
                        private String inspec_fountion;

                        public String getInspec_fountion() {
                            return inspec_fountion;
                        }

                        public void setInspec_fountion(String inspec_fountion) {
                            this.inspec_fountion = inspec_fountion;
                        }
                    }
                }

                public static class ManufacturerBean {
                    private List<ManufacturerInfoListBean> Manufacturer_infoList;

                    public List<ManufacturerInfoListBean> getManufacturer_infoList() {
                        return Manufacturer_infoList;
                    }

                    public void setManufacturer_infoList(List<ManufacturerInfoListBean> Manufacturer_infoList) {
                        this.Manufacturer_infoList = Manufacturer_infoList;
                    }

                    public static class ManufacturerInfoListBean {
                        private String Manufacturer_name;
                        private String Manufacturer_location;
                        private String Manufacturer_phone;
                        private String Manufacturer_info;

                        public String getManufacturer_name() {
                            return Manufacturer_name;
                        }

                        public void setManufacturer_name(String Manufacturer_name) {
                            this.Manufacturer_name = Manufacturer_name;
                        }

                        public String getManufacturer_location() {
                            return Manufacturer_location;
                        }

                        public void setManufacturer_location(String Manufacturer_location) {
                            this.Manufacturer_location = Manufacturer_location;
                        }

                        public String getManufacturer_phone() {
                            return Manufacturer_phone;
                        }

                        public void setManufacturer_phone(String Manufacturer_phone) {
                            this.Manufacturer_phone = Manufacturer_phone;
                        }

                        public String getManufacturer_info() {
                            return Manufacturer_info;
                        }

                        public void setManufacturer_info(String Manufacturer_info) {
                            this.Manufacturer_info = Manufacturer_info;
                        }
                    }
                }

                public static class InspecTypeBean {
                    private List<InspecTypeListBean> inspec_typeList;

                    public List<InspecTypeListBean> getInspec_typeList() {
                        return inspec_typeList;
                    }

                    public void setInspec_typeList(List<InspecTypeListBean> inspec_typeList) {
                        this.inspec_typeList = inspec_typeList;
                    }

                    public static class InspecTypeListBean {
                        private String inspec_type;

                        public String getInspec_type() {
                            return inspec_type;
                        }

                        public void setInspec_type(String inspec_type) {
                            this.inspec_type = inspec_type;
                        }
                    }
                }
            }
        }
    }
}
