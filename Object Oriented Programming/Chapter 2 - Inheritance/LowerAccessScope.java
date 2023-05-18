class subclass {
    public void sayMyName() {
        System.out.println("subclass");
    }
}

public class LowerAccessScope extends subclass {
    void sayMyName() {
        System.out.println("LowerAccessScope");
    }
}
