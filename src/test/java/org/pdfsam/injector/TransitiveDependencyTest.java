package org.pdfsam.injector;

import static org.junit.Assert.assertNotNull;

import javax.inject.Inject;

import org.junit.Test;
import org.pdfsam.injector.Injector;

public class TransitiveDependencyTest {
    @Test
    public void transitive() {
        Injector injector = Injector.start();
        A a = injector.instance(A.class);
        assertNotNull(a.b.c);
    }

    public static class A {
        private final B b;

        @Inject
        public A(B b) {
            this.b = b;
        }
    }

    public static class B {
        private final C c;

        @Inject
        public B(C c) {
            this.c = c;
        }
    }

    public static class C {

    }


}
