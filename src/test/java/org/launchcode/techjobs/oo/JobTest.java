package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job();
        String jobString = job.toString();
        assertTrue(jobString.startsWith(System.lineSeparator()));
        assertTrue(jobString.endsWith(System.lineSeparator()));
    }
    public void testToStringContainsCorrectLabelsAndData() {
        // Create job components
        Employer employer = new Employer("LaunchCode");
        Location location = new Location("St. Louis");
        PositionType positionType = new PositionType("Front-end developer");
        CoreCompetency coreCompetency = new CoreCompetency("JavaScript");

        // Create a job instance
        Job job = new Job("Web Developer", employer, location, positionType, coreCompetency);

        // Get the string representation of the job
        String jobString = job.toString();

        // Check if the string contains correct labels and data
        assertTrue(jobString.contains("ID: " + job.getId()));
        assertTrue(jobString.contains("Name: Web Developer"));
        assertTrue(jobString.contains("Employer: LaunchCode"));
        assertTrue(jobString.contains("Location: St. Louis"));
        assertTrue(jobString.contains("Position Type: Front-end developer"));
        assertTrue(jobString.contains("Core Competency: JavaScript"));
    }
    @Test
    public void testTestToStringContainsCorrectLabelsAndDataExists() throws ClassNotFoundException {
        Class<?> jobTestClass = Class.forName("org.launchcode.techjobs.oo.JobTest");
        Method testToStringContainsCorrectLabelsAndDataMethod = null;

        try {
            testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");
            assertNotNull("Method testToStringContainsCorrectLabelsAndData not found in JobTest", testToStringContainsCorrectLabelsAndDataMethod);
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringContainsCorrectLabelsAndData method");
        }
    }

    @Test
    public void testSettingJobId(){
        Job job1= new Job();
        Job job2= new Job();
        assertNotEquals(job1.getId(),job2.getId()); //IDs should not be equal
       // assertEquals(job1.getId(),job2.getId()); //IDs should be equal

    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        // Test the class and value of each field
        assertTrue(job.getName() instanceof String);
        assertEquals("Product tester", job.getName());

        assertTrue(job.getEmployer() instanceof Employer);
        assertEquals("ACME", job.getEmployer().getValue());

        assertTrue(job.getLocation() instanceof Location);
        assertEquals("Desert", job.getLocation().getValue());

        assertTrue(job.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job.getPositionType().getValue());

        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job = new Job();
        String jobString = job.toString();

        assertTrue(jobString.startsWith(System.lineSeparator())); // Check if starts with a new line
        assertTrue(jobString.endsWith(System.lineSeparator())); // Check if ends with a new line
    }

}
