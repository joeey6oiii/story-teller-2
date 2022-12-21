package interfaces;

import exceptions.checked.ItemNotFoundException;

public interface PutAble {
    void put(IsPutable canBePut, TakePutAble canTakePut) throws ItemNotFoundException;
}
