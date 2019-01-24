package com.zj.common.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * 启动解压FrameworkAdminUtil-x.x.x.jar到resources目录
 * @author zj
 * @date 2019/01/23
 */
public class FrameworkAdminUtil implements InitializingBean, ServletContextAware {

    private static final Logger LOGGER = LoggerFactory.getLogger(FrameworkAdminUtil.class);

    @Override
    public void afterPropertiesSet() throws Exception {

    }

    @Override
    public void setServletContext(ServletContext servletContext) {
        LOGGER.info("===== 开始解压framework-admin =====");
        String version = PropertiesFileUtil.getInstance("framework-admin-client").get("framework.admin.version");
        LOGGER.info("framework-admin.jar 版本: {}", version);
        String jarPath = servletContext.getRealPath("/WEB-INF/lib/framework-admin-" + version + ".jar");
        LOGGER.info("framework-admin.jar 包路径: {}", jarPath);
        String resources = servletContext.getRealPath("/") + "/resources/framework-admin";
        LOGGER.info("framework-admin.jar 解压到: {}", resources);
        JarUtil.decompress(jarPath, resources);
        LOGGER.info("===== 解压framework-admin完成 =====");
    }

}
