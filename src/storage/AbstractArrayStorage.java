package storage;

import exceptions.StorageException;
import model.Resume;

import java.util.*;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

    private static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public final void saveElement(Resume resume, Integer index) {
        if (size < STORAGE_LIMIT) {
            insertResume(resume, index);
            size++;
        } else {
            throw new StorageException("storage overflow", resume.getUuid());
        }
    }

    @Override
    public final void deleteElement(Integer index) {
        size--;
        deleteResume(index);
        storage[size] = null;
    }

    @Override
    protected List<Resume> getStorage() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected boolean isExist(Integer index) {
        return index >= 0;
    }

    @Override
    public final int size() {
        return size;
    }

    @Override
    protected final void updateElement(Resume resume, Integer index) {
        storage[index] = resume;
    }

    @Override
    protected final Resume getElement(Integer index) {
        return storage[index];
    }

    protected abstract void insertResume(Resume resume, Integer index);

    protected abstract void deleteResume(Integer index);
}