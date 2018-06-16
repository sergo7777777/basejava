package storage;

import model.Resume;

import java.util.ArrayList;

public class ListStorage extends AbstractStorage {

    private final ArrayList<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected void saveElement(Resume resume, Object index) {
        storage.add(resume);
    }

    @Override
    protected void updateElement(Resume resume, Object index) {
        storage.set((int)index, resume);
    }

    @Override
    protected Resume getElement(Object key) {
        return storage.get((int)key);
    }

    @Override
    protected void deleteElement(Object key) {
        storage.remove((int) key);
    }

    @Override
    public Resume[] getAll() {
        storage.trimToSize();
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int getKey(String uuid) {
        Resume resume = new Resume(uuid);
        return storage.indexOf(resume);
    }
}
