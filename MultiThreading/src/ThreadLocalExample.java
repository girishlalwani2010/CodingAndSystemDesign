class User{
		int userId;
		String password;
	}
	
	class ESFSession{
		User uservo;
		String requestMetadata; // could be object as well
	}
	
	
	// t.threadlocals, 
	
	class ESFSessionThreadLocal{
		
		private static final ThreadLocal<ESFSession> esfSessionThreadLocal = new ThreadLocal<ESFSession>();
		
		// setting the ESFSession on begin of each HTTP request 
		public static void setESFSession(ESFSession esfSession){
			esfSessionThreadLocal.set(esfSession);
		}
		// getting the ESFSession in between of thread execution, in between of Transaction
		public ESFSession getESFSession(){
			return esfSessionThreadLocal.get();
		}
		
		// Clean the Thread Local associated with 
		public void removeESFSession(){
			esfSessionThreadLocal.remove();
		}
	}

	// Thread Local Second Example, for sharing the context within the transaction
	 class TransactionManager {
		private static final ThreadLocal<String> context = new ThreadLocal<String>();
		public static void startTransaction() {
		//logic to start a transaction
		//...
		String generatedId	= "sgcsg!@";
		context.set(generatedId); 
		}
		public static String getTransactionId() {
		return context.get();
		}
		public static void endTransaction() {
		//logic to end a transaction
		//…
		context.remove();
		}
		}

	public class ThreadLocalExample {
		// ThreadLocal internally implements a map called to ThreadLocal map which is the map of ThreadLocalVariable to Value.
	// So we can say that each thread has ThreadLocalMap, because thread can have one or more Thread Locals
	}
