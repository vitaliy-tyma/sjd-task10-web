package info.sjd;

import java.util.logging.Logger;

import info.sjd.service.DataSaver;

public class AppRunner {
	private static String URL = "https://www.amazon.com/LG-gram-Thin-Light-Laptop/dp/B078WRSHV4/ref=sr_1_82_sspa";
	private static final String SEP = System.getProperty("file.separator");
	private static final String DIR_NAME = "data" + SEP;
	private static final String FILE_NAME = DIR_NAME + "task10.xml";
	
	
	public static void main(String[] args) {
		/** DataSaver*/
		Logger logger = Logger.getLogger(AppRunner.class.getName());
		logger.info("PROGRAM STARTED");
		
		//URL = "http://google.com";
		String xml_data = DataSaver.getData(URL);
		DataSaver.saveToFile(xml_data, FILE_NAME);
		
		logger.info("PROGRAM ENDED");
		
		
	}

}
