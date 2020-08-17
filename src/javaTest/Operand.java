package javaTest;

public class Operand {
    private String operands;
//контсруктор класса
    public Operand(String operands) {
        this.operands = operands;
    }

    /*
     * Проверка операнда на принадлежность к арабской системе счисления
     *
     * */
    public boolean isIntegers(){

        return operands.matches("[1-9][0]?");

    }
    /*
    * Проверка операнда на принадлежность к Римской системе счисления
    * */
    public boolean isRoman(){
try {


      if (Roman.valueOf(operands)!=null)
        return true;
      else return false;
}catch (Exception e)
{
    return false;
}
    }

    public String getOperands() {
        return operands;
    }
}
