package homeworks.bracechecker;

public class BraceCheckerTest {
    public static void main(String[] args) {
        BraceChecker bc1 = new BraceChecker("Hello from [Java]");
        bc1.check();
        System.out.println();

        BraceChecker bc2 = new BraceChecker("{Hello from (Java)}");
        bc2.check();
        System.out.println();

        BraceChecker bc3 = new BraceChecker("{[()]}");
        bc3.check();
        System.out.println();

        BraceChecker bc4 = new BraceChecker("Hello Java");
        bc4.check();
        System.out.println();

        BraceChecker bc5 = new BraceChecker("Hello from [Java)");
        bc5.check();
        System.out.println();

        BraceChecker bc6 = new BraceChecker("{[(])}");
        bc6.check();
        System.out.println();

        BraceChecker bc7 = new BraceChecker("Hello from Java]");
        bc7.check();
        System.out.println();

        BraceChecker bc8 = new BraceChecker("{Hello Java");
        bc8.check();
        System.out.println();

        BraceChecker bc9 = new BraceChecker("((()))");
        bc9.check();
        System.out.println();

        BraceChecker bc10 = new BraceChecker("(()");
        bc10.check();
        System.out.println();
    }
}
