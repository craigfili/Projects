
public class Multithreads {
		static int counter = 0;
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
		    @Override
		    public void run() {
			    for (int i=0; i < 20; i++){
			    	counter++;
					System.out.println(counter);
				}
		    }
		});  
		t1.start();
		try {
		t1.join();
		}catch (InterruptedException e) {
			System.out.println("Interrupted Exception");
		}
		Thread t2 = new Thread(new Runnable() {
		    @Override
		    public void run() {
		    	for (int i=0; i < 21; i++){//21 to count down to 0
		    		System.out.println(counter);//print and decrement
					counter--;             // order changed to print 20 twice
				}
		    }
		});  
		t2.start();
	}

}
