package com.zj.upms.rpc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 服务启动类
 * Created by Zhangzj on 2017/2/3.
 */
public class UpmsRpcServiceApplication {

	private static final Logger LOGGER = LoggerFactory.getLogger(UpmsRpcServiceApplication.class);

	public static void main(String[] args) {
		LOGGER.info(">>>>> framework-upms-rpc-service 正在启动 <<<<<");
		new ClassPathXmlApplicationContext("classpath:META-INF/spring/*.xml");
		LOGGER.info(">>>>> framework-upms-rpc-service 启动完成 <<<<<");
	}

}
