package util;

import exceptions.ValidationException;

@FunctionalInterface
public interface Validation<T> { // T is here generic , koi bhi type yeh same interface use ho skta h
    void validate (T Value) throws ValidationException;
}

