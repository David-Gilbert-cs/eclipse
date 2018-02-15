package thread;

import java.util.Random;

public class Simulator
{
	public static void main(String[] args)
	{
		Account account = new Account(0);
		new Thread( new Parent(account)).start();
		new Thread( new Teen(account,100)).start();
		new Thread( new Teen(account,150)).start();
		new Thread( new Teen(account,200)).start();
	}
}

class Parent implements Runnable
{
	private Account aAccount;
	public Parent(Account pAccount) { aAccount = pAccount; }
	
	@Override
	public void run()
	{
		for( int i = 0; i < 1000; i++ )
		{
			try
			{
				aAccount.credit(1000);
				Thread.sleep(250);			
				System.out.println("Week " + i + " " + aAccount.getBalance());
			}
			catch(InterruptedException e)
			{
				return;
			}
		}
	}
}

class Teen implements Runnable
{
	private Account aAccount;
	private int aAllowance;
	private Random aRandom = new Random();
	
	public Teen( Account pAccount, int pAllowance )
	{
		aAccount = pAccount;
		aAllowance = pAllowance;
	}
	@Override
	public void run()
	{
		for( int i = 0; i < 150; i++ )
		{
			int spend = aRandom.nextInt(aAllowance);
			aAccount.debit(spend);
		}
	}
}
