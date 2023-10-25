package directory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Добавить метод, который ищет сотрудника по стажу (может быть список)
 * Добавить метод, который выводит номер телефона сотрудника по имени (может быть список)
 * Добавить метод, который ищет сотрудника по табельному номеру
 * Добавить метод добавление нового сотрудника в справочник сотрудников
 */
public class EmployeeDirectory {
    List<Employee> directory = new ArrayList<>();

    {
        directory.add(new Employee(1L, "Petr", 15, "1342141414124"));
        directory.add(new Employee(2L, "Vladimir", 10, "5342355235"));
        directory.add(new Employee(3L, "Ivan", 5, "2532357888"));
        directory.add(new Employee(4L, "Elena", 7, "885574645343"));
    }

    public List<Employee> findAllByExperience(Integer experience) {
        return directory.stream()
                .filter((emp) -> emp.getExperience()==experience)
                .collect(Collectors.toList());
    }

    public List<String> findAllPhoneByName(String name) {
        return directory.stream()
                .filter((emp) -> emp.getName().equals(name))
                .map(Employee::getPhone)
                .collect(Collectors.toList());
    }

    public Employee findById(Long id) {
        return directory.stream().filter((emp) -> emp.getId()==id).findFirst().get();
    }

    public Employee createEmployee(Employee employee) {
        directory.add(employee);
        return employee;
    }

}
