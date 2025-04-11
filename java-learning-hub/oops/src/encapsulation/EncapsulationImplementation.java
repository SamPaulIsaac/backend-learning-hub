package encapsulation;

public class EncapsulationImplementation {
    public static void main(String[] args) {
        Fruit apple = new Fruit();
        apple.setName("Apple");
        apple.setPrice(500);
        Fruit orange = new Fruit();
        orange.setName("Orange");
        orange.setPrice(250);
        System.out.println(apple.getName());
        System.out.println(apple.getPrice());
        System.out.println(orange.getName());
        System.out.println(orange.getPrice());
    }
}


class Fruit {

    private String name;
    private Integer price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}