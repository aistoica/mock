package com.endava.persistance;

import com.endava.dto.MockService;
import com.endava.dto.Rule;

import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */
public interface PersistanceService {

    public List<MockService> getAllServices();
    public void persistService(MockService service);
    public List<Rule> getRulesForService(Integer serviceId);
}
