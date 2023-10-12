package gp.x.easydev;


class Gen<T> {
    T ob;

    Gen(T o) {
        this.ob = o;
    }

    T getob() {
        return this.ob;
    }

    void showType() {
        System.out.println("Тип T: " + this.ob.getClass().getName());
    }

    public static void main(String[] args) {
        Gen<Integer> iOb = new Gen(77);
        iOb.showType();
        int value = (Integer) iOb.getob();
        System.out.println("Значение " + value);
        Gen<String> strOb = new Gen("Обобщённый текст");
        strOb.showType();
        String str = (String) strOb.getob();
        System.out.println("Значение: " + str);
        System.out.println("--------------------------------------------------");
        testsT("3232", 1, "w", 2323.4D);
    }

    static void testsT(Object... args) {
        for (int i = 0; i < args.length; ++i) {
            System.out.println(args[i] + " | " + args[i].getClass());
            if (args[i] instanceof String) {
                System.out.println("Это стринг!");
            }

            if (args[i] instanceof Integer) {
                System.out.println("Это Integer!");
            }
        }

    }
}
