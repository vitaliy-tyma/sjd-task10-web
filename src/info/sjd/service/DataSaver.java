package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;
import info.sjd.AppRunner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

//import javax.print.Doc;

public class DataSaver {

	public static String getData(String url) {
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		logger.info("in getData");

		Document doc = null;
		String xml_data = null;

		try {
			System.setProperty("http.proxyHost", "127.0.0.1");
			System.setProperty("http.proxyPort", "22222");

			System.setProperty("https.proxyHost", "127.0.0.1");
			System.setProperty("https.proxyPort", "22222");

			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla/5.0");
			connection.referrer("http://google.com");
			connection.timeout(30 * 1000);

			doc = connection.get();

		} catch (IOException e) {
			e.printStackTrace();
		}

		String strHTML = doc.text();
		String title = doc.title();

		//- Elements data = doc.select("//*[(@id = \"productTitle\")]");
		//- Elements data = doc.select("(@id = \"productTitle\")");

		logger.info(strHTML);
		logger.info(title);

		
		xml_data = title;
		return xml_data;

	}

	public static void saveToFile(String xml_data, String file_name) {

		try (FileWriter writer = new FileWriter(file_name)) {
			writer.write(xml_data);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
