public class Test {

    public int index;
    public String name = "";

    public Test() {
        index = 220;
    }

    public Test(String nome) {
        index = 220;
        this.name = nome;
    }

    @Override
    public String toString() {
        return "nome: " + name + " index: " + index;
    }
}
