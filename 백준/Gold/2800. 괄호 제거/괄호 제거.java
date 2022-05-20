import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    public static class Pair{
        int leftIndex;
        int rightIndex;

        Pair(int leftIndex, int rightIndex){
            this.leftIndex = leftIndex;
            this.rightIndex = rightIndex;
        }
    }
    public static ArrayList<Pair> pairs;     // 괄호 쌍 인덱스 리스트
    public static int N;                    // 괄호 쌍의 갯수
    public static char[] expression;
    public static String originalExpression;
    public static HashSet<String> removedExpressions;

    public static void main(String[] args) throws Exception{
        BufferedReader  br  = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //수식문자열을 char 리스트로 받기
        String originalExpression = br.readLine().trim();
        expression = new char[originalExpression.length()];
        for(int index = 0 ;index<originalExpression.length(); index++){
            expression[index] = originalExpression.charAt(index);
        }

        //괄호쌍의 인덱스를 찾기
        pairs = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int index = 0 ; index<expression.length; index++){
            char currentChar = expression[index];
            if(currentChar =='('){
                stack.push(index);
            }
            else if(currentChar==')'){
                Pair pair = new Pair(stack.pop(),index);
                pairs.add(pair);
            }
        }

        removedExpressions = new HashSet<>();           //  괄호가 제거된 수식
        N = pairs.size();                               // 괄호쌍의 갯

        removePair(0,expression);

        List removedExpressionList = new ArrayList(removedExpressions);
        Collections.sort(removedExpressionList);

        for(int index = 0; index<removedExpressionList.size(); index++){
            if(!removedExpressionList.get(index).equals(originalExpression)){
                bw.write(removedExpressionList.get(index)+"\n");
            }
        }

        bw.flush();

    }
    public static void removePair(int index, char[] expression){
        if(index>=N){
            String removeExpression = new String(expression);
            removeExpression=removeExpression.replaceAll(" ", "");
            removedExpressions.add(removeExpression);
        }
        else{
            Pair currentPair= pairs.get(index);

            //currentPair삭제
            expression[currentPair.leftIndex] = ' ';
            expression[currentPair.rightIndex]= ' ';
            removePair(index+1, expression);

            // currentPair삭제안함
            expression[currentPair.leftIndex] = '(';
            expression[currentPair.rightIndex]= ')';
            removePair(index+1, expression);




        }
    }
}