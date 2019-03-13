package com.lambdaTest2;

public interface PersonFactory<P extends Person> {
    P create(String firstName, String lastName);
}
