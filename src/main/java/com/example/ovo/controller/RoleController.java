package com.example.ovo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ovo.model.Role;
import com.example.ovo.model.User;
import com.example.ovo.repository.RoleRepository;

@RestController
@RequestMapping("/ovo")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping(value = "/CreateRole")
	public Role createUser(@Valid @RequestBody Role role) {
		 return roleRepository.save(role);
	}
	
	@DeleteMapping("/DeleteRole/{id}")
	public ResponseEntity<?> deleteRole(@PathVariable(value = "id") Long roleId) {
        Role role = roleRepository.findById(roleId)
                .orElseThrow(() -> new com.example.ovo.exception.ResourceNotFoundException("Role", "id", roleId));

        roleRepository.delete(role);

        return ResponseEntity.ok().build();
    }
	
	 @PostMapping("/UpdateRole/{id}")
	    public Role updateRole(@PathVariable(value = "id") Long roleId,
	                                           @Valid @RequestBody Role roleDetails) {

	        Role role = roleRepository.findById(roleId)
	                .orElseThrow(() -> new com.example.ovo.exception.ResourceNotFoundException("User", "id", roleId));

	        role.setRole(roleDetails.getRole());
	        Role updatedRole = roleRepository.save(role);
	        return updatedRole;
	    }
}
