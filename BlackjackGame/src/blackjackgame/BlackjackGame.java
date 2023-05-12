/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package blackjackgame;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Kai
 */
public class BlackjackGame extends Application {

    private Deck deck;                      // The deck of cards
    private Hand playerHand;                // Player's hand
    private Hand computerHand;              // Computer's hand
    private Label playerScoreLabel;         // Label to display player's score
    private Label computerScoreLabel;       // Label to display computer's score
    private Label scoreSummaryLabel;        // Label to display hands won and lost
    private Button dealButton;              // Button for dealing cards
    private Button hitButton;               // Button for player to hit
    private Button standButton;             // Button for player to stand
    private Button shuffleButton;           // Button for shuffling the deck
    private int handsWon;                   // Number of hands won
    private int handsLost;                  // Number of hands lost

    /**
     * Constructs a new BlackjackGame object.
     * Initializes the deck, player's hand, computer's hand, and the counters.
     */
    public BlackjackGame() {
        deck = new Deck();
        playerHand = new Hand();
        computerHand = new Hand();
        handsWon = 0;
        handsLost = 0;
    }
    
    /**
     * The main entry point of the application.
     * Launches the JavaFX application.
     * 
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    /**
     * Initializes and shows the JavaFX stage.
     * 
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        // Create the labels
        playerScoreLabel = new Label("Player Score: 0");
        computerScoreLabel = new Label("Computer Score: 0");
        scoreSummaryLabel = new Label("Hands won: 0 / Hands lost: 0");

        // Create the buttons and set their event handlers
        dealButton = new Button("Deal");
        dealButton.setOnAction(event -> dealButtonClicked());

        hitButton = new Button("Hit");
        hitButton.setOnAction(event -> hitButtonClicked());
        hitButton.setDisable(true);

        standButton = new Button("Stand");
        standButton.setOnAction(event -> standButtonClicked());
        standButton.setDisable(true);

        shuffleButton = new Button("Shuffle");
        shuffleButton.setOnAction(event -> shuffleButtonClicked());

        // Create the root pane and add the labels and buttons
        FlowPane root = new FlowPane(10, 10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(
                playerScoreLabel, computerScoreLabel, scoreSummaryLabel,
                dealButton, hitButton, standButton, shuffleButton);

        // Create the scene and set it on the stage
        Scene scene = new Scene(root, 400, 300);

        primaryStage.setTitle("Blackjack Game");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Event handler for the deal button.
     * Shuffles the deck and deals two cards to the player and the computer.
     * Updates the score labels, enables the hit and stand buttons, and displays the player's hand.
     */
    private void dealButtonClicked() {
        deck.shuffle();

        playerHand.clear();
        computerHand.clear();

        playerHand.addCard(deck.dealCard());
        playerHand.addCard(deck.dealCard());

        computerHand.addCard(deck.dealCard());
        computerHand.addCard(deck.dealCard());

        playerScoreLabel.setText("Player Score: " + playerHand.getScore());
        computerScoreLabel.setText("Computer Score: " + computerHand.getScore());

        hitButton.setDisable(false);
        standButton.setDisable(false);

        displayPlayerHand();
    }

    /**
     * Event handler for the hit button.
     * Deals an additional card to the player.
     * Updates the score label, checks for a bust, and displays the player's hand.
     */
    private void hitButtonClicked() {
        playerHand.addCard(deck.dealCard());
        playerScoreLabel.setText("Player Score: " + playerHand.getScore());

        if (playerHand.getScore() > 21) {
            endGame(false);
        }

        displayPlayerHand();
    }

    /**
     * Event handler for the stand button.
     * Continues dealing cards to the computer until its score is at least 17.
     * Ends the game and determines the winner.
     */
    private void standButtonClicked() {
        while (computerHand.getScore() < 17) {
            computerHand.addCard(deck.dealCard());
            computerScoreLabel.setText("Computer Score: " + computerHand.getScore());
        }

        endGame(true);
    }

    /**
     * Event handler for the shuffle button.
     * Shuffles the deck and updates the score summary label.
     */
    private void shuffleButtonClicked() {
        deck.shuffle();
        scoreSummaryLabel.setText("Hands won: " + handsWon + " / Hands lost: " + handsLost);
    }

    /**
     * Ends the game and determines the winner.
     * Disables the deal, hit, and stand buttons.
     * Compares the scores and updates the result label.
     * Updates the score summary label.
     * Prints the result if the player stood.
     * 
     * @param isStand whether the player stood or not
     */
    private void endGame(boolean isStand) {
        dealButton.setDisable(false);
        hitButton.setDisable(true);
        standButton.setDisable(true);

        int playerScore = playerHand.getScore();
        int computerScore = computerHand.getScore();

        String result;
        if (playerScore > 21 || (computerScore <= 21 && computerScore > playerScore)) {
            result = "Computer wins!";
            handsLost++;
        } else if (computerScore > 21 || playerScore > computerScore) {
            result = "Player wins!";
            handsWon++;
        } else {
            result = "It's a draw!";
        }

        scoreSummaryLabel.setText("Hands won: " + handsWon + " / Hands lost: " + handsLost);

        if (isStand) {
            System.out.println(result);
        }
    }

    /**
     * Displays the player's hand as a set of card images.
     * Creates an ImageView for each card and adds it to a FlowPane.
     * Updates the player's hand pane in the root pane.
     */
    private void displayPlayerHand() {
        FlowPane playerHandPane = new FlowPane(10, 10);
        playerHandPane.setAlignment(Pos.CENTER);

        for (int card : playerHand.getCards()) {
            String suit = getSuitSymbol(card);
            String rank = getRankSymbol(card);
            String cardImagePath = "file:Cards/" + suit + rank + ".png";
            Image cardImage = new Image(cardImagePath);
            ImageView cardImageView = new ImageView(cardImage);
            cardImageView.setFitHeight(100);
            cardImageView.setFitWidth(70);
            playerHandPane.getChildren().add(cardImageView);
        }

        // Remove existing player hand pane and add the updated one
        FlowPane root = (FlowPane) playerScoreLabel.getParent();
        root.getChildren().removeIf(node -> node instanceof FlowPane);
        root.getChildren().add(playerHandPane);
    }

    /**
     * Gets the suit symbol for the card based on its value.
     * The card value is used to calculate the suit index.
     * Returns the corresponding suit symbol from the suits array.
     * 
     * @param card the card value
     * @return the suit symbol
     */
    private String getSuitSymbol(int card) {
        int suitIndex = (card - 1) / 10;  // Calculate the suit index based on the card value
        String[] suits = {"c", "d", "h", "s"};
        return suits[suitIndex];
    }

    /**
     * Gets the rank symbol for the card based on its value.
     * If the rank is between 2 and 10, it returns the rank as a string.
     * If the rank is 1 (Ace), it returns "1".
     * If the rank is a face card, it returns a random face card symbol (j, q, k).
     * 
     * @param card the card value
     * @return the rank symbol
     */
    private String getRankSymbol(int card) {
        int rank = card % 10;
        if (rank >= 2 && rank <= 10) {
            return String.valueOf(rank);
        } else if (rank == 1) {
            return "1";
        } else {
            String[] faceCards = {"j", "q", "k"};
            Random random = new Random();
            return faceCards[random.nextInt(faceCards.length)];
        }
    }

    /**
     * Represents a deck of cards.
     * The deck contains a list of card values and tracks the index of the next card to deal.
     */
    static class Deck {

        private List<Integer> cards;    // List of card values
        private int nextCardIndex;      // Index of the next card to deal
        
        // Constructs a new Deck object.
        public Deck() {
            cards = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
            nextCardIndex = 0;
        }

        public void shuffle() {
            Collections.shuffle(cards);
            nextCardIndex = 0;
        }
        
        /**
         * Deals the next card from the deck.
         * Returns the value of the next card and increments the next card index.
         * 
         * @return the value of the next card
         */
        public int dealCard() {
            int card = cards.get(nextCardIndex);
            nextCardIndex++;
            return card;
        }
    }
    
    /**
     * Represents a player's hand.
     * The hand contains a list of card values and tracks the score.
     */
    static class Hand {

        private List<Integer> cards;
        private int score;

        /**
         * Constructs a new Hand object.
         * Initializes the cards list and score.
         */
        public Hand() {
            cards = new ArrayList<>();
            score = 0;
        }

        /**
         * Adds a card to the hand.
         * Updates the cards list and the score by adding the card value.
         * 
         * @param card the card value to add
         */
        public void addCard(int card) {
            cards.add(card);
            score += card;
        }

        /**
         * Gets the score of the hand.
         * 
         * @return the score
         */
        public int getScore() {
            return score;
        }

        /**
         * Clears the hand by removing all cards and resetting the score to 0.
         */
        public void clear() {
            cards.clear();
            score = 0;
        }

        /**
         * Gets the list of cards in the hand.
         * 
         * @return the list of cards
         */
        public List<Integer> getCards() {
            return cards;
        }
    }
}
