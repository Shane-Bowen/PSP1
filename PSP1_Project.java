import java.util.Scanner;
public class project {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		
		/**
		 * Name:Shane Bowen
		 * ID:R00149085
		 */

		System.out.println("****************************************************");
		System.out.println("* Welcome to CIT's Round Robin Football Tournament *");
		System.out.println("****************************************************");

		int numberOfTeams;
		System.out.print("Enter the number of teams? "); //Asking for the number of teams.
		numberOfTeams = keyboard.nextInt();

		final int DRAW = 1;//The amount of points a draw, win and we don't have to for a loss because it equals 0.
		final int WIN = 3;

		int totalPoints = 0;//We will accumulate the total points per team
		
		int numberOfDraws = 0; //We will accumulate the number of Draws, Wins and Losses per team
		int numberOfWins = 0;
		int numberOfLosses = 0;
		
		int totalAttendance = 0;//We will accumulate the total Attendance per match
		int averageAttendance = 0;
		
		double totalTakings ;//the total takings for the tournament will be a double.
		
		int totalDraws =0;//We need to record a second total number of draws, wins and losses because the other one will have to reseted to 0 just before it.
		int totalWins = 0;
		int totalLosses = 0;

		int numberOfMatches = 0;//Accumulating the total number of matches
		int winningTeam = 0;//We set the highest points for a team at 0, then whatever team is greater than 0 will become the winning team
		String winningTeamName = "";//Also include the name of the winning team
		double winningTeamTakings = 0;

		String table="";//We will accumulate every team into a table at the end
		String teamName = "";//We will accumulate the name of the team
		int amountOfWinners = 1;
		
		for (int k = 1; k <= numberOfTeams ; k++)//We use a for loop to determine the amount of times it will loop depending the number of teams
		{
			System.out.print("What is the name of team " + k + "? "); //Ask the name of the team
			teamName = keyboard.next();

			for (int b =1; b<= numberOfTeams -1; b++)//We use a for loop to determine the amount of times it will loop depending the number of teams minus one
			{
				System.out.println("Match " + b + ": ("+ b + " of " + (numberOfTeams -1) + ") for " + teamName + " vs. team " + (b+1));//Ask the result of the match
				int result;
				System.out.print("Did " + teamName + "? \n\t1:Draw \n\t2:Win \n\t3:Lose \n\t==>");
				result = keyboard.nextInt();

				if (result ==1)//if the result equals 1 then we add the worth of a draw to the total points and add one onto the number of draws
				{
					totalPoints += DRAW;
					numberOfDraws ++;
					totalDraws ++;
				}

				else if (result==2)//if the result equals 2 then we add the worth of a win to the total points and add one onto the number of wins
				{
					totalPoints += WIN;
					numberOfWins ++;
					totalWins ++;
				}

				else if (result==3)//if the result equal 3 we add one onto the number of losses and we don't have to add anything to the total points because it equals 0.
				{
					numberOfLosses ++;
					totalLosses ++;
				}

				numberOfMatches = numberOfTeams * (numberOfTeams -1) / 2;//this equation will help us find the number of matches
				if(k <= b )//if k is less than or equal to b we will record the number supporters
				{
					int supporters;
					System.out.print("Match " + b + ": (" + b + " of " + (numberOfTeams -1) + ") for " + teamName + " vs. team " + (b+1) + " how many supporters attended? ");
					supporters = keyboard.nextInt();//ask the number of supporters per match
					totalAttendance += supporters;
				}
			}

			table+=("\n " + teamName + "\t  " + numberOfWins + "\t  " + numberOfDraws + "\t  " + numberOfLosses + "\t  " + totalPoints );//all the results and total points of the teams will go here

			if (totalPoints > winningTeam) //if a teams total points is greater than the winning teams total points then it will become the winning team
			{
				winningTeam = totalPoints;
				winningTeamName = teamName + " take home " ;
				amountOfWinners=1;
			}
			else if (totalPoints == winningTeam)//if there is a tie for the number of winning of teams then they both will be the winning team.
			{
				amountOfWinners ++;	
				winningTeamName += " and " + teamName + " take home" ;
			}

			totalPoints = 0;//we will reset the total points, number of draws, number of wins and number of losses and the end.
			numberOfDraws = 0;
			numberOfWins = 0;
			numberOfLosses = 0;

		}
		
		if(totalDraws % 2 !=0 && totalWins != totalLosses)//if the total of draws is not a even number and the total of wins is not equal to the number of losses then the data is invalid
		{
			System.out.println("Data is invalid - please check your data and start again. ");
		}
		
		else{//if the data is ok then we can print off everything
			totalTakings = totalAttendance * 5.50;//5.50 is the price of a ticket and the total attendance is 5.50 multiply by the total attendance
			winningTeamTakings = totalTakings * 0.50/amountOfWinners;//the winning team takings is the total takings multiply by a half and if there is more than 1 winner then divide by the amount of winners
			averageAttendance = totalAttendance / numberOfMatches;//average attendance is the total attendance divided by the number of matches

			System.out.print("\nTeam \t Won \t Drawn \t Lost \t Total");
			System.out.print("\n==== \t === \t ===== \t ==== \t =====");

			System.out.println(table);//print the table that we have been accumulating

			System.out.println("The total attendance in all matches is: " + totalAttendance);//**display the total attendance
			System.out.println("Average Attendance per game is: " + averageAttendance );//display the average attendance
			System.out.println("Total takings at all matches is (\u20ac): " + totalTakings);//display the total takings
			System.out.println("The winning team is " + winningTeamName +  " \u20AC" + winningTeamTakings);//display the winning team
		}
		
		keyboard.close();
	}
}	