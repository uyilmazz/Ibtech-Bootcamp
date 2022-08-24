package com.ibtech.filer;

public class SupplierFiler extends BaseFiler<Supplier> {

	public SupplierFiler(String filePath) {
		super(filePath);
	}

	@Override
	protected String format(Supplier entity) {
		StringBuilder builder = new StringBuilder();
		builder.append(entity.getSupplierId()).append(DELIMETER);
		builder.append(entity.getSupplierName()).append(DELIMETER);
		builder.append(entity.getTotalCredit()).append(DELIMETER);
		String line = builder.toString();
		return line;
	}

	@Override
	protected Supplier parse(String line) {
		String[] tokens = line.split(DELIMETER);
		Supplier supplier = new Supplier();
		supplier.setSupplierId(Long.parseLong(tokens[0]));
		supplier.setSupplierName(tokens[1]);
		supplier.setTotalCredit(Double.parseDouble(tokens[2]));
		return supplier;
	}

}
