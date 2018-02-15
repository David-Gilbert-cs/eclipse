package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Shared data structure for my synchronization examples.
 */
public class Account
{
	private final Lock lock = new ReentrantLock();
	private final Condition aBalanceAvailable = lock.newCondition();
	
	private int aBalance;

	public Account(int pBalance)
	{
		aBalance = pBalance;
	}
	
	public void credit(int pAmount)
	{ 
		lock.lock();
		try{
			aBalance += pAmount; 
			aBalanceAvailable.signalAll();
		}
		finally {
			lock.unlock();
		}
		
	}
	
	public void debit(int pAmount) 
	{ 
		lock.lock();
		try 
		{
			while(pAmount > getBalance() )
			{
				aBalanceAvailable.await();
			}
			aBalance -= pAmount; 
		}
		catch( InterruptedException e ) { return; }
		finally 
		{
			lock.unlock();
		}
	}
	
	public int getBalance() 
	{
		lock.lock();
		try {
		return aBalance;}
		finally {
			lock.unlock();
		}
	}
}
