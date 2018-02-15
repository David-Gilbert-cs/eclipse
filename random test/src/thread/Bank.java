package thread;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Bank
{
	private static final NumberFormat FORMATTER = DecimalFormat.getCurrencyInstance();
	
	static
	{
		FORMATTER.setMinimumFractionDigits(0);
	}
	
	public static void main( String[] args )
	{
		final Account[] accounts = createAccounts();
		final Thread[] customers = createCustomers(accounts);
//		CountDownLatch
		
		startAll(customers);
		waitForAll(customers);
		
		int total = 0;
		for( Account account : accounts)
		{
			total += account.getBalance();
		}
		
		System.out.println(FORMATTER.format(total));
	}
	
	private static Account[] createAccounts()
	{
		Account[] accounts = new Account[50];
		for( int i = 0 ; i < accounts.length; i++ )
		{
			accounts[i] = new Account(20000);
		}
		return accounts;
	}

	private static Thread[] createCustomers(Account[] pAccounts)
	{
		Thread[] customers = new Thread[50];
		for( int i = 0; i < customers.length; i++ )
		{
			customers[i] = new Thread(new Customer(pAccounts, i));
		}
		return customers;
	}
	
	private static void startAll(Thread[] pThreads)
	{
		for( Thread thread : pThreads )
		{
			thread.start();
		}
	}
	
	private static void waitForAll(Thread[] pThreads)
	{
		for( Thread thread : pThreads )
		{
			try
			{
				thread.join();
			}
			catch( InterruptedException e )
			{
				return;
			}
		}
	}
}

class Customer implements Runnable
{
	private final Account[] aAccounts;
	private final Random aRandom = new Random();
	private final int aNumber;

	public Customer(Account[] pAccounts, int pNumber) 
	{ 
		aAccounts = pAccounts; 
		aNumber = pNumber;
	}
	
	@Override
	public void run()
	{
		for( int i = 0 ; i < 100000; i++)
		{
			aAccounts[aNumber].debit(10);
			aAccounts[aRandom.nextInt(aAccounts.length)].credit(10);
		}
	}
}
