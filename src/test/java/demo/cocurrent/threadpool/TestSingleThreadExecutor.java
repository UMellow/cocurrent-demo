package demo.cocurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestSingleThreadExecutor {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		for(int i=0; i<10; i++) {
			final int index = i;
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(index);
					try {
						while(true) {
							TimeUnit.MILLISECONDS.sleep(10 * 1000);
						}						
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}
			});
			
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}
		}
	}
}
