package br.com.santander.devguide.rdbms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import br.com.santander.devguide.rdbms.entity.MyDataBean;
import br.com.santander.devguide.rdbms.entity.MyEntityBean;
import br.com.santander.devguide.rdbms.entity.MyEntityDao;

@SpringBootApplication
// @ComponentScan(basePackages = "br.com.santander.devguide.rdbms.entity")
public class MyApp {

	public static void main(String[] args) throws IOException {

		SpringApplication app = new SpringApplication(MyApp.class);

		Properties properties = new Properties();
		properties.setProperty("spring.datasource.username",
				Files.lines(Paths.get("/etc/secret/dbuser")).findFirst().get());
		properties.setProperty("spring.datasource.password",
				Files.lines(Paths.get("/etc/secret/dbpass")).findFirst().get());
		app.setDefaultProperties(properties);

		System.out.println(properties);

		ConfigurableApplicationContext appCtx = app.run(args);

		MyApp service = appCtx.getBean(MyApp.class);
		//
		Map<String, String> data = new HashMap<>();
		data.put("id", "1");
		data.put("text", "some text");
		data.put("when", "01/01/1970");
		data.put("amount", "100.0");
		MyEntityBean entity = service.createRecord(data);
		System.out.println(entity);
		//
		entity = service.readRecord(1L);
		System.out.println(entity);

		MyDataBean vo = service.readRecordData(1L);
		System.out.println(vo);
	}

	@SuppressWarnings({ "unused", "unchecked" })
	private static <T> T getParam(String[] args, String paramName, Class<T> type) {
		T paramVal = null;
		for (String param : args) {
			if (param.startsWith(paramName + "=")) {
				String tempVal = param.substring(paramName.length() + 1, param.length());
				if (type.equals(Long.class)) {
					paramVal = (T) Long.valueOf(tempVal);
				} else if (type.equals(Double.class)) {
					paramVal = (T) Double.valueOf(tempVal);
				} else if (type.equals(Integer.class)) {
					paramVal = (T) Integer.valueOf(tempVal);
				} else if (type.equals(Date.class)) {
					try {
						paramVal = (T) df.parse(tempVal);
					} catch (ParseException e) {
						throw new RuntimeException(e);
					}
				}
			}
		}

		return paramVal;
	}

	private static SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@Autowired
	private MyEntityDao dao;

	public MyApp() {
	}

	MyEntityBean createRecord(Map<String, String> data) {
		try {
			//
			Long id = Long.valueOf(data.get("id"));
			String text = data.get("text");
			Date when = df.parse(data.get("when"));
			Double amount = Double.valueOf(data.get("amount"));
			//
			MyEntityBean entity = new MyEntityBean(id, text, when, amount);
			//
			return dao.save(entity);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	MyEntityBean readRecord(Long id) {
		return dao.find(id);
	}

	MyDataBean readRecordData(Long id) {
		return dao.retrieveData(id);
	}

}
