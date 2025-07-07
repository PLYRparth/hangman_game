## 🎵 Hangman Game with Music & SFX 🎮

A Java-based Hangman game featuring sound effects and looping background music to enhance your gaming experience. 
The game challenges players to guess 10 different names, revealing only vowels initially and using the classic 6-step Hangman drawing for incorrect guesses.

## 🧩 Features

- 🔠 Word guessing with partial word reveal (vowels shown)
- 🎵 Background music that loops throughout the game
- ✅ Correct guess sound effect
- ❌ Incorrect guess sound effect
- 💀 Hangman visualization for wrong guesses (up to 6)
- 🏆 Win and Lose game endings with corresponding sound effects
- 🎮 10 progressive levels with increasing challenge

## ▶️ How to Run

1. **Ensure you have Java installed (JDK 8 or higher).**
2. **Compile the Java code:**
   ```bash
   javac src/Main.java
Run the game:
java -cp src Main

#⚠️ Make sure all .wav audio files are located in the src/ directory. Paths are hardcoded in the game.

# 🎮 Gameplay Instructions

You will be presented with a word that only shows its vowels.

Type one letter at a time to guess the word.

You have 6 lives — each incorrect guess draws more of the hangman.

Clear all 10 levels to win the game.

Background music plays continuously during gameplay.

# 🔊 Audio Integration

This game uses Java's built-in javax.sound.sampled package to:

Loop background music using Clip.LOOP_CONTINUOUSLY

Trigger sound effects during specific game events

- If you encounter any issues playing sounds, ensure your audio files are valid .wav format and supported by Java Sound API.

# 📜 License
This project is open-source and free to use. Feel free to fork, modify, and share!

