class Solution {
    public int solution(int n) {
        int answer = 2;
        if(n==1){
            return 1;
        }else if(n==2){
            return 2;
        }
        for(int i=3; i<=n; i++){
            answer++;
            while(true){
                if(answer%3==0 || answer%10 ==3 || answer/10 ==3 || (answer%100)/10 ==3){
                    answer++;
                }else {
                    break;
                }
            }
        }
        return answer;
        
    }
}