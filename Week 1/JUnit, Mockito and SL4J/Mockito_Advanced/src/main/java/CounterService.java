public class CounterService {

    private CounterRepository repository;

    public CounterService(CounterRepository repository) {
        this.repository = repository;
    }

    public int getNextCount() {
        return repository.getCount();
    }
}
