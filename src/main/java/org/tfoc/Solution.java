package org.tfoc;

/**
 * The class containing the solution to this exercise
 */
public class Solution {

    public boolean isValid(String s) {

        char[] characters = s.toCharArray();

        if(characters.length % 2 != 0) return false;

        boolean isValid = true;
        int counter = 0;

        while (isValid && counter < characters.length){

            char firstChar = characters[counter];
            char secondChar = characters[counter + 1];

            if((isOpenParentheses(firstChar) && !isClosingParentheses(secondChar))
            || (isOpenBracket(firstChar) && !isClosingBracket(secondChar))
            || (isOpenCurlyBrace(firstChar) && !isClosingCurlyBrace(secondChar))){

                isValid = false;
            }

            counter+= 2;
        }

        return isValid;
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
