package com.endava.dto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */
@NamedQueries({
        @NamedQuery(name = "getAllRulesByPort", query = "FROM Rule r WHERE r.service.port = :port")
})
@Entity
@Table(name = "rule")
public class Rule {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "serviceId")
    private MockService service;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = false)
    @JoinColumn(name = "ruleId")
    private List<Operation> operationList;

    public MockService getService() {
        return service;
    }

    public void setService(MockService service) {
        this.service = service;
    }

    public List<Operation> getOperationList() {
        return operationList;
    }

    public void setOperationList(List<Operation> operationList) {
        this.operationList = operationList;
    }

    public void addOperation(Operation operation) {
        if(this.operationList == null) {
            this.operationList = new ArrayList<Operation>();
        }
        this.operationList.add(operation);
    }

    @Override
    public String toString() {
        return "Rule{" +
                "operationList=" + operationList +
                '}';
    }
}
