class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        //지도 1과 지도2를 겹친것이므로 한 변의 길이는 같다.
        
        for(int  i = 0 ; i<arr1.length ; i++){
            StringBuilder first = new StringBuilder(Integer.toBinaryString(arr1[i]));
            //10진수를 2진수로 해주는 함수
            //2진수를 10진수로 해주는 함수는 Integer.parseInt("바꾸려는 2진수", 2)
            //first에는 지도1의 값, 2진수로 바꾸고 문자열로 저장
            StringBuilder second = new StringBuilder(Integer.toBinaryString(arr2[i]));
            //second에는 지도 2의 값
            int index = 0;
            while (true){
                if(index==n){
                    break;
                }else{
                    if(first.length()!=n){
                        first.insert(0, "0");
                    }
                    else if(second.length()!=n){
                        second.insert(0, "0");
                    } else{
                        if(first.charAt(index)=='1' || second.charAt(index)=='1'){

                            if(answer[i]==null){
                                answer[i] = "#";
                            }else{
                                answer[i] = answer[i]+"#";
                            }
                        }else{
                            if(answer[i]==null){
                                answer[i] = " ";
                            }else{
                                answer[i] = answer[i]+" ";
                            }
                        }
                        index++;
                    }

                }
            }
        }
        return answer;
    }
}
