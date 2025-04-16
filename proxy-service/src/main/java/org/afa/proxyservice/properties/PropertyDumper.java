package org.afa.proxyservice.properties;

import jakarta.annotation.PostConstruct;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.PropertySource;
import org.springframework.stereotype.Component;

@Component
public class PropertyDumper {

	private final ConfigurableEnvironment env;

	public PropertyDumper(ConfigurableEnvironment env) {
		this.env = env;
	}

	@PostConstruct
	public void dumpAllProperties() {
		System.out.println("🛠 Dumping my usefull property :");
		String configUrl = env.getProperty("CONFIG_SERVICE_URL");
		System.out.println("🔍 CONFIG_SERVICE_URL = " + configUrl);

		String resolvedImport = env.getProperty("spring.config.import");
		System.out.println("🔍 spring.config.import = " + resolvedImport);

		String configUrl2 = env.getProperty("DISCOVERY_SERVICE_URL");
		System.out.println("🔍 DISCOVERY_SERVICE_URL = " + configUrl2);

		String resolvedImport2 = env.getProperty("eureka.client.serviceUrl.defaultZone");
		System.out.println("🔍 eureka.client.serviceUrl.defaultZone = " + resolvedImport2);

		/*System.out.println("🛠 Dumping all Spring Boot properties:");
		for (PropertySource<?> propertySource : env.getPropertySources()) {
			System.out.println("Source: " + propertySource.getName());
			if (propertySource.getSource() instanceof java.util.Map<?, ?> map) {
				map.forEach((key, value) -> System.out.println("  " + key + " = " + value));
			}
		}*/
	}
}
