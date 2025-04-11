public class RecordPattern {
    public static void main(String[] args) {
        Cricketer cricketer1 = new Cricketer("SamPaul Isaac", "India");
        Cricketer cricketer2 = new Cricketer("Matthew", "India");
        Cricketer cricketer3 = new Cricketer("Adam", "India");
        System.out.println("NAMES of the CRICKETERS");
        System.out.println(STR."\{cricketer1.name()}, \{cricketer2.name()}, \{cricketer3.name()}");
    }
}

record Cricketer(String name, String country) {
}
