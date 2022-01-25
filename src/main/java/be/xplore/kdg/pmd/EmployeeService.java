package be.xplore.kdg.pmd;

import lombok.Value;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    List<String> getEmployeeNames() {
        var names = new ArrayList<String>();

        for (Employee employee : employeeRepository.getEmployees()) {
            names.add(employee.getName());
        }

        return names;
    }
}

class EmployeeRepository {
    public List<Employee> getEmployees() {
        return null; // if no employees exist in the repository
    }
}

@Value
class Employee {
    String name;
}
