package lesson9;

public class PowerOfTwo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public boolean checkPowerOf2(int n) {
        return n > 0 && (n&(n-1)) == 0;
    }
}
