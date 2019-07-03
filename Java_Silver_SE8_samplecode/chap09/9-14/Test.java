import java.util.*;
interface A { void foo(); }
class B implements A { public void foo() {} public void bar() {} }
class C extends B { public void foo() {} }
class Test {
    public static void main(String[] args) {
        List<A> list = new ArrayList<A>();
        list.add(new B());
        list.add(new C());
        for(A a : list) {
            a.foo();
            a.bar();
        }
    }
}