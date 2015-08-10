package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Writer extends Thread{
   private boolean runForestRun = true;
   private Dictionary dictionary = null;
	private static final Logger log = LoggerFactory.getLogger(SpringConcurrencyLockApplication.class);

   public Writer(Dictionary dictionary2, String threadName) {
     this.dictionary = dictionary2;
     this.setName(threadName);
   }
   @Override
   public void run() {
	   int cont=0;
	   String newName = this.getName();
     while (this.runForestRun) { 
       String [] keys = dictionary.getKeys();
       for (String key : keys) {
         String newValue = getNewValueFromDatastore(key);
         //updating dictionary with WRITE LOCK
         dictionary.set(key, newName+" : "+cont);
         String value = dictionary.get(key);
		log.info("Thread: "+ this.getName()+"key: "+key + " : " + "value: "+value);
		cont++;
		
		this.setName(newName+" : "+cont);
       }
       try {
	         Thread.sleep(2000);
	       } catch (InterruptedException e) {
	         e.printStackTrace();
	       }
       //update every seconds
      
     }
   }
   public void stopWriter(){
     this.runForestRun = false;
     this.interrupt();
   }
   public String getNewValueFromDatastore(String key){
     //This part is not implemented. Out of scope of this artile
     return "newValue";
   }
}
