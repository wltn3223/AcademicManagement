import controller.LessonRegisterManager;
import controller.StudentRegisterManager;
import controller.SubjectRegisterManager;
import controller.TraineeRegisterManager;
import view.LESSON_CHOICE;
import view.MENU_CHOICE;
import view.MenuViewer;
import view.STUDENT_CHOICE;
import view.SUBJECT_CHOICE;
import view.TRAINEE_CHOICE;

public class AcademiManagementMain {
	public static void main(String[] args) {
		mainMenu();
	}

	public static void mainMenu() {

		int choiceNum;
		boolean stopFlag = false;
		while (!stopFlag) {
			try {
				MenuViewer.mainMenuView();
				choiceNum = Integer.parseInt(MenuViewer.input.readLine());
				switch (choiceNum) {
				case MENU_CHOICE.SUBJECT:
					subjectMenu();
					break;
				case MENU_CHOICE.STUDENT:
					studentMenu();
					break;
				case MENU_CHOICE.LESSON:
					lessonMenu();
					break;
				case MENU_CHOICE.TRAINEE:
					traineeMenu();
					break;
				case MENU_CHOICE.EXIT:
					stopFlag = true;
					System.out.println("프로그램을 종료합니다.");
					break;

				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}
			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
				stopFlag = true;
			}

		}
	}

	public static void subjectMenu() throws Exception {
		int choiceNum;
		SubjectRegisterManager subjectManager = new SubjectRegisterManager();
		MenuViewer.subjectMenuView();
		choiceNum = Integer.parseInt(MenuViewer.input.readLine());
		switch (choiceNum) {
		case SUBJECT_CHOICE.LIST:
			System.out.println("");
			subjectManager.subjectList();
			break;
		case SUBJECT_CHOICE.INSERT:
			System.out.println("");
			subjectManager.subjectRegistr();
			break;
		case SUBJECT_CHOICE.UPDATE:
			System.out.println("");
			subjectManager.subjectUpdate();
			break;
		case SUBJECT_CHOICE.DELETE:
			System.out.println("");
			subjectManager.subjectDelete();
			break;
		case SUBJECT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void studentMenu() throws Exception {
		int choiceNum;
		StudentRegisterManager studnetManager = new StudentRegisterManager();
		MenuViewer.studentMenuView();
		choiceNum = Integer.parseInt(MenuViewer.input.readLine());
		switch (choiceNum) {
		case STUDENT_CHOICE.INSERT:
			System.out.println("");
			studnetManager.studnetRegistr();
			break;
		case STUDENT_CHOICE.UPDATE:
			System.out.println("");
			studnetManager.studnetUpdate();
			break;
		case STUDENT_CHOICE.LIST:
			System.out.println("");
			studnetManager.studnetTotalList();
			break;
		case STUDENT_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void lessonMenu() throws Exception {
		int choiceNum;
		LessonRegisterManager lessonManager = new LessonRegisterManager();
		MenuViewer.lessonMenuView();
		choiceNum = Integer.parseInt(MenuViewer.input.readLine());
		switch (choiceNum) {
		case LESSON_CHOICE.LIST:
			System.out.println("");
			lessonManager.lessonList();
			break;
		case LESSON_CHOICE.INSERT:
			System.out.println("");
			lessonManager.lessonRegistr();
			break;
		case LESSON_CHOICE.UPDATE:
			System.out.println("");
			lessonManager.lessonUpdate();
			break;
		case LESSON_CHOICE.DELETE:
			System.out.println("");
			lessonManager.lessonDelete();
			break;
		case LESSON_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}

	public static void traineeMenu() throws Exception {
		int choiceNum;
		TraineeRegisterManager traineeManager = new TraineeRegisterManager();
		MenuViewer.traineeMenuView();
		choiceNum = Integer.parseInt(MenuViewer.input.readLine());
		switch (choiceNum) {
		case TRAINEE_CHOICE.LIST:
			System.out.println("");
			traineeManager.traineeList();
			break;
		case TRAINEE_CHOICE.INSERT:
			System.out.println("");
			traineeManager.traineeRegistr();
			break;
		case TRAINEE_CHOICE.UPDATE:
			System.out.println("");
			traineeManager.traineeDelete();
			break;
		case TRAINEE_CHOICE.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
	}
}