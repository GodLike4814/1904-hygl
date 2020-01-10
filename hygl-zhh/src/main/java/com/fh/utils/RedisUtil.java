package com.fh.utils;

import redis.clients.jedis.Jedis;

public class RedisUtil {

    //向Redis中set值
    public static void set(String key,String value){
        Jedis jedis=null;
        try {
                jedis = RedisPool.getResource();
            jedis.auth("123");
            jedis.set(key,value);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis=null;
            }
        }
    }

    //删除指定的key
    public static void del(String key){
        Jedis jedis=null;
        try {
            jedis = RedisPool.getResource();
            jedis.auth("123");
            jedis.del(key);
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            if(null != jedis){
                jedis.close();
                jedis=null;
            }
        }
    }

    //设置指定key的存活时间
    public static void expire(String key,int second){
        Jedis jedis=null;
        try {
            jedis = RedisPool.getResource();
            jedis.auth("123");
            jedis.expire(key,second);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(null != jedis){
                jedis.close();
                jedis=null;
            }
        }
    }

    //根据key获取对应的Redis的值
    public static String get(String key){
        Jedis jedis=null;
        String result ="";
        try {
            jedis = RedisPool.getResource();
            jedis.auth("123");
            result = jedis.get(key);
        }catch (Exception e){
            e.printStackTrace();
            return result;
        }finally {
            if(null != jedis){
                jedis.close();
                jedis=null;
            }
        }
        return result;
    }
        //main方法测试
//    public static void main(String[] args) {
//       // set("stuName","shazi");
//        String stuName = get("stuName");
//        System.out.println(stuName);
//        //System.out.println(22222222);
//
//    }
}
