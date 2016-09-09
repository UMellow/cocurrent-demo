package demo.cocurrent.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个可根据需要创建新线程的线程池，以前构造的线程，在可重用时将重用它们
 * 
 * @author zhaoyi 
 * @date 2016年9月9日 上午10:40:39
 */
public class TestCachedThreadPool {

	public static void main(String[] args) throws InterruptedException {
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0; i<10; i++) {
			final int index = i;			
			TimeUnit.MILLISECONDS.sleep(i * 1000);			
			executor.execute(new Runnable() {
				
				@Override
				public void run() {
					System.out.println(index);					
				}
			});
		}
	}
}
