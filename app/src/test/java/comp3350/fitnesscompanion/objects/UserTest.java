package comp3350.fitnesscompanion.tests.objects;


import org.junit.Assert;
import org.junit.Test;

import comp3350.fitnesscompanion.objects.User;

public class UserTest {

    @Test
    public void testUser(){
        User user;

        System.out.println("\nStarting UserTest");

        user = new User("jon.boisvert@myumn.ca","ASDF3350","Jonathan","Boisvert",31,75,170);
        Assert.assertNotNull("Check if object is actually created",user);
        user.setEmail("jon.boisvert@myumn.ca");
        Assert.assertEquals("Check if email matches","jon.boisvert@myumn.ca", user.getEmail());
        user.setPassword("COMP3350");
        Assert.assertEquals("Check if password matches","COMP3350", user.getPassword());
        user.setFname("Jon");
        Assert.assertEquals("Check if first name matches","Jon", user.getFname());
        user.setLname("Boisvert");
        Assert.assertEquals("Check if last name matches","Boisvert", user.getLname());
        user.setAge(32);
        Assert.assertEquals("Check if age matches",32, user.getAge());
        user.setWeight(65);
        Assert.assertEquals("Check if weight matches",65, user.getWeight());
        user.setHeight(165);
        Assert.assertEquals("Check if height matches",165, user.getHeight());

        System.out.println("\nEnding UserTest");

    }

}
