package testcases;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import testbase.TestBase;

public class Sample {

	static final Logger logger = LogManager.getLogger(Sample.getName());
	
	public static void main(String[] args) throws IOException {
		
		logger.info("Sample Class to initialized");
		
		TestBase tb = new TestBase();
		tb.getDriverInstance();
		
	}

	private static Object getName() {
		// TODO Auto-generated method stub
		return null;
	}

}
