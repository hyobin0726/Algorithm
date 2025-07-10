class Solution {
    public int solution(String[] babbling) {
        
        int cnt = 0;
        for(int i =0; i<babbling.length; i++){
            String tmp = babbling[i];
            boolean isValid = true;
            while (true){
                isValid = true;
                if(tmp.length() > 2 ){
                    if(tmp.substring(0,3).equals("aya")) {
                        tmp = tmp.substring(3);
                        isValid = false;

                    }else if (tmp.substring(0,3).equals("woo")){
                        tmp = tmp.substring(3);
                        isValid = false;
                    }
                }
                if(tmp.length() >1 ) {
                    if (tmp.substring(0, 2).equals("ye")) {
                        tmp = tmp.substring(2);
                        isValid = false;
                    } else if (tmp.substring(0, 2).equals("ma")) {
                        tmp = tmp.substring(2);
                        isValid = false;
                    }
                }
                if(isValid) {
                    if (tmp.length() == 0) {
                        cnt += 1;
                        break;
                    } else {
                        break;
                    }

                }
            }
        }
        System.out.println(cnt);
        return cnt;
    }
}

