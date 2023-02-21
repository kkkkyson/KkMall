package com.kyson.mall.product;

//import com.aliyun.oss.OSS;
//import com.aliyun.oss.OSSClient;
//import com.aliyun.oss.OSSClientBuilder;
//import com.aliyun.oss.OSSException;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson2.JSON;
import com.kyson.mall.product.entity.BrandEntity;
import com.kyson.mall.product.entity.GatewayInfoVo;
import com.kyson.mall.product.entity.GatewayInfoVos;
import com.kyson.mall.product.service.BrandService;
import org.junit.jupiter.api.Test;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.*;

@SpringBootTest
class KkmallProductApplicationTests {

    @Autowired
    BrandService brandService;

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void testRedisson(){

        System.out.println(redissonClient);
    }
    @Test
    public void testStringRedisTemplate(){

        ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
        opsForValue.set("hello", " world " + UUID.randomUUID().toString());

    }

    @Test
    void contextLoads()
    {
        BrandEntity brandEntity = new BrandEntity();
        //test
        brandEntity.setDescript("test");
        brandEntity.setName("test");
        //brandService.save(brandEntity);

        Map<String, Object> params = new HashMap<>();
        params.put("limit",1);
        params.put("page",1);
        String s = JSON.toJSONString(params);
        System.out.println(s);
    }

    @Test
    void jsonTest()
    {
        String jsonMessage = "[{'num':'成绩', '外语':88, '历史':65, '地理':99, 'object':{'aaa':'1111','bbb':'2222','cccc':'3333'}}," +
 "{'num':'兴趣', '外语':28, '历史':45, '地理':19, 'object':{'aaa':'11a11','bbb':'2222','cccc':'3333'}}," +
 "{'num':'爱好', '外语':48, '历史':62, '地理':39, 'object':{'aaa':'11c11','bbb':'2222','cccc':'3333'}}]";
    JSONArray myJsonArray = JSONArray.parseArray(jsonMessage);
        System.out.println(myJsonArray.get(0).toString());
    }

    public static void main(String[] args)
    {
        Map<String, Object> params = new HashMap<>();
        params.put("limit",1);
        params.put("page",1);
        String s = JSON.toJSONString(params);
        System.out.println(s);

        GatewayInfoVos gatewayInfoVos = new GatewayInfoVos();

        GatewayInfoVo gatewayInfoVo = new GatewayInfoVo();
        gatewayInfoVo.setGatewayId("1");
        gatewayInfoVo.setGatewayPwd("aa");
        gatewayInfoVo.setState(1);
        GatewayInfoVo gatewayInfoVo1 = new GatewayInfoVo();
        gatewayInfoVo1.setGatewayId("2");
        gatewayInfoVo1.setGatewayPwd("22");
        gatewayInfoVo1.setState(1);

        List<GatewayInfoVo> list =new ArrayList<>();
        list.add(gatewayInfoVo);
        list.add(gatewayInfoVo1);

        gatewayInfoVos.setGatewayInfoVoList(list);

        System.out.println(JSON.toJSONString(gatewayInfoVos));
    }
}
