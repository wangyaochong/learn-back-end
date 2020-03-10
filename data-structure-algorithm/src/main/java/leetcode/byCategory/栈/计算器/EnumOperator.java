package leetcode.byCategory.栈.计算器;

public enum EnumOperator {
    //加号
    ADD(1),
    SUB(1),
    MUL(2),
    DIV(2),
    LEFT_PARE(3),
    RIGHT_PARE(3),
    ;
    int priority;

    EnumOperator(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public static leetcode.byCategory.栈.计算器.EnumOperator getByChar(char c) {
        if (c == '-') return leetcode.byCategory.栈.计算器.EnumOperator.SUB;
        if (c == '+') return leetcode.byCategory.栈.计算器.EnumOperator.ADD;
        if (c == '*') return leetcode.byCategory.栈.计算器.EnumOperator.MUL;
        if (c == '/') return leetcode.byCategory.栈.计算器.EnumOperator.DIV;
        if (c == '(') return EnumOperator.LEFT_PARE;
        if (c == ')') return EnumOperator.RIGHT_PARE;
        return null;
    }

    public int getResult(int op1, int op2) {
        switch (this) {
            case ADD:
                return op1 + op2;
            case DIV:
                return op1 / op2;
            case MUL:
                return op1 * op2;
            case SUB:
                return op1 - op2;
        }
        return 0;
    }

    public double getResult(double op1, double op2) {
        switch (this) {
            case ADD:
                return op1 + op2;
            case DIV:
                return op1 / op2;
            case MUL:
                return op1 * op2;
            case SUB:
                return op1 - op2;
        }
        return 0;
    }
}
