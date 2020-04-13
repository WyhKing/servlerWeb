package test;


public class Test {
    public static void main(String[] args) {
        Validate v = ValidateCodeUtil.getRandomCode();
        System.out.println(v.getBase64Str());
        System.out.println(v.getValue());
    }
}


