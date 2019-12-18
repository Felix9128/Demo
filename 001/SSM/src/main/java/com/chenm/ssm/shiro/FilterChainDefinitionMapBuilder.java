package com.chenm.ssm.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

public class FilterChainDefinitionMapBuilder {

    public Map<String,String> buildFilterChainDefinitionMap(){
        //LinkedHashMap:是有顺序的
        Map<String, String> map = new LinkedHashMap<>();
        //将权限路径添加到map中（实际是从数据库查询）
        map.put("/login.jsp","anon" );
        map.put("/login", "anon");
        map.put("/addpermission.jsp", "perms[user:add]");
        map.put("/**", "authc");
        return map;
    }
}
