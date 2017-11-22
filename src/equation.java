public class equation {
    private transient String[] equation;
    private transient String[] backup;
    private int size;
    public equation(String equation) {
        if((""+equation.charAt(0)).equals("-"))
            equation="0"+equation;
        int a=0;
        size = equation.length();
        this.equation = new String[size];
        for(int i=0 ;i < equation.length();i++) {
            if(!((""+equation.charAt(i)).equals("=")||(""+equation.charAt(i)).equals(" "))) {
                this.equation[a] = "" + equation.charAt(i);
                int j = i + 1;
                if (isNumeric(equation.charAt(i)) && j < equation.length()) {
                    while (j < equation.length() && isNumeric(equation.charAt(j))) {
                        this.equation[a] = this.equation[a] + equation.charAt(j);
                        j++;
                    }
                    i = j - 1;                }
                a++;
                size = a;
            }
        }
        replace();

    }
    public String[] get_equation(){
        return equation;
    }
    public void replace(){
        backup = new String[size];
        for (int i = 0; i < size; i++){
            backup[i]=equation[i];
        }
        equation=backup;
    }
    public void kill(int num){
        for (int i = num; i < size-1;i++){
            equation[i]=equation[i+2];
        }
        size=size-1;
        replace();
    }
    public void plus(int num){
            equation[num - 1] = "" + (Double.parseDouble(equation[num - 1]) + Double.parseDouble(equation[num + 1]));
            size--;
            kill(num);
    }
    public void minus(int num){
        equation[num - 1] = "" + (Double.parseDouble(equation[num - 1]) - Double.parseDouble(equation[num + 1]));
        size--;
        kill(num);
    }
    public void multiply(int num){
        equation[num-1]=""+(Double.parseDouble(equation[num-1]) * Double.parseDouble(equation[num+1]));
        size--;
        kill(num);
    }
    public void division(int num) {
        try {
            equation[num - 1] = "" + (Double.parseDouble(equation[num - 1]) / Double.parseDouble(equation[num + 1]));
            size--;
            kill(num);
        }catch (ArithmeticException e){
            System.out.println("您输入的算式存在异常：被除数为0，请修改您的算式再试一次");
        }
    }
    public void power(int num){
        equation[num - 1] = "" + Math.pow(Double.parseDouble(equation[num + 1]),Double.parseDouble(equation[num - 1]));
        size--;
        kill(num);
    }
    public void delete(int num){
        for (int i = num; i < size-1;i++){
            equation[i]=equation[i+1];
        }
        size--;
}
    public static boolean isNumeric(char str) {
        if (!Character.isDigit(str))
            return false;
        return true;
    }

}