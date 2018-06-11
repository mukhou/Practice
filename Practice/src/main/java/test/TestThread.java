package test;

class MyRunnable implements Runnable{
	public void run(){
		for(int i =0; i<4; i++){
			System.out.println(Thread.currentThread().getName());
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				
			}
		}
	}
}

public class TestThread {
	public static void main(String [] args) {
		MyRunnable mr = new MyRunnable();
		Thread t1 = new Thread(mr);
		Thread t2 = new Thread(mr);
		Thread t3 = new Thread(mr);
		t1.setName("Urmi Thread");
		t2.setName("Jhini Thread");
		t3.setName("Rini Thread");
		t1.start();
		t2.start();
		t3.start();
		//System.out.println(Thread.currentThread().getName());
		
	}

}
