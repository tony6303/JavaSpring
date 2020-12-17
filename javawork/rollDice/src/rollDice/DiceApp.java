package rollDice;

import javax.swing.JFrame;

public class DiceApp extends JFrame{
	public int dice1;
	public int dice2;
	public double randomValue;
	public double randomValue2;
	
	
	
	public DiceApp() {
		super();
		rollDice();
	}
	class RandomDice implements Runnable{
		@Override
		public void run() {
			while(true) {
				randomValue = Math.random();
				randomValue2 = Math.random();
				dice1 = (int)(randomValue * 6) + 1; 
				dice2 = (int)(randomValue2 * 6) + 1;
				System.out.println(dice1 + " and " + dice2);
				if (dice1 == dice2) {
					System.out.println("double!! ");
				}
				try {
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}	
	class DiceImg implements Runnable{

		@Override
		public void run() {
			while(true) {
				if(dice1 == 1) {
					
				}
			}
		}
		
	}
	
	public void rollDice() {
		Thread rd = new Thread(new RandomDice());
		rd.start();
	}
	
	public void changeImg() {
		Thread rd = new Thread(new DiceImg());
		rd.start();
	}
}
