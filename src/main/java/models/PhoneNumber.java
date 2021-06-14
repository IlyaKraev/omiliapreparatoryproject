package models;

public class PhoneNumber {

    private String digits;
    private String type;
    private boolean isInternational;
    private boolean isValid;
    private int length;

    public PhoneNumber() {
    }

    public PhoneNumber(String digits) {
        this.digits = digits;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isInternational() {
        return isInternational;
    }

    public void setInternational(boolean international) {
        isInternational = international;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Number ");
        sb.append(digits);
        sb.append(" Details: [Number Type: ").append(type);
        sb.append(" | Call Type:");
        if(this.isInternational){
            sb.append(" International ");
        } else if (this.digits.startsWith("2")||this.digits.startsWith("69")){
            sb.append(" Domestic ");
        } else sb.append(" Undefined ");
        sb.append("| Verdict:");
        if (this.isValid){
        sb.append(" Valid");
        } else sb.append(" Invalid");
        sb.append("]\n");
        return sb.toString();
    }
}
