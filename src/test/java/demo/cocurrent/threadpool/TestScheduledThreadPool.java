package demo.cocurrent.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 创建一个定长线程池，可定时或周期性执行
 * 
 * @author zhaoyi 
 * @date 2016年9月9日 上午10:03:46
 */
public class TestScheduledThreadPool {

	public static void main(String[] args) {
		
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(5);
				
		/*executor.schedule(new Runnable() {			
			@Override
			public void run() {
				System.out.println("延迟5秒执行");				
			}
		}, 5, TimeUnit.SECONDS);*/
		
		executor.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("延迟5秒执行后，每隔两秒执行一次");				
			}
		}, 5, 2, TimeUnit.SECONDS);
	}
}
