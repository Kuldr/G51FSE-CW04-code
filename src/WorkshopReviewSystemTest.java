import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class WorkshopReviewSystemTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final String optionText = "What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit"+System.lineSeparator();
    //private final ByteArrayInputStream in = new ByteArrayInputStream();
    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void workshopPaperSystemMain100a(){
        /*  Test ID: 100a
            Authored: Oscar Mason, Tim Cargan
         */
        WorkshopReviewSystem workshopReviewSystem = new WorkshopReviewSystem();
        String input = "O";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        workshopReviewSystem.main(new String[]{""});
        float averageScore = 4/3;
        //TODO Hardcoded average score
        String output = optionText + "1) Paper 1 is great - 4.0" + System.lineSeparator() +
                "2) Paper 2 is my best work - 2.0" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());
    }

    @Test
    public void workshopPaperSystemMain100b() throws Exception{
        /*  Test ID: 100b
            Authored: Oscar Mason, Tim Cargan
         */
        WorkshopReviewSystem workshopReviewSystem = new WorkshopReviewSystem();
        String input = "P\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        workshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?"+System.lineSeparator()+"[Paper added]"+System.lineSeparator()+ optionText;
        assertEquals(output, outContent.toString() );
    }


    @Test
    public void workshopPaperSystemMain100c(){
        /*  Test ID: 100c
            Authored: Oscar Mason, Tim Cargan
         */
        WorkshopReviewSystem workshopReviewSystem = new WorkshopReviewSystem();
        String input = "R\n2\n5\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        workshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Review added to Paper 2]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());
    }
}