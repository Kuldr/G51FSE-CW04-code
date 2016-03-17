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
    private final String optionText = "What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit" + System.lineSeparator();
    private static final String TEXT_NONASCII = "サービス停止のお知らせ【2/27]";
    private static final String TEXT_LONG = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium " +
            "doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto" +
            " beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut" +
            " fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam" +
            " est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi" +
            " tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis" +
            " nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur?" +
            " Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur," +
            " vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
        WorkshopReviewSystem.addTestData();

    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void workshopPaperSystemMain100a() {
        /*  Test ID: 100a
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.removeTestData();
        WorkshopReviewSystem.addTestData();

        String input = "O";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        float averageScore_1 = (float)9/3;
        float averageScore_2 = (float)4.0/3;
        String output = optionText +
                "1) Paper 1 is great - " + averageScore_1 + System.lineSeparator() +
                "2) Paper 2 is my best work - " + averageScore_2 + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain100b() {
        /*  Test ID: 100b
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "P\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?" + System.lineSeparator() +
                "[Paper added]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString() );

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain100c() {
        /*  Test ID: 100c
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.removeTestData();
        WorkshopReviewSystem.addUnreviwedPaper3();

        String input = "R\n3\n5\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Review added to Paper 3]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain100d() {
        /*  Test ID: 100d
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "X\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Goodbye!" + System.lineSeparator();
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }
    
    @Test
    public void workshopPaperSystemMain103() {
        /*  Test ID: 103
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "Unknown\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "[Command not recognised]" + System.lineSeparator()
                + optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }


    @Test
    public void workshopPaperSystemMain106a()  {
        /*  Test ID: 106a
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.removeTestData();
        WorkshopReviewSystem.addTestData();

        String input = "o";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        float averageScore_1 = (float)9/3;
        float averageScore_2 = (float)4.0/3;
        String output = optionText +
                "1) Paper 1 is great - " + averageScore_1 + System.lineSeparator() +
                "2) Paper 2 is my best work - " + averageScore_2 + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain106b() {
        /*  Test ID: 106b
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "p\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?" + System.lineSeparator() +
                "[Paper added]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString() );

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain106c() {
        /*  Test ID: 106c
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.removeTestData();
        WorkshopReviewSystem.addUnreviwedPaper3();

        String input = "r\n3\n5\nGood paper\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Review added to Paper 3]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain106d() {
        /*  Test ID: 106d
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "x\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Goodbye!" + System.lineSeparator();
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain108() {
        /*  Test ID: 108
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "P\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?" + System.lineSeparator() +
                "[Error No Title, Paper not added]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString() );

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }
    @Test
    public void workshopPaperSystemMain109() {
        /*  Test ID: 108
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "P\n" + TEXT_NONASCII + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?" + System.lineSeparator() +
                "[Paper added]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString() );

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }


    @Test
    public void workshopPaperSystemMain120() {
        /*  Test ID: 120
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "R\n5\n3\nTest\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Error, no such Paper]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain122() {
        /*  Test ID: 122
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addUnreviwedPaper3();

        String input = "R\n3\n0\nReview\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Error, Bad Score]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain123() {
        /*  Test ID: 123
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addUnreviwedPaper3();

        String input = "R\n3\n3\n\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Error must enter review text]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain124() {
        /*  Test ID: 124
            Authored: Oscar Mason, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.removeTestData();
        WorkshopReviewSystem.addUnreviwedPaper3();

        String input = "R\n3\n3\n" + TEXT_NONASCII + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Review added to Paper 3]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain125() {
        /*  Test ID: 125
            Authored: Benjamin Charlton, Tim Cargan
         */

        //Set up
        WorkshopReviewSystem.addTestData();

        String input = "R\n1\n3\n" + TEXT_LONG + "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "Which paper do you want to add a review to?" + System.lineSeparator() +
                "What score do you give it?" + System.lineSeparator() +
                "Please enter your review:" + System.lineSeparator() +
                "[Error paper already has 3 reviews]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain127() {
        /*  Test ID: 127
            Authored: Oscar Mason, Tim Cargan
         */

        //SetUp
        WorkshopReviewSystem.removeTestData();

        String input = "O\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "[There are no papers]" + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain130() {
        /*  Test ID: 130
            Authored: Oscar Mason, Tim Cargan
         */

        //SetUp
        WorkshopReviewSystem.removeTestData();

        String input = "P\nTest\n1\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "What is the title of the paper?" + System.lineSeparator() +
                "[Paper added]" + System.lineSeparator() +
                optionText +
                "Paper 1 - No reviews submitted yet." + System.lineSeparator() +
                optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain131() {
        /*  Test ID: 131
            Authored: Oscar Mason, Tim Cargan
         */

        //SetUp
        WorkshopReviewSystem.removeTestData();

        String input = "51\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "[No paper with given ID]" + System.lineSeparator() + optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }

    @Test
    public void workshopPaperSystemMain132() {
        /*  Test ID: 132
            Authored: Oscar Mason, Tim Cargan
         */

        //SetUp
        WorkshopReviewSystem.removeTestData();

        String input = "-51\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        WorkshopReviewSystem.main(new String[]{""});
        String output = optionText + "[Command not recognised]" + System.lineSeparator() + optionText;
        assertEquals(output, outContent.toString());

        //TearDown
        WorkshopReviewSystem.removeTestData();
    }
}
