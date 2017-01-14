package com.langrensha.utility;

import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	private Timer timer;
	private int myCount;
	int id;

	public MyTimer(int count, int id) {
		this.id = id;
		this.myCount = count;
	}

	public void execute() {
		if (timer != null)
			timer.cancel();
		timer = new Timer();
		timer.schedule(new MyTask(myCount), 0, 1000);
	}

	public void cancel() {
		timer.cancel();
	}

	class MyTask extends TimerTask {
		private int count;

		public MyTask(int count) {
			this.count = count;
		}

		@Override
		public void run() {
			Thread.currentThread().setName("" + id);
			System.out.print(Thread.currentThread().getName() + ":" + count
					+ " ");
			count--;
			if (count <= 0) {
				synchronized (timer) {
					// timer.purge();
					timer.cancel();
					System.out.println("时间到");
				}
			}
		}
	}

	public static void main(String args[]) {
		MyTimer timer = new MyTimer(5, 1);
		timer.execute();
//		timer = new MyTimer(5, 1);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		timer.execute();
	}
}
