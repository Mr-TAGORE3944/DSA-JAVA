public class keypad_mobile_combinations {
    


    static void printKeypadCom(String dig  ,String[] kp , String res){
                if(dig.length() == 0){
                    System.out.print(res + " ");
                    return;
                }

        int idx = dig.charAt(0) - '0';

        String curr = kp[idx];


        for(int i = 0 ; i < curr.length() ;i++){
            printKeypadCom(dig.substring(1), kp, res + curr.charAt(i));
        }
        


    }

    public static void main(String[] args) {
        

        String dig = "23";

        String[] kp = {"" , "" , "abc" , "def" , "ghi" , "jkl" , "mno" , "pqrs" , "tuvw" , "xyz"};
        printKeypadCom(dig, kp, "");
    }
}
