import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        System.out.println("欢迎使用郝人的计算器");
        System.out.println("完成一次计算后如需对结果继续进行计算，可输入新算式或直接输入运算符" );
        System.out.println("如需结束该次计算请输入“new”");
        System.out.println("如需关闭计算器请输入“end”");
        System.out.println("请输入您的算式，亲爱的Miss.Tenderloin");  //   *Tenderloin：某种美味的肉制品
        String equation = in.next();
        String input="1";
        do {
            if(input.equals("new")) {
                System.out.println("请输入您的算式，亲爱的Miss.Tenderloin");
                equation = in.next();
            }else if(!isNumeric(input.substring(0,1)))
                equation=equation+input;
            compute compute = new compute(equation);
            compute.calculate();
            compute.getresult();
            input = in.next();
        }while(!input.equals("end"));

    }

    public static boolean isNumeric(String str){
        for (int i = 0; i < str.length(); i++){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
