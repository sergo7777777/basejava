package storage;

import model.Resume;
import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    protected void doSave(Resume resume) {
        int index = -(getIndex(resume.getUuid()) + 1);
        System.arraycopy(storage, index, storage, index + 1, size - index);
        storage[index] = resume;

        /*storage[size] = resume;
        Arrays.sort(storage, 0 , size);*/
    }

    @Override
    protected void doDelete(int index) {
        System.arraycopy(storage, index + 1, storage, index, size);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
