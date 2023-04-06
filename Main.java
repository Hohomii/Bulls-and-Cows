import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random(); // 랜덤 객체 생성
        int createNum = 0;
        String ranNum = "";
        String resultNum = "";

        for (int i=0; i < 3; i++) {
            createNum = random.nextInt(9); // 0~9까지 랜덤숫자 생성
            ranNum = Integer.toString(createNum); // 숫자를 문자로 변환
            if (!resultNum.contains(ranNum)) {     // 랜덤숫자의 중복 제거를 위한 반복문
                resultNum += ranNum;
            } else {
                i -= 1;
            }
        }

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        System.out.println(resultNum + " 테스트 확인용");

        Scanner sc = new Scanner(System.in);
        int index = 0;  // while문 사용해서 index가 따로 필요했음

        while (true) {
            String inputValue = sc.nextLine();
            int strike = 0;
            int ball = 0;

            if (inputValue.length() != 3 || !isStringInt(inputValue)) {  // 입력값이 세자리 숫자가 아니거나, 숫자가 아닐 경우
                System.out.println("입력값이 세 자리 숫자가 아닙니다. 다시 입력해주세요.");
                continue;     // while문 다시 시작
            }

            for (int j = 0; j < 3; j++) {    // ball & strike 판별
                char input = inputValue.charAt(j);
                char result = resultNum.charAt(j);
                if (input == result) {      // 숫자의 값과 위치가 모두 같으면 1S
                    strike++;
                } else if (resultNum.contains(String.valueOf(input))) {  // 숫자의 값은 일치하지만 위치가 틀리면 1B
                    ball++;
                }
            }
            index++;

            System.out.println(index + "번째 시도 : " + inputValue);
            System.out.println(ball + "B" + strike + "S");

            if (strike == 3) {      // 3S이면 게임종료
                System.out.println(index + "번째만에 맞히셨습니다.");
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }

    public static boolean isStringInt(String s) {    // 입력값이 정수가 맞는지 확인
        try {
            Integer.parseInt(s);  // 문자열을 정수로 변환하는 메서드
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

