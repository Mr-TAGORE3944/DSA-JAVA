package graphs;
import java.util.Scanner;

public class OliverGame {

    public static class GameWorld {
        private char[][] world;
        private int oliverX, oliverY;

        public GameWorld(int width, int height) {
            world = new char[height][width];
            oliverX = width / 2;
            oliverY = height / 2;
            world[oliverY][oliverX] = 'O';
        }

        public void moveOliver(char direction) {
            world[oliverY][oliverX] = '.';
            switch (direction) {
                case 'N': oliverY = Math.max(0, oliverY - 1); break;
                case 'S': oliverY = Math.min(world.length - 1, oliverY + 1); break;
                case 'E': oliverX = Math.min(world[0].length - 1, oliverX + 1); break;
                case 'W': oliverX = Math.max(0, oliverX - 1); break;
                default: System.out.println("Invalid move. Use N, S, E, or W."); break;
            }
            world[oliverY][oliverX] = 'O';
        }

        public void displayWorld() {
            for (char[] row : world) {
                for (char cell : row) {
                    System.out.print(cell == 0 ? '.' : cell);
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameWorld game = new GameWorld(10, 10);

        while (true) {
            game.displayWorld();
            System.out.println("Enter move (N/S/E/W) or Q to quit:");
            char move = scanner.next().toUpperCase().charAt(0);

            if (move == 'Q') {
                break;
            }

            game.moveOliver(move);
        }

        scanner.close();
    }
}
