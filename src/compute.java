public class compute {
    public equation equation1;
    public compute(String input){
        equation1=new equation(input);
    }
    private int value(String a){
        char b=a.charAt(0);
        switch (b){
            case '+':
                return 1;
            case '-':
                if (a.length()>1)
                    return -1;
                return 1;
            case '*':
                return 2;
            case '/':
                return 3;
            case '^':
                return 4;
            case '(':
                return -2;
            case ')':
                return -3;
            default:
                return 0;
        }
    }
    private int queue(){
        int num = 0;
        int now_value = 0;
        int bracket = 0;
        for(int i=0;i<equation1.get_equation().length;i++){
            if (value(equation1.get_equation()[i])>now_value) {
                num = i;
                now_value = value(equation1.get_equation()[i]);
            }else if(value(equation1.get_equation()[i])==(-2)){
                now_value = 0;
                bracket = i;
                if(value(equation1.get_equation()[i+1])==1)
                    equation1.get_equation()[i+1]=equation1.get_equation()[i+1]+equation1.get_equation()[i+2];
                    equation1.delete(i+2);
                    equation1.replace();
            }else if(value(equation1.get_equation()[i])==(-3)){
                if (now_value<=1){
                    equation1.delete(i);
                    equation1.delete(bracket);
                    equation1.replace();
                }
                if(num==0)
                    num++;
                break;
            }
        }
        return num;
    }
    public void calculate(){
        do{
            int num = queue();
            switch(equation1.get_equation()[num].charAt(equation1.get_equation()[num].length()-1)){
                case'+':
                    equation1.plus(num);
                    break;
                case'-':
                    equation1.minus(num);
                    break;
                case'*':
                    equation1.multiply(num);
                    break;
                case'/':
                    equation1.division(num);
                    break;
                case'^':
                    equation1.power(num);
                    break;
                default:
                    System.out.println(equation1.get_equation()[num]+":非常抱歉，此运算本计算器尚未收录，请等待版本更新或联系开发者QQ：3022297051");
                    break;
            }
        }while(equation1.get_equation().length>1);
    }
    public void getresult(){
        System.out.println("结果是"+equation1.get_equation()[0]);
    }
}
