import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		boolean playAgain = true;

		System.out.println("Let's play Rock Paper Scissors");
		System.out.println("-------------------------------");

		while (playAgain) {
			int rounds = 0;
			int ties = 0;
			int userWins = 0;
			int computerWins = 0;

			do {
				System.out.println("How many rounds would you like to play? (between 1 to 10)");
				rounds = scanner.nextInt();
				if (rounds < 1 || rounds > 10) {
					System.out.println("Invalid number of rounds. Exiting."); // exits if wrong number of rounds
					return;
				}
			} while (rounds < 1 || rounds > 10);

			// game-play round
			for (int i = 1; i <= rounds; i++) {
				System.out.println("-------------------------------");
				System.out.println("Round " + i + " -- START");
				System.out.println("-------------------------------");

				int computerPick = random.nextInt(3) + 1;
				int playerPick = 0;

				do {
					System.out.println("Pick a number: [1] Rock, [2], Paper, [3] Scissors");
					playerPick = scanner.nextInt();
				} while (playerPick < 1 || playerPick > 3);

				switch (computerPick) { // show player computer's choice after they've picked
				case 1:
					System.out.println("The computer picked rock.");
					break;
				case 2:
					System.out.println("The computer picked paper.");
					break;
				case 3:
					System.out.println("The computer picked scissors.");
				}

				if (playerPick == computerPick) { // round outcome
					ties++;
					System.out.println("You tie this round.");
				}
				else if (playerPick == 1) {
					if (computerPick == 3) {
						userWins++;
						System.out.println("You win this round!");
					}
					else {
						computerWins++;
						System.out.println("You lose this round, the computer wins.");
					}
				}
				else if (playerPick > computerPick) {
					userWins++;
					System.out.println("You win this round!");
				}
				else {
					computerWins++;
					System.out.println("You lose this round, the computer wins.");
				}

				if (i == rounds) { // last round score reveal
					System.out.println("-------------------------------");
					System.out.println("FINAL SCORE:");
					System.out.println("Ties: " + ties + ", wins: " + userWins + ", losses: " + computerWins);
					System.out.println("-------------------------------");

					if (userWins > computerWins)
						System.out.println("*****You won!*****");
					else if (userWins == computerWins)
						System.out.println("*****You tied.*****");
					else
						System.out.println("*****You lose.******");
					System.out.println("-------------------------------");
					System.out.println("Would you like to play again? (y/n)");

					String replay = scanner.next();

					if (replay.equals("y")) {
						System.out.println("-------------------------------");
					}
					else {
						playAgain = false; // makes while loop condition false
						System.out.println("Thanks for playing!");
					}
				}
			}
		}
	}

}
