

import Exceptions.*;

import java.util.*;


public class WorkshopReviewSystem {

	private static ArrayList<WorkshopPaper> AllPapers = new ArrayList<WorkshopPaper>(); //Bug Fix: 133, assignment need to be moved out of main here to make test run; Tim Cargan

	public static void main(String[] args) throws WorkshopPaperEmptyTitleException, WorkshopPaperExcessReviewException /*TODO : Handle the exceptions properly*/ {
		// TODO Auto-generated method stub

		
		System.out.println("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit");
		Scanner in = new Scanner(System.in);
		while (in.hasNextLine()){
			String s = in.nextLine(); //Bug Fix: 131; Tim Cargan
			try{
				if (s.equals("O")) {
					PrintPaperOverview();
				} else if (s.equals("P")){
					AddPaper(in);
				} else if (s.equals("R")) {
					AddReview(in);
				} else if (s.equals("X")) {
					System.out.println("Goodbye!");
					break;
				} else if (Integer.parseInt(s) != -1 ) {
					PrintAPaper(Integer.parseInt(s)-1);
				} else {
					System.out.println("Command not recognised");
				}
			} catch (Exception e) {
				System.out.println("Something went wrong: " + e.toString() + "\n");
			}
			System.out.println("What do you want to do?\n O = Overview, P = Add Paper, R = Add Review, [num] = Detail of that paper, X = exit");
		}
		in.close();
		
	}
	
	private static void AddPaper(Scanner in) throws WorkshopPaperEmptyTitleException {
		System.out.println("What is the title of the paper?");
		//in.nextLine(); // - Bug Fix: 131; Tim Cargan
		String title = in.nextLine();
		AllPapers.add(new WorkshopPaper(title));
		System.out.println("[Paper added]");
	}
	
	private static void AddReview(Scanner in) throws WorkshopPaperExcessReviewException, WorkshopReviewInvalidScore {
		System.out.println("Which paper do you want to add a review to?");
		int x = in.nextInt();
		System.out.println("What score do you give it?");
		int score = in.nextInt();
		System.out.println("Please enter your review:");
		in.nextLine(); //to remove read-in bug
		String review = in.nextLine();
		WorkshopPaper wp = AllPapers.get(x-1);
		wp.addReview(new WorkshopReview(score,review));
		System.out.println("[Review added to Paper " + x + "]");
	}
	
	private static void PrintPaperOverview(){
		for (int x = 0; x < AllPapers.size(); x++) {
			WorkshopPaper wp = AllPapers.get(x);
			try{
				System.out.println((x+1) + ") " + wp.getPTitle()+ " - " + wp.getAverageScore());
			}catch (WorkshopPaperNoReviewsYetException e){

			}
		}
	}
	
	private static void PrintAPaper(int paperID) {
		WorkshopPaper wp = AllPapers.get(paperID);
		System.out.print("\nPaper " + (paperID+1) + " - " + wp.toString());
	}

	//Test code
	//Bug Fix: 132; Moved test code out of main Tim Cargan
	public void add_test_data() throws WorkshopPaperEmptyTitleException, WorkshopPaperExcessReviewException, WorkshopReviewInvalidScore{
		//Test code, shouldnt not be in main
		WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
		p1.addReview(new WorkshopReview(4,"This paper is pretty good."));
		p1.addReview(new WorkshopReview(3,"This paper is good for the workshop."));
		p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));

		AllPapers.add(p1);

		WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
		p2.addReview(new WorkshopReview(2,"This can hardly be his best work"));
		p2.addReview(new WorkshopReview(1,"Ive read better articles in Hello Magazine"));
		p2.addReview(new WorkshopReview(1,"So painful to read."));

		AllPapers.add(p2);

		//PrintPaperOverview();
		//PrintAPaper(0);
		//PrintAPaper(1);
	}
}
