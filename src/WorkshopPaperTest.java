import Exceptions.WorkshopPaperEmptyTitleException;
import Exceptions.WorkshopPaperExcessReviewException;
import Exceptions.WorkshopPaperNoReviewsYetException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class WorkshopPaperTest {

    @Test
    public void testWorkshopPaperConstructor() throws Exception {

        /*  Test ID: 1
            Authored: Oscar Mason, Jon Dilks, Benjamin Charlton, Tim Cargan
         */

        WorkshopPaper workshopPaper = new WorkshopPaper();
        assertNotNull(workshopPaper);

        assertEquals("New Paper", workshopPaper.getPTitle());
        assertEquals(3, workshopPaper.getPReviews().length);
        assertArrayEquals(new WorkshopReview[3], workshopPaper.getPReviews());
    }

    @Test
    public void WorkshopPaperMainConstructorTest2() {

        /*  Test ID: 2
            Authored: Oscar Mason, Benjamin Charlton
         */

        WorkshopPaper workshopPaper = new WorkshopPaper("Test Paper");
        assertNotNull(workshopPaper);

        assertEquals("Test Paper", workshopPaper.getPTitle());
        assertEquals(3, workshopPaper.getPReviews().length);
        assertArrayEquals(new WorkshopReview[3], workshopPaper.getPReviews());
    }

    @Test(expected = WorkshopPaperEmptyTitleException.class)
    public void WorkshopPaperMainConstructorTest3() {
        /*  Test ID: 3
            Authored: Oscar Mason, Benjamin Charlton, Jonathan Dilks
         */
        WorkshopPaper workshopPaper1 = new WorkshopPaper("");
    }

    @Test
    public void testGetPTitle() {
        /*  Test ID: 5
            Authored: Oscar Mason, Benjamin Charlton
         */
        WorkshopPaper workshopPaper = new WorkshopPaper("Title Goes Here");
        assertEquals("Title Goes Here", workshopPaper.getPTitle());
    }

    @Test
    public void setPTitleTest6() {
        /*  Test ID: 6
            Authored: Oscar Mason, Benjamin Charlton
         */
        WorkshopPaper workshopPaper = new WorkshopPaper();
        workshopPaper.setPTitle("New Title");
        assertEquals("New Title", workshopPaper.getPTitle());

    }

    @Test
    public void setPTitleTest7() {
        /*  Test ID: 7
            Authored: Oscar Mason, Benjamin Charlton
         */

        final String exampleTitle = "Example Paper";

        WorkshopPaper workshopPaper = new WorkshopPaper(exampleTitle);

        boolean thrown = false;

        try {
            workshopPaper.setPTitle("");
        }
        catch (Exception e)
        {
            thrown = true;
        }
        assertTrue(thrown);
        assertEquals(workshopPaper.getPTitle(), exampleTitle);
    }

    @Test
    public void addReview9() {
        /*  Test ID: 9
            Authored: Oscar Mason, Benjamin Charlton, Jonathan Dilks
         */
        final String testText="Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";

        WorkshopPaper workshopPaper = new WorkshopPaper();
        WorkshopReview workshopReview = new WorkshopReview(3, testText);
        workshopPaper.addReview(workshopReview);

        WorkshopReview[] workshopReviews = workshopPaper.getPReviews();
        assertEquals(workshopReviews[0], workshopReview);

        assertEquals(workshopReview.getRReview(), testText);
    }

    @Test(expected = WorkshopPaperExcessReviewException.class)
    public void addReview10(){
        /*  Test ID: 10
            Authored: Oscar Mason, Jonathan Dilks
         */
        WorkshopPaper workshopPaper = new WorkshopPaper();
        for (int i = 0; i<workshopPaper.getPReviews().length+1; i++){
            workshopPaper.addReview(new WorkshopReview(i, "Test"));
        }
    }

    @Test
    public void getAverageScoreTest12() throws Exception {
        /*  Test ID: 12
            Authored: Oscar Mason, Benjamin Charlton
         */
        WorkshopPaper workshopPaper = new WorkshopPaper();
        for (int i = 0; i<3; i++){
            workshopPaper.addReview(new WorkshopReview(i+2, "Test"));
        }

        assertEquals(3, workshopPaper.getAverageScore(), 0.2);
    }

    @Test(expected = WorkshopPaperNoReviewsYetException.class)
    public void getAverageScoreTest16(){
        /*  Test ID: 16
            Authored: Oscar Mason, Jonathan Dilks
         */
        WorkshopPaper workshopPaper= new WorkshopPaper();
        workshopPaper.getAverageScore();
    }

    @Test
    public void toStringTest13(){
        /*  Test ID: 13
            Authored: Oscar Mason, Benjamin Charlton
         */
        WorkshopPaper workshopPaper = new WorkshopPaper();
        for (int i = 0; i<3; i++){
            workshopPaper.addReview(new WorkshopReview(i+2, "Test"));
        }

        String expectedOutput = "Average Score = ***\n\n"
        + "Review 1:\nScore = **\n Review: Test\n\n"
        + "Review 2:\nScore = ***\n Review: Test\n\n"
        + "Review 3:\nScore = ****\n Review: Test\n\n";

        assertEquals(expectedOutput, workshopPaper.toString());
    }

    @Test
    public void toStringTest14() {
        /*  Test ID: 14
            Authored: Oscar Mason, Jonathan Dilks
         */
        final String noReviewString = "No reviews submitted yet.";

        WorkshopPaper workshopPaper3 = new WorkshopPaper();
        assertEquals(workshopPaper3.toString(), noReviewString);
    }

    @Test
    public void toStringTest15() {
        /*  Test ID: 15
            Authored: Oscar Mason, Jonathan Dilks
         */
        WorkshopPaper workshopPaper = new WorkshopPaper();
        for (int i = 0; i<2; i++){
            workshopPaper.addReview(new WorkshopReview(2, "Any text"));
        }

        String expectedOutput = "Average Score = **\n\n"
                + "Review 1:\nScore = **\n Review: Test\n\n"
                + "Review 2:\nScore = **\n Review: Test\n\n";

        assertEquals(workshopPaper.toString(), expectedOutput);
    }

}