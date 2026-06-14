class Computer {

    private String cpu;
    private String ram;
    private String storage;
    private String gpu;
    private String os;

    private Computer(Builder builder) {

        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.os = builder.os;
    }

    public void display() {

        System.out.println("CPU : " + cpu);
        System.out.println("RAM : " + ram);
        System.out.println("Storage : " + storage);
        System.out.println("GPU : " + gpu);
        System.out.println("OS : " + os);
    }

    public static class Builder {

        private String cpu;
        private String ram;
        private String storage;
        private String gpu;
        private String os;

        public Builder setCPU(String cpu) {

            this.cpu = cpu;
            return this;
        }

        public Builder setRAM(String ram) {

            this.ram = ram;
            return this;
        }

        public Builder setStorage(String storage) {

            this.storage = storage;
            return this;
        }

        public Builder setGPU(String gpu) {

            this.gpu = gpu;
            return this;
        }

        public Builder setOS(String os) {

            this.os = os;
            return this;
        }

        public Computer build() {

            return new Computer(this);
        }
    }
}
public class BuilderPatternExample {
    public static void main(String[] args) {

        Computer gamingPC =
            new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGPU("RTX 4070")
                .setOS("Windows 11")
                .build();

        gamingPC.display();

        System.out.println();

        Computer officePC =
            new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setOS("Windows 10")
                .build();

        officePC.display();
    }
    
}
