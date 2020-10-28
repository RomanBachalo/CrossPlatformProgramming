package com.company;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

import static org.junit.jupiter.api.Assertions.*;

class Task2Test {
    @Test
    public void shouldFindQuestionSentences() throws Exception{
        Task2 task2 = new Task2();
        String text = "Short string with question mark? Short string.";

        Assert.assertTrue(task2.findQuestionSentences(text).size() == 1);
        String expected = "Short string with question mark?";
        String real = task2.findQuestionSentences(text).get(0);
        Assert.assertEquals(expected,real);
    }

    @Test
    public void shouldFindWordsOfLengthFive() throws Exception{
        Task2 task2 = new Task2();
        String text = "Short string with question mark? Short string.";
        var list = task2.findQuestionSentences(text);

        String expected = "Short";
        String real = task2.findWordsWithLength(list.get(0), 5).get(0);

        Assert.assertEquals(expected, real);
    }

    @Test
    public void shouldNotFindAnySentence() throws Exception{
        Task2 task2 = new Task2();
        String text = "Short string with question mark. Short string.";
        var list = task2.findQuestionSentences(text);

        Assert.assertEquals(list.size(), 0);
    }
}