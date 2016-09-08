package demo.cocurrent.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestFixedThreadPool {

	public static void main(String[] args) {
		
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		for(int i=0; i<10; i++) {
			final int index = i;
			executor.execute(new Runnable() {

				@Override
				public void run() {					
					System.out.println(index);
					try {
//						Thread.sleep(4000);
						TimeUnit.MILLISECONDS.sleep(3000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}				
			});
		}
	}
	
	@Test
	public void testFixedPool() {
		
		ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
		
		for(int i=0; i<10; i++) {
			final int index = i;
			executor.execute(new Runnable() {

				@Override
				public void run() {					
					System.out.println(index);
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {						
						e.printStackTrace();
					}
				}				
			});
		}
	}

}
