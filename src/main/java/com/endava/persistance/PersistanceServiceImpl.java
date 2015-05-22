package com.endava.persistance;

import com.endava.dto.MockService;
import com.endava.dto.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */

@Service
public class PersistanceServiceImpl implements PersistanceService{

    @Autowired
    private PersistanceDao persistanceDao;

    @Override
    @Transactional
    public List<MockService> getAllServices() {
        return persistanceDao.getAllServices();
    }

    @Override
    @Transactional
    public void persistService(MockService service) {
        persistanceDao.persistService(service);
    }

    @Override
    @Transactional
    public List<Rule> getRulesForService(Integer serviceId) {
        return persistanceDao.getRulesForService(serviceId);
    }
}
