package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main12891 {
    public static void main(String[] args) throws IOException {

        int[] checkArr = new int[4];
        int[] coppyArr = new int[4];
        int count = 0;
        int start = 0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken()); // 총 문자열 길이
        int P = Integer.parseInt(st.nextToken()); // 부분 문자열 길이
        String DNA = br.readLine(); // DNA STRING

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < 4; i++){
            checkArr[i] = Integer.parseInt(st.nextToken()); // 2 0 1 1 과 같은 string
        }

        for(int j = 0; j < S-P+1; j++){
            coppyArr = checkArr;

            for(int k = start; k < start+4; k++){
                switch (DNA.charAt(start)) {
                    case 'A' :
                        coppyArr[0]--;
                        break;
                    case 'C' :
                        coppyArr[1]--;
                        break;
                    case 'T' :
                        coppyArr[2]--;
                        break;
                    case 'G' :
                        coppyArr[3]--;
                        break;
                }
            }
            start++;

            if(coppyArr[0] <= 0 && coppyArr[1] <= 0 && coppyArr[2] <= 0 && coppyArr[3] <= 0){
                count++;
            }
        }

        if(count == 0) System.out.println(0);
        else System.out.println(count);

    }
}
