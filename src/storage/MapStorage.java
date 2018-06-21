package storage;

import model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected void saveElement(Resume resume, Object key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateElement(Resume resume, Object key) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getElement(Object key) {
        for (Map.Entry entry : map.entrySet()) {
            Object searchKey = entry.getValue();
        if (key.equals(entry.getValue())) {
            return (Resume) searchKey;
        }
    }
        return null;
    }

    @Override
    protected void deleteElement(Object key) {
        Object searchKey = null;
        for (Map.Entry entry : map.entrySet()) {
            if (key.equals(entry.getValue())) {
                searchKey = entry.getKey();
            }
        }
        map.remove((String) searchKey);
    }

    @Override
    protected boolean isExist(Object key) {
        return key != null;
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        Collection<Resume> list = map.values();
        List<Resume> storage = new ArrayList<>(list);
        storage.sort(Comparator.comparing(Resume::getUuid));
        return storage;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    protected Object getKey(String key) {
        Object searchKey;
        for (Map.Entry entry : map.entrySet()) {
            if (entry.getKey().equals(key)) {
                searchKey = entry.getValue();
                return searchKey;
            }
        }
        return null;
    }
}
