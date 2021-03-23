package fakhri.chaerul.insan.repository;

import fakhri.chaerul.insan.data.Person;

public interface PersonRepository {

    Person selectById(String id);

    void insert(Person person);
}
