 public static String solution(String number, int k) {

        int size = number.length()-k; //구해야하는 자리수
        int max =  Integer.MIN_VALUE;
        int index = 0;
        int j;
        StringBuilder builder = new StringBuilder();
        for(int i=0; i<size; i++){
            for( j = index; j<=k; j++) {
                int num = number.charAt(j) -'0';

                if(num == 9) {
                    max = num;
                    index= j+1;

                    break;
                }

                if(max < num) {
                    max = num;
                    index= j+1;

                }
            }

            builder.append(max);
            max = Integer.MIN_VALUE;
            k++;


        }

        return builder.toString();
    }
