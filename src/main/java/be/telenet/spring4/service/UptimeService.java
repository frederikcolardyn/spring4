package be.telenet.spring4.service;

import be.telenet.spring4.model.ApiResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by frederik on 10/11/14.
 */
@Service
public class UptimeService {

    private Log log = LogFactory.getLog(this.getClass());
    private Date startDate;
    private Map<String, String> slowDatabase = new HashMap<>();

    @PostConstruct
    public void setup(){
        this.startDate = new Date();
    }

    public ApiResponse uptime() {
        log.info("Cache empty, create api response.");
        return new ApiResponse("ok", "Up since " + this.startDate);
    }

}
