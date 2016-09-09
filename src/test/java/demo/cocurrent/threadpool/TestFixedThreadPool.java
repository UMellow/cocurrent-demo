package demo.cocurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

/**
 * 创建一个定长线程池，可控制线程最大并发数，超出的线程在队列中等待
 * 
 * @author zhaoyi 
 * @date 2016年9月9日 上午9:56:36
 */
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
