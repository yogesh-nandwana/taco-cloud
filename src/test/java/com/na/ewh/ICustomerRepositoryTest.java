package com.na.ewh;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.na.ewh.model.Address;
import com.na.ewh.model.Contact;
import com.na.ewh.model.Customer;
import com.na.ewh.repositroy.ICustomerRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class ICustomerRepositoryTest {
	@Autowired 
	ICustomerRepository customerRepository;

	@Test
	public void testIfCustomerRepoIsNonNull(){
		assertThat(customerRepository).isNotNull();
	}

	@Test
	public void testSaveAndPrintCustomer() {
		Contact contact = new Contact();

		Address address = new Address();

		Customer customer = new Customer();
		contact.setCustomer(customer);
		address.setCustomer(customer);

		customer.setInitial(Customer.INITIAL.MR);
		customer.setType(Customer.TYPE.TRADER);
		customer.setFirstName("Mohan");
		customer.setMiddleName("Lal");
		customer.setLastName("Bagwaan");
		customer.setAddress(address);
		customer.setContact(contact);

		Customer savedCustomer = customerRepository.save(customer);
		assertThat(savedCustomer).isNotNull();
		System.out.println(savedCustomer);
	}
}