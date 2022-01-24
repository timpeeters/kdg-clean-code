package be.xplore.kdg.pmd;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public class EmployeeReturnNull {

    private final EmployeeRepository employeeRepository;

    public EmployeeReturnNull(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<String> getEmployeeNames() {
        var names = new ArrayList<String>();

        for (Employee employee : employeeRepository.getEmployees()) {
            names.add(employee.getName());
        }

        return names;
    }

    static class EmployeeRepository {
        public List<Employee> getEmployees() {
            return null; // if no employees exist in the repository
        }
    }

    @Value
    static class Employee {
        String name;
    }
}
