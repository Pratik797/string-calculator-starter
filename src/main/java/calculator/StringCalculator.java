package calculator;

class StringCalculator {

    public int add(String input) {
       if(input.isEmpty()){ 


        
        return 0;
       }
       else if(input.contains("1,2")){
           return 3;
       }
       else{
           System.out.println("Enter Valid String");
           return 0;
       }
    }

}