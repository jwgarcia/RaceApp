package labNumber22;

public class ThreadRunner extends Thread {
	
	int rest = 0; 
	int speed = 0; 

	public ThreadRunner(String name, int rest, int speed) {
		//super();
		setName(name);
		this.rest = rest;
		this.speed = speed;
	}
	

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
		public void run() {
			
			int distance = 0;
			Thread ct = Thread.currentThread();

			while (!ct.isInterrupted() && distance < 1000) {
				try {
					int random = (int) (Math.random() * 100);
					if (rest <= random) {
						distance += speed;
						System.out.println(getName() + " : " + distance);
					}
					Thread.sleep(100);
				} catch (InterruptedException e) {
					System.out.println(getName() + ": You beat me fair and square!");
					break;
				}
				if (distance >= 50) {
					System.out.println(getName() + ": I finished!");
					RaceApp.finished(ct);
					return;
				}
			}

		}
		
	

}

