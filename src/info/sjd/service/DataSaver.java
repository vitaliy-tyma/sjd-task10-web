package info.sjd.service;

import java.io.FileWriter;
import java.io.IOException;
import info.sjd.model.Product;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DataSaver {

	public static Product getData(String url, Boolean proxy) {
		Product product = null;
		Document doc = null;
		String product_name;
		String keyboard;
		String color;
		String product_number;
		String display;
		String cpu;
		String ram;
		String hdd;
		String os;
		String battery;

		try {
			if (proxy) {
				System.setProperty("http.proxyHost", "127.0.0.1");
				System.setProperty("http.proxyPort", "22222");

				System.setProperty("https.proxyHost", "127.0.0.1");
				System.setProperty("https.proxyPort", "22222");
			}

			Connection connection = Jsoup.connect(url);
			connection.userAgent("Mozilla/5.0");
			connection.referrer("http://google.com");
			connection.timeout(30 * 1000);

			doc = connection.get();

			/** Data from title */
			Element getDivTitle = doc.getElementById("titleSection");
			String[] product_title_quals = getDivTitle.text().split(",");

			product_name = parseName(product_title_quals);
			keyboard = parseKb(product_title_quals);
			color = parseColor(product_title_quals);
			product_number = parsePNumber(product_title_quals);

			/** Data from list */
			Element getDivQuals = doc.getElementById("feature-bullets");
			Elements quals = getDivQuals.select("span");

			/** Elements to array */
			int i = 0;
			String product_quals[] = new String[quals.size()];
			for (Element qual : quals) {
				product_quals[i++] = qual.text();
			}

			/**
			 * Continue with try/catch processing
			 */
			display = product_quals[4];
			cpu = product_quals[7];
			ram = product_quals[8].split(" & ")[0];
			hdd = product_quals[8].split(" & ")[1];
			os = (product_quals[5].split(". "))[0];
			battery = product_quals[6];

			product = new Product(product_name, display, cpu, ram, hdd, keyboard, color, product_number, os, battery);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return product;
	}

	/** saveToFile */
	public static void saveToFile(String xml_data, String file_name) {

		try (FileWriter writer = new FileWriter(file_name)) {
			writer.write(xml_data);
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** Parse name */
	public static String parseName(String[] product_title_quals) {
		String product_name;
		try {
			product_name = product_title_quals[0].split(" - ")[0];
		} catch (Exception ex) {
			ex.printStackTrace();
			product_name = "UNDEFINED";
		}
		return product_name;
	}

	/** Parse keyboard */
	private static String parseKb(String[] product_title_quals) {
		String keyboard;
		try {
			keyboard = product_title_quals[4].split(" - ")[0];
		} catch (Exception ex) {
			ex.printStackTrace();
			keyboard = "UNDEFINED";
		}
		return keyboard;
	}

	/** Parse color */
	private static String parseColor(String[] product_title_quals) {
		String color;
		try {
			color = (product_title_quals[4].split(" - ")[1]).split(" – ")[0];
		} catch (Exception ex) {
			ex.printStackTrace();
			color = "UNDEFINED";
		}
		return color;
	}

	/** Parse product_number */
	private static String parsePNumber(String[] product_title_quals) {
		String product_number;
		try {
			product_number = (product_title_quals[4].split(" - ")[1]).split(" – ")[1];
		} catch (Exception ex) {
			ex.printStackTrace();
			product_number = "UNDEFINED";
		}
		return product_number;
	}

}