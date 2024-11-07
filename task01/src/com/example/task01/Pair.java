package com.example.task01;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;

public class Pair<T,X> {
    // TODO напишите реализацию
    private final T firstValue;
    private final X secondValue;

    private Pair(){
        this.firstValue = null;
        this.secondValue = null;
    }
    private Pair(T firstValue, X secondValue){
        this.firstValue = firstValue;
        this.secondValue = secondValue;
    }
    public T getFirst(){
        return firstValue;
    }
    public X getSecond(){
        return secondValue;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) obj;
        return this.firstValue.equals(pair.firstValue) && this.secondValue.equals(pair.secondValue);
    }
    @Override
    public int hashCode(){
        return firstValue.hashCode() + secondValue.hashCode();
    }

    public static <T, X> Pair<T, X> of (T firstValue, X secondValue){
        return new Pair<>(firstValue, secondValue);
    }

    public void ifPresent(BiConsumer<? super T, ? super X> biConsumer){
        if (firstValue != null && secondValue != null){
            biConsumer.accept((T)firstValue, (X)secondValue);
        }
    }
}

