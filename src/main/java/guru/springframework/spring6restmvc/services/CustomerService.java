package guru.springframework.spring6restmvc.services;

import guru.springframework.spring6restmvc.model.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Slf4j
@Service
public class CustomerService {
    private Map<UUID, Customer> customerMap;
    public CustomerService() {
        this.customerMap = new HashMap<>();

        Customer c1 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Axel Karlsson")
                .build();

        Customer c2 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Håkan Juholt")
                .build();

        Customer c3 = Customer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .customerName("Glenn Hysén")
                .build();



        customerMap.put(c1.getId(), c1);
        customerMap.put(c2.getId(), c2);
        customerMap.put(c3.getId(), c3);
    }

    public List<Customer> listCustomers(){
        return new ArrayList<>(customerMap.values());
    }

    public Customer getCustomerById(UUID id) {

        log.debug("Get Customer by Id - in service. Id: " + id.toString());

        return customerMap.get(id);
    }
}
