package numbers;

public class JumpingNumber extends NumberProperty {
    public JumpingNumber(String number) {
        super(number);
        name = "jumping";
    }

    @Override
    boolean match() {
        boolean isJumping = true;

        for (int i = 0; i < number.length() - 1; i++) {
            if (Math.abs(Integer.parseInt(String.valueOf(number.charAt(i))) - Integer.parseInt(String.valueOf(number.charAt(i + 1)))) != 1) {
                isJumping = false;
                break;
            }
        }
        return isJumping;
    }
}
