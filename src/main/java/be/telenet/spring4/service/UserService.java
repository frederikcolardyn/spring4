package be.telenet.spring4.service;

import be.telenet.spring4.model.ApiResponse;
import be.telenet.spring4.model.User;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by frederik on 10/11/14.
 */
@Service
@CacheConfig(cacheNames = "users")
@Transactional
public class UserService {

    private Log log = LogFactory.getLog(this.getClass());

    @PersistenceContext
    private EntityManager entityManager;

    @Cacheable(key = "#id")
    public User loadUser(Long id) {
        log.info("Loading user with id " + id);
        return entityManager.find(User.class, id);
    }

    public List<User> loadUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @CacheEvict(allEntries = true)
    public void clearCache(){
        log.info("Clear all users from cache.");
    }

    @CachePut(key = "#user.id")
    public User saveUser(User user){
        entityManager.persist(user);
        log.info("Added user " + user);
        return user;
    }

    @CacheEvict(key = "#id")
    public void deleteUser(Long id) {
        entityManager.remove(loadUser(id));
    }
}
