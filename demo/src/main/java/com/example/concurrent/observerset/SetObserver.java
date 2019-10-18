package com.example.concurrent.observerset;

public interface SetObserver<E> {
    void added(ObservableSet<E> set, E element);
}
