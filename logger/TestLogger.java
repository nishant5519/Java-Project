package logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TestLogger {

	private static final Logger LOGGER = Logger.getLogger(TestLogger.class
			.getName());

	public static void main(String[] args) {
		//LOGGER.entering(TestLogger.class.getName(), "main");
		LOGGER.setLevel(Level.FINE);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINE);
		LOGGER.addHandler(handler);
		LOGGER.config("Logger Name: " + LOGGER.getName());
		LOGGER.fine("Finer Message");
	}
}
