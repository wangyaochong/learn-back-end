package src.bean;

import lombok.ToString;

//@Data
public class CircularBean {
    Long cirId;
    String beanName;

    @ToString.Exclude
    TestBean testBean;


    public Long getCirId() {
        return cirId;
    }

    public void setCirId(Long cirId) {
        this.cirId = cirId;
    }

    public String getBeanName() {
        return beanName;
    }

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public TestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }
}
