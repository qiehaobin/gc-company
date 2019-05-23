/**
 * Copyright 2018 人人开源 http://www.renren.io
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.rxjy.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-07-17 21:12
 */
@Component
public class JedisUtils {

    @Autowired
    private StringRedisTemplate redisTemplate;
    private static StringRedisTemplate stringRedisTemplate;

    @PostConstruct
    public void init() {
        stringRedisTemplate=redisTemplate;
    }

    public static String get(String key) {
        String result = stringRedisTemplate.opsForValue().get(key);
        return result;
    }

    public static void set(String key, String value, Long time, TimeUnit timeUnit){
        stringRedisTemplate.opsForValue().set(key,value,time,timeUnit);
    }

    public static void del(String key){
        stringRedisTemplate.delete(key);
    }
}
