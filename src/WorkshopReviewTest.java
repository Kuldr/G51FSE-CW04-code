import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class WorkshopReviewTest {

    private static final int VALID_MIN_SCORE = 1;
    private static final int VALID_MID_SCORE = 3;
    private static final int VALID_MAX_SCORE = 5;
    private static final int INVALID_LOW_SCORE = 0;
    private static final int INVALID_HIGH_SCORE = 5;

    @Test
    public void testGetRScore() throws Exception {
        /* ID: 57
           Authored: Tim Cargan, Jon Dilks
         */
        WorkshopReview workshopReview = new WorkshopReview();
        assertEquals(VALID_MIN_SCORE, workshopReview.getRScore());

        /*
            ID: 58
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview.setRScore(VALID_MID_SCORE);
        assertEquals(VALID_MID_SCORE, workshopReview.getRScore());
    }

    @Test
    public void testSetRScore() throws Exception {
        /*
            ID: 60
            Authored: Tim Cargan, Jon Dilks
         */
        WorkshopReview workshopReview = new WorkshopReview();

        workshopReview.setRScore(VALID_MAX_SCORE);
        assertEquals(VALID_MAX_SCORE, workshopReview.getRScore());


        workshopReview.setRScore(VALID_MIN_SCORE);
        assertEquals(VALID_MIN_SCORE, workshopReview.getRScore());

        /*
            ID: 59
            Authored: Tim Cargan, Jon Dilks
         */
        try {
            workshopReview.setRScore(INVALID_LOW_SCORE);
            fail("Invalid low score 'ran'");
        }catch (Exception e){}
        assertNotEquals(INVALID_LOW_SCORE, workshopReview.getRScore());

        try {
            workshopReview.setRScore(INVALID_HIGH_SCORE);
            fail("Invalid high score 'ran'");
        }catch (Exception e){}
        assertNotEquals(INVALID_HIGH_SCORE, workshopReview.getRScore());
    }

    @Test void  testWorkshopPaperConstructor() throws Exception{
        WorkshopReview workshopReview;
        /*
            ID: 50
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        assertNotNull(workshopReview);


        workshopReview = new WorkshopReview(VALID_MID_SCORE, "txt");
        assertEquals(VALID_MID_SCORE, workshopReview.getRScore());
        assertEquals("txt", workshopReview.getRReview());
    }

    @Test
    public void testGetRReview() throws Exception {

    }

    @Test
    public void testSetRReview() throws Exception {

    }

    @Test
    public void testToString() throws Exception {

}
        }