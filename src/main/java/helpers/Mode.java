package helpers;

public enum Mode {

    READ("read"),
    WRITE("write");

    private final String mode;

    Mode(String mode) {
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }
}
