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
    private final String optionText = "What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit\n";
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
        String output = optionText + "\n1) Paper 1 is great - 4.0\n2) Paper 2 is my best work - " + averageScore + "\n"+ optionText;
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
        String output = optionText + "What is the title of the paper?\n[Paper added]\n"+ optionText;
        output = output.replace("\n","").replace("\r","");
        String outTest = outContent.toString().replace("\n","").replace("\r","");
        assertEquals(output, outTest );
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
        String output = optionText + "\nWhat is the title of the paper?\n"+ optionText;
        output = output.replace("\n","").replace("\r","");
        String outTest = outContent.toString().replace("\n","").replace("\r","");
        assertEquals(output, outTest );
    }
}