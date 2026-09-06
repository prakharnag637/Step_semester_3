import java.util.Scanner;
class RockPaperScissorsGame {
    String getComputerMove() {
        String[] moves = {"Rock", "Paper", "Scissors"};
        int n = (int)(Math.random() * 3);
        return moves[n];
    }
    String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        if (playerMove.equals("Rock") && computerMove.equals("Scissors")) {
            return "Player Wins";
        }
        if (playerMove.equals("Paper") && computerMove.equals("Rock")) {
            return "Player Wins";
        }
        if (playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player Wins";
        }
        return "Computer Wins";
    }
}
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RockPaperScissorsGame r = new RockPaperScissorsGame();
        int wins = 0;
        int losses = 0;
        int draws = 0;
        String[] playerMoves = new String[5];
        String[] computerMoves = new String[5];
        String[] results = new String[5];
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter Rock, Paper or Scissors: ");
            playerMoves[i] = sc.nextLine();
            computerMoves[i] = r.getComputerMove();
            results[i] = r.playRound(playerMoves[i], computerMoves[i]);
            if (results[i].equals("Player Wins")) {
                wins++;
            }
            else if (results[i].equals("Computer Wins")) {
                losses++;
            }
            else {
                draws++;
            }
        }
        System.out.println("\n----- Final Summary -----");
        System.out.println("Round\tPlayer\t\tComputer\tResult");
        for (int i = 0; i < 5; i++) {
            System.out.println((i + 1) + "\t" + playerMoves[i] + "\t\t"
                    + computerMoves[i] + "\t\t" + results[i]);
        }
        double winPercentage = ((double) wins / 5) * 100;
        System.out.println("\nWins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.println("Win Percentage: " + winPercentage + "%");
        sc.close();
    }
}