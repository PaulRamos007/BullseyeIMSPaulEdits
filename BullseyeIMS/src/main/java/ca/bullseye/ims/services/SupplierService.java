package ca.bullseye.ims.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ca.bullseye.ims.model.Supplier;
import ca.bullseye.ims.repositories.SupplierRepository;

@Service
public class SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	// display all supplier records
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.findAll();
	}

	// create new supplier record
	public Supplier addNewSupplier(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	// getting a specific supplier record
	public Supplier getSupplierById(Long supId) {
		Optional<Supplier> optional = supplierRepository.findById(supId);
		Supplier supplier = null;
		if (optional.isPresent()) {
			supplier = optional.get();
		} else {
			throw new RuntimeException("Record not found for Supplier Id: " + supId);
		}
		return supplier;
	}

	// update supplier record
	public void updateSupplier(Supplier supplier) {
		supplierRepository.save(supplier);
	}

	// delete a specific supplier
	public void deleteSupplier(Long supId) {
		supplierRepository.deleteById(supId);
	}

	// pagination and sorting
	public Page<Supplier> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending()
				: Sort.by(sortField).descending();
		Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
		return this.supplierRepository.findAll(pageable);
	}

}
