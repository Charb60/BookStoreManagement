import java.util.Random;
import java.util.Scanner;

public class BoxGame {
    private static final int SIZE = 3; // ขนาดตาราง 3x3
    private int[][] board;
    private int emptyRow;
    private int emptyCol;

    public BoxGame() {
        board = new int[SIZE][SIZE];
        initializeBoard();
        shuffleBoard();
    }

    // สร้างบอร์ดเบื้องต้น 1-8 และช่องว่าง
    private void initializeBoard() {
        int num = 1;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (row == SIZE - 1 && col == SIZE - 1) {
                    board[row][col] = 0; // ช่องว่าง
                    emptyRow = row;
                    emptyCol = col;
                } else {
                    board[row][col] = num++;
                }
            }
        }
    }

    // สุ่มตำแหน่งบอร์ด
    private void shuffleBoard() {
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int direction = random.nextInt(4);
            if (direction == 0) {
                move(emptyRow - 1, emptyCol); // ขึ้น
            } else if (direction == 1) {
                move(emptyRow + 1, emptyCol); // ลง
            } else if (direction == 2) {
                move(emptyRow, emptyCol - 1); // ซ้าย
            } else if (direction == 3) {
                move(emptyRow, emptyCol + 1); // ขวา
            }
        }
    }

    // แสดงผลบอร์ด
    public void printBoard() {
        for (int[] row : board) {
            for (int value : row) {
                System.out.print((value == 0 ? " " : value) + "\t");
            }
            System.out.println();
        }
    }

    // ตรวจสอบเงื่อนไขการเลื่อนบล็อก
    public boolean move(int row, int col) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && (Math.abs(emptyRow - row) + Math.abs(emptyCol - col) == 1)) {
            board[emptyRow][emptyCol] = board[row][col];
            board[row][col] = 0;
            emptyRow = row;
            emptyCol = col;
            return true;
        }
        return false;
    }

    // ตรวจสอบว่าเกมจบหรือไม่
    public boolean isSolved() {
        int num = 1;
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (row == SIZE - 1 && col == SIZE - 1) {
                    return board[row][col] == 0;
                }
                if (board[row][col] != num++) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BoxGame game = new BoxGame();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Sliding Puzzle Game (3x3)!");
        while (!game.isSolved()) {
            game.printBoard();
            System.out.print("Enter move (W=up, S=down, A=left, D=right): ");
            char move = scanner.next().toUpperCase().charAt(0);
            boolean moved;
            
            if (move == 'W') {
                moved = game.move(game.emptyRow - 1, game.emptyCol);
            } else if (move == 'S') {
                moved = game.move(game.emptyRow + 1, game.emptyCol);
            } else if (move == 'A') {
                moved = game.move(game.emptyRow, game.emptyCol - 1);
            } else if (move == 'D') {
                moved = game.move(game.emptyRow, game.emptyCol + 1);
            } else {
                System.out.println("Invalid move!");
                moved = false;
            }
            
            if (!moved) {
                System.out.println("Invalid move!");
            }
        }
        System.out.println("Congratulations! You solved the puzzle!");
    }
}
