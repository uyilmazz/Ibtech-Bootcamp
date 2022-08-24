package com.ibtech.filer;


public class CustomerFiler extends BaseFiler<Customer>{

	public CustomerFiler(String filePath) {
		super(filePath);
	}

	@Override
	protected String format(Customer entity) {
		StringBuilder builder = new StringBuilder();
		builder.append(entity.getCustomerId()).append(DELIMETER);
		builder.append(entity.getCustomerName()).append(DELIMETER);
		builder.append(entity.getTotalDebit());
		String line = builder.toString();
		return line;
	}

	@Override
	protected Customer parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Customer customer = new Customer();
		customer.setCustomerId(Long.parseLong(tokens[0]));
		customer.setCustomerName(tokens[1]);
		customer.setTotalDebit(Double.parseDouble(tokens[2]));
		return customer;
	}
	
	
}
