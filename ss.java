import java.util.Scanner;

public class ss{
    static int N;
    static int[][] board;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter grid size N (e.g. 4): ");
        N = scanner.nextInt();
        board = new int[N][N];

        System.out.println("All valid server placements:\n");
        solve(0);
    }

    static void solve(int row) {
        if (row == N) {
            printBoard();
            System.out.println();
            return;
        }

        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;
                solve(row + 1);
                board[row][col] = 0; // Backtrack
            }
        }
    }

    static boolean isSafe(int row, int col) {
        // Check column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 1) return false;
        }

        // Check upper-left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }

        // Check upper-right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 1) return false;
        }

        return true;
    }

    static void printBoard() {
        for (int[] row : board) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}
