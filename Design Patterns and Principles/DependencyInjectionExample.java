interface CustomerRepository {

    String findCustomerById(int id);
}

class CustomerRepositoryImpl
        implements CustomerRepository {

    @Override
    public String findCustomerById(
            int id) {

        return "Customer ID : "
                + id
                + " | Name : Shubaashree";
    }
}

class CustomerService {

    private CustomerRepository repository;

    public CustomerService(
            CustomerRepository repository) {

        this.repository = repository;
    }

    public void getCustomer(
            int id) {

        System.out.println(
                repository.findCustomerById(id));
    }
}

public class DependencyInjectionExample {

    public static void main(String[] args) {

        CustomerRepository repository =
                new CustomerRepositoryImpl();

        CustomerService service =
                new CustomerService(
                        repository);

        service.getCustomer(101);
    }
}
