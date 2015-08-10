package hello;

import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;


@Component
public class Dictionary {

	private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

	private final Lock read = readWriteLock.readLock();

	private final Lock write = readWriteLock.writeLock();
	

	private static final Logger log = LoggerFactory
			.getLogger(SpringConcurrencyLockApplication.class);

	private Map<String, String> dictionary;

	private HazelcastInstance instance;

	public Dictionary() {
		Config hazelcastConfiguration = new Config();
		instance = Hazelcast.newHazelcastInstance(hazelcastConfiguration);
		dictionary=instance.getMap("dictionary");
	}

	public void set(String key, String value) {
		write.lock();
		log.info("WRITE LOCK FOR 3 SEC");
		
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		try {
			dictionary.put(key, value);
		} finally {
			write.unlock();
		}
	}

	public String get(String key) {
		read.lock();

		try {
			return dictionary.get(key);
		} finally {
			read.unlock();
		}
	}

	public String[] getKeys() {
		read.lock();
		try {
			String keys[] = new String[dictionary.size()];
			return dictionary.keySet().toArray(keys);
		} finally {
			read.unlock();
		}
	}

}