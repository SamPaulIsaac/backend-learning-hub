package protected_demo.protected_package2;

import protected_demo.protected_package1.Sample1Protected;

public class ProtectedDemoApplication extends Sample1Protected {
    public static void main(String[] args) {
        Sample1Protected sample = new Sample1Protected();
        sample.id = 5;
        sample.value = "test";
        System.out.println(sample.id);
        System.out.println(sample.value);
        /* Commenting the below as it throws exception due to protected access specifier
            and is present in other package.
        */
        // sample.testMethod();
        // Work around.
        ProtectedDemoApplication protectedDemoApplication = new ProtectedDemoApplication();
        protectedDemoApplication.testMethod();
    }

    @Override
    protected void testMethod() {
        System.out.println("This method has protected access specifier. But, still this is accessed through inheritance.");
    }
}
