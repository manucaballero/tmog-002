package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public boolean isValidV2(String s) {

        char[] characters = s.toCharArray();

        if(characters.length % 2 != 0) return false;

        boolean isValid = true;
        int firstPointer = 0;

        while (isValid && firstPointer < characters.length){

            char currentCharacter = characters[firstPointer];
            if(isOpenCharacter(currentCharacter)) {

                boolean isFoundCorrectClosing = false;
                int secondPointer = firstPointer + 1;
                int parenthesesWithoutClosing = 0;
                int bracketsWithoutClosing = 0;
                int curlyBracesWithoutClosing = 0;

                while (!isFoundCorrectClosing && secondPointer < characters.length) {

                    char secondPointerCharacter = characters[secondPointer];
                    if (parenthesesWithoutClosing == 0
                            && bracketsWithoutClosing == 0
                            && curlyBracesWithoutClosing == 0
                            && isCorrectClosing(currentCharacter, secondPointerCharacter)) {
                        isFoundCorrectClosing = true;
                    }

                    if (isOpenParentheses(secondPointerCharacter)) parenthesesWithoutClosing++;
                    if (isOpenBracket(secondPointerCharacter)) bracketsWithoutClosing++;
                    if (isOpenCurlyBrace(secondPointerCharacter)) curlyBracesWithoutClosing++;
                    if (isClosingParentheses(secondPointerCharacter)) parenthesesWithoutClosing--;
                    if (isClosingBracket(secondPointerCharacter)) bracketsWithoutClosing--;
                    if (isClosingCurlyBrace(secondPointerCharacter)) curlyBracesWithoutClosing--;

                    secondPointer++;
                }
                isValid = isFoundCorrectClosing;
            }
            firstPointer++;
        }

        return isValid;
    }

    private boolean isOpenCharacter(char character){

        return isOpenParentheses(character) || isOpenBracket(character) || isOpenCurlyBrace(character);
    }

    private boolean isCorrectClosing(char first, char second){

        return (isOpenParentheses(first) && isClosingParentheses(second))
                || (isOpenBracket(first) && isClosingBracket(second))
                || (isOpenCurlyBrace(first) && isClosingCurlyBrace(second));
    }

    private boolean isOpenParentheses(char element){

        return element == 40;
    }

    private boolean isClosingParentheses(char element){

        return element == 41;
    }

    private boolean isOpenBracket(char element){

        return element == 91;
    }

    private boolean isClosingBracket(char element){

        return element == 93;
    }

    private boolean isOpenCurlyBrace(char element){

        return element == 123;
    }

    private boolean isClosingCurlyBrace(char element){

        return element == 125;
    }

}
