package task1;

public enum Operation {
    PLUS("+" ,0, true, false),
    MINUS ("-", PLUS.getPriority(), true, false),
    DIVISION("/",PLUS.getPriority() +1, true, false),
    MULTI ("*", DIVISION.getPriority(), true, false),
    LEFT_BRACKET ("(",PLUS.getPriority()-1, false, false),
    RIGHT_BRACKET(")", LEFT_BRACKET.getPriority(), false, false),
    ROOT( "√", LEFT_BRACKET.getPriority() -1, false, true),
    SIN("sin", LEFT_BRACKET.getPriority() -1, false, true),
    COS( "cos",LEFT_BRACKET.getPriority() -1, false, true),
    MC("MC", MULTI.getPriority()+1, false, false),
    MPlUS("M+", MULTI.getPriority()+1, false,false ),
    MMINUS("M-", MULTI.getPriority()+1, false,false ),
    MR("MR", MULTI.getPriority()+1, false,false ),
    MS("MS", MULTI.getPriority()+1, false,false );



    private String symbol;
    private int priority;
    private boolean isBinary;
    private boolean isPrefix;

    Operation(String symbol, int priority, boolean isBinary, boolean isPrefix) {
        this.symbol = symbol;
        this.priority = priority;
        this.isBinary = isBinary;
        this.isPrefix = isPrefix;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isBinary() {
        return isBinary;
    }

    public boolean isPrefix() {
        return isPrefix;
    }

    public boolean isMemory() {

        return this.name().startsWith("M");
    }

    public static Operation of(String symbol) {
        for (Operation value : values()) {
            if (value.symbol.equals(symbol)) {
                return value;
            }
        }
        return null;
    }
}
