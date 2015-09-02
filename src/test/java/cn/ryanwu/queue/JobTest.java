package cn.ryanwu.queue;

import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JobTest {
	
	private static JobManager jobManager;
	
	@BeforeClass
	public static void before() {
		jobManager = new JobManager(5, 3);
		jobManager.start();
	}
	
	@Test
	public void testJob1() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		generateJobs(20);
	}

	@AfterClass
	public static  void after() throws InterruptedException {
		Thread.sleep(30000);
		jobManager.close();
	}
	
	public void generateJobs(int count) {
		for(int i = 0; i < count; i++) {
			try {
				Thread.sleep(800);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Job job = new Job(String.valueOf("Job"+new Random().nextInt()));
			jobManager.addJob(job);
		}
	}
}
