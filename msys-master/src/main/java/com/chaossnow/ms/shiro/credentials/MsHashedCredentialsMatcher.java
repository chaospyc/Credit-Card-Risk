package com.chaossnow.ms.shiro.credentials;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.MemoryConstrainedCacheManager;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chaos
 * @ClassName MsHashedCredentialsMatcher
 * @date 2022年08月01日 22:23
 * @Version 1.0
 */
public class MsHashedCredentialsMatcher extends HashedCredentialsMatcher {

    private Cache<String, AtomicInteger> passwordMsCache;

    public MsHashedCredentialsMatcher(MemoryConstrainedCacheManager memoryConstrainedCacheManager) {
        passwordMsCache = memoryConstrainedCacheManager.getCache("passwordMsCache");
    }

    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {

        String username =  (String) token.getPrincipal();

        AtomicInteger retryCount = passwordMsCache.get(username);
        if(retryCount == null){
            retryCount = new AtomicInteger(0);
            passwordMsCache.put(username,retryCount);
        }
        if(retryCount.incrementAndGet()>5){
            throw new ExcessiveAttemptsException();
        }

        boolean matches = super.doCredentialsMatch(token,info);
        if(matches){
            passwordMsCache.remove(username);
        }
        return matches;
    }
}
