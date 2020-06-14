# AUTHOR: Madhobi Rani Shaha
package com.parse.starter;

import com.parse.ParseObject;

import org.junit.Test;

import static org.junit.Assert.*;

public class LawyerRegTest {

    @Test
    public void mapParser() {
        String name = "Ramesh Singh",
                almaMater = "Hazra Law College",
                contact = "9283627162",
                email = "ramesh.singh@gmail.com",
                years = "10",
                location = "Kolkata",
                specialization = "Criminal";

        LawyerReg lawyerReg = new LawyerReg();
        ParseObject lawyer = lawyerReg.mapParser("user", name, almaMater, contact, email, years, location, specialization);

        assertNotNull(lawyer);
    }
}
