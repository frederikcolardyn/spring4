package be.telenet.spring4.rest;

import be.telenet.spring4.service.OcapiPropertyService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.annotations.GenerationTime;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by frederik on 04/02/15.
 */
@RestController
public class CustomerController {

    private Log log = LogFactory.getLog(this.getClass());

    @Resource
    private OcapiPropertyService ocapiPropertyService;

    @RequestMapping(value = "/customer/{id}", method = {RequestMethod.GET})
    public Serializable readProperty(@PathVariable String id, @RequestParam String p){
        log.info("Loading customer " + id + " property " + p);
        return ocapiPropertyService.readProperty(id, p);
    }

    @RequestMapping(value = "/customer/{id}", method = {RequestMethod.POST})
    public Serializable writeProperty(@PathVariable String id, @RequestParam String p, @RequestBody String value){
        log.info("Writing customer " + id + " property " + p + " => " + value);
        return ocapiPropertyService.writeProperty(id, p, value);
    }

    @RequestMapping(value = "/customer/{id}", method = {RequestMethod.DELETE})
    public Serializable deleteProperty(@PathVariable String id, @RequestParam String p){
        log.info("Deleting customer " + id + " property " + p);
        return ocapiPropertyService.deleteProperty(id, p);
    }
}
