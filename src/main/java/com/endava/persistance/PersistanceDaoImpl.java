package com.endava.persistance;

import com.endava.dto.MockService;
import com.endava.dto.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by astoica on 5/22/2015.
 */

@Repository
public class PersistanceDaoImpl implements PersistanceDao{

    private final static Logger logger = LoggerFactory.getLogger(PersistanceDaoImpl.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<MockService> getAllServices() {

        List<MockService> serviceList = entityManager.createNamedQuery("getAllServices", MockService.class).getResultList();
        if(serviceList.size() == 0) {

            logger.info("No services were found");
            return null;
        }
        return serviceList;
    }

    @Override
    public void persistService(MockService service) {

        entityManager.persist(service);
        logger.info("Persisted service: " + service);
    }

    @Override
    public List<Rule> getRulesForService(Integer serviceId) {

        List<Rule> ruleList = entityManager.createNamedQuery("getRulesForService", Rule.class).setParameter("serviceId", serviceId).getResultList();
        if(ruleList.size() == 0) {

            logger.info("No rules were found for service: " + serviceId);
            return null;
        }
        return ruleList;
    }
}
