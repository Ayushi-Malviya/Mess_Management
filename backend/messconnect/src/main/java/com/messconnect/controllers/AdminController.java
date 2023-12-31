package com.messconnect.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.messconnect.dto.ActiveAddonsDTO;
import com.messconnect.dto.ActiveMenuDTO;
import com.messconnect.dto.AddonDTO;
import com.messconnect.dto.BalanceDTO;
import com.messconnect.dto.MenuDTO;
import com.messconnect.entities.AddOn;
import com.messconnect.entities.Menu;
import com.messconnect.services.AddonService;
import com.messconnect.services.BalanceService;
import com.messconnect.services.MenuService;
import com.messconnect.services.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private MenuService menuService;

	@Autowired
	private UserService userService;

	@Autowired
	private AddonService addonService;

	@Autowired
	private BalanceService balanceService;

	@Autowired
	private ModelMapper mapper;

	@GetMapping("/getallmenu")
	public ResponseEntity<?> todaysMenuData() {
		return new ResponseEntity<>(menuService.getAllMenuData(), HttpStatus.OK);

	}

	@GetMapping("/getallitems")
	public ResponseEntity<?> allItemsData() {
		return new ResponseEntity<>(menuService.getAllItemsData(), HttpStatus.OK);

	}

	@GetMapping("/getuserdata/{email}")
	public ResponseEntity<?> userData(@PathVariable String email) {
		return new ResponseEntity<>(userService.getUserData(email), HttpStatus.OK);

	}

	@GetMapping("/getalladdons")
	public ResponseEntity<?> allAddonsData() {
		return new ResponseEntity<>(addonService.getallAddonsData(), HttpStatus.OK);

	}

	@PostMapping("addnewaddon")
	public ResponseEntity<?> addAddon(@RequestBody AddonDTO newAddonDTO) {
		AddOn newAddon = mapper.map(newAddonDTO, AddOn.class);
		return new ResponseEntity<>(addonService.addNewAddon(newAddon), HttpStatus.OK);
	}

	@PostMapping("addnewmenu")
	public ResponseEntity<?> addMenu(@RequestBody @Valid MenuDTO newMenuDTO) {
		Menu newMenu = mapper.map(newMenuDTO, Menu.class);
		return new ResponseEntity<>(menuService.addNewMenu(newMenu), HttpStatus.OK);
	}

	@PutMapping("/updatebalance")
	public ResponseEntity<?> updateBalance(@RequestBody BalanceDTO balanceDTO) {
		return new ResponseEntity<>(
				balanceService.updateUserBalance(balanceDTO.getUserId(), balanceDTO.getUpdatedBal()), HttpStatus.OK);

	}

	@PutMapping("/activateMenu")
	public ResponseEntity<?> activateMenu(@RequestBody ActiveMenuDTO actMenuDTO) {
		return new ResponseEntity<>(menuService.activateTodayMenu(actMenuDTO.getActiveMenus()), HttpStatus.OK);

	}

	@PutMapping("/activateAddon")
	public ResponseEntity<?> activateAddon(@RequestBody ActiveAddonsDTO actAddonDTO) {
		return new ResponseEntity<>(addonService.activateTodayAddon(actAddonDTO.getActiveAddons()), HttpStatus.OK);

	}

}
