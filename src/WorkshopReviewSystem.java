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
			s = s.toUpperCase(); //Bug Fix: 106; Can now deal lowercase letters
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
				} else {
					//Bug Fix 103 - now runs the '#id' command or outputs apropreate message if command unknow
					boolean isCommandANumber = true;
					try {
						if (Integer.parseInt(s) > 0) {
							PrintAPaper(Integer.parseInt(s) - 1);
						}
					}catch (Exception e){
						isCommandANumber = false;
					}

					if (!isCommandANumber){
						System.out.println("Command not recognised");
					}

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

		WorkshopPaper wp = null;

		//Bug Fix: 120; Now outputs better error message for invalid paper id - Tim Cargan
		try {
			wp = AllPapers.get(x - 1);

		}catch(IndexOutOfBoundsException e){
			System.out.println("[Error, no such Paper]");
			return;
		}
		//Bug Fix 122: Now outputs better error message for the user - Tim Cargan
		try {
			wp.addReview(new WorkshopReview(score, review));
		}catch (WorkshopReviewInvalidScore e){
			System.out.println("[Error, Bad Score]");
			return;
		}
		System.out.println("[Review added to Paper " + x + "]");


	}
	
	private static void PrintPaperOverview(){
		if (AllPapers.size() == 0){
			System.out.println("[There are no papers]");
		}
		for (int x = 0; x < AllPapers.size(); x++) {
			WorkshopPaper wp = AllPapers.get(x);
			try{
				System.out.println((x+1) + ") " + wp.getPTitle()+ " - " + wp.getAverageScore());
			}catch (WorkshopPaperNoReviewsYetException e){

			}
		}
	}
	
	private static void PrintAPaper(int paperID) {
		//Bug Fix: 131 Prints a nice error message for the user
		try {
			WorkshopPaper wp = AllPapers.get(paperID);
			System.out.println("Paper " + (paperID+1) + " - " + wp.toString()); //Bug Fix: 134, prints approrate lin breaks in right place: Tim Cargan
		}catch (IndexOutOfBoundsException e) {
			System.out.println("[No paper with given ID]");
		}

	}

	//Test code
	//Bug Fix: 132; Moved test code out of main Tim Cargan
	public static void add_test_data() {
		try {
			//Test code, shouldn't not be in main
			WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
			p1.addReview(new WorkshopReview(4, "This paper is pretty good."));
			p1.addReview(new WorkshopReview(3, "This paper is good for the workshop."));
			p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));

			AllPapers.add(p1);

			WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
			p2.addReview(new WorkshopReview(2, "This can hardly be his best work"));
			p2.addReview(new WorkshopReview(1, "Ive read better articles in Hello Magazine"));
			p2.addReview(new WorkshopReview(1, "So painful to read."));

			AllPapers.add(p2);

		}catch (Exception e){}
		//PrintPaperOverview();
		//PrintAPaper(0);
		//PrintAPaper(1);
	}
	public static void remove_test_data(){
		AllPapers.clear();
	}

	public static void add_unreviwed_paper_3() {
		try {
			//Test code, shouldn't not be in main
			WorkshopPaper p1 = new WorkshopPaper("Paper 1 is great");
			p1.addReview(new WorkshopReview(4, "This paper is pretty good."));
			p1.addReview(new WorkshopReview(3, "This paper is good for the workshop."));
			p1.addReview(new WorkshopReview(2, "This paper is pretty mediocre."));

			AllPapers.add(p1);

			WorkshopPaper p2 = new WorkshopPaper("Paper 2 is my best work");
			p2.addReview(new WorkshopReview(2, "This can hardly be his best work"));
			p2.addReview(new WorkshopReview(1, "Ive read better articles in Hello Magazine"));
			p2.addReview(new WorkshopReview(1, "So painful to read."));

			AllPapers.add(p2);
			WorkshopPaper p3 = new WorkshopPaper("Paper 3 is my best work");
			p3.addReview(new WorkshopReview(3, "This can hardly be his best work, its meh"));
			AllPapers.add(p3);
		}catch (Exception e){}
	}

}