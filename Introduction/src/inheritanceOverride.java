public class inheritanceOverride {
    // Superclass
    class Bird {
        public void fly() {
            System.out.println("Bird is flying");
        }
    }

    // Subclass
    class Parrot extends Bird {
        @Override
        public void fly() {
            System.out.println("Parrot is flying");
        }
    }

    public class Main {
        public void main(String[] args) {
            Parrot myParrot = new Parrot();
            myParrot.fly();  // Output: Parrot is flying
        }
    }


}
