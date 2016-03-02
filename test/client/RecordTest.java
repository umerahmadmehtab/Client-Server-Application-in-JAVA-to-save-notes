/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 */
public class RecordTest {
    
    
    @Test
    public void testName() {
        System.out.println("GetUser");
        Record instance = new Record("Umer", "Testing", 1);
        String expResult = "Umer";
        String result = instance.getName();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getNotes method, of class Record.
     */
    @Test
    public void testNotes() {
        System.out.println("getNotes");
        Record instance = new Record("Umer", "Testing", 1);
        String expResult = "Testing";
        String result = instance.getNotes();
        assertEquals(expResult, result);
    }
    
}
