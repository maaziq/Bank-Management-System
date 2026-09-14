package jsp.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jsp.springboot.entity.Role;
import jsp.springboot.service.RoleService;

@RestController
@RequestMapping("/role")
public class RoleController {

	
	private RoleService roleService;
	
	public RoleController(RoleService roleService) {
		super();
		this.roleService = roleService;
	}


	@PostMapping
	public ResponseEntity<String> addRole(@RequestBody Role role){
		
		roleService.addRoles(role);
		return ResponseEntity.ok("Done!");
	}
}

