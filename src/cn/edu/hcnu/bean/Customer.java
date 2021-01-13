package cn.edu.hcnu.bean;

import java.util.Date;
import java.util.Set;

public class Customer {
    private String id;//没有业务意义
    private String customerType;//旅客类型：成人、儿童、婴儿
    private String name;//旅客姓名
    private String phone;//联系电话
    private String cardId;//身份证
    private Date birthDate;
    private Set<Order> ordersSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String custerType) {
        this.customerType = custerType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Set<Order> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Order> ordersSet) {
        this.ordersSet = ordersSet;
    }
}
