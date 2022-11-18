package day16;

import java.util.Scanner;

public interface UserManagerService {
	public void printMenu(String str);
	public int selectMenu(Scanner scan, int min, int max);
	public void runMenu(int menu, UserProfiler up, Scanner scan);
}
