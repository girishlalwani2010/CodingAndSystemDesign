class Message {
	
	private String message;
	
	public Message(){
		
	}
	public void setMessage(String message){
		this.message = message;
	}
	public String getMessage(){
		return message;
	}
	
}
public class ProducerConsumerWithSingleMessage {
	
	class Producer implements Runnable{

		Message message;
		
		public Producer(Message message){
			this.message = message;
		}
		
		@Override
		public void run() {
			int i =0;
			synchronized(message){
				while(i<20){
					if(message.getMessage() != null){
						try {
							message.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					message.setMessage("Hello Object Produced");
					System.out.println(message.getMessage());
					message.notify();
					i++;
				}
			}
		}
		
	}
	
	class Consumer implements Runnable{
		
		Message message;
		
		public Consumer(Message message){
			this.message = message;
		}

		@Override
		public void run() {
			int i = 0;
			synchronized(message){
				while(i<20){
				if(message.getMessage() == null){
					try {
						message.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Hi Object Consumed");
				message.setMessage(null);
				message.notify();
				i++;
				}
			}
			
		}
		
		
	}
	
	public static void main(String[] args) {
		Message message = new Message();
		ProducerConsumerWithSingleMessage producerConsumerWithSingleMessage = new ProducerConsumerWithSingleMessage();
		Producer producer = producerConsumerWithSingleMessage.new Producer(message);
		Thread producerThread  = new Thread(producer);
		Consumer consumer = producerConsumerWithSingleMessage.new Consumer(message);
		Thread consumerThread  = new Thread(consumer);
		producerThread.start();
		consumerThread.start();
	}

}
