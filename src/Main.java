import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] vowels = {'a','e','i','o','u'};
        String[] words = {"aarav", "advitiya", "daksha", "amrish", "falguni", "hrishita", "jaagrithi", "paridhi", "barsati", "taksha"};
        int lose = 0;
        int level = 0;
        System.out.println("""
                    ***********************
                    Welcome to HANGMAN GAME!
                    Total levels : 10
                    Total lives : 6
                    ***********************""");
        char result = 'o';



        while(result == 'o' || result == 'w'){
            playGameMusic();
            for(int i=0; i<10; i++){

                if(lose == 6){
                    result = 'l';
                    break;
                }

                result = 'o';
                playSound("src/level.wav");
                level = i+1;
                System.out.println("LEVEL :" + level);
                String word = words[i];
                ArrayList<Character> wordSpace = new ArrayList<>();

                for(int j=0; j < word.length(); j++){
                    char ch = word.charAt(j);
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'
                            || ch == 'u') {
                        wordSpace.add(ch);
                    }else {
                        wordSpace.add('_');
                    }
                }
                while(result == 'o' && lose < 6) {
                    System.out.print("Word : ");
                    for (char c : wordSpace) {
                        System.out.print(c + " ");
                    }

                    System.out.print("\nGuess a leter :");
                    char guess = scanner.next().toLowerCase().charAt(0);

                    if (word.indexOf(guess) >= 0) {
                        System.out.println("Correct guess");
                        playSound("src/correct.wav");
                        for (int check = 0; check < word.length(); check++) {
                            if (word.charAt(check) == guess) {
                                wordSpace.set(check, guess);
                            }
                        }
                    } else {
                        System.out.println("Incorrect guess!!!");
                        playSound("src/incorrect.wav");
                        lose++;
                        displayHangman(lose);
                    }

                    int count=0;
                    for(char w : wordSpace){
                        if( w == '_'){
                            count++;
                        }
                    }
                    if(count == 0){
                        System.out.println("_____________________");
                        System.out.println("You guesses the name!");
                        System.out.println("The name is : " + word);
                        System.out.println("Level " + level + " is cleared");
                        System.out.println("_____________________");
                        result = 'w';
                    }
                }
            }
            break;
        }
        if(lose == 6) {
            System.out.println("Hangman died !! you lost all 6 lives");
            System.out.println("THE GAME ENDS");
            level -= 1;
            System.out.println("you cleared " + level + " level/s");
            playSound("src/lose.wav");
            playSound("src/lose1.wav");
            scanner.next();

        } else {
            System.out.println("🏆🏆🏆🏆🏆🏆🏆🏆");
            System.out.println("CONGO YOU GUESSED ALL");
            System.out.println("YOU WON THE GAME!!!");
            System.out.println("*******************");
            playSound("src/win.wav");
            scanner.next();
        }

    }
    public static void displayHangman(int l){
        switch(l){
            case 0 -> System.out.println("""
                      +---+
                      |   |
                          |
                          |
                          |
                          |
                    =========""");
            case 1 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                          |
                          |
                          |
                    =========""");
            case 2 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                      |   |
                          |
                          |
                    =========""");
            case 3 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                     /|   |
                          |
                          |
                    =========""");
            case 4 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                     /|\\  |
                          |
                          |
                    =========""");
            case 5 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     /    |
                          |
                    =========""");
            case 6 -> System.out.println("""
                      +---+
                      |   |
                      O   |
                     /|\\  |
                     / \\  |
                          |
                    =========""");
        }
    }
    public static void playGameMusic(){
        File file = new File("src/Game.wav");
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        catch(Exception e){
            System.out.println("Something wrong with music");
        }
    }
    public static void playSound(String path){
        File file = new File(path);
        try(AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        }
        catch(Exception e){
            System.out.println("Something wrong with music");
        }
    }
}
