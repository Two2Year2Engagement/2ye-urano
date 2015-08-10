package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reader extends Thread {

	private Dictionary dictionary = null;

	private static final Logger log = LoggerFactory.getLogger(SpringConcurrencyLockApplication.class);

	
	public Reader(Dictionary d, String threadName) {
		this.dictionary = d;
		this.setName(threadName);
	}

	private boolean runForestRun = true;

	@Override
	public void run() {
		while (runForestRun) {
			String[] keys = dictionary.getKeys();
			for (String key : keys) {
				// reading from dictionary with READ LOCK
				String value = dictionary.get(key);

				// make what ever you want with the value.
				log.info("Thread: "+ this.getName()+"key: "+key + " : " + "value: "+value);
			}

			// update every seconds
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void stopReader() {
		this.runForestRun = false;
		this.interrupt();
	}
}