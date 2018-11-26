package src.bean;

import lombok.ToString;

//@Data
public class TestBean {
    Long id;
    String name;

    @ToString.Exclude
    CircularBean circularBean;

    OuterSpringClass outerSpringClass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CircularBean getCircularBean() {
        return circularBean;
    }

    public void setCircularBean(CircularBean circularBean) {
        this.circularBean = circularBean;
    }

}
