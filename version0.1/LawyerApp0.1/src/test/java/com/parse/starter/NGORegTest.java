#Author:  Madhobi Rani Shaha
package com.parse.starter;

import com.parse.ParseObject;

import org.junit.Test;

import static org.junit.Assert.*;

public class NGORegTest {

    @Test
    public void mapParser() {
        String username = "newuser",
                name = "Help Foundation",
                location = "Kolkata",
                financialAid = "10000",
                years = "12",
                contact = "9218337282",
                email = "help.foundation@gmail.com";

        NGOReg ngoReg = new NGOReg();
        ParseObject ngo = ngoReg.mapParser(username, name, location, financialAid, years, contact, email);

        assertNotNull(ngo);
    }
}
