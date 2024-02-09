package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public static boolean isValidV2(String s) {

        StringBuilder currentString = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            char currentChar = s.charAt(i);
            if(isOpenCharacter(currentChar)){

                currentString.append(currentChar);
            }else if(isCorrectClosing(currentString.charAt(currentString.length() - 1), currentChar)){
                currentString.deleteCharAt(currentString.length() - 1);
            }else{
                return false;
            }
        }

        return true;
    }
    public static boolean isValidV1(String s) {

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

    private static boolean isOpenCharacter(char character){

        return isOpenParentheses(character) || isOpenBracket(character) || isOpenCurlyBrace(character);
    }

    private static boolean isCorrectClosing(char first, char second){

        return (isOpenParentheses(first) && isClosingParentheses(second))
                || (isOpenBracket(first) && isClosingBracket(second))
                || (isOpenCurlyBrace(first) && isClosingCurlyBrace(second));
    }

    private static boolean isOpenParentheses(char element){

        return element == 40;
    }

    private static boolean isClosingParentheses(char element){

        return element == 41;
    }

    private static boolean isOpenBracket(char element){

        return element == 91;
    }

    private static boolean isClosingBracket(char element){

        return element == 93;
    }

    private static boolean isOpenCurlyBrace(char element){

        return element == 123;
    }

    private static boolean isClosingCurlyBrace(char element){

        return element == 125;
    }

}
