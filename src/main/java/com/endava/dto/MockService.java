package com.endava.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */

@NamedQueries({
        @NamedQuery(name="getAllServices", query = "FROM MockService s"),
        @NamedQuery(name="getRulesForService", query = "FROM MockService s WHERE s.id = :serviceId")
})
@Entity
@Table(name = "service")
public class MockService {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "serviceType")
    private ServiceType serviceType;

    @Column(name = "port")
    private Integer port;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "serviceId")
    private List<Rule> ruleList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public List<Rule> getRuleList() {
        return ruleList;
    }

    public void setRuleList(List<Rule> ruleList) {
        this.ruleList = ruleList;
    }

    public void addRule(Rule rule) {
        if(this.ruleList == null) {
            this.ruleList = new ArrayList<Rule>();
        }
        this.ruleList.add(rule);
    }

    @Override
    public String toString() {
        return "MockService{" +
                "name='" + name + '\'' +
                ", serviceType=" + serviceType +
                ", port=" + port +
                ", ruleList=" + ruleList +
                '}';
    }
}
