package Class;

class BahubaliPart1 {

    void King() {
        System.out.println("Amarendra Bahubali..");
    }

    void Enemy() {
        System.out.println("Kalakeya..");
    }

    void NSP() {
        System.out.println("Kattappa 1");
    }
}

class BahubaliPart2 extends BahubaliPart1 {
    void King2() {
        System.out.println("Mahendra Bahubali..");
    }

    void Enemy2() {
        System.out.println("BalalaDeva..");
    }

    void NSP() {
        System.out.println("kattappa 2");
    }
}

public class Mahessmathi {
    public static void main(String[] args) {
        BahubaliPart1 part1 = new BahubaliPart1();
        BahubaliPart2 part2 = new BahubaliPart2();

        System.out.print("King of part 1--> ");
        part1.King();
        System.out.print("Enemy of part 1-->");
        part1.Enemy();
        System.out.print("King of part 2--> ");
        part2.King2();
        System.out.print("Enemy of part 2-->");
        part2.Enemy2();
        System.out.print("NSP of part 2 and 1 -->");
        part2.NSP();
    }
}
