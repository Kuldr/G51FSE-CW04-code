import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class WorkshopReviewTest {

    private static final int VALID_MIN_SCORE = 1;
    private static final int VALID_MID_SCORE = 3;
    private static final int VALID_MAX_SCORE = 5;
    private static final int INVALID_LOW_SCORE = 0;
    private static final int INVALID_HIGH_SCORE = 5;
    private static final String TEXT = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
            "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto" +
            " beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut" +
            " fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam" +
            " est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi" +
            " tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis" +
            " nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?" +
            " Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur," +
            " vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
    private static final String TEXT_NONASCII = "サービス停止のお知らせ【2/27]" +
            "2014年2月27日（木）はサーバメンテンナンスのため下記の時間帯にサービスが停止する時" +
            "間帯があります。ご不便をお掛け致しますが、ご理解賜りますようお願い申し上げます";

    //TODO: Update the excel sheet with the tests


    @Test
    //TODO: Break out tests
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
    //TODO: Break out tests
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
        // TODO: Write Exception for Invalid Score
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

    @Test
    public void  testWorkshopReviewConstructor50() {
        WorkshopReview workshopReview;
        /*
            ID: 50
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        assertNotNull(workshopReview);
    }
    @Test
    public void  testWorkshopReviewConstructor51() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 51
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        assertNotNull(workshopReview);
        assertEquals(VALID_MIN_SCORE, workshopReview.getRScore());
    }
    @Test
    public void  testWorkshopReviewConstructor52() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 52
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        assertEquals("", workshopReview.getRReview());
    }
    @Test
    public void  testWorkshopReviewConstructor53() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 53
            Authored: Tim Cargan, Jon Dilks
         */
        // TODO:  Add lorem lipsum
        workshopReview = new WorkshopReview(VALID_MID_SCORE, "txt");
        assertEquals(VALID_MID_SCORE, workshopReview.getRScore());
        assertEquals("txt", workshopReview.getRReview());
    }

    @Test
    public void  testWorkshopReviewConstructor54() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 54
            Authored: Tim Cargan, Jon Dilks
         */
        // TODO: Change to custom exception expected
        try {
            workshopReview = new WorkshopReview(INVALID_LOW_SCORE, TEXT);
            fail("Low score accepted");
        }catch (Exception e){}

    }

    @Test
    //TODO: Unicode string tests
    public void  testWorkshopReviewConstructor55() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 55
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview(VALID_MID_SCORE, TEXT);


    }

    @Test
    //TODO: Jon can do this one
    public void  testWorkshopReviewConstructor56() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 56
            Authored: Tim Cargan, Jon Dilks
         */

    }

    @Test
    public void testGetRReview61() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 61
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        assertEquals("", workshopReview.getRReview());
    }

    @Test
    public void testGetRReview62() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 62
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview(VALID_MID_SCORE, TEXT);
        assertEquals(TEXT, workshopReview.getRReview());
    }
    @Test
    public void testGetRReview63() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 63
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview(VALID_MID_SCORE, TEXT_NONASCII);
        assertEquals(TEXT_NONASCII, workshopReview.getRReview());
    }

    @Test
    public void testSetRReview64() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 64
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview(VALID_MID_SCORE, TEXT);
        workshopReview.setRReview("");
        assertEquals("", workshopReview.getRReview());
    }


    @Test
    public void testSetRReview65() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 65
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        workshopReview.setRReview(TEXT);
        assertEquals(TEXT, workshopReview.getRReview());
    }

    @Test
    public void testSetRReview66() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 66
            Authored: Tim Cargan, Jon Dilks
         */
        workshopReview = new WorkshopReview();
        workshopReview.setRReview(TEXT_NONASCII);
        assertEquals(TEXT_NONASCII, workshopReview.getRReview());
    }

    @Test
    //TODO: What is an oversize string?
    public void testSetRReview67() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 67
            Authored: Tim Cargan, Jon Dilks
         */
    }

    @Test
    public void testToString68() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 68
            Authored: Tim Cargan, Jon Dilks
         */
        // TODO: Check what the output should be
        workshopReview = new WorkshopReview();
        String toString = workshopReview.toString();
        assertEquals("Score:1\nReview: ", toString);
    }
    
    @Test
    public void testToString69() throws Exception {
        WorkshopReview workshopReview;
        /*
            ID: 69
            Authored: Tim Cargan, Jon Dilks
         */
        // TODO: Check what the output should be
        workshopReview = new WorkshopReview(VALID_MID_SCORE, TEXT);
        String expected = "Score:" + VALID_MID_SCORE + "\nReview: " + TEXT;
        assertEquals(expected, workshopReview.toString());
    }

}