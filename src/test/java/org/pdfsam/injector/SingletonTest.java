package org.pdfsam.injector;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import javax.inject.Provider;
import javax.inject.Singleton;

import org.junit.Test;
import org.pdfsam.injector.Injector;

public class SingletonTest {
    @Test
    public void nonSingleton() {
        Injector injector = Injector.start();
        assertNotEquals(injector.instance(Plain.class), injector.instance(Plain.class));
    }

    @Test
    public void singleton() {
        Injector injector = Injector.start();
        assertEquals(injector.instance(SingletonObj.class), injector.instance(SingletonObj.class));
    }

    @Test
    public void singletonThroughProvider() {
        Injector injector = Injector.start();
        Provider<SingletonObj> provider = injector.provider(SingletonObj.class);
        assertEquals(provider.get(), provider.get());
    }

    public static class Plain {

    }

    @Singleton
    public static class SingletonObj {

    }
}
