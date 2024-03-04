package si.session_activities.mock_practicums.test03.set1.problem02;

import java.util.Scanner;

/**
 * An implementation of the Frogs and Rabbits puzzle game. 
 */
public class FrogsAndRabbits {
    /**
     * The default length of a log.
     */
    private static final int DEFAULT_SIZE = 6;

    /**
     * Used as the "index" when a move cannot be made.
     */
    private static final int NO_MOVE = -10;

    /**
     * Represents the current state of the game.
     */
    public enum GameState {
        IN_PROGRESS, // game is in progress
        WON,         // the game is over
        STALEMATE    // there is a stalemate
    }

    /**
     * Represents a space on the log.
     */
    public enum Space {
        EMPTY('_', 0, 0),    // empty spot
        FROG('F', 1, 2),     // only  moves right
        RABBIT('R', -1, -2); // only moves left

        /**
         * The character used to represent the space in ASCII output.
         */
        private final char representation;

        /**
         * One space in the move direction.
         */
        private final int oneSpace;

        /**
         * Two spaces in the move direction.
         */
        private final int twoSpaces;

        private Space(char representation, int oneSpace, int twoSpaces) {
            this.representation = representation;
            this.oneSpace = oneSpace;
            this.twoSpaces = twoSpaces;
        }

        /**
         * Returns the character that represents this kind of space on the log.
         * 
         * @return The character that represents the space.
         */
        public char getRepresentation() {
            return this.representation;
        }

        /**
         * Returns one space in the move direction, e.g. +1 for frogs or -1 for
         * rabbits.
         * 
         * @return One space in the move direction.
         */
        public int getOneSpace() {
            return this.oneSpace;
        }

        /**
         * Returns two spaces in the move direction, e.g. +2 for frogs or -3 
         * for rabbits.
         * 
         * @return Two spaces in the move direction.
         */
        public int getTwoSpaces() {
            return this.twoSpaces;
        }

        @Override
        public String toString() {
            return Character.toString(this.representation);
        }
    }

    /**
     * The log used to play the game.
     */
    private final Space[] log;

    /**
     * The number of moves made since the last reset.
     */
    private int moves;

    /**
     * Creates a new Frogs and Rabbits game with the default log size.
     */
    public FrogsAndRabbits() {
        this(DEFAULT_SIZE);
    }

    /**
     * Creates a new Frogs and Rabbits game with the specified log size.
     * 
     * @param size The size of the log to play on.
     */
    public FrogsAndRabbits(int size) {
        log = new Space[size];
        reset();
    }

    /**
     * Copy constructor that makes a deep copy of the game so that moves can be
     * made without altering the original log.
     * 
     * @param far The source of the copy.
     */
    public FrogsAndRabbits(FrogsAndRabbits far) {
        this.log = new Space[far.log.length];
        for(int index=0; index<log.length; index++) {
            this.log[index] = far.log[index];
        }
        this.moves = far.moves;
    }

    /**
     * Returns the size of the log.
     * 
     * @return The size of the log.
     */
    public int getSize() {
        return this.log.length;
    }

    /**
     * Returns the state of the game.
     * 
     * @return The state of the game.
     */
    public GameState getGameState() {
        return isWon() ? GameState.WON : 
            isStalemate() ? GameState.STALEMATE : GameState.IN_PROGRESS;
    }

    /**
     * Resets the game to start over.
     */
    public void reset() {
        int empty = log.length / 2 - 1;
        for(int frog=0; frog<empty; frog++) {
            log[frog] = Space.FROG;
        }
        log[empty] = Space.EMPTY;
        for(int rabbit=empty+1; rabbit<log.length; rabbit++) {
            log[rabbit] = Space.RABBIT;
        }
        moves = 0;
    }

    /**
     * Returns the number of moves made so far.
     * 
     * @return The number of moves made in the game so far.
     */
    public int getMoves() {
        return moves;
    }

    /**
     * Attempts to make a move from the specified index.
     * 
     * @param index The index from which the move should be made.
     * 
     * @return True if the move was made, and false if no move can be made from
     * the specified index.
     */
    public boolean move(int index) {
        boolean moved = false;
        if(inBounds(index) && log[index] != Space.EMPTY) {
            int moveIndex = getMoveIndex(index);
            if(moveIndex != NO_MOVE) {
                swap(index, moveIndex);
                moved = true;
            }
        }
        moves += moved ? 1 : 0;
        return moved;
    }

    /**
     * Helper function: returns the index to which the animal at the specified
     * index can move (if a move is possible). This should be one space if the
     * next space is empty, or two spaces if the animal can jump.
     * 
     * @param index The index from which the move will be made.
     * @return The index to which the animal can move or NO_MOVE if a move is
     * not possible.
     */
    private int getMoveIndex(int index) {
        int moveIndex = NO_MOVE;
        if(inBounds(index) && log[index] != Space.EMPTY) {
            Space animal = log[index];
            int oneSpace = index + animal.getOneSpace();
            int twoSpaces = index + animal.getTwoSpaces();
            if(isEmpty(oneSpace)) {
                moveIndex = oneSpace;
            } else if(isEmpty(twoSpaces)) {
                moveIndex = twoSpaces;
            }
        }
        return moveIndex;
    }

    /**
     * Helper method: swaps two spaces on the log.
     * 
     * @param index The first index.
     * @param swapSpace The swap index.
     */
    private void swap(int index, int swapSpace) {
        Space temp = log[index];
        log[index] = log[swapSpace];
        log[swapSpace] = temp;
    }

    /**
     * Helper method: returns true if the specific square is on the log and is
     * empty.
     * 
     * @param index The index being checked.
     * @return True if the index is on the log and is empty.
     */
    private boolean isEmpty(int index) {
        return inBounds(index) && log[index] == Space.EMPTY;
    }

    /**
     * Helper method: returns true if the index is on the log.
     * 
     * @param index The index being checked.
     * @return True if the index is on the log and false otherwise.
     */
    private boolean inBounds(int index) {
        return index > -1 && index < log.length;
    }

    /**
     * Helper method: checks to see if the game is won; all rabbits are on the
     * left and all frogs are on the right.
     * 
     * @return True if the game has been won, and false otherwise.
     */
    private boolean isWon() {
        Space animal = Space.RABBIT;
        for(Space space : log) {
            if(space == Space.EMPTY) {
                animal = Space.FROG;
            } else if(space != animal) {
                return false;
            }
        }
        return true;
    }

    /**
     * Helper method: checks to see if the game has reached a stalemate where
     * no moves are possible.
     * 
     * @return True if the game is stalemated - the game has not been won, and
     * no additional moves can be made.
     */
    private boolean isStalemate() {
        boolean stalemate = true;
        for(int index=0; index<log.length; index++) {
            if(getMoveIndex(index) != NO_MOVE) {
                stalemate = false;
                break;
            }
        }
        return stalemate;
    }

    /**
     * Returns a string representation of the log with the index of each space
     * on the next line. This will not work for logs larger than 10 spaces.
     * 
     * FF_RRR
     * 012345
     * 
     * @return A string representation of the board with the index of each 
     * space on the next line.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for(Space space : log) {
            builder.append(space.getRepresentation());
        }
        builder.append("\n");
        for(int i=0; i<log.length; i++) {
            builder.append(i);
        }
        return builder.toString();
    }

    private static boolean makeMove(FrogsAndRabbits far, String move) {
        boolean moved = false;
        try {
            int index = Integer.parseInt(move);
            if(far.move(index)) {
                System.out.println("Good move!");
                moved = true;
            } else {
                System.out.println("Invalid move: " + index);
            }
        } catch(NumberFormatException e) {
            System.out.println("Please enter a valid index: " + move);
        }
        return moved;
    }

    public static void main(String[] args) {
        FrogsAndRabbits far = new FrogsAndRabbits(10);
        try(Scanner scanner = new Scanner(System.in)) {
            while(far.getGameState() == GameState.IN_PROGRESS) {
                System.out.println(far);
                System.out.print(">> ");
                String next = scanner.nextLine();
                if(next.equalsIgnoreCase("quit")) {
                    break;
                } else if(next.contains(",")) {
                    System.out.println("Trying to make multiple moves...");
                    String[] moves = next.split(", ");
                    for(String move : moves) {
                        if(makeMove(far, move)) {
                            System.out.println(far);
                        } else {
                            break;
                        }
                    }
                } else {
                    try {
                        makeMove(far, next);
                    } catch(NumberFormatException e) {
                        System.out.println("Please enter the index of a space"
                            + " on the log.");
                    }
                }
            }
        }
        System.out.println(far);
        System.out.println("You made " + far.getMoves() + " moves.");
        switch(far.getGameState()) {
            case STALEMATE -> System.out.println("You lost!");
            case IN_PROGRESS -> System.out.println("Giving up?!");
            case WON -> System.out.println("You won!");
        }
    }
}
