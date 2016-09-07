package demo.cocurrent.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorServiceFactory {

	/** 私有化线程池执行器接口 */
	private ExecutorService executorService;
	
	/** 静态私有化当前对象示例 */
	private static ExecutorServiceFactory factory = new ExecutorServiceFactory();
	
	/**
	 * 私有化构造方法
	 */
	private ExecutorServiceFactory() {
		
	}
	
	/**
	 * 提供获取当前对象实例的getInstance方法
	 * 
	 * @return ExecutorServiceFactory 当前类实例（Singleton） 
	 */
	public ExecutorServiceFactory getInstance() {
		
		return factory;
	}
	
	private ThreadFactory getThreadFactory() {
		
		AtomicInteger atomicInteger = new AtomicInteger();
		
		return new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				
				/*public Thread newThread(Runnable runnable) {
					
				}*/
				
				return null;
			}
		};
	}
	
}
