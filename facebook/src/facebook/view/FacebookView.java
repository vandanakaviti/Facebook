package facebook.view;

import java.util.Scanner;

import facebook.controller.FacebookControllerInterface;
import facebook.entity.FacebookUser;
import facebook.utility.ControllerFactory;

public class FacebookView {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		String ans = "y";
		
		while (ans.contentEquals("y")) {
			FacebookControllerInterface fc = ControllerFactory.createObject();
			
			System.out.println("******************** MAIN MENU ********************");
			System.out.println("Press 1 to sign-up");
			System.out.println("Press 2 to sign-in");
			System.out.print("Enter your choice : ");
			int mainAns = s.nextInt();
			System.out.println();
			String ans1 = "y";
			
			while (ans1.contentEquals("y")) {
				switch (mainAns) {
				case 1:
					System.out.println("*********** Sign-up ***********");
					fc.signUp();
					break;
				
				case 2:
					FacebookUser user = fc.signIn();	
					if (user != null) {
						String ans2 = "y";
						while (ans.contentEquals("y")) {
							System.out.println("                            *********** Sign-in MENU ***********");
							System.out.println("                            Press 1 to edit your profile");
							System.out.println("                            Press 2 to delete a profile");
							System.out.println("                            Press 3 to view a profile");
							System.out.println("                            Press 4 to view all profiles");
							System.out.println("                            Press 5 to search profiles with same name");
							System.out.println("                            Press 6 to profiles in sorted order by name");
							System.out.println("                            Press 7 to create timeline");
							System.out.print("Enter your choice : ");
							int ch = s.nextInt();
							System.out.println();
							
							switch(ch) {
								case 1:
									fc.editProfileController(user.getEmail());
									break;
								case 2:
									fc.deleteProfileController();
									break;
								case 3:
									fc.viewProfileController();
									break;
								case 4:
									fc.viewAllProfilesController();
									break;
								case 5:
									fc.searchProfileController();
									break;
								case 6:
									fc.sortProfileController();
									break;	
								case 7:
									fc.createTimelineController();
									break;
								default:
									System.out.println("Enter valid choice");
									break;
								
							}
							System.out.print("Do you wish to continue to sign-in menu (y/n) : ");
							ans2 = s.next();
							System.out.println();
						}
					}
					else {
						System.out.println("Oops! You are not registered. Press 1 to sign-up" + "\n");
					}
					break;
				}
			System.out.print("Do you wish to come back to Main menu (y/n) : ");
			ans1 = s.next();
			System.out.println();
			}
		}
	}
}
