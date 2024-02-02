package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17609 {

    static int T;
    static String[] letters;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        letters = new String[T + 1];

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            letters[i] = st.nextToken();
        }

        //원래 문자열,뒤부터 정렬한 문자열
        //포인터가 앞과 뒤 두개가 있어서 -> 하나하나 비교하다가 안 겹치면 count +1
        // 겹치면 앞과 뒤 둘다 +1 +1 해서 다음 문자열 비교하기
        //재귀로 구현

        for (int i = 0; i < T; i++) {
            String nowLetter = letters[i];
            System.out.println(palindrome(0, letters[i].length() - 1, nowLetter, 0));
        }

    }

    private static int palindrome(int start, int end, String letter, int check) {
        //회문이 아예 아닌 경우 -> 2
        //회원 -> 0 , 유사회문 -> 1
        if (check >= 2) return 2;

        while (start < end) {
            if (letter.charAt(start) == letter.charAt(end)) {
                start++;
                end--;
            } else { // 고민 지점.... left & right 지점 다 나눠서 햇는데 꼬여서 구글링 --> 넘 드러븜 코드
                return Math.min(palindrome(start + 1, end, letter, check + 1), palindrome(start, end - 1, letter, check + 1));
                //https://blackvill.tistory.com/70 해당 코드가 내가 생각했던 코드랑 제일 유사
                //https://stdio-han.tistory.com/82 이게 참고 코드
            }
        }

        return check;
    }
}
