package com.parse.starter;

import com.parse.ParseObject;

import org.junit.Test;

import static org.junit.Assert.*;

public class reviewTest {

    @Test
    public void mapParser() {
        String username = "newuser",
                lawyerOrNgoUser = "Konika Mitra",
                client = "Ram Mishra",
                date = "10/04/2020",
                reason = "Criminal Activities",
                experience = "Good experience";

        review review = new review();
        ParseObject rev = review.mapParser(username, lawyerOrNgoUser, client, date, reason, experience);
        assertNotNull(rev);
    }
}