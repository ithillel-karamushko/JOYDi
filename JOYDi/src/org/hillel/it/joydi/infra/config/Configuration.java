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
	List<String> lines;

	private Configuration() {
		this.properties = new HashMap<String, String>();
		try {
			this.stream = Configuration.class.getClassLoader()
					.getResourceAsStream("application.properties");
			this.lines = IOUtils.readLines(stream, Charset.defaultCharset());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(stream);
		}
	}

	public static Configuration getInstance() {
		if (instance == null) {
			instance = new Configuration();
		}
		return instance;
	}

	public String getPropertie(String key) {
		for (String line : lines) {
			String[] propertie = line.split("=");
			properties.put(propertie[0], propertie[1]);
		}
		return properties.get(key);
	}
}
