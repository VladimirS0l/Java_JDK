package directory;

/**
 * Тест метода, который ищет сотрудника по стажу (может быть список)
 * Тест метода, который выводит номер телефона сотрудника по имени (может быть список)
 * Тест метода, который ищет сотрудника по табельному номеру
 * Тест метода добавление нового сотрудника в справочник сотрудников
 */
public class Les4App {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee emp1 = new Employee(5L, "Alice", 7, "123456789");
        Employee emp2 = new Employee(6L, "Pavel", 10, "123456789");
        Employee emp3 = new Employee(7L, "Ivan", 15, "123456710");

        directory.createEmployee(emp1);
        directory.createEmployee(emp2);
        directory.createEmployee(emp3);

        System.out.println(directory.findAllByExperience(7));

        System.out.println(directory.findAllPhoneByName("Ivan"));

        System.out.println(directory.findById(6L));
    }
}
