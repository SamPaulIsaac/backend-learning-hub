public class JavaGenericExample<ParameterType> {
    ParameterType ptObject;

    JavaGenericExample(ParameterType parameterTypeObject) {
        ptObject = parameterTypeObject;
    }

    void callAndPrintTheParameterTypeValue() {
        System.out.println("Value: " + ptObject);
    }

}

class JavaGenericExample2<ParameterType1, ParameterType2> {
    ParameterType1 ptObject1;
    ParameterType2 ptObject2;

    JavaGenericExample2(ParameterType1 parameterType1, ParameterType2 parameterType2) {
        ptObject1 = parameterType1;
        ptObject2 = parameterType2;
    }

    void callAndPrintTheParameterTypeValue() {
        System.out.println("Values: " + ptObject1 + " , " + ptObject2);
    }

}

class CallingClass {
    static <T> void genericDisplay(T element) {
        System.out.println(element.getClass().getName() + " = " + element);
    }

    public static void main(String[] args) {
        JavaGenericExample<Integer> javaGenericExample1 = new JavaGenericExample<>(5);
        javaGenericExample1.callAndPrintTheParameterTypeValue();
        System.out.println("----------------------------------------------------------------------------------------");
        JavaGenericExample<Long> javaGenericExample2 = new JavaGenericExample<>(50L);
        javaGenericExample2.callAndPrintTheParameterTypeValue();
        System.out.println("----------------------------------------------------------------------------------------");
        JavaGenericExample2<String, Integer> javaGenericExample3 =
                new JavaGenericExample2<>("sam", 25);
        javaGenericExample3.callAndPrintTheParameterTypeValue();
        System.out.println("----------------------------------------------------------------------------------------");
        CallingClass.genericDisplay("Sam");
        System.out.println("----------------------------------------------------------------------------------------");
        CallingClass.genericDisplay("25");
        System.out.println("----------------------------------------------------------------------------------------");
        CallingClass.genericDisplay("19.25090809");
        System.out.println("----------------------------------------------------------------------------------------");
        // difference is value is within quotes
        CallingClass.genericDisplay(25);
        System.out.println("----------------------------------------------------------------------------------------");
        CallingClass.genericDisplay(19.25090809);
        System.out.println("----------------------------------------------------------------------------------------");
    }
}