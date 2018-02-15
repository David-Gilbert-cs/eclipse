package thread;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//import sun.swing.SwingLazyValue;

@SuppressWarnings("serial")
public class PrintLotsOfNumbers extends JFrame
{
	public PrintLotsOfNumbers()
	{
		final JButton button = new JButton("Go");
		button.setPreferredSize(new Dimension(50,25));
		add(button);
		
		button.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				new Thread(new Runnable() {
					
					public void run()
					{
						// Still not technically correct...
						SwingUtilities.invokeLater(()->button.setText("Processing..."));
						longRunningOperation();	
						SwingUtilities.invokeLater(()->button.setText("Half Done!"));
						longRunningOperation();		
						SwingUtilities.invokeLater(()->button.setText("Done!"));
					}
				}).start();
			}
		});
		
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setLocationRelativeTo(null);
		pack();
		setVisible( true );
	}
	
	public static void main(String[] args)
	{
		new PrintLotsOfNumbers();
	}
	
	public static void longRunningOperation()
	{
		for( int i = 0; i < 500000; i++)
		{
			System.out.println(i);
		}
	}
}
