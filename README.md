
# Use my code for educational purposes, not for submitting it as your own work!

1. Intended to be executed through 'inputLouis'.
2. Download P1input.txt and change FILE_PATH to reflect your P1input.txt.
3. Place TextFileInput.java in the same directory as the other two .java files.
4. This code was created by Louis Cubero, if anyone submitted code very similar to mine, they plagiarized and did not use it for educational purposes.

# Project concept created by Dr. Kenneth Lord

This project is loosely based on a word puzzle called the Spelling Beehive found in the Sunday New York Times magazine. In it, a player is given a set of seven letters and has to find as many words as possible using some portion, but at least five, of those seven letters. Letters may be used more than once. Each correct word earns one point.

# Program uses letters from first string: "latipmo" and user has to guess the following:
```
aioli
allot
appall
atilt
atoll
impala
laptop
lollipop
lotto
mallot
mammal
militia
moola
optimal
palatial
papal
pilot
plait
polio
tilapia
total
```

Your program should read the first line into a String variable for the letters, and the rest of the file into an array of Strings against which the user’s guesses can be matched.

# GUI Requirements
Create a GUI for the puzzle with a grid layout of one row and two columns. In the left column put the puzzle letters, and in the right column display the words that the user has found so far (words the user has guessed and your program has found on the solutions list) and the user’s score. Accept words from the user via a JOptionPane.

# MessageDialogs
MessageDialogs should be shown to the user in the following cases:

1. The user has used a letter that is not one of the seven letters given.
2. The user’s guess is less than 5 letters long.
3. The user’s guess is not in the solutions list.
