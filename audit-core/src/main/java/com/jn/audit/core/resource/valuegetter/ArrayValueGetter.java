package com.jn.audit.core.resource.valuegetter;

import com.jn.langx.util.Emptys;
import com.jn.langx.util.Preconditions;

public class ArrayValueGetter<E> implements ValueGetter<E[], E> {
    private int index;

    public ArrayValueGetter(int index) {
        this.index = index;
    }

    @Override
    public E get(E[] input) {
        if (Emptys.isEmpty(input)) {
            return null;
        }
        Preconditions.checkArgument(index >= 0 && index < input.length);
        return input[index];
    }
}
