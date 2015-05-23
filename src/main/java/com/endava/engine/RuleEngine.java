package com.endava.engine;

import com.endava.dto.Operation;
import com.endava.dto.RestRequest;
import com.endava.dto.Rule;
import com.endava.persistance.PersistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by astoica on 5/23/2015.
 */
@Service
public class RuleEngine {

    @Autowired
    private PersistanceService persistanceService;

    public String runRule(RestRequest request) {

        List<Rule> ruleList = persistanceService.getAllRulesByPort(request.getPort());

        if(ruleList != null) {
            for (Rule rule : ruleList) {

                List<Operation> operationList = rule.getOperationList();

                for (Operation operation : operationList) {

                    if (operation.getOperation().equals("Equals")) {
                        if (operation.getType().equals("Method") && request.getMethod().equals(operation.getContent())) {
                            return operation.getOutput();
                        } else if (operation.getType().equals("Path") && request.getPath().equals(operation.getContent())) {
                            return operation.getOutput();
                        }
                    }
                    else if(operation.getOperation().equals("Contains")) {
                        if (operation.getType().equals("Method") && request.getMethod().contains(operation.getContent())) {
                            return operation.getOutput();
                        } else if (operation.getType().equals("Path") && request.getPath().contains(operation.getContent())) {
                            return operation.getOutput();
                        }
                    }
                }

            }
        }
        else {
            return "No rule found";
        }
        return null;
    }
}
