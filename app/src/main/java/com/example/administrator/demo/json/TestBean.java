package com.example.administrator.demo.json;

import java.util.ArrayList;
import java.util.List;

/**
 * @author TangLongHui
 * @data created on 2019/6/26.
 * @describe
 */
public class TestBean {
    public TestBean() {
        address = new AddressEntity();
        isNonProfit = false;
        name = "test";
        page = 1;
        url = "1341";
        links = new ArrayList<>();
        links.add(new LinksEntity("1"));
        links.add(new LinksEntity("2"));
        links.add(new LinksEntity("3"));
    }

    /**
     * address : {"country":"中国","city":"江苏苏州","street":"科技园路."}
     * isNonProfit : true
     * name : BeJson
     * links : [{"name":"Google","url":"http://www.google.com"},{"name":"Baidu","url":"http://www.baidu.com"},{"name":"SoSo","url":"http://www.SoSo.com"}]
     * page : 88
     * url : http://www.bejson.com
     */
    private AddressEntity address;
    private boolean isNonProfit;
    private String name;
    private List<LinksEntity> links;
    private int page;
    private String url;

    public void setAddress(AddressEntity address) {
        this.address = address;
    }

    public void setIsNonProfit(boolean isNonProfit) {
        this.isNonProfit = isNonProfit;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLinks(List<LinksEntity> links) {
        this.links = links;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public AddressEntity getAddress() {
        return address;
    }

    public boolean isIsNonProfit() {
        return isNonProfit;
    }

    public String getName() {
        return name;
    }

    public List<LinksEntity> getLinks() {
        return links;
    }

    public int getPage() {
        return page;
    }

    public String getUrl() {
        return url;
    }

    public class AddressEntity {
        public AddressEntity() {
            country = "北京";
            city = "北京";
            street = "北京";
        }

        /**
         * country : 中国
         * city : 江苏苏州
         * street : 科技园路.
         */
        private String country;
        private String city;
        private String street;

        public void setCountry(String country) {
            this.country = country;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setStreet(String street) {
            this.street = street;
        }

        public String getCountry() {
            return country;
        }

        public String getCity() {
            return city;
        }

        public String getStreet() {
            return street;
        }
    }

    public class LinksEntity {
        public LinksEntity(String name) {
            this.name = name;
            url="sdfsfd";
        }

        /**
         * name : Google
         * url : http://www.google.com
         */

        private String name;
        private String url;

        public void setName(String name) {
            this.name = name;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
