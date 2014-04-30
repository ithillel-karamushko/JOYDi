package org.hillel.it.joydi.infra.config;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.io.IOUtils;

public class Configuration {
	private static Configuration instance;
	Map<String, String> properties;
	InputStream stream;

	private Configuration() {
		this.properties = new HashMap<String, String>();
	}

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	public String getPropertie(String key) throws IOException {
		stream = Configuration.class.getClassLoader().getResourceAsStream(
				"application.properties");
		List<String> lines = IOUtils.readLines(this.stream,
				Charset.defaultCharset());
		for (String line : lines) {
			String[] propertie = line.split("=");
			properties.put(propertie[0], propertie[1]);
		}
		IOUtils.closeQuietly(stream);
		return properties.get(key);
	}

}
