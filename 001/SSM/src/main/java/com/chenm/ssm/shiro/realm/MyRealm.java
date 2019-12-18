package com.chenm.ssm.shiro.realm;

import com.chenm.ssm.domain.User;
import com.chenm.ssm.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;


public class MyRealm extends AuthorizingRealm{

    @Autowired
    private IUserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        //获取前台页面传入的名字
        String username = token.getUsername();
        //根据名字去数据库查询数据
        User user = userService.queryByUsername(username);
        System.out.println(user);
        if(user==null){
            throw new UnknownAccountException("用户名或者密码错误");
        }
        System.out.println(getName());
        //加盐
        ByteSource salt = ByteSource.Util.bytes("chenm_ssm");
        return new SimpleAuthenticationInfo(username,user.getPassword(),salt,getName());
    }

    //加密：
    public static void main(String[] args) {
        //加盐
        ByteSource salt = ByteSource.Util.bytes("chenm_ssm");
        SimpleHash md5Hash = new SimpleHash("MD5", "123", salt, 1000);
        /**
         * "123"加密后：3b025aec00c5108bd0bea5a56b0aefa9
         * "123"加密再加盐后：e59710bd4ee5ffa9e93f69a84aab7843
         */
        System.out.println(md5Hash);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登陆用户名
        String username = (String) principalCollection.getPrimaryPrincipal();
        //实际是根据用户名，获取权限
        //模拟
        List<String> perimissions = Arrays.asList("user:*","dept:*");
        //获取到的权限添加info中，交给securityManager去比对
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(perimissions);
        return info;
    }
}
