package com.markus.demo;

import com.markus.demo.node.UserExports;
import io.prometheus.client.CollectorRegistry;
import io.prometheus.client.exporter.MetricsServlet;
import io.prometheus.client.hotspot.DefaultExports;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonitoringConfig {
    /**
     * 注册新的servlet
     *
     * @return servletBean
     */
    @Bean
    ServletRegistrationBean<MetricsServlet> servletRegistrationBean() {
        //打开prometheus JVM所有监控参数
        DefaultExports.initialize();
        //自定义的export
        new UserExports().register(CollectorRegistry.defaultRegistry);
        MetricsServlet metricsServlet = new MetricsServlet();
        return new ServletRegistrationBean<>(metricsServlet, "/metrics");
    }
}
