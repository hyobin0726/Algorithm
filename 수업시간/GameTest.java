import java.util.Scanner;

/**
 * 가위,바위,보 게임을 하는 클래스
 */
public class GameTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("가위바위보 게임을 시작합니다. 아래 보기 중 하나를 고르세요.");
        System.out.println("1. 5판 3승");
        System.out.println("2. 3판 2승");
        System.out.println("3. 1판 1승");

        System.out.print("번호를 입력하세요.");
        int num = in.nextInt();
        int gameNum = 0;

        if (num== 1) {
            gameNum = 5;
        } else if (num ==2) {
            gameNum = 3;

        } else {
            gameNum = 1;
        }

        int computer = 0 ;
        int user = 0;

        int comscore = 0;
        int userscore =0;
        int game = 0;

        while (game< gameNum) {

            computer = (int) (Math.random()*3) +1;


            System.out.print("가위바위보 중 하나 입력:");
            String str = in.next();

            switch (str) {
                case "가위":
                    if (computer == 1) {
                        System.out.println("비겼습니다!!");

                    }
                    else if (computer == 2 ) {
                        System.out.println("졌습니다!!");
                        comscore+=1;
                    }
                    else {
                        System.out.println("이겼습니다!!");
                        userscore+=1;
                    }
                    game+=1;
                    break;
                case "바위":
                    if (computer == 1) {
                        System.out.println("이겼습니다!!");
                        userscore+=1;
                    }
                    else if (computer == 2 ) {
                        System.out.println("비겼습니다!!");
                    }
                    else {
                        System.out.println("졌습니다!!");
                        comscore+=1;
                    }
                    game+=1;
                    break;
                case "보":
                    if (computer == 1) {
                        System.out.println("졌습니다!!");
                        comscore+=1;
                    }
                    else if (computer == 2 ) {
                        System.out.println("이겼습니다!!");
                        userscore+=1;
                    }
                    else {
                        System.out.println("비겼습니다!!");
                    }
                    game+=1;
                    break;
            }

        }
        if (comscore > userscore) {
            System.out.println("###컴퓨터 승!!!");
        } else if (comscore < userscore) {
            System.out.println("###사용자 승!!!");
        }
        else {
            System.out.println("###비겼습니다!!!");
        }
    }
}
