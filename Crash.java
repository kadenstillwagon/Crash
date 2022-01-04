package Project;
import java.text.DecimalFormat;
import java.util.*;
public class Crash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*for(int i=0; i<100;i++)
		{
			System.out.println(crash());
		}*/
		int newgame =1;
		while(newgame==1)
		{
			System.out.println("\n\n\n\t\t\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\t\t\t\t\t\t |---------   |------        /\\       |---------   |      |  ");
			System.out.println("\t\t\t\t\t\t\t\t |            |      \\      /  \\      |            |      |  ");
			System.out.println("\t\t\t\t\t\t\t\t |            |______/     /____\\     |_________   |______|  ");
			System.out.println("\t\t\t\t\t\t\t\t |            |    \\      /      \\             |   |      |  ");
			System.out.println("\t\t\t\t\t\t\t\t |            |     \\    /        \\            |   |      |  ");
			System.out.println("\t\t\t\t\t\t\t\t |---------   |      \\  /          \\  ----------   |      |  ");
			System.out.println("\t\t\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			
		 /* System.out.println("\n\n\n\n|-------------------------------------------------------------------------------------------------------------------------------|");
			      System.out.println("|Rules:                                                                                                                         |");
			    //System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|");
			      System.out.println("| 1. There is a maximum of SEVEN players allowed.                                                                               |");
			      System.out.println("| 2. Names must be between 2 and 9 letters long and may include numbers or symbols.                                             |");
			      System.out.println("| 3. Bet amounts are in pennies. Starting money and bets must be between 1 and 999999.                                          |");
			      System.out.println("| 4. If asked a question other than name or starting amount, answer only with 1, 2, or 3.                                       |");
			      System.out.println("| 5. If a player gets blackjack, they will win double their bet, unless dealer gets blackjack as well.                          |");
			      System.out.println("| 6. If you select double down, you will double your bet for that round.                                                        |");
			      System.out.println("| 7. Insurance is offered when the dealer has an ace. If you select insurance, you will only lose or gain half of you bet.      |");
			      System.out.println("| 8. If the dealer busts, everyone wins, except those who have already busted.                                                  |");
			      System.out.println("| 9. If the dealer gets blackjack, everyone without blackjack loses. Those with blackjack push.                                 |");
			      System.out.println("| 10. Rouds must be finished.                                                                                                   |");
			      System.out.println("| 11. Money balance is maintained each round, but is reset if a new game is started.                                            |");
			      System.out.println("| 12. Players can be added or removed after each round. An eighth player cannot be added and a single player cannot be removed. |");
			      System.out.println("|-------------------------------------------------------------------------------------------------------------------------------|\n\n\n\n");*/
			    
			    int start=0;
				while(start!=1)
				{
			    Scanner sg = new Scanner(System.in);
				System.out.println("Enter 1 to Start Game:\t");
				start = sg.nextInt();
				
				if(start==1)
				{
				System.out.println("\n\n\n");
			    play();
				}
				else
				{
					System.out.println("\nEnter 1 Only!\n");
				}
				}
			int wrong=0;
			while(wrong==0)
			{
			Scanner ng = new Scanner(System.in);
			System.out.println("Would you like to start a new game?");
			System.out.println("1. Yes\n2. No");
			newgame= ng.nextInt();
			//String newgameS=ng.nextLine();
			
			if(newgame==1)
			{
				wrong=1;
			}
			if(newgame==2)
			{
				wrong=1;
				System.out.println("Goodbye");
			}
			else if(newgame!=1 && newgame!=2)
			{
				wrong=0;
				System.out.println("\nEnter only 1 or 2!\n");
			}
			
			}
		}                   
	}
	static void play()
	{
		int players=8;
		double multi=0;
		while(players>7)
		{
		Scanner pl = new Scanner(System.in);
		System.out.print("Enter number of players: \t");
		players= pl.nextInt();
		
		if(players>7)
		{
			System.out.println("\n7 is the Maxium number of players!\n");
		}
		}
		PlayersOfGame gp=new PlayersOfGame(players);
		
		System.out.println("\n\nLoading sample graph...\n\n\n");
		
		try 
		{
			Thread.sleep(2000);
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		sampleGraph();
		
		
		int cont=1;
		while(cont==1 || cont==3)
		{
		reset(players, gp);
		setup(players, gp);
		
		
		for(int i=1; i<=players; i++)
		{
			setPrediction(i, gp);
			setBett(i, gp);
			double limit=calcFinalLim(i, gp);
			multi=multiplier(limit);
			gp.setMulti(i, multi);
		}
		setup(players, gp);
		
		System.out.println("\n\nGame is starting...\n\n");
		try 
		{
			Thread.sleep(3000);
			
		} 
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		
		header();
		int crashnum=crashgraph();
		
		for(int j=1; j<=players; j++)
		{
		winLose(gp, players, crashnum, j);
		calcMoney(multi, gp, players, j, crashnum);
		}
		setup(players, gp);
		
		
		
		int wrongagain=0;
		while(wrongagain==0)
		{
		Scanner ag = new Scanner(System.in);
		System.out.println("Play Another Round?");
		System.out.println("1. Yes\n2. No\n3. Add or Remove a Player");
		cont= ag.nextInt();
		
		reset(players, gp);
		
		if(cont==1)
		{
		wrongagain=1;
		reset(players, gp);
		}
		else if(cont==3)
		{
			wrongagain=1;
			int addremove=1;
			while(addremove!=3)
			{
			Scanner ar = new Scanner(System.in);
			System.out.println("\n\n\nAdd or Remove a Player?");
			System.out.println("1. Add\n2. Remove\n3. No");
			addremove= ar.nextInt();
			
			if(addremove==1)
			{
				if(players<7)
				{
				players=addPlayer(gp, players);
				}
				else
				{
					System.out.println("Too Many Players(The Max is SEVEN)");
				}
			}
			else if(addremove==2)
			{
				if(players>1)
				{
				Scanner re = new Scanner(System.in);
				System.out.println("Which player do you want to remove?");
				for(int i=1;i<=players; i++)
				{
				System.out.println(i+". "+gp.getName(i));
				}
				int removed= re.nextInt();
				
				players=removePlayer(gp, removed, players);
				}
				else
				{
					System.out.println("\nCannot Remove One Player\n");
				}
			}
			else if(addremove==3)
			{
				
			}
			else
			{
				System.out.println("\nEnter only 1, 2, or 3\n");
			}
		}
	}
		
		
		else if(cont==2)
		{
			DecimalFormat Dec = new DecimalFormat("0.#");
			wrongagain=1;
			System.out.println("\n\nFINAL AMOUNTS\n~~~~~~~~~~~~~\n\n");
			
			gp.sortPlayers();
			for(int i=1; i<=players; i++)
			{
				System.out.println(i+". "+gp.getName(i)+":\t"+Dec.format(gp.getMoney(i))+"\n   "+"Money Won:\t"+Dec.format((gp.getMoney(i))-(gp.getStartingMoney(i)))+"\n");
			}
			System.out.println("\n\n\n");
			fullreset(players, gp);
		}
		else
		{
			wrongagain=0;
			System.out.println("\nEnter only 1, 2, or 3!\n");
		}
		}
		}
	}
	
	static int crashgraph()
	{
		double finalLim=0;
		double exponent=1;
		long wait=200;
		double limit=0;
		int crashnum=crash();
		for(int i=1;i<=crashnum; i++)
		{
			try 
			{
				Thread.sleep(wait);
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			limit=Math.pow(i, exponent);
			
			exponent+=.0069;
			if(i<10)
			{
			System.out.print(i+".  |");
			}
			else
			{
				System.out.print(i+". |");
			}
			
			graphsection(limit, i);
			

			
		}
		double multiplier=0;
		finalLim=limit;
		
		System.out.println("\n\nCrashed at "+crashnum);
		if(crashnum==50)
		{
			multiplier=10;
		}
		else
		{
			multiplier=multiplier(finalLim);
		}
		DecimalFormat Dec = new DecimalFormat("0.#");
		System.out.println("Max Multiplier: "+Dec.format(multiplier));
		
		return crashnum;
		
		/*else
		{
			System.out.println("Stopped at "+stopped);
			multiplier=multiplier(finalLim);
			System.out.println("Multiplier: "+multiplier);
		}*/
		
	}
	static void graphsection(double limit, int i)
	{
		for(int j=1; j<limit; j++)
		{
			if(j==30)
			{
				System.out.print("|");
			}
			System.out.print(" ");
		}
		if(i!=20)
		{
		System.out.print("-");
		}
		
		if(limit<30)
		{
			for(int j=1; j<=30-limit-1; j++)
			{
				System.out.print(" ");
			}
			System.out.print("|");
		}
		System.out.println();
	}
	static void header()
	{
		System.out.println("    |                            1.0                            2.0                            3.0                            4.0                            5.0                            6.0");
		System.out.println("    |                             |                              |                              |                              |                              |                              | ");
		System.out.println("----|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
	}
	static void sampleGraph()
	{
		System.out.println("\n\nSample Graph:\n\n");
		header();
		double exponent=1;
		long wait=200;
		double limit=0;
		for(int i=1;i<=50; i++)
		{
			try 
			{
				Thread.sleep(wait);
				
			} 
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			
			limit=Math.pow(i, exponent);
			
			exponent+=.0069;
			if(i<10)
			{
			System.out.print(i+".  |");
			}
			else
			{
				System.out.print(i+". |");
			}
			
			graphsection(limit, i);
			
		}
		System.out.println("\n\n");
	}
	static int crash()
	{
		Random rand=new Random();
		int crash=rand.nextInt(50)+1;
		if(crash<21)
		{
			crash=rand.nextInt(50)+1;
		}
		return crash;
	}
	static double multiplier(double limit)
	{
		double multi=0;
		for(double i=0, j=1, k=0; j<64; i++, j++, k+=.1)
		{
			if(i*3< limit && limit <=j*3)
			{
				multi+=k;
			}
		}
		if(limit>=187)
		{
			multi=10;
		}
		return multi;
	}
	static void setup(int numplayers, PlayersOfGame players)
	{

		if(numplayers==1)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 0)+"\n");
		}
		else if(numplayers==2)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 1)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 0)+"\n");
		}
		else if(numplayers==3)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 1)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 0)+"\n\n"+playerInfo(players, 3, players.getprediction(3), 1)+"\n");
		}
		else if(numplayers==4)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 2)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 1)+"\n\n"+playerInfo(players, 3, players.getprediction(3), 0)+"\n\n"+playerInfo(players, 4, players.getprediction(4), 1)+"\n");
		}
		else if(numplayers==5)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 2)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 1)+"\n\n"+playerInfo(players, 3, players.getprediction(3), 0)+"\n\n"+playerInfo(players, 4, players.getprediction(4), 1)+"\n\n"+playerInfo(players, 5, players.getprediction(5), 2)+"\n");
		}
		else if(numplayers==6)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 3)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 2)+"\n\n"+playerInfo(players, 3, players.getprediction(3), 1)+"\n\n"+playerInfo(players, 4, players.getprediction(4), 0)+"\n\n"+playerInfo(players, 5, players.getprediction(5), 1)+"\n\n"+playerInfo(players, 6, players.getprediction(6), 2)+"\n");
		}
		else if(numplayers==7)
		{
		System.out.println("\n\n\n\n\n\n"+playerInfo(players, 1, players.getprediction(1), 3)+"\n\n"+playerInfo(players, 2, players.getprediction(2), 2)+"\n\n"+playerInfo(players, 3, players.getprediction(3), 1)+"\n\n"+playerInfo(players, 4, players.getprediction(4), 0)+"\n\n"+playerInfo(players, 5, players.getprediction(5), 1)+"\n\n"+playerInfo(players, 6, players.getprediction(6), 2)+"\n\n"+playerInfo(players, 7, players.getprediction(7), 3)+"\n");
		}
		
	}
	static String playerInfo(PlayersOfGame players, int num, int prediction, int distance)
	{
		String str="";
		DecimalFormat Dec=new DecimalFormat("0.#");
		if(distance==0)
		{
		str+= "----------------\nName: "+players.getName(num)+"\nBalance: "+Dec.format(players.getMoney(num))+"\nBet: "+players.getBet(num)+"\nPrediction: "+players.getprediction(num)+"("+Dec.format(players.getMulti(num))+"x)"+"\nStatus: "+players.getStatus(num)+"\n----------------";
		}
		if(distance==1)
		{
		str+= "\t\t\t----------------\n\t\t\tName: "+players.getName(num)+"\n\t\t\tBalance: "+Dec.format(players.getMoney(num))+"\n\t\t\tBet: "+players.getBet(num)+"\n\t\t\tPrediction: "+players.getprediction(num)+"("+Dec.format(players.getMulti(num))+"x)"+"\n\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t----------------";
		}
		if(distance==2)
		{
		str+= "\t\t\t\t\t\t----------------\n\t\t\t\t\t\tName: "+players.getName(num)+"\n\t\t\t\t\t\tBalance: "+Dec.format(players.getMoney(num))+"\n\t\t\t\t\t\tBet: "+players.getBet(num)+"\n\t\t\t\t\t\tPrediction: "+players.getprediction(num)+"("+Dec.format(players.getMulti(num))+"x)"+"\n\t\t\t\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t\t\t\t----------------";
		}
		if(distance==3)
		{
		str+= "\t\t\t\t\t\t\t\t\t----------------\n\t\t\t\t\t\t\t\t\tName: "+players.getName(num)+"\n\t\t\t\t\t\t\t\t\tBalance: "+Dec.format(players.getMoney(num))+"\n\t\t\t\t\t\t\t\t\tBet: "+players.getBet(num)+"\n\t\t\t\t\t\t\t\t\tPredicition: "+players.getprediction(num)+"("+Dec.format(players.getMulti(num))+"x)"+"\n\t\t\t\t\t\t\t\t\tStatus: "+players.getStatus(num)+"\n\t\t\t\t\t\t\t\t\t----------------";
		}
		return str;
	}
	static void setBett(int player, PlayersOfGame gp)
	{
		int mon=1000000;
		while(mon>999999)
		{
		Scanner sb= new Scanner(System.in);
		System.out.print(gp.getName(player)+" Enter Bet: \t");
		mon = sb.nextInt();
		
		if(mon>999999)
		{
			System.out.println("Bet must be under 1000000");
		}
		
		}
		
		gp.setBet(player, mon);
		gp.loseMoney(player, gp.getBet(player));
	}
	static void setPrediction(int player, PlayersOfGame gp)
	{
		int pred=51;
		while(pred>50)
		{
		Scanner pr= new Scanner(System.in);
		System.out.print(gp.getName(player)+" Enter Prediction(1-50): \t");
		pred = pr.nextInt();
		
		if(pred>50)
		{
			System.out.println("Prediction must be under 50");
		}
		
		}
		
		gp.setprediction(player, pred);
	}
	static double calcFinalLim(int player, PlayersOfGame gp)
	{
		double exponent=1+(0.0069*(gp.getprediction(player)-1));
		double limit=Math.pow(gp.getprediction(player), exponent);
		return limit;
	}
	static void winLose(PlayersOfGame gp, int players, int crashnum,  int i)
	{
			if(gp.getprediction(i)<=crashnum)
			{
				gp.setStatus(i, 1);
			}
			else
			{
				gp.setStatus(i, 4);
			}
	}
	static void calcMoney(double multiplier, PlayersOfGame gp, int players, int i, int crashnum)
	{
		if(gp.getprediction(i)!=crashnum)
		{
			if(gp.getStatus(i).contains("Win"))
			{
				gp.addMoney(i, gp.getBet(i)*gp.getMulti(i));
			}
			else
			{
				gp.addMoney(i, 0);
			}
		}
		else
		{
			if(gp.getStatus(i).contains("Win"))
			{
				gp.addMoney(i, gp.getBet(i)*(gp.getMulti(i)+3));
				gp.setMulti(i, gp.getMulti(i)+3);
			}
			else
			{
				gp.addMoney(i, 0);
			}
		}
		
	}
	static void reset(int players, PlayersOfGame gp)
	{
		for(int i=1; i<=players; i++)
		{
			gp.setBet(i, 0);
			gp.setprediction(i, 0);
			gp.setStatus(i, 0);
			gp.resetmax(i);
			gp.setMulti(i, 0);
		}
	}
	static void fullreset(int players, PlayersOfGame gp)
	{
		for(int i=1; i<=players; i++)
		{
			gp.setBet(i, 0);
			gp.setprediction(i, 0);
			gp.setStatus(i, 0);
			gp.resetmax(i);
			gp.loseMoney(i, gp.getMoney(i));
			gp.setName(i, "");
			gp.setMulti(i, 0);
		}
		players=0;
	}
	static int addPlayer(PlayersOfGame gp, int players)
	{
		players++;
		gp.addPlayer();
		return players;
	}
	static int removePlayer(PlayersOfGame gp, int i, int players)
	{
		gp.removePlayer(i);
		players--;
		return players;
	}
	

}
class Playyer
{
	private String name;
	private double money;
	private double startingMoney;
	private int bet=0;
	private boolean max=false;
	private String status="";
	private int prediction=0;
	private double multi=0;
	
	public Playyer()
	{
		int toolong=10;
		while(toolong>9 || toolong<=1)
		{
		Scanner nm = new Scanner(System.in);
		System.out.print("\nEnter Player Name:\t");
		name=nm.nextLine();
		
		toolong=name.length();
		if(toolong>9 || toolong<=1)
		{
			System.out.println("\nName must between 2 and 9 characters.\n");
		}
		}
		
		int toomuch=1000000;
		while(toomuch>999999)
		{
		Scanner mn= new Scanner(System.in);
		System.out.print("Enter Starting Amount:\t");
		money = mn.nextDouble();
		startingMoney=money;
		
		toomuch=(int)money;
		if(toomuch>999999)
		{
			System.out.println("\nStarting Amount must be under 999999\n");
		}
		}
		
		
	}
	public String getName()
	{
		return name;
	}
	public void setName(String i)
	{
		name=i;
	}
	public int getprediction()
	{
		return prediction;
	}
	public void setprediction(int i)
	{
		prediction=i;
	}
	public double getMulti()
	{
		return multi;
	}
	public void setMulti(double i)
	{
		multi=i;
	}
	public double getMoney()
	{
		return money;
	}
	public void addMoney(double i)
	{
		money=money+i;
	}
	public void loseMoney(double i)
	{
		money=money-i;
	}
	public double getStartingMoney()
	{
		return startingMoney;
	}
	public int getBet()
	{
		return bet;
	}
	public void setBet(int i)
	{
		bet=i;
	}
	public boolean getmax()
	{
		return max;
	}
	public void changemax()
	{
		max=true;
	}
	public void resetmax()
	{
		max=false;
	}
	public String getStatus()
	{
		return status;
	}
	public void setStatus(int i)
	{
		if(i==0)
		{
			status="";
		}
		else if(i==1)
		{
			status="Win";
		}
		else if(i==2)
		{
			status="Loss";
		}
		else if(i==3)
		{
			status="Push";
		}
		else
		{
			status="Crash(Loss)";
		}
	}
	public void changeStatus()
	{
		status="Win";
		money+=bet;
	}
	
}
class PlayersOfGame
{
	Playyer[] players;
	int numOfPlayers;
	
	public PlayersOfGame(int np)
	{
		numOfPlayers=np;
		players= new Playyer[7];
		for(int i=0; i<numOfPlayers; i++)
		{
			players[i]=new Playyer();
		}
		
	}
	public void addPlayer()
	{
		numOfPlayers=numOfPlayers+1;
		players[numOfPlayers-1]=new Playyer();
	}
	public void removePlayer(int i)
	{
		Playyer temp=players[i-1];
		players[i-1]=players[numOfPlayers-1];
		players[numOfPlayers-1]=temp;
		
	}
	public String getName(int i)
	{
		return players[i-1].getName();
	}
	public void setName(int i, String j)
	{
		players[i-1].setName(j);
	}
	public int getprediction(int i)
	{
		return players[i-1].getprediction();
	}
	public void setprediction(int i, int j)
	{
		players[i-1].setprediction(j);
	}
	public double getMulti(int i)
	{
		return players[i-1].getMulti();
	}
	public void setMulti(int i, double j)
	{
		players[i-1].setMulti(j);
	}
	public double getMoney(int i)
	{
		return players[i-1].getMoney();
	}
	public void addMoney(int i, double j)
	{
		players[i-1].addMoney(j);
	}
	public void loseMoney(int i, double j)
	{
		players[i-1].loseMoney(j);
	}
	public double getStartingMoney(int i)
	{
		return players[i-1].getStartingMoney();
	}
	public int getBet(int i)
	{
		return players[i-1].getBet();
	}
	public void setBet(int i, int j)
	{
		players[i-1].setBet(j);
	}
	public boolean getmax(int i)
	{
		return players[i-1].getmax();
	}
	public void changemax(int i)
	{
		players[i-1].changemax();
	}
	public void resetmax(int i)
	{
		players[i-1].resetmax();
	}
	public String getStatus(int i)
	{
		return players[i-1].getStatus();
	}
	public void setStatus(int i, int j)
	{
		players[i-1].setStatus(j);
	}
	public void changeStatus(int i)
	{
		players[i-1].changeStatus();
	}
	public void sortPlayers()
	{
		for(int i=0; i<numOfPlayers-1; i++)
		{
			int maxIndex = i;
			for(int j=i+1; j<numOfPlayers; j++)
			{
				if(players[j].getMoney() > players[maxIndex].getMoney())
					maxIndex = j;
			}
			
			Playyer temp = players[i];
			players[i] = players[maxIndex];
			players[maxIndex] = temp;


		}
	}
	
}
