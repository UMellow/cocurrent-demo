package demo.cocurrent.factory;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class TestExecutor {

	public static void main(String[] args) {
		
		ExecutorProcessPool processPool = ExecutorProcessPool.getInstance();
		
		for(int i=0; i<200; i++) {
			processPool.submit(new ExecuteTask1(i + ""));
		}
		
		for(int i=0; i<200; i++) {
			processPool.execute(new ExecuteTask2(i + ""));
		}
		
		processPool.shutdown();
		System.out.println("over");
	}

	static class ExecuteTask1 implements Callable<String> {

		private String taskName;
		
		public ExecuteTask1(String taskName) {
			this.taskName = taskName;
		}
		
		@Override
		public String call() throws Exception {
			
			TimeUnit.MILLISECONDS.sleep(1000);
			
			System.out.println("======== 业务执行，Callable TaskName  ========" + taskName);
			
			return ">>>>>>>>>>>>> 线程执行结果，Callable TaskName <<<<<<<<<<<<< " + taskName;
		}
		
	}
	
	static class ExecuteTask2 implements Runnable {

		private String taskName;
		
		public ExecuteTask2(String taskName) {
			this.taskName = taskName;
		}
		
		@Override
		public void run() {
			
			try {
				TimeUnit.MILLISECONDS.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			System.out.println("======== 业务执行，Runnable TaskName  ========" + taskName);
		}
		
	}
	
}
