package com.example.Springboot_RDS;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmployeeController
{
@Autowired
EmployeeRepository erepo;
@RequestMapping("/test")
public String test()
{
	return"test is completed";
}
@PostMapping("/save")
public String saveData(@RequestBody Employee e)
{
	erepo.save(e);
	return"Data is saved into Database";
}
@GetMapping("/all")
public List<Employee> allData()
{
	return erepo.findAll();
}
@GetMapping("/{id}")
public Optional<Employee> byId(@PathVariable int id)
{
	return erepo.findById(id);
}
@DeleteMapping("/del/{id}")
public String delete(@PathVariable int id)
{
	erepo.deleteById(id);
	return"Data is Deleted";
}

}
