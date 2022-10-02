package com.vivid.stock.dbservice;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

import com.netflix.appinfo.ApplicationInfoManager;

@ComponentScan
public class DynamicMetadataReporter {
 
//   @Autowired
//   private ApplicationInfoManager aim;
// 
//   @PostConstruct
//   public void init() {
//      Map<String, String> map = aim.getInfo().getMetadata();
//      String hostname = map.get("hostName");
//      map.put("eurekaHost", hostname);
//   }
}
