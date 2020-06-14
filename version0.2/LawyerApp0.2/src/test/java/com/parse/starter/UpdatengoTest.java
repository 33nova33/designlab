# AUTHOR: Madhobi Rani Shaha
package com.parse.starter;

import com.parse.ParseObject;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class UpdatengoTest {

    @Test
    public void mapParser() {
        String username = "newuser",
                name = "Help Foundation",
                location = "Kolkata",
                financialAid = "10000",
                years = "12",
                contact = "9218337282",
                email = "help.foundation@gmail.com";

        Updatengo ngoReg = new Updatengo();
        ParseObject ngo = ngoReg.mapParser(username, name, location, financialAid, years, contact, email);

        assertNotNull(ngo);
    }
}
