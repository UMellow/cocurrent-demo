package demo.cocurrent.factory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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
	public static ExecutorServiceFactory getInstance() {
		
		return factory;
	}
	
	/**
	 * 创建一个可安排的线程池
	 * 
	 * @return ExecutorService 
	 * 			线程执行器，可安排在给定延迟后运行命令或者定期地执行
	 */
	public ExecutorService createSchedulerThreadPool() {
		
		int processors = Runtime.getRuntime().availableProcessors();
		executorService = Executors.newScheduledThreadPool(processors * 10, getThreadFactory());
		return executorService;
	}
	
	/**
	 * 创建一个可重用固定线程数的线程池
	 * 
	 * @return ExecutorService
	 * 			线程执行器，以共享的无界队列方式来运行这些线程 
	 */
	public ExecutorService createFixedThreadPool(int nThreads) {
		
		executorService = Executors.newFixedThreadPool(nThreads, getThreadFactory());
		return executorService;
	}
	
	private ThreadFactory getThreadFactory() {			
		
		return new ThreadFactory() {
			
			@Override
			public Thread newThread(Runnable r) {
				
				AtomicInteger atomicInteger = new AtomicInteger();
				SecurityManager securityManager = System.getSecurityManager();
				
				ThreadGroup threadGroup;
				if(securityManager != null) {
					threadGroup = securityManager.getThreadGroup();
				} else {
					threadGroup = Thread.currentThread().getThreadGroup();
				}
				
				Thread thread = new Thread(threadGroup, r);
				thread.setName("任务线程 - " + atomicInteger.incrementAndGet());
				return thread;											
			}
		};
	}
	
}
