package demo.cocurrent.factory;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class ExecutorProcessPool {

	/** 静态私有化当前对象示例 */
	private static ExecutorProcessPool processPool = new ExecutorProcessPool();
	
	/** 线程池执行器 */
	private ExecutorService executor;
	
	/** 线程数量 */
	private final int threadMax = 10;
	
	/**
	 * 私有化构造方法
	 */
	private ExecutorProcessPool() {
		
		System.out.println("threadMax -->> " + threadMax);
		executor = ExecutorServiceFactory.getInstance().createFixedThreadPool(threadMax);
	}
	
	/**
	 * 提供获取当前对象实例的getInstance方法
	 * 
	 * @return ExecutorProcessPool 当前类实例（Singleton） 
	 */
	public static ExecutorProcessPool getInstance() {
		
		return processPool;
	}
	
	/**
	 * 关闭线程池；执行以前提交的任务，但不接受新任务
	 */
	public void shutdown() {
		
		executor.shutdown();
	}
	
	/**
	 * 提交一个Runnable类型的任务到线程池执行
	 * 
	 * @return Future<?> 该任务的未决结果，在任务完成时可调用get()方法获取任务结果
	 */
	public Future<?> submit(Runnable task) {
		
		return executor.submit(task);
	}
	
	/**
	 * 提交一个Callable类型的任务到线程池执行
	 * 
	 * @return Future<?> 代表该任务，在任务完成时可调用get()方法获取任务结果
	 */
	public Future<?> submit(Callable<?> task) {
				
		return executor.submit(task);
	}
	
	/**
	 * 提交任务到线程池，该任务的执行时间依赖于Executor的实现
	 */
	public void execute(Runnable task) {
		
		executor.execute(task);
	}
}
